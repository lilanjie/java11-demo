package com.llj.demo.streamDemo;

import com.llj.demo.domain.Boy;
import com.llj.demo.domain.Girl;
import com.llj.demo.domain.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @author llj
 * @date 2022/05/13
 */
public class OptionalTest {

    @Test
    public void test() {
        User user = new User();
        User user1 = new User(1, "22", 30);
        User user2 = new User();
        user2 = null;

        // Optional.of(T t) t必须为空
        Optional<User> optionalUser1 = Optional.of(user);
        System.out.println(optionalUser1);
        System.out.println();
        Optional<User> optionalUser2 = Optional.ofNullable(user);
        System.out.println(optionalUser2);
        System.out.println();

        // Optional.ofNullable(T t) t可以为null
        Optional<User> optionalUser = Optional.ofNullable(user2);
        User grf = optionalUser.orElse(new User("grf"));
        System.out.println(optionalUser);
        System.out.println(grf);
        System.out.println();

        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
    }

    public String getGirlName(Boy boy) {
        if (boy != null) {
            if (boy.getGirl() != null) {
                return boy.getGirl().getName();
            }
        }
        return null;
    }
    @Test
    public void test2() {
        Boy boy = new Boy();
        getGirlName(boy);
    }

    /**
     * ofNullable() 和 orElse() 的使用
     * @param boy
     * @return
     */
    public String getGirlName2(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("备胎男的备胎女")));
        //确保boy1不为空，才能getGirl()
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("备胎女"));
        //确保girl1不为空，才能getName()
        return girl1.getName();
    }
    @Test
    public void test3() {
        Boy boy1 = new Boy();
        Boy boy2 = new Boy("2男");
        Boy boy3 = new Boy("3男", new Girl("3女"));
        Boy boy4 = new Boy(new Girl("4女"));
        Boy boy5 = new Boy();
        boy5 = null;
        System.out.println(getGirlName2(boy1));
        System.out.println("-----boy1------");
        System.out.println(getGirlName2(boy2));
        System.out.println("-----boy2------");
        System.out.println(getGirlName2(boy3));
        System.out.println("-----boy3------");
        System.out.println(getGirlName2(boy4));
        System.out.println("-----boy4------");
        System.out.println(getGirlName2(boy5));
        System.out.println("-----boy5------");
    }
}
