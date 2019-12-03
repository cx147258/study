package cx.ThreadTest;

/**
 * 新启线程只有俩个方法
 * 1.继承Thread类
 * 2.实现Runnable接口
 */
public class ThreadTest {

    public static void threadTest(){
        new MyThread().start();
    }

    public static void main(String[] args){

//        threadTest();

        //1 继承Thread，重写run方法
//        for(int i = 0; i < 100; i++){
//            System.out.println(Thread.currentThread().getName()+" "+i);
//            if(i == 30){
//                Thread myThread1 = new cx.ThreadTest();//New状态
//                Thread myThread2 = new cx.ThreadTest();
//                myThread1.start();
//                myThread2.start();
//            }
//        }

        //2
//        for(int i = 0; i < 100; i++){
//            System.out.println(Thread.currentThread().getName()+" "+i);
//            if(i == 30){
//                Runnable myRunnable = new MyRunnable();//创建一个Runnable实现类的对象
//                Thread thread1 = new Thread(myRunnable);//将myRunnable作为Thread的target创建新的线程
//                Thread thread2 = new Thread(myRunnable);
//                thread1.start();//调用start方法使线程进入就绪状态
//                thread2.start();
//            }
//        }

        //3
        Runnable myRunnable = new MyRunnable();//创建一个Runnable实现类的对象
        Thread thread1 = new Thread(myRunnable);//将myRunnable作为Thread的target创建新的线程
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 30){
                thread1.start();//调用start方法使线程进入就绪状态
            }
            if(i == 40){
                ((MyRunnable) myRunnable).stopThread();
            }
        }
    }
}
