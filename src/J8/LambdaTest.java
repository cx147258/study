package J8;

import static java.lang.Thread.sleep;

public class LambdaTest {

    private static void test1(){

        MathOperation addition = (int a, int b) -> a + b;
        int sum = addition.operation(1,2);
        System.out.println(sum);//3

        MathOperation substract = ((int a, int b) -> a-b);
        int sub = substract.operation(1,2);
        System.out.println(sub);//-1

    }

    private static void test2(){

        new Thread(()->{
            for(int i = 0; i < 10; i++){
                System.out.println("this is a thread");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        test2();
    }
}
