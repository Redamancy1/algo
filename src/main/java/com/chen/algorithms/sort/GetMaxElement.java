package com.chen.algorithms.sort;

import java.util.Random;

/**
 * 给定一乱序数组，在其中找到第k个大的数字
 * C = [3,2,1,5,6,4], k = 2, 返回5
 * 需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 *
 * @author Redamancy
 * @date 2022/3/8 - 20:59
 */
public class GetMaxElement {

    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,9,5,1,10,3,2,9,11};
        int k = 5;
        //快排后的第k个，不需要去全部排序，根据下标去操作元素
        int target = findKthLargest(arr,k);
        System.out.println("第"+k+"大的元素是---"+target);
    }

    /**
     * 假设j是第k大元素的下标，第k大的下标就为 k-1(降序排序)
     * j = k-1:j就是第k大的元素
     * j > k-1:当前元素找大了，第k大元素在[left,j-1]区间
     * j < k-1:当前元素找小了，第k大元素在[j+1,right]区间
     * 每次只操作"一半"的元素，将数据先排序好，从找元素值变成比对元素下标
     * 最终找的是元素的下标
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums,int k){
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int left = 0,right = length - 1;
        while(left < right){
            //分区，将“大小”分为两边
            int pos = partition(nums,left,right);
            //第k大的即使 下标为 k-1 的元素
            if (pos == k - 1) { break; }
            if (pos < k - 1) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return nums[k-1];
    }

    public static int partition(int[] nums,int left,int right){
        int temp = nums[left];
        while (left < right){
            //降序排序，大的放左边
            while (left < right && nums[right] <= temp){
                //右边的数字比标准数小时，下标左移，直到遇到比标准数大的(记录他准备换到最前面)
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= temp){
                //左边的数字比标准数大时，下标右移，直到遇到比标准数小的（记录他准备换到最后面)
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
