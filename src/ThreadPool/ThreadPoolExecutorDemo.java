package ThreadPool;

import jdk.jshell.spi.ExecutionControl;

import java.net.Inet4Address;
import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

//        for (int i = 0; i < 10; i++){
//            Runnable workers = new MyRunable("" + i);
//            executor.execute(workers);
//            while (!executor.isTerminated()) {
//            }
//            System.out.println("Finished all threads");
//        }
        Mycallable mycallable = new Mycallable(1);
        FutureTask<Integer> futureTask = new FutureTask<>(mycallable);
        executor.submit(futureTask);
        System.out.println(futureTask.get());
        Future<Integer> submit1 = executor.submit(mycallable);
        System.out.println(submit1.get());
        executor.shutdown();
    }
}
