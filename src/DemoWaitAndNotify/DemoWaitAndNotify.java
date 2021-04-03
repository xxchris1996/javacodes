package DemoWaitAndNotify;

public class DemoWaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("告知老板包子种类和数量");
                    try{
                        obj.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("开冲！");
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println("5秒后做好了");
                    obj.notify();
                }
            }
        }.start();
    }
}
