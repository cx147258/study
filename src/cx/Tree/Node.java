package cx.Tree;

public class Node {
    int age;
    String name;
    Node leftChild;//左子节点的引用
    Node rightChild;//右子节点的引用

    public Node(int age,String name){
        this.age = age;
        this.name = name;
    }

    //打印该节点信息
    public void dispalyNode(){
        System.out.println("age = " + age + "；name = " + name);
    }
}
