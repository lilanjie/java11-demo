package com.llj.demo.lambdaDemo;

/**
 * @author llj
 * @date 2022/05/07
 */

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用，是Lambda的另一种语法格式
 * 三种使用肠镜
 */
public class MethodRefTest {

    /**
        场景一：对象：：实例方法
        需要对象，是否冗余相较于Lambda
     */
    @Test
    public void test1() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello!");

        System.out.println("--------------------");

        //Lambda 表达式中使用到了方法 println，属于对象System.out
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("你好！");
    }

    /**
      场景二：类：：静态方法
     */
    @Test
    public void test2() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        int compare = comparator.compare(1, 2);
        System.out.println(compare);

        System.out.println("-------------");

        Comparator<Integer> comparator1 = Integer::compareTo;
        int compare1 = comparator1.compare(2, 1);
        System.out.println(compare1);
    }

    @Test
    public void test3() {
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        Long apply = function.apply(1.3);
        System.out.println(apply);

        System.out.println("-------------------------");

        Function<Double, Long> fun = d -> Math.round(d);
        System.out.println(fun.apply(1.1));

        System.out.println("------------------");

        Function<Double, Long> fun1 = Math::round;
        System.out.println(fun1.apply(2.1));
    }

    /**
     * 场景三：类：：实例方法
     */
    @Test
    public void test5() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("***********");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("ss", "sa"));

    }


}
