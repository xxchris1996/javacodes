package CodingTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock_wait extends Thread{
    static String resource0 = "resource0";
    static String resource1 = "resource1";
    static final Semaphore semaphore0 = new Semaphore(1);
    static final Semaphore semaphore1 = new Semaphore(1);


    public static void main(String[] args) {
        LockAa lockAa = new LockAa();
        LockBa lockBa = new LockBa();
        new Thread(lockAa).start();
        new Thread(lockBa).start();

    }
}
class LockAa implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                if(DeadLock_wait.semaphore0.tryAcquire(10, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()+" get "+DeadLock_wait.resource0);
                    if(DeadLock_wait.semaphore1.tryAcquire(10, TimeUnit.SECONDS)){
                        System.out.println(Thread.currentThread().getName()+" get "+DeadLock_wait.resource1);
                    }
                }
                DeadLock_wait.semaphore1.release();
                DeadLock_wait.semaphore0.release();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class LockBa implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                if(DeadLock_wait.semaphore0.tryAcquire(10, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()+" get "+DeadLock_wait.resource0);
                    if(DeadLock_wait.semaphore1.tryAcquire(10, TimeUnit.SECONDS)){
                        System.out.println(Thread.currentThread().getName()+" get "+DeadLock_wait.resource1);
                    }
                }
                DeadLock_wait.semaphore1.release();
                DeadLock_wait.semaphore0.release();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
