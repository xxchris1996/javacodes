package DemoWaitAndNotify;

public class ChiHuo extends Thread {
    private BaoZi bz;

    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag==false){
                    try {
                        bz.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("正在吃"+bz.pi+bz.xian);
                bz.flag=false;
                bz.notify();
                System.out.println("包子吃完了，继续做包子");
            }
        }
    }
}
