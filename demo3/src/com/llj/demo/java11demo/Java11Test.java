package com.llj.demo.java11demo;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author llj
 * @date 2022/05/16
 */
public class Java11Test {
    /**
     * String 新增方法
     */
    @Test
    public void test() {
        //判断字符串是否为空白，全部为true
        System.out.println("".isBlank());
        System.out.println(" ".isBlank());
        System.out.println("  \t ".isBlank());
        //strip()去除首尾空白
        System.out.println("----" + " abd  ".strip() + "----");
        System.out.println("----" + "  abd  ".trim() + "----");
        System.out.println("----" + " \t abd  \n  ".strip() + "----");
        System.out.println("----" + " \t abd  \n  ".trim() + "----");
        //stripTrailing()去除尾部空格；stripLeading()去除头部空格
        System.out.println("----" + " abd  ".stripTrailing() + "----");
        System.out.println("----" + " abd  ".stripLeading() + "----");
        //.repeat(n)重复N次
        System.out.println("abc".repeat(3));
        //lines().count()
        System.out.println(" a\n b\n c");
        System.out.println("a\n b\n c".lines().count());
    }

    /**
     * Optional 新增方法
     */
    @Test
    public void test1() {
        var op = Optional.empty();
        System.out.println(op.isPresent());
        System.out.println(op.isEmpty());
        /* System.out.println(op.orElseThrow()); */

        Optional<String> op1 = Optional.of("1");
        System.out.println(op1.orElseThrow());
        /* op = Optional.of("shala"); */
        Optional<Object> op2 = op.or(() -> op1);
        System.out.println(op2);
    }

    /**
     * 局部变量类型推断升级
     */
    @Test
    public void test2() {
        //lambda 表达式中给var参数加注解
        Consumer<String> consumer =
            (@Deprecated var t)-> System.out.println(t);
    }

    /**
     * HttpClient 替换原有的HttpURLConnection
     */
    @Test
    public void test3() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("")).build();
            HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, stringBodyHandler);
            String body = response.body();
            System.out.println(body);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
