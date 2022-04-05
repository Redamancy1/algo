package com.chen.algorithms.moveElements;

import org.springframework.util.StopWatch;

/**
 * 给定一组数字，将0移动到最后且不改变其他数字顺序
 *
 * @author Redamancy
 * @date 2022/2/15 - 21:21
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] num = new int[]{0, 2, 3, 5, 0, 4, 7};
        int[] num2 = new int[]{0, 4,2,0,7,1,0,9};
        int[] num3 = new int[]{3,0,3,1,5,0,0,7};
        StopWatch watch = new StopWatch();
        watch.start("额外空间");
        movezero(num);
        watch.stop();
        watch.start("直接赋值");
        movezero2(num2);
        watch.stop();
        //快速排序
        watch.start("交换位置");
        movezero3(num3);
        watch.stop();
        System.out.println(watch.prettyPrint());
    }

    private static void movezero(int[] num) {
        int[] temp = new int[num.length];
        int i = 0;
        for (int a : num) {
            if (a != 0) {
                temp[i] = a;
                i++;
            }
        }
        for (int j = i; j < num.length; j++) {
            temp[j] = 0;
        }
        System.out.println("额外空间法");
        for (int a : temp) {
            System.out.println(a);
        }

    }

    private static void movezero2(int[] num) {
        //0,4,2,0,7,1,0,9
        //用一个k记录有多少个移动了-记录0的下标
        int k = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                num[k] = num[i];
                k++;
            }
        }
        //对剩余的位置直接赋值 0
        for (int i = k; i < num.length; i++) {
            num[i] = 0;
        }
        System.out.println("直接赋值法");
        for (int a : num) {
            System.out.println(a);
        }
    }

    private static void movezero3(int[] nums) {
        //3,0,3,1,5,0,0,7
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //if(i!=k) 避免元素中没有0，而每个元素都与自身交换位置
                swap(nums, i, k);
                k++;
            }
        }
        System.out.println("交换位置法");
        for (int a : nums) {
            System.out.println(a);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
