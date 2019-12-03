package cx.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    //ArrayList : List的主要实现类
    //List存储有序的，可重复的元素

    /**
     * List中相对于Collection，新增加的方法
     *
     * 1. void add(int index, Object ele):在指定的索引位置index添加元素ele
     * 2. boolean addAll(int index, cx.CollectionTest eles)
     * 3. Object get(int index):获取指定索引的元素
     * 4. int indexOf(Object obj):返回obj在集合中首次出现的位置,没有返回-1
     * 5. int lastIndexOf(Object obj):返回obj在集合中最后一次出现的位置，没有返回-1
     * 6. Object remove(int index):删除指定索引位置的元素
     * 7. Object set(int index, Object ele):修改指定索引位置index的元素为ele
     * 8. List subList(int fromIndex, int toIndex):返回[fromIndex，toIndex)的list
     *
     * list常用的方法：增（add）删（remove）改（set）查（get）插（add）长度（size）
     */


    @Test
    public void testList2(){
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add("AA");
        list.add("BB");
        list.add("CC");

        System.out.println(list.indexOf("AA"));
        System.out.println(list.lastIndexOf("BB"));

        List list1 = list.subList(2,4);
        System.out.println(list1);
    }
    @Test
    public void testList1(){
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add(1,0);

        System.out.println(list);
        Object obj = list.get(2);
        System.out.println(obj);
        list.remove(1);
        System.out.println(list);
        list.set(0,9);
    }
}
