package com.llj.demo.java9demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author llj
 * @date 2022/05/14
 * StreamAPI增强
 */
public class java9StreamTest {
    /**
     * takeWhile()
     * dropWhile()
     */
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(12, 32, 54, 32, 67, 56, 43);
        //take elements while condition
        Stream<Integer> takeWhile = list.stream().takeWhile(n -> n < 60);
        takeWhile.forEach(System.out::println);
        System.out.println();

        //drop elements while condition
        Stream<Integer> dropWhile = list.stream().dropWhile(n -> n < 60);
        dropWhile.forEach(System.out::println);
        System.out.println(dropWhile);
    }

    /**
     * 空值
     */
    @Test
    public void test1() {
        //of() 允许多个元素中存在null，不允许单个null
        Stream<Integer> stream = Stream.of(1, 2, null);
        stream.forEach(System.out::println);
        //ofNullable() 允许单个null
        Stream<Object> stream1 = Stream.ofNullable(null);
        stream1.forEach(System.out::println);
    }

    /**
     * iterate()
     */
    @Test
    public void test2() {
        //java 8
        Stream.iterate(0,x->x+1).limit(10).
            forEach(System.out::println);

        //java 9 重载
        Stream.iterate(0,x->x<100,x->x+1).limit(10).
            forEach(System.out::println);
    }

    /**
     * optional类中Stream()
     */
    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
        stream.flatMap(x-> x.stream()).forEach(System.out::println);
    }

}
