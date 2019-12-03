package cx.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestIterator {
    //使用增强for循环实现数组的遍历
    @Test
    public void testFor1(){
        String[] str = new String[]{"AA","BB"};
        for(String s:str){ //s是新定义的局部变量，其值的修改不会对str造成影响
            System.out.println(s);
        }
    }

    //使用增强for循环实现集合的遍历
    @Test
    public void testFor(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add("AA");
        coll.add("DD");
        coll.add("BB");
        coll.add("CC");

        for(Object i:coll){
            System.out.println(i);
        }
}

    //错误的写法
    @Test
    public void test2(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add("AA");
        coll.add("DD");
        coll.add("BB");
        coll.add("CC");

        Iterator it = coll.iterator();
        while(it.next() != null){ //间隔着打印，会出现空指针异常
            System.out.println(it.next());
        }

    }

    //正确的写法
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add("AA");
        coll.add("DD");
        coll.add("BB");
        coll.add("CC");

        Iterator it = coll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
