package com.llj.demo.lambdaDemo;

/**
 * @author llj
 * @date 2022/05/07
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 本质： 函数式接口 @FunctionalInterface的实例
 * -> 操作符 ，左边：形参列表，右边：方法体
 * 1. 接口 = （） -> 单句方法体；
 * 2. 接口 = （参数，...）-> 单句方法体；
 * 3. 接口 = （）-> {多句方法体};
 * 不需要写明接口中的具体方法名（接口中只有一个方法）
 */
public class LambdaTest2 {

    /**
     * 类型一 ：无参数，无返回值
     */
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("今天周六");
            }
        };
        r1.run();

        System.out.println("*********************");

        Runnable r2 = () -> {
            System.out.println("但是要上班");
        };
        r2.run();
    }

    /**
     * 类型二 ：有参数，无返回
     */
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("今天开会吗？");

        System.out.println("_______________");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("有，软件例会");
    }

    /**
     * 类型三 ：有参数，参数类型可省略，由系统进行类型推断，无返回
     */
    @Test
    public void test3() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("今天开会吗？");

        System.out.println("_______________");

        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("有，软件例会");
    }

    /**
     * 类型四 ：有参数，（）可省略
     */
    @Test
    public void test4() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("今天开会吗？");

        System.out.println("_______________");

        Consumer<String> consumer1 = s -> System.out.println(s);

        consumer1.accept("有，软件例会");
    }

    /**
     * 类型五 ：有参数，有返回,{}可省略
     */
    @Test
    public void test5() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = comparator.compare(12, 32);
        System.out.println(compare);

        System.out.println("-----------------------------------");

        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        int compare1 = com1.compare(21, 32);
        System.out.println(compare1);
    }

    /**
     * 类型六 ：有参数，有返回，{}不可省略
     */

    @Test
    public void test6() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int compare = comparator.compare(1, 2);
        System.out.println(compare);

        System.out.println("-----------------------------");

        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare1 = comparator1.compare(2, 1);
        System.out.println(compare1);
    }


}
