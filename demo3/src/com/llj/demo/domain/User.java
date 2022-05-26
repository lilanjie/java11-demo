package com.llj.demo.domain;

import java.util.Objects;

/**
 * @author llj
 * @date 2022/05/11
 */

public class User {
    private int id;
    private String name;
    private int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
            salary == user.salary &&
            Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", salary=" + salary +
            '}';
    }

    public User(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public User() {
        System.out.println(" User()");
    }

    public User(String user) {
        this.name = user;
        System.out.println(" User(String user)");
    }

    public User(int id) {
        this.id = id;
        System.out.println(" User(int id)");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String user) {
        this.name = user;
    }

    public User(int id, String user) {
        this.id = id;
        this.name = user;
        System.out.println(" User(int id, String user)");
    }
}
