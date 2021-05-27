package CodingTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mycount {
    Lock lock = new ReentrantLock();
    Condition _saveCondition = lock.newCondition();
    Condition _drawCondition = lock.newCondition();

    private String oid;
    private int cash;

    Mycount(String oid, int cash){
        this.oid = oid;
        this.cash = cash;
    }

    void save(int x){
        lock.lock();
        if(x > 0){
            cash += x;
            System.out.println(Thread.currentThread().getName()+" 存款"+x+ "当前余额 "+ cash);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        } else {
            System.out.println("存款错误");
        }
        _drawCondition.signalAll();
        lock.unlock();
    }

    void draw(int x){
        lock.lock();
        if(cash - x < 0){
            System.out.println("余额不足");
        } else {
            cash -= x;
            System.out.println(Thread.currentThread().getName()+" 取款"+x + "当前余额 "+ cash);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Mycount mycount = new Mycount("FG", 1000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,1, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.CallerRunsPolicy());
        Thread s1 = new SavaThread(mycount, "s1", 1000);
        Thread d1 = new DrawThread(mycount, "d1", 1000);
        Thread d2 = new DrawThread(mycount, "d2", 2000);
        Thread s2 = new SavaThread(mycount, "s2", 1000);
        Thread s3 = new SavaThread(mycount, "s3", 1000);
        Thread d3 = new DrawThread(mycount, "d3", 3000);
        executor.execute(s1);
        executor.execute(d1);
        executor.execute(d2);
        executor.execute(s2);
        executor.execute(s3);
        executor.execute(d3);
    }
}

class SavaThread extends Thread{
    Mycount mycount;
    String id;
    int x;
    SavaThread(Mycount mycount, String id, int x){
        this.mycount = mycount;
        this.id = id;
        this.x = x;
    }

    @Override
    public void run() {
        mycount.save(x);
    }
}

class DrawThread extends Thread{
    Mycount mycount;
    String id;
    int x;
    DrawThread(Mycount mycount, String id, int x){
        this.mycount = mycount;
        this.id = id;
        this.x = x;
    }

    @Override
    public void run() {
        mycount.draw(x);
    }
}
