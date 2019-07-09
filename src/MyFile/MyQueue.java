package MyFile;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private int[] queArray;
    private int maxSize;
    private int front;
    private int rear;
    private int length;

    public MyQueue(int maxSize){
        this.maxSize = maxSize;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        length = 0;
    }

    //插入
    public void insert(int elem) throws Exception{
        if(isFull()){
            throw new Exception("队列已满,不能插入");
        }
        //如果队尾指针已到达数组末端，插入到数组的第一个位置
        if(rear == maxSize - 1){
            rear = -1;
        }
        queArray[++rear] = elem;
        length++;
    }

    //移除
    public void remove()throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空，不能移除");
        }
        if(front == maxSize){
            front = 0;
        }
        front++;
        length--;
    }

    //查看队头元素
    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("队列中没有元素");
        }
        return queArray[front];
    }

    //获取队列长度
    public int size(){
        return length;
    }

    //判空
    public boolean isEmpty(){
        return (length == 0);
    }

    //判满
    public boolean isFull(){
       return (length == maxSize);
    }

    public static void main(String[] args) throws Exception {
//        MyQueue myQueue = new MyQueue(5);
//        myQueue.insert(1);
//        System.out.println(myQueue.size());
//        System.out.println(myQueue.peek());
//        myQueue.remove();
//        System.out.println(myQueue.size());


        //java中队列使用方法
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q:queue){
            System.out.println(q);
        }
        System.out.println("------------------");

        System.out.println("poll = "+queue.poll());//返回队列中的第一个元素，并在队列中删除
        for(String q:queue){
            System.out.println(q);
        }
        System.out.println("------------------");

        System.out.println("element = "+queue.element());//返回第一个元素
        for(String q:queue){
            System.out.println(q);
        }
        System.out.println("------------------");

        System.out.println("peek = "+queue.peek());//返回第一个元素
        for(String q:queue){
            System.out.println(q);
        }
        System.out.println("------------------");
    }
}
