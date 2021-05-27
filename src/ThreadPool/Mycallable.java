package ThreadPool;

import java.util.concurrent.Callable;

public class Mycallable implements Callable<Integer> {
    public Mycallable(int i) {
        System.out.println(i);
    }

    private int sum;

    @Override
    public Integer call() throws Exception {
            System.out.println("Callable子线程开始计算啦！");
            Thread.sleep(2000);

            for (int i = 0; i < 5000; i++) {
                sum = sum + i;
            }
            System.out.println("Callable子线程计算结束！");
            return sum;
    }
}
