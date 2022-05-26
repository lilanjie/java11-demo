package com.llj.demo.streamDemo;

import com.llj.demo.domain.User;
import com.llj.demo.domain.UserData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author llj
 * @date 2022/05/12
 * Stream 的中间操作
 * 过滤、去重、跳过、限量
 * 一个流只能
 */

public class StreamAPITest1 {


    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test() {
        List<User> userLists = UserData.getUserLists();
        Stream<User> userStream = userLists.stream();

        //过滤数据 Stream<T> filter(Predicate<? super T> predicate);
        userStream.filter(user -> user.getSalary() > 500).
            forEach(System.out::println);
        System.out.println();
        // 去除重复 ,前提是对象中写了equals()和hashcode()
        userLists.stream().distinct().forEach(System.out::println);
        System.out.println();

        //截断流，使元素不超过给定数量
        userLists.stream().limit(5).forEach(System.out::println);
        System.out.println();

        //skip() 跳过前N个元素
        userLists.stream().skip(3).forEach(System.out::println);
        System.out.println();

        //元素数据不足N个返回空流
         userStream.skip(10).forEach(System.out::println);
    }

    /**
     * 映射
     */
    @Test
    public void test1() {
        //    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        List<String> list = Arrays.asList("sa", "de");
        list.stream().map(s -> s.toUpperCase())
            .forEach(System.out::println);

        System.out.println();
        List<User> users = UserData.getUserLists();
        Stream<Integer> stream = users.stream().map(User::getSalary);
        stream.filter(a -> a > 500).forEach(System.out::println);
        System.out.println();

        //flatMap 剥开所有层,每层都转换成一个流，然后将所有流接成一个流
        Stream<Stream<Character>> stream1 = list.stream()
            .map(StreamAPITest1::fromStringToStream);
        stream1.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();

        list.stream().flatMap(StreamAPITest1::fromStringToStream)
            .forEach(System.out::println);
    }

    /**
     * 排序
     */
    @Test
    public void test2() {
        //sorted() 按自然排序，即Integer 的默认 Comparable
        List<Integer> list = Arrays.asList(12, 34, 32, 11, 23);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();

        //自定义类实现Comparable接口后可使用sorted()
        //自定义类可利用  实现排序
        List<User> userLists = UserData.getUserLists();
        userLists.stream().sorted(Comparator.comparing(User::getId))
            .forEach(System.out::println);

        userLists.stream().sorted((u1, u2) -> Integer.compare(u1.getId(), u2.getId()))
            .forEach(System.out::println);
        System.out.println();

        userLists.stream().sorted((u1, u2) -> {
            int compare = Integer.compare(u1.getId(), u2.getId());
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(u1.getSalary(), u2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
