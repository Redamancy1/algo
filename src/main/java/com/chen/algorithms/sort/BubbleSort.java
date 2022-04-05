package com.chen.algorithms.sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Redamancy
 * @date 2022/2/18 - 11:19
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,7,2,9,11};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        //控制共比较多少轮
        for(int i=0;i<arr.length-1;i++){
            //控制比较的次数
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
