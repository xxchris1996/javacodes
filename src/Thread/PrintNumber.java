package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//原子类
public class PrintNumber extends Thread{
    private static AtomicInteger cnt = new AtomicInteger();
    private int id;
    PrintNumber(int id){
        this.id = id;
    }

    @Override
    public void run() {
        while (cnt.get() < 100){
            cnt.incrementAndGet();
            System.out.println("thread_"+id+" num:"+cnt.get());
        }
    }

    public static void main(String[] args) {
        Thread t0 = new PrintNumber(0);
        Thread t1 = new PrintNumber(1);
        t0.start();
        t1.start();
    }
}
//sychronized
//public class PrintNumber extends Thread{
//    private static int cnt = 0;
//    private int id;
//    PrintNumber(int id){
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//        while (cnt < 100){
//            synchronized (PrintNumber.class){
//                cnt++;
//                System.out.println("thread_"+id+" num:"+cnt);
//                PrintNumber.class.notify();
//                try {
//                    PrintNumber.class.wait(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Thread t0 = new PrintNumber(0);
//        Thread t1 = new PrintNumber(1);
//        t0.start();
//        t1.start();
//    }
//}
//reentrantlock
//public class PrintNumber extends Thread{
//    private Lock lock = new ReentrantLock();
//    private Condition condition = lock.newCondition();
//    private static int cnt = 0;
//    private int id;
//    PrintNumber(int id){
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//        try {
//            lock.lock();
//            while(cnt < 100) {
//                if (cnt % 2 == id) {
//                    cnt += 1;
//                    System.out.println("thread_"+id+" num:"+cnt);
//                    condition.signalAll();
//                }  else {
//                    try {
//                        condition.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread t0 = new PrintNumber(0);
//        Thread t1 = new PrintNumber(1);
//        t0.start();
//        t1.start();
//    }
//}