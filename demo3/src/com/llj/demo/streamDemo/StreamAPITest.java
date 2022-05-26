package com.llj.demo.streamDemo;

/**
 * @author llj
 * @date 2022/05/12
 */

import com.llj.demo.domain.User;
import com.llj.demo.domain.UserData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 实例化
 * 通过集合、数组
 */
public class StreamAPITest {

    /**
     * 方式一：通过集合创建
     */
    @Test
    public void test() {
        List<User> userLists = UserData.getUserLists();
//    返回一个顺序流
        Stream<User> userStream = userLists.stream();
//    返回一个并行流
        Stream<User> parallelStream = userLists.parallelStream();
    }

    /**
     * 方式二：通过数组创建
     */
    @Test
    public void test1() {
        int[] arr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(arr);

        User user1 = new User(100,"gt");
        User user2 = new User(101,"rf");
        User[] users = new User[]{user1,user2};
        Stream<User> userStream = Arrays.stream(users);
    }

    /**
     * 方式三：通过Stream of()
     */
    @Test
    public void test2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    /**
     * 方式四：创建无限刘彬
     */
    @Test
    public void test3() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);
    }


}
