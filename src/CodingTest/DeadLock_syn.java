package CodingTest;

public class DeadLock_syn extends Thread{
    private static String resource0 = "resource0";
    private static String resource1 = "resource1";

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                synchronized (DeadLock_syn.resource0){
                    System.out.println(Thread.currentThread().getName() +" "+ resource0);
                    synchronized (DeadLock_syn.resource1){
                        System.out.println(Thread.currentThread().getName() +" "+ resource1);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (DeadLock_syn.resource0){
                    System.out.println(Thread.currentThread().getName() +" "+ resource0);
                    synchronized (DeadLock_syn.resource1){
                        System.out.println(Thread.currentThread().getName() +" "+ resource1);
                    }
                }
            }
        }.start();
    }
}
