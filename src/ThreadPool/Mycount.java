package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mycount {
    private String oid;
    private int cash;

    private Lock lock = new ReentrantLock(false);
    private Condition _save = lock.newCondition();
    private Condition _draw = lock.newCondition();

    Mycount(String oid, int cash){
        this.oid = oid;
        this.cash = cash;
    }
    public void saving(int x, String name){
        lock.lock();
        if(x > 0){
            cash += x;
            System.out.println(name + "存款" + x + ", 当前余额为" + cash);
        }
        _draw.signalAll();
        lock.unlock();
    }

    public void drawing(int x, String name){
        lock.lock();
        try {
//            if(cash - x < 0){
//                System.out.println(name + "阻塞中");
//                _draw.await(2000, TimeUnit.MILLISECONDS);
//            }
            if(cash - x >= 0){
                cash -= x;
                System.out.println(name + "取款" + x + ", 当前余额为" + cash);
            } else {
                System.out.println(name+" 余额不足,当前余额为 "+cash+"   取款金额为 "+x);
            }
            _save.signalAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    static class SaveThread extends Thread{
        private String name;
        private Mycount mycount;
        private int x;

        SaveThread(String name, Mycount mycount, int x){
            this.name = name;
            this.mycount = mycount;
            this.x = x;
        }

        @Override
        public void run() {
            mycount.saving(x, name);
        }
    }
    static class DrawThread extends Thread{
        private String name;
        private Mycount mycount;
        private int x;

        DrawThread(String name, Mycount mycount, int x){
            this.name = name;
            this.mycount = mycount;
            this.x = x;
        }

        @Override
        public void run() {
            mycount.drawing(x, name);
        }
    }

    public static void main(String[] args) {
        final int CORE_POOL_SIZE = 5;
        final int MAX_POOL_SIZE = 10;
        final int QUEUE_CAPACITY = 100;
        final long KEEP_ALIVE_TIME = 1L;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                    MAX_POOL_SIZE,
                    KEEP_ALIVE_TIME,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                    new ThreadPoolExecutor.CallerRunsPolicy());
        Mycount mycount = new Mycount("1024", 1000);
        Thread t1 = new SaveThread("S1", mycount, 100);
        Thread t2 = new SaveThread("S2", mycount, 1000);
        Thread t3 = new DrawThread("D1", mycount, 12600);
        Thread t4 = new SaveThread("S3", mycount, 600);
        Thread t5 = new DrawThread("D2", mycount, 2300);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        executor.execute(t5);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}

