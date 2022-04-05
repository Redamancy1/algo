package com.chen.algorithms.moveElements;

/**
 * 有序的数组！！
 *
 * 给定一个有序数组，删除重复内容，使每个元素只出现一次，并返回新的长度。
 * 不要为其他数组分配额外的空间，您必须通过在 O（1）额外的内存中就地修改输入数组来实现这一点。
 *  给定nums = [1,1,2]，
 * 你的函数应该返回length = 2，前两个nums元素分别是1和2。
 * 无论你离开新的长度，都没有关系。
 *
 * @author Redamancy
 * @date 2022/2/3 - 21:36
 */
public class DeleteRepeatElement {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,2,3,3,3,4};
        deleteRepeatElement(arr);
    }

    private static void deleteRepeatElement(int[] arr){
        if (arr.length == 0){
            System.out.println("数据异常");
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[j] != arr[i]){
                j++;
                arr[j] = arr[i];
            }
        }
        int result = j+1;
        System.out.println("调整后的长度为："+result);
    }

}
