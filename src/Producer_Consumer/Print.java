package Producer_Consumer;

public class Print {

    public static void main(String[] args) {
        Resource1 resource1 = new Resource1();
        ComsumerThread comsumerThread1 = new ComsumerThread(resource1,0);
        ComsumerThread comsumerThread2 = new ComsumerThread(resource1,1);
        ProducerThread producerThread = new ProducerThread(resource1,0);
        producerThread.start();
        comsumerThread1.start();
        comsumerThread2.start();


    }
}
class Resource1 {
    private int num;
    private int size = 10;

    public synchronized void add(){
        if(num < size){
            num++;
//            System.out.println("生产者："+ Thread.currentThread().getName() + "生产一件资源，现在有"+num+"个。");
            notify();
        } else {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + "进入等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void remove(){
        if(num > 0){
//            num--;
            System.out.println("消费者："+ Thread.currentThread().getName() + "生产消耗资源，现在有"+num+"个。");
            notify();
        } else {
            try {
                wait();
                System.out.println("资源不足");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ComsumerThread extends Thread{
    private Resource1 resource1;
    private int id;
    public ComsumerThread(Resource1 resource1, int id){
        this.resource1 = resource1;
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource1.remove();
        }
    }
}

class ProducerThread extends Thread{
    private Resource1 resource1;
    private int id;
    public ProducerThread(Resource1 resource1, int id){
        this.resource1 = resource1;
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource1.add();
        }
    }
}
