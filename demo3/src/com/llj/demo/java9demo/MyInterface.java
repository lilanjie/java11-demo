package com.llj.demo.java9demo;

/**
 * @author llj
 * @date 2022/05/13
 */
public interface MyInterface {

    void methodAbstract();

    static void methodStatic() {
        System.out.println("静态方法");
    }

    default void methodDefault() {
        System.out.println("默认方法");
        methodPrivate();
    }

    //私有方法，不能在接口外部调用
    private void methodPrivate() {
        System.out.println("私有方法");
    }

}
