package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * |-----Set接口：存储无需的，不可重复的元素：Set中常用的方法都是Collection下定义的
 *          |---------HashSet(主要实现类)
 *          |---------LinkedHashSet
 *          |---------TreeSet
 */
public class TestSet {

    /**
     * Set：存储的元素是无序的，不可重复的
     * 1.无序性：无序性不等于随机性。元素在底层存储的位置是无序的
     * 2.不可重复性：当向set添加相同元素，后面的添加不进去
     */
    @Test
    public void testHashTest(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(null);
        set.add("AA");
        set.add("BB");
        System.out.println(set);
    }
}
