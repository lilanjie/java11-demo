package com.llj.demo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author llj
 * @date 2022/05/12
 */
public class UserData {
    public static List<User> getUserLists() {
        List<User> list = new ArrayList<>();
        User user = new User(1,"佟湘玉",0);
        User user1 = new User(2,"白展堂",2000);
        User user2 = new User(3,"吕轻侯",2000);
        User user3 = new User(4,"李大嘴",4000);
        User user4 = new User(5,"郭芙蓉",2000);
        User user5 = new User(6,"莫小贝",50);
        User user6 = new User(6,"莫小贝",50);
        User user7 = new User(6,"莫小贝",51);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.add(user);
        return list;
    }
}
