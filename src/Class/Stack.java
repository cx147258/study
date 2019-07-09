package Class;

public class Stack {
    private int size;//栈的大小
    private int top;//栈顶元素的下标
    private int[] stackArray;//栈的容器

    //构造函数
    public Stack(int size){
        stackArray = new int [size];
        top = -1;//栈初始化的时候，栈内无元素，栈顶的下标为-1
        this.size = size;
    }


    public void push(int elem){
        stackArray[++top] = elem;//插入栈顶
    }

    //出栈，返回栈顶元素，返回后，栈顶元素的下标减1（删除栈顶元素）
    public int pop(){
        return stackArray[top--];
    }

    //查看栈顶元素，但不删除
    public int peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == size-1);
    }
}
