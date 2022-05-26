package com.llj.demo.java9demo;

/**
 * @author llj
 * @date 2022/05/13
 */
public class MyInterfaceImpl implements MyInterface {
    /**
     * 静态方法只能由接口调用，且不能被实现类继承和重写
     * 私有方法只能在接口内部被调用
     */
    public static void main(String[] args) {
        System.out.println("---------methodStatic---------");
        MyInterface.methodStatic();

        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        System.out.println("---------methodAbstract---------");

        myInterface.methodAbstract();
        System.out.println("---------methodDefault---------");
        myInterface.methodDefault();
    }

//    @Override
//    public void methodDefault() {
//        System.out.println("实现类重写默认方法");
//    }

    @Override
    public void methodAbstract() {
        System.out.println("抽象接口方法");
    }
}
