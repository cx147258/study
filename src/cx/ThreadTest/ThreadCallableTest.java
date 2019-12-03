package cx.ThreadTest;

import java.util.concurrent.FutureTask;

public class ThreadCallableTest {
    public static void main(String[] args) {

        MyThreadCallable myThreadCallable = new MyThreadCallable();
        FutureTask<Integer> future = new FutureTask<Integer>(myThreadCallable);//使用FutureTask类来包装Callable对象
        new Thread(future,"有返回值的线程").start();//Callable对象来创建并启动线程
        try{
            System.out.println("子线程的返回值"+future.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
