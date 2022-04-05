package com.chen.algorithms.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个字符串中寻找没有重复字母的最长子串
 * -438,76
 * input:aabckdaaa
 * ouput:abckda
 * 知识点：滑动窗口
 *
 * @author Redamancy
 * @date 2022/2/24 - 21:26
 */
public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {

        String s = "helloSpringClouddd";
        System.out.println(lengthOfLongestSubstring(s));

    }

    private static int lengthOfLongestSubstring(String str){
        //滑动窗口 s[l,...r]
        int len = str.length(); //字符串长度
        int result = 0; //结果
        int left = 0;   //左边界
        int right = 0; //右边界
        Set set = new HashSet<Character>();
        if (len == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        /*左边界小于长度&& 剩余长度大于已记录的结果*/
        while (left < len && len - left > result) {
            /*右边界未到头&& set中不包含当前值*/
            if (right + 1 < len && !set.contains(chars[right])) {
                /*符合条件，移动右边界*/
                set.add(chars[right]);
                right++;
            }else{
                /*不符合条件，移动左边界*/
                set.remove(chars[left]);
                left++;
            }
            result = Math.max(result,right - left);
        }
        return result;
    }
}
