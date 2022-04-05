package com.chen.algorithms.moveElements;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *  给定 nums = [3,2,2,3], val = 3,
 *  函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * @author Redamancy
 * @date 2022/1/23 - 20:33
 */
public class PopTargetElements {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int target = 2;
        popElements1(nums,target);
        //双指针-交换元素记录下标+1，返回长度
        popElements2(nums,target);
    }

    private static void popElements1(int[] arr,int target){
        int length = arr.length;
        for (int i = 0;i < arr.length;i++){
            if (arr[i] == target){
                length --;
            }
        }
        System.out.println("最后长度："+length);
    }

    private static void popElements2(int[] nums,int target){
        if(nums.length==0) {
            System.out.println("数据异常");
        }

        int i=0,j=0;
        int temp;
        //j永远比i走的快一步
        while(j<nums.length){
            //0,1,2,2,3,0,4,2
            //只有当i和j所指元素不相同的时候，才进行交换
            //先交换再 i++,j++，避免下标越界
            if(nums[i]!=nums[j]){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            //记录target下标
            if(nums[i]!=target) {
                i++;
            }
            //记录非target下标
            if(j<=i || nums[j]==target) {
                j++;
            }
        }
        System.out.println("长度为======"+i);;
    }
}
