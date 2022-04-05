package com.chen.algorithms.sort;

import java.util.Arrays;

/**
 *  插入排序
 *  下标移动到哪排序到哪，即下标所到之处前面都是排序好的
 *  每次用下标所指元素跟前面的一个一个比较，大的后移直到遇到比他小/无 就停止并把进行判断的元素赋值给该位置的后一个位置
 *  下标从第二个开始就好了，因为默认下标前面都是有序的，第二个开始排序比较
 * @author Redamancy
 * @date 2022/2/18 - 12:20
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,12,4,4,3,3,5,1,7,2,9,11};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr){
        //遍历所有数字
        for(int i=1;i< arr.length;i++){
            //如果当前数字比前一个数字小
            if(arr[i]<arr[i-1]){
                //把当前遍历的数字存起来
                int temp = arr[i];
                int j;
                //遍历当前数字前面所有的数字
                for(j=i-1;j>=0&&temp<arr[j];j--){
                    //把前一个数字赋给后一个数字
                    //即元素后移
                    arr[j+1] = arr[j];
                }
                //把临时变量赋给不满足条件的后一个元素
                arr[j+1] = temp;
            }
        }
    }
}
