package com.chen.algorithms.sort;

import java.util.Arrays;

/**
 *  希尔排序
 *  使用**步长**：相隔 步长(total/2) 进行比较，每轮 步长/2
 *  通过步长将数据分成几组分别比较，最后组合起来
 *  本质：插入排序
 *  1.确定步长
 *  2.根据步长分组
 *  3.插入排序
 *  4.递归前面步骤 直至步长为0
 *
 * @author Redamancy
 * @date 2022/2/18 - 21:21
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,12,3,5,1,7,2,9,11};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 遍历所有元素时，i = d 第一次肯定是中间那个，每次 i++ 实际上遍历新的一组元素（内部循环遍历是 步长来 递减 比较)
     * 遍历本组第一次 i-d 的 值 是第一个元素，即表示从第一个元素(本组)开始遍历本组
     * 本组元素一个循环内比较的是 **左->右**（插入排序）即将最新的一个跟前面排序好的比较
     * @param array
     */
    public static void shellSort(int[] array){
        //遍历所有的步长
        for(int d=array.length/2;d>0;d/=2){
            //遍历所有组
            for(int i=d;i<array.length;i++){
                //遍历本组中所有的元素
                for(int j=i-d;j>=0;j-=d){
                    //如果当前元素大于加上步长后的那个元素
                    if(array[j]>array[j+d]){
                        int temp = array[j];
                        array[j] = array[j+d];
                        array[j+d] = temp;
                    }
                }
            }
        }
    }
}
