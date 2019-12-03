package cx.CollectionTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class ArrayListRandomAccessTest {
    public static void main(String[] args){
        List list= new ArrayList();
        for (int i = 0 ; i < 100000; i++){
            list.add(i);
        }
        iteratorThroughRandomAccess(list);
        System.out.println(" ");
        iteratorThroughIterator(list);
        System.out.println(" ");
        iteratorThroughFor2(list);
    }

    private static void isRandomAccess(List list){
        //RandomAccess 是一个标记接口，判断集合是否ArrayList或LinkedList，从而选择更优的便利方式，提高性能
        if(list instanceof RandomAccess){ //instanceof运算符用来判断对象是否一个特定类的实例
            System.out.println("RandomAccess implemented");
        }
        else{
            System.out.println("RandomAccess not implemented");
        }
    }

    //随机访问，通过索引值遍历
    public static void iteratorThroughRandomAccess(List list){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++){
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess  " + interval + "ms");
    }

    //通过迭代器访问
    public static void iteratorThroughIterator(List list){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator  " + interval + "ms");
    }

    //通过for循环访问
    public static void iteratorThroughFor2(List list){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj : list){
            ;
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2  " + interval + "ms");
    }

}
