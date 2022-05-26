package com.llj.demo.lambdaDemo;


import org.junit.Test;

import java.util.Comparator;

/**
 * @author llj
 * @date 2022/05/07
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("今天周六要上班！");
            }
        };

        run1.run();
    }

    /**
     * -> 操作符 ，左边：形参列表，右边：方法体
     * 1. 接口 = （） -> 单句方法体；
     * 2. 接口 = （参数，...）-> 单句方法体；
     * 3. 接口 = （）-> {多句方法体};
     * 不需要写明接口中的具体方法名（接口中只有一个方法）
     */
    @Test
    public void test2() {
        Runnable run2 = () -> System.out.println("今天周六就是要上班");
        run2.run();
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = comparator1.compare(12, 21);
        System.out.println(compare1);
    }

    @Test
    public void test4() {
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare = comparator2.compare(21, 12);
        System.out.println(compare);
    }

    /**
     * 方法引用
     */
    @Test
    public void test5() {
        Comparator<Integer> comparator3 = Integer::compare;
        int compare3 = comparator3.compare(34, 21);
        System.out.println(compare3);
    }

}
