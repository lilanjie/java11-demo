package com.llj.demo.java10demo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author llj
 * @date 2022/05/14
 * 局部变量类型推断
 * 根据右边
 */
public class Java10Test {
    /**
     * var
     */
    @Test
    public void test() {
        var n = 10;
        System.out.println(n);

        var list = Arrays.asList(1, 2, 3);
        for (var i : list) {
            System.out.println(i);
        }

        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    /**
     * 不适用类型举例
     * 1. 未初始化的局部变量
     * 2. lambda表达式和方法引用
     * 3. 函数的返回类型和参数（构造器参数）
     * 4. 对象属性
     * 5. try catch 块中，不能用于 catch 异常类型
     */
    @Test
    public void test1() {
        //值为null或不赋值
//        var n;

        //lambda 表达式
        Supplier<String> sup = () -> "a";
//        var sup1 = () -> "b";

        //方法引用
        Consumer<String> con = System.out::println;
//        var con = System.out::println;

        //数组的某种静态初始化
        int[] arr = new int[]{1, 2, 3};
        int[] arr1 = {12, 3};
        var arr2 = new int[]{4, 5};
//        var arr3 = {4,5};
    }

    @Test
    public void test2() {
        try {
            var url = new URL("http://www.baidu.com");
            var connection = url.openConnection();
            var bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 总结：类型推断需要等式右边有线索才能根据右边类型进行推断
     * 实际没什么大用
     * 但可以使代码更简洁，增加可读性
     */

}
