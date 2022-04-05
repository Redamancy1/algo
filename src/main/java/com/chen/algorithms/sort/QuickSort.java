package com.chen.algorithms.sort;

import java.util.Arrays;

/**
 * 二叉树的前序遍历
 *  快速排序
 *  选取一个中间数，数据一分为二，小的在左，大的在右(无序)
 *  过程：右->左，跟第一个比较，大就不动下标 j 前移一位
 *  小就跟第一个交换位置，同时第一个下标 i 后移一位。
 *  最后 i，j 重复的位置放第一个数
 *  下一轮：左右各自以第一个数为比较单位，递归操作，直到剩下一个（i,j 重合）
 *  参数初始传入：arr,0,arr.length-1
 * @author Redamancy
 * @date 2022/2/15 - 11:04
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,4,9,5,1,10,3,2,9,11};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        int[] arr2 = new int[]{6,2,5,6,7,2,1,1};
//        Arrays.com.chen.algorithms.sort(arr2);
//        System.out.println(Arrays.toString(arr2));
    }

    public static void quickSort(int[] arr,int start,int end){
        //直到剩下一个元素 start = end
        if(start < end){
            //把数组中的第 0 个数字作为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high){
                //左右的比较是轮流的
                //右边的数字比标准数大，下标往前移动，即大的不动
                while (low<high && stard<=arr[high]){
                    high--;
                }
                //使用右边的数字替换左边的数
                //即将当前这轮的标准数替换掉
                arr[low] = arr[high];

                //如果左边的数字比标准数小，下标往后移动，即小的不动
                while (low<high && arr[low]<=stard){
                    low++;
                }
                //使用左边的数字替换右边的数字
                //即将前面替换标准数的小值所在位置替换成新的大值
                arr[high] = arr[low];
            }
            //low 跟 high 已重合
            //把标准数赋值给低位所在位置的元素
            //这一步已经把数组分成两部分：大于标准数 和 小于标准数
            //arr[low] = arr[high]
            arr[low] = stard;
            //递归处理所有小的数字
            quickSort(arr,start,low);
            //递归处理所有大的数字
            quickSort(arr,low+1,end);
        }

    }
}