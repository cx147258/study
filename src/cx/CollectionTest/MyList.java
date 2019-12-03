package cx.CollectionTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyList {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();//顺序表
        List<String> list2 = new LinkedList<String>();//链表

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        list1.remove(2);

        for(int i = 0 ; i < list1.size(); i++){

            System.out.println(list1.get(i));
        }

        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");

        Iterator<String> it = list2.iterator();
        while (it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

    }
}
