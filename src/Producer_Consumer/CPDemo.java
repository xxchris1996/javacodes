package Producer_Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CPDemo {
    public static void main(String[] args) {
        Resource0  resource0 = new Resource0();
        ConsumerThread0 consumerThread0 = new ConsumerThread0(resource0, 1);
        ConsumerThread0 consumerThread1 = new ConsumerThread0(resource0, 2);
        ProducerThread0 producerThread0 = new ProducerThread0(resource0,0);
        producerThread0.start();
        consumerThread0.start();
        consumerThread1.start();

    }
}
class Resource0{
    static int num = 0;
//    int size = 10;
    BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
    public void add() {
        try {
            bq.put(num++);
            System.out.println("生产者生产" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(){
            try {
                Integer take = bq.take();
                System.out.println(Thread.currentThread().getName() + "消费"+take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

class ConsumerThread0 extends Thread{
    private Resource0 resource0;
    private int id;

    public ConsumerThread0(Resource0 resource0, int id){
        this.resource0 = resource0;
        this.id = id;
    }

    @Override
    public void run(){
        while(true){
            resource0.remove();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class ProducerThread0 extends Thread{
    private Resource0 resource0;
    private int id;

    public ProducerThread0(Resource0 resource0, int id){
        this.resource0 = resource0;
        this.id = id;
    }

    @Override
    public void run(){
        while (true){
            resource0.add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}