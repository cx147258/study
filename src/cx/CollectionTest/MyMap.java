package cx.CollectionTest;

import java.util.*;

public class MyMap {

    public static void test1(){

        Map<String,String> map = new HashMap<>();//创建map实例
        map.put("1","lili");//向集合中添加对象
        map.put("2","huahua");

        Set<String> set = map.keySet();//构建map集合中所有key对象的集合
        Iterator<String> it = set.iterator();//创建集合迭代器

        System.out.println("map key ");
        while(it.hasNext()){//遍历集合
            System.out.println(it.next());
        }

        Collection<String> coll = map.values();//构建map集合中所有value对象的集合
        it = coll.iterator();

        System.out.println("map value");
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


    /**
     *
     遍历map

     keySet()方法：返回此映射中所包含的键的 set 视图（集合）
     public Set<K> keySet()

     value()方法：返回此映射所包含的值的 collection 视图
     public cx.CollectionTest<V> values()

     entrySet()方法：返回此映射所包含的映射关系的 collection 视图（这边有点疑问：因为事实上返回的是Set），在返回的集合中，每个元素都是一个Map.Entry
     public Set<Map.Entry<K,V>> entrySet()

     */

    public static void main(String[] args) {

//        test1();

        /**
         * 遍历map的方法
         */

        Map<String,String> map = new HashMap<String,String>();

        map.put("test1","A");

        map.put("test2","B");

        map.put("test3","C");

        map.put("test4","D");

        map.put("test5","E");

        //使用keySet方法，取出所有的键组成Set集合
        System.out.println(map.keySet());
        //使用values方法，取出所有的值组成的Collection
        System.out.println(map.values());
        //entrySet()方法，取出 所有的键-值组成Set集合
        System.out.println(map.entrySet());


        //将Map中的键，值取出，有三种常见的方法：
        // 1
        System.out.println("通过keySet()方法取出键，再通过迭代分别取出对应的值");
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext())
        {
            String key = it.next();
            String value = map.get(key);		//通过get方法，获取键对应的值
            System.out.println(key+" "+value);	//将键和值都打印出来
        }

        // 2

        System.out.println("通过entrySet()来访问该集合，得到每个Map.Entry元素，最后通过getKey()和getValue()方法得到键和值");
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        while(it2.hasNext())
        {
            Map.Entry<String,String> me = it2.next();
            System.out.println(me.getKey()+" "+me.getValue());		//通过getKey()得到键
        }

        // 3
        System.out.println("通过values(),只能取出value值");
        Iterator<String> it3 = map.values().iterator();
        while(it3.hasNext())
        {
            String name = it3.next();
            System.out.println(name);				  //打印出所有的值
        }

        //使用for-each

        //遍历map中的键
        System.out.println("使用for-each，遍历map中的键");
        for (String key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        //遍历map中的值
        System.out.println("使用for-each，遍历map中的值");
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }

        System.out.println("使用for-each，遍历map中的键值对");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
