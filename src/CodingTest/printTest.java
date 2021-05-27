package CodingTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

//public class printTest extends Thread{
//    private static AtomicInteger num = new AtomicInteger();
//    private int id;
//
//    printTest(int id){
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//        while (num.get() < 100){
//            num.incrementAndGet();
//            System.out.println(Thread.currentThread().getName()+" "+num.get());
//        }
//    }
//
//    public static void main(String[] args) {
//        printTest pt0 = new printTest(0);
//        printTest pt1 = new printTest(1);
//        pt0.start();
//        pt1.start();
//    }
//}

//public class printTest extends Thread{
//    private static int num = 0;
//    private int id;
//    printTest(int id){
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//        while (num <= 100){
//            synchronized (printTest.class){
//                System.out.println(Thread.currentThread().getName()+" "+num);
//                num++;
//                printTest.class.notify();
//                try {
//                    printTest.class.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        printTest t0 = new printTest(0);
//        printTest t1 = new printTest(1);
//        t0.start();
//        t1.start();
//    }
//}

public class printTest extends Thread{
    private int id;
    private static int num = 0;
    Semaphore semaphore;
    printTest(int id, Semaphore semaphore){
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (num < 100){
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" "+num);
                num++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        printTest t0 = new printTest(0, semaphore1);
        printTest t1 = new printTest(1, semaphore1);
        t0.start();
        t1.start();
    }
}