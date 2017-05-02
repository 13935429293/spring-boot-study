package org.ywb.study.ch3.netty.demo4;

import java.io.Serializable;

/**
 * date: 2017/4/24 19:23
 * description:
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 4057081842753402251L;
    private int age;
    private String name;
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
