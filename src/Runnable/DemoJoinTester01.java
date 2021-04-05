package Runnable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DemoJoinTester01 implements Runnable{
    private String name;

    public DemoJoinTester01(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(2);
//            System.out.println(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DemoJoinTester01("One"));
        Thread thread2 = new Thread(new DemoJoinTester01("Two"));
        thread1.start();
        thread2.start();

        try {
            thread2.join();
            thread1.join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }

}
