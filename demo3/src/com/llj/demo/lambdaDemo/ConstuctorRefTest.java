package com.llj.demo.lambdaDemo;

/**
 * @author llj
 * @date 2022/05/11
 */

import com.llj.demo.domain.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.jar.JarOutputStream;

/**
 * 构造器引用
 * 数组引用
 */
public class ConstuctorRefTest {

    /**
     * 构造器引用
     */
    @Test
    public void test() {
        Supplier<User> sup = new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        };
        sup.get();
        System.out.println("----------------");

        Supplier<User> sup1 = () -> new User();
        sup.get();
        System.out.println("------------");

        Supplier<User> sup2 = User::new;
        sup2.get();
        System.out.println("------------");
        sup2.get();

    }

    @Test
    public void test1() {
        Function<Integer, User> fun1 = id -> new User(id);
        fun1.apply(2);
        System.out.println("------------");

        Function<Integer, User> fun2 = User::new;
        fun2.apply(3);
        System.out.println("------------");
    }

    @Test
    public void test2() {
        BiFunction<Integer,String,User> fun1 =(id, name) -> new User(id, name);
        fun1.apply(4,"李大嘴");
        System.out.println("------------");

        BiFunction<Integer,String,User> fun2 = User::new;
        fun2.apply(5,"白展堂");
    }

    /**
     * 数组引用
     */
    @Test
    public void test3() {
        Function<Integer,String[]> fun1 = length -> new String[length];
        String[] strings = fun1.apply(3);
        System.out.println(Arrays.toString(strings));
        System.out.println("-------------------");

        Function<Integer,String[]> fun2 = String[] ::new;
        System.out.println(Arrays.toString(fun2.apply(5)));
    }
}
