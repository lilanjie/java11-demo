package com.llj.demo.streamDemo;

import com.llj.demo.domain.User;
import com.llj.demo.domain.UserData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author llj
 * @date 2022/05/12
 * 测试Stream终止操作
 */

public class StreamAPITest2 {
    /**
     * 1. 匹配与查找
     */
    @Test
    public void test() {
        List<User> userLists = UserData.getUserLists();
        boolean allMatch = userLists.stream().allMatch(u -> u.getSalary() > 50);
        System.out.println("allMatch: " + allMatch);
        System.out.println();

        boolean anyMatch = userLists.stream().anyMatch(u -> u.getSalary() > 2000);
        System.out.println("anyMatch: " + anyMatch);
        System.out.println();

        boolean noneMatch = userLists.stream().noneMatch(u -> u.getSalary() > 4000);
        System.out.println("noneMatch: " + noneMatch);
        System.out.println();

        Optional<User> first = userLists.stream().findFirst();
        System.out.println(first);
        System.out.println();

        System.out.println(userLists.stream().count());
        System.out.println();

        String s = userLists.stream().max(Comparator.comparing(User::getSalary))
            .toString();
        System.out.println(s);
        System.out.println();

        Stream<Integer> salarryStream = userLists.stream().map(User::getSalary);
        Optional<Integer> max = salarryStream.max(Integer::compareTo);
        System.out.println(max);
    }

    /**
     * 2. 归约
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().reduce(Integer::sum));
        System.out.println();

        List<User> userLists = UserData.getUserLists();
        Stream<Integer> stream = userLists.stream().map(User::getSalary);
        Optional<Integer> reduce = stream.reduce(Integer::sum);
        //    stream.reduce((s1, s2) -> s1 + s2);
        System.out.println(reduce);
    }

    /**
     * 收集
     */
    @Test
    public void test2() {
        List<User> userLists = UserData.getUserLists();
        List<User> userList = userLists.stream()
            .filter(user -> user.getSalary() > 51)
            .collect(Collectors.toList());
        userList.forEach(System.out::println);
    }

}
