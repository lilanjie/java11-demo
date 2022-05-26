package com.llj.demo.java10demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author llj
 * @date 2022/05/16
 */
public class Java10Test1 {
    /**
     * 只读集合操作 copyOf()：
     * 若源集合是只读集合，直接返回源集合；
     * 否则，会调用List.of() 创建一个新的只读集合
     */
    @Test
    public void test() {
        var list = new ArrayList<String>();
        var copy = List.copyOf(list);
        System.out.println(list == copy);

        var list1 = List.of(1, 2, 3);
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1);
    }
}
