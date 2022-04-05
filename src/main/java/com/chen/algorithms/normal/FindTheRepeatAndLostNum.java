package com.chen.algorithms.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误集合-645
 * input:[1,2,3,3,6]
 * output:[3,5]
 *
 * 给一个长度为 N 的数组 nums，其中本来装着 [1..N] 这 N 个元素，无序
 *
 * @author Redamancy
 * @date 2022/2/28 - 20:05
 */
public class FindTheRepeatAndLostNum {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,4,3};
        //最捞HashMap法
        int[] res = findNum(arr);
        System.out.println(res[0]+"--"+res[1]);
        //元素变负数法
        int[] res2 = findNum2(arr);
        System.out.println(res2[0]+"---"+res[1]);
        //排序法：排序好如果index的值不匹配就是重复的  1~N  num[i] = i+1

    }


    private static int[] findNum2(int[] nums){
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            //Math.abs--绝对值
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                //dup = index + 1
                //注意此处不能退出，要全部遍历，因为最终只有一个正数，其余都需要赋值成负数
                dup = Math.abs(nums[i]);
            } else {
                //假设元素不是 1~N，而是 0~N-1
                //相当于占位，每个元素值去把index=元素值的下标占位，将该下标上的元素变成负数
                //当下一次有相同元素来访问该下标时（计算公式相同，值相同得出的index相同），说明重复访问了，第二次来访问的元素就是重复值
                //没有人访问的下标就是丢失的元素的值
                nums[index] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                // 将索引转换成元素
            {
                missing = i + 1;
                break;
            }
        }

        return new int[]{dup, missing};
    }
    
    private static int[] findNum(int[] arr){
        Map<Integer, Integer> numMap = new HashMap<>(8);
        for (int i=0; i<arr.length; i++){
            if (numMap.containsKey(arr[i])){
                numMap.put(arr[i],2);
            }else {
                numMap.put(arr[i],1);
            }
        }

        int repeat=0,lost=0;
        for (int i=1;i<=arr.length;i++){
            if (numMap.containsKey(i) && numMap.get(i) > 1){
                repeat = i;
            }else if (!numMap.containsKey(i)){
                //丢失的元素将不会保存HashMap中
                lost = i;
            }

        }
        return new int[]{repeat,lost};

    }
}
