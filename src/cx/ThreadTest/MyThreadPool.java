package cx.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {

    /***
     *   4种线程池
     *   1.newCachedThreadPool 调用execute将重用以前构造的线程，如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有60s未被使用的线程
     *   2.newFixedThreadPool 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
     *   3.newScheduledThreadPool 创建一个线程池，它可安排在给定延迟后运行命令或定期的执行
     *   4.newSingleThreadExecutor 返回一个线程池，这个线程池可以在线程死后重新启动一个线程来代替原来的线程继续执行下去
     */
    public static void threadPoolTest(){
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(true){
            threadPool.execute(new Runnable() {//提交多个任务，并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "is running...");
                    try{
                        Thread.sleep(3000);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public static void main(String[] args) {
        threadPoolTest();
    }
}
