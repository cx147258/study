package cx.ThreadTest;

/**
 * java中线程的创建1：继承Thread，重写run方法
 */
public class MyThread extends Thread {
    private int count = 10;

    @Override
    public void run(){
        while(true){
            System.out.print(count + " ");
            if(count-- == 0){
                return;
            }
        }
    }
}
