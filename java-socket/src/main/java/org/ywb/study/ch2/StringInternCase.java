package org.ywb.study.ch2;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/30
 * Time: 18:00
 */
public class StringInternCase {
    public static void main(String[] args) {

        String a = new StringBuffer("xiaoyang").append("test").toString();
        String b = new StringBuffer("java").toString();

        System.out.println(a.intern() == a);
        System.out.println(a.intern() == a);
        System.out.println(a.intern() == a);
        System.out.println(b.intern() == b);
        System.out.println(b.intern() == b);
        System.out.println(b.intern() == b);
    }
}
