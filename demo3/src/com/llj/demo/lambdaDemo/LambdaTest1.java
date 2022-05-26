package com.llj.demo.lambdaDemo;

/**
 * @author llj
 * @date 2022/05/07
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 * 1. Consumer<T>,参数类型T，返回void
 * 2. Supplier<T>,返回T
 * 3. Function<T,R>,传入T，返回R
 * 4. Predicate<T>, 传入T，返回boolean
 */
public class LambdaTest1 {

    @Test
    public void test1() {
        sayMoney(400, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("今天花了" + integer + "块！");
            }
        });

        System.out.println("-----------------------------");

        sayMoney(500, money -> System.out.println("今天花了" + money + "块！"));

    }

    public void sayMoney(Integer money, Consumer<Integer> consumer) {
        //声明两个参数之间的关系
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京");
        List<String> strings = seeLists(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(strings);

        System.out.println("-------------------------");

        List<String> strings1 = seeLists(list, s -> s.contains("京"));
        System.out.println(strings1);
    }

    public List<String> seeLists(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }
}
