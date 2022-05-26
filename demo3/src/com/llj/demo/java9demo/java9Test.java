package com.llj.demo.java9demo;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author llj
 * @date 2022/05/14
 */
public class java9Test {
    /**
     * 1. 钻石操作符 省略数据类型，系统可以进行类型推断
     */
    @Test
    public void test() {
        Comparable<String> comparable = new Comparable<>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };
        comparable.compareTo("a");

        Comparable<String> comparable1 = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };
        comparable.compareTo("b");
    }

    /**
     * 2. try 改进
     */
    @Test
    public void test1() {
        /**
         * java8之前 try（代码块）
         * java8 try(语句)
         */
        try (InputStreamReader reader = new InputStreamReader(System.in)) {
            char[] chars = new char[20];
            int len;
            if ((len = reader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * java9
         */
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            char[] chars = new char[20];
            int len;
            if ((len = reader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3. 创建只读集合
     */
    @Test
    public void test2() {
        /**
         * java 8
         * Collections.unmodifiableXXX()
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Collections.unmodifiableList(Arrays.asList(0, 9, 8, 7));

        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(3, 4, 5)));
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        /**
         * java 9
         * .of()
         */
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);

        Set<Integer> set1 = Set.of(2, 3);

        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
    }

    /**
     * 4. InputStream().transferTo()
     */
    @Test
    public void test3() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        OutputStream outputStream = null;
        try (InputStream inputStream = classLoader.getResourceAsStream("hello.txt")) {
            outputStream = new FileOutputStream("src\\hell1.txt");
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
