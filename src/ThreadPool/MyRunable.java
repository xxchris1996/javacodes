package ThreadPool;

import java.util.Date;

public class MyRunable implements Runnable{

    private String command;

    public MyRunable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start.Time:" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "End.Time:" + new Date());
    }

    @Override
    public String toString() {
        return "MyRunable{" +
                "command='" + command + '\'' +
                '}';
    }

    private void processCommand(){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
