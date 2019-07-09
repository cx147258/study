package MyThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable{
    private int taskNum;

    public MyTask(int num){
        this.taskNum = num;
    }

    @Override
    public void run(){
        System.out.println("正在执行task" + taskNum);
        try{
            Thread.currentThread().sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("task" + taskNum + "执行完毕");
    }


    public static void main(String[] args) throws Exception{
        /**创建线程池
         * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
         * BlockingQueue<Runnable> workQueue);
         * corePoolSize：核心池的大小
         *
         * maximumPoolSize：线程池最大线程数
         *
         * keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止
         *
         * unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
         * TimeUnit.DAYS;               //天
         * TimeUnit.HOURS;             //小时
         * TimeUnit.MINUTES;           //分钟
         * TimeUnit.SECONDS;           //秒
         * TimeUnit.MILLISECONDS;      //毫秒
         * TimeUnit.MICROSECONDS;      //微妙
         * TimeUnit.NANOSECONDS;       //纳秒
         *
         * workQueue：一个阻塞队列，用来存储等待执行的任务
         */


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,11,
                200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        for(int i = 0; i < 16; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);//执行
            System.out.println("线程池中的数目："+executor.getPoolSize()+" 队列中等待的数目"+executor.getQueue().size()
            +" 已执行玩的任务的数目"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
        /**
         * shutdown()方法，则线程池处于SHUTDOWN状态，此时线程池不能够接受新的任务，它会等待所有任务执行完毕
         * shutdownNow()方法，则线程池处于STOP状态，此时线程池不能接受新的任务，并且会去尝试终止正在执行的任务
         */
    }
}
