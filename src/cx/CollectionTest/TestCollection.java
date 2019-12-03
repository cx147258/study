package cx.CollectionTest;

import org.junit.Test;

import java.util.*;

public class TestCollection {

   @Test
   public void testCollection2(){
       Collection coll = new ArrayList();
       coll.add(123);
       coll.add("AA");
       coll.add(new Date());
       coll.add("BB");
       coll.add("CC");

       //6.contains(Object obj):判断集合中是否包含指定的obj
       //判断依据：根据元素所在类的equal()方法进行判断
       //明确：如果存入集合中的元素是自定义类的对象。要求：自定义类重写equal()方法
       boolean b1 = coll.contains("AA");
       System.out.println(b1);

       //7.containsAll(cx.CollectionTest coll):判断当前集合中是否包含coll中所有元素
       Collection coll1 = new ArrayList();
       coll1.add(123);
       ((ArrayList) coll1).add("AA");
       boolean b2 = coll.containsAll(coll1);
       System.out.println(b2);//true

       //8.retainAll(cx.CollectionTest coll):求当前集合与coll的共有的元素，返回给当前集合
       System.out.println("coll: " + coll); //coll: [123, AA, Thu Oct 25 09:53:21 CST 2018]
       System.out.println("coll1: " + coll1); // coll1: [123, AA]
       coll.retainAll(coll1);
       System.out.println("coll: " + coll); //coll: [123, AA]

       //9.remove(Object obj):删除集合中的obj元素，成功返回true，失败返回false
       boolean b4 = coll.remove("22");
       boolean b5 = coll.remove("AA");
       System.out.println(b4);
       System.out.println(b5);

       //10.removeAll(cx.CollectionTest coll):从当前集合中删除包含在coll中的元素
       Collection coll2 = new ArrayList();
       coll2.add(123);
       coll2.add("AA");
       coll2.add("BB");
       coll.add(new Date());
       coll.add("BB");
       coll.add("CC");

       System.out.println("coll: " + coll); //coll: [123, Thu Oct 25 10:04:08 CST 2018, BB, CC]
       System.out.println("coll2: " + coll2);// coll2: [123, AA, BB]
       coll.removeAll(coll2);
       System.out.println("coll: " + coll); // coll: [Thu Oct 25 10:04:08 CST 2018, CC]

       //11.equals(Object obj):判断俩个集合中的所有元素是否完全相等
       coll2.equals(coll);

       //12.hashCode():计算哈希值
       System.out.println(coll.hashCode());

       //13.toArray():将集合转化成数组
       Object obj[] = coll.toArray();
       System.out.println("obj数组： ");
       for(int i = 0 ; i < obj.length; i++) {
           System.out.println(obj[i]);
       }

       //14.iterator():返回一个Iterator接口实现类的对象
       Iterator it = coll.iterator();
       while(it.hasNext()){
           System.out.println(it.next());
       }
   }

    @Test
    public void testCollection(){
        Collection coll = new ArrayList();

        //1.size():返回集合中元素的个数
        System.out.println(coll.size());

        //2.add(Object obj):像集合中添加一个元素
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        System.out.println(coll.size());
        System.out.println(coll);

        //3.addAll(cx.CollectionTest coll):将形参coll中的所有元素添加到当前集合
        Collection coll1 = Arrays.asList(1,2,3);
        ((ArrayList) coll).addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //4.isEmpty():判断集合是否为空
        System.out.println(coll.isEmpty());

        //5.clear():清空集合元素
        coll.clear();
        System.out.println(coll);
    }
}
