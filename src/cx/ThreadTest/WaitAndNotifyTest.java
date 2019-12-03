package cx.ThreadTest;

import static java.lang.Thread.sleep;

public class WaitAndNotifyTest {

    private static void notifyTest(){
        Object co = new Object();
        System.out.println(co);

        for(int i = 0; i < 5; i++){
            MyThread2 myThread2 = new MyThread2("Thread"+i,co);
            myThread2.start();
        }

        try{
            sleep(2000);
            System.out.println("Main Thread Notify");
            synchronized (co){
                co.notify();
            }
            sleep(2000);
            System.out.println("Main Thread is end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void notifyAllTest(){
        Object co = new Object();
        System.out.println(co);

        for(int i = 0; i < 5; i++){
            MyThread2 myThread2 = new MyThread2("Thread"+i,co);
            myThread2.start();
        }

        try{
            sleep(2000);
            System.out.println("Main Thread Notify");
            synchronized (co){
                co.notifyAll();
            }
            sleep(2000);
            System.out.println("Main Thread is end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        notifyTest();
        notifyAllTest();
    }
}
