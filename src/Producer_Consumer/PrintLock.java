package Producer_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        Resource2 resource2 = new Resource2(lock, producerCondition, consumerCondition);
        ConsumerThread1 consumerThread1 = new ConsumerThread1(resource2);
        ConsumerThread1 consumerThread2 = new ConsumerThread1(resource2);
        ProducerThread1 producerThread1 = new ProducerThread1(resource2);
        consumerThread1.start();
        producerThread1.start();
        consumerThread2.start();

    }
}
class Resource2 {
    private int num = 0;
    private int size = 10;
    private Lock lock;
    private Condition producerCondition;
    private Condition consumerCondition;
    public Resource2(Lock lock, Condition producerCondition, Condition consumerCondition){
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    public void add(){
        lock.lock();
        try {
            if(num < size){
                num++;
//                System.out.println(Thread.currentThread().getName() + "生产一件资源,当前资源池有" + num + "个");
                consumerCondition.signalAll();
            } else {
                producerCondition.await();
                System.out.println(Thread.currentThread().getName() + "线程进入等待");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void remove(){
        lock.lock();
        try {
            if(num > 0){
//                num--;
                System.out.println("消费者" + Thread.currentThread().getName() + "消耗一件资源," + "当前资源池有" + num + "个");
                producerCondition.signalAll();
            } else {
                try {
                    consumerCondition.await();
                    System.out.println(Thread.currentThread().getName() + "线程进入等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
class ProducerThread1 extends Thread{
    private Resource2 resource2;
    public ProducerThread1(Resource2 resource2){
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource2.add();
        }
    }
}
class ConsumerThread1 extends Thread{
    private Resource2 resource2;
    public ConsumerThread1(Resource2 resource2){
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource2.remove();
        }
    }
}
