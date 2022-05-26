package com.llj.demo.domain;

/**
 * @author llj
 * @date 2022/05/13
 */
public class Boy {
    private String name;
    private Girl girl;

    public Boy(String name) {
        this.name = name;
    }

    public Boy() {

    }

    public Boy(String name, Girl girl) {
        this.name = name;
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
            "name='" + name + '\'' +
            ", girl=" + girl +
            '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }
}
