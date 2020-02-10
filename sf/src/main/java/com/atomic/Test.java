package com.atomic;

/**
 * @Auther: tianchao
 * @Date: 2020/2/8 21:20
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int a = -1<<29;
        System.out.println(Integer.toBinaryString(a));
        int b = 0<<29;
        System.out.println(Integer.toBinaryString(b));
        int c = 1<<29;
        System.out.println(Integer.toBinaryString(c)+" ================"+c);
    }
}
