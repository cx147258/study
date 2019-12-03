package cx.CollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap {
    public static void main(String[] args){
        //定义一个Map的容器对象
        Map<Integer,String> map1 = new HashMap<Integer,String>();
        map1.put(1,"a");
        map1.put(2,"b");
        map1.put(3,"c");
        System.out.println("map1"+map1);

        Map<Integer,String> map2 = new HashMap<Integer,String>();
        map2.put(1,"AAA");
        map2.put(2,"BBB");
        map2.put(3,"CCC");
        System.out.println("map2"+map2);

        //从指定映射中将所有映射关系复制到此映射中
        map1.putAll(map2);
        System.out.println("map1"+map1);
        System.out.println("map2"+map2);

        // remove() 删除关联对象，指定key对象
        // clear() 清空集合对象
        map1.remove(1);
        System.out.println("map1"+map1);
        map1.clear();
        System.out.println("map1"+map1);

        //get(Object key)获取key对应的value值
        System.out.println("map2 1:value->"+map2.get(1));
        System.out.println("map1.size="+map1.size());
        System.out.println("map2.size="+map2.size());

        //判断
        // boolean isEmpty() 长度为0返回true否则false
        // boolean containsKey(Object key) 判断集合中是否包含指定的key,contains是包含的意思
        // boolean containsValue(Object value)判断集合中是否包含指定的value
        System.out.println("map1.isEmpty()="+map1.isEmpty());
        System.out.println("map2.isEmpty()="+map2.isEmpty());
        System.out.println("map2.containsKey(2)="+map2.containsKey(2));
        System.out.println("map2.containsValue(AAA)="+map2.containsValue("AAA"));

        //遍历
        //1.keySet()
        // 需要分别获取key和value，没有面向对象的思想
        // Set<K> keySet() 返回所有的key对象的Set集合
        Set<Integer> ks = map2.keySet();
        Iterator<Integer> it = ks.iterator();
        while(it.hasNext()){
            Integer key = it.next();
            String value = map2.get(key);
            System.out.println("key = "+key+" ,value = "+value);
        }
        //返回map中的value值
        for(String value:map2.values()){
            System.out.println("value = "+value);
        }

        //2. Map.Entry
        //返回的Map.Entry对象的Set集合 Map.Entry包含了key和value对
        //Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
        Set<Map.Entry<Integer,String>> es = map2.entrySet();//Map.entrySet() 这个方法返回的是一个Set<Map.Entry<K,V>>
        Iterator<Map.Entry<Integer,String>> it1 = es.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> en = it1.next();
            Integer key = en.getKey();
            String value = en.getValue();
            System.out.println("key = "+key+" ,value = "+value);
        }
    }
}
