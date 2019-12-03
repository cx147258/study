package cx.ThreadTest;

import java.util.concurrent.Callable;

/**
 * java中线程的创建3：通过Callable和Future创建线程
 * call()方法有返回值
 * run()方法没有返回值
 */
public class MyThreadCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //doSomething
        return 5;
    }
}
