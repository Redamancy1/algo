package com.chen.algorithms.moveElements;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length =5
 * 并且原数组的前五个元素被修改为
 * 1, 1, 2, 2, 3 。即每个元素最多出现2次，次数超过2次的删除一个
 *
 * @author Redamancy
 * @date 2022/2/3 - 21:57
 */
public class DeleteRepeatElementAtMore {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,1,2,2,3};
        int result = removeDuplicates(arr);
        System.out.println(result);
    }

    private static int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<3) {
            return len;
        }
        int pos=2;
        for(int i=2;i<len;i++) {
            if(nums[i]!=nums[pos-2]) {
                nums[pos]=nums[i];
                pos++;
            }
        }
        return pos;
    }
}
