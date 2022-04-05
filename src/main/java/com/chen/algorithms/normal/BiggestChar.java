package com.chen.algorithms.normal;

/**
 * 获取最大公共子串长度，非最大公共子序列
 * 公共子串 ≠ 公共子序列
 * 效率估计较差，需要所有组合都遍历走一遍判断是否包含
 *
 * @author Redamancy
 * @date 2022/2/16 - 21:34
 */
public class BiggestChar {

    public static void main(String[] args) {

        String s1 = "qwerabcdtyuiop";
        String s2 = "xbcabcdvbn";
        String s = getMaxSubstring(s2, s1);
        System.out.println("最大公共子串 = " + s);
    }

    /**
     * 获取最大子串
     ** 思路：
     *  * 1，既然取得是最大子串，先看短的那个字符串是否在长的那个字符串中。
     *  * 如果存在，短的那个字符串就是最大子串。
     *  * 2，如果不是呢，那么就将短的那个子串进行长度递减的方式去子串，去长串中判断是否存在。
     *  * 如果存在就已找到，就不用在找了。
     * @param s1
     * @param s2
     * @return
     */
    public static String getMaxSubstring(String s1, String s2) {

        String max,min;
        //先区别哪个字符串较长较短
        max = (s1.length()>s2.length())?s1:s2;
        min = max.equals(s1)?s2:s1;

        System.out.println("max="+max);
        System.out.println("min="+min);

        for (int i = 0; i < min.length(); i++) {
            //每层依次判断数量从 min.length() 到 1 递减直到包含,
            //由于是从大到下递减所以有多个符合的子串时也是优先返回了较长的子串
            for(int a = 0,b = min.length()-i; b != min.length()+1; a++,b++){
                //subString(a,b) = [a,b)
                String sub = min.substring(a, b);
                if(max.contains(sub)) {
                    return sub;
                }
            }
        }
        return null;
    }
}
