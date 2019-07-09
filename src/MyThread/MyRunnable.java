package MyThread;


/**
 * java中线程的创建2：实现Runnable接口，重写该接口的run方法
 */
public class MyRunnable implements Runnable {

    private int i = 0;
    private boolean stop;

    @Override
    public void run(){
        for(i = 0; i < 100; i++){
            System.out.println("*****************"+Thread.currentThread().getName()+" "+i);
        }
    }
    public void stopThread(){
        this.stop = true;
    }
}
