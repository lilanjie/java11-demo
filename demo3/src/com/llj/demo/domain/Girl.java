package com.llj.demo.domain;

/**
 * @author llj
 * @date 2022/05/13
 */
public class Girl {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
            "name='" + name + '\'' +
            '}';
    }
}
