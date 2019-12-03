package cx.ThreadTest;

public class MyThread2 extends Thread {
    private String name;
    private Object co;

    public MyThread2(String name, Object co){
        this.co = co;
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println(name + "is waiting");
        try{
            synchronized (co){
                co.wait();
            }
            System.out.println(name + "has been notified");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
