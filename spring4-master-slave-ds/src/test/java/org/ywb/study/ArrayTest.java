package org.ywb.study;

import java.util.Scanner;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/25
 * Time: 13:39
 * <p>
 * 获取数组中元素值的最大值与最小值的差值，要求如下：
 * <p>
 * 定义int getNum(int[] arr)静态方法，该方法要求完成：
 * 获取指定数组arr中元素值的最大值和最小值的差值（要求返回的差值大于等于0），并返回
 * <p>
 * 定义main方法，在main方法中完成：
 * <p>
 * 1.键盘录入5个整数，并存放在int数组arr中，输入前提示输入的是第几个值
 * 2.传递数组arr调用getNum(int[] arr)方法，获取返回值，并在控制台打印输出返回值
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int a = 0; a < 5; a++) {
            System.out.println("提示输入的是第" + (a + 1) + "个值");
            Scanner s = new Scanner(System.in);
            arr[a] = s.nextInt();
        }
        int num = getNum(arr);
        System.out.println(num);

    }

    public static int getNum(int[] arr) {
        sort(arr);
        return arr[arr.length - 1] - arr[0];
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}