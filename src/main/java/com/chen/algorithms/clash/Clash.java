package com.chen.algorithms.clash;

import org.springframework.util.StopWatch;

/**
 * TODO
 *
 * @author Redamancy
 * @date 2022/1/15 - 20:05
 */
public class Clash {

    public static void main(String[] args) {

        //两数之和-167
        twoNumSum();

        //判断字符串是否是回文串-125
        ifPalindrome();

        //反转元音字母-345
        reVowel();

        //寻找最大体积容器-高与宽的选取及过程最优解的比较保存-11
        maxArea();

        //寻找长度最小的子数组-滑动窗口-209
        // 本质也是遍历找到所有符合条件的并临时存储依次比较找到最优解
        minLength();
    }

    /**
     *给定一个含有n个正整数的数组和一个正整数s
     * 找出该数组中满足其和 >= s 的长度最小的连续子数组，不符合返回0
     * 输入 s = 7,nums = [2,3,1,2,4,3]
     * 输出 2
     * 子数组【4,3】满足长度为2
     */
    private static void minLength(){
        int[] array = new int[]{1,8,6,1,5,1,2,5,4,4,3,9};
        int target = 13;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("题目209-遍历");
        getLength(target,array);
        stopWatch.stop();
        stopWatch.start("题目209-滑动窗口");
        getLength2(target,array);
        stopWatch.stop();
        stopWatch.start("题目209-二分法");
        getLength3(target,array);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    private static void getLength(int target,int[] array){

    }

    private static void getLength2(int target,int[] array){
        int left = 0;
        //把[left, right]区间看作是一个滑动窗口，初始时滑动窗口中没有元素故right = -1
        int right = -1;
        int sum = 0;
        //n + 1比整个数组的长度还大，但要注意这个值其实是取不到的
        int len = array.length + 1;
        while (left < array.length){
            if (right+1<array.length && sum<target){
                right++;
                sum += array[right];
            }else {
                sum -= array[left];
                left++;
            }
            if (sum >= target){
                //len是上一轮匹配的子串长度，与本轮匹配到的字串长度比较，选取最小的
                len = Math.min(len,right - left+1);
            }
        }
        if (len == array.length + 1){
            System.out.println("没有匹配的子串");
        }else {
            System.out.println("匹配的最小字串长度为："+len);
        }
    }

    private static void getLength3(int target,int[] array){

    }

    private static void maxArea(){
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("题目11-指针对撞");
        water(array);
        stopWatch.stop();
        stopWatch.start("题目11-暴力法");
        water2(array);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

    /**
     * 双指针，且需要额外的变量保留当前最大面积
     * 不需要双层循环
     * @param array
     */
    private static void water(int[] array){
        if(array == null || array.length == 0 || array.length == 1){
            System.out.println("装不了");
        }
        int left = 0;
        int right = array.length - 1;
        //临时最大面积变量
        int maxArea = 0;

        while(left<right){
            //当前间距
            int b = right - left;
            //当前短边的值（高）,面积由短边起决定作用
            int tall = 0;
            //短边向中间移动
            if (array[left] < array[right]){
                tall = array[left];
                left++;
            }else {
                tall = array[right];
                right--;
            }
            int area = tall*b;
            if (area > maxArea){
                maxArea = area;
            }
        }
        System.out.println("最大面积是：" + maxArea);
    }

    /**
     * 循环每一个元素与其他元素相乘所得面积
     * 比较两者较小的为高，坐标距离为宽：面积=高*宽，每次比较所得面积较大最后输出
     * @param array
     */
    private static void water2(int[] array){
        if(array == null || array.length == 0 || array.length == 1){
            System.out.println("装不了");
        }
        int len = array.length;
        int maxRes = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                //短边为高，盛水取决于短边
                int hei = Math.min(array[i], array[j]);
                //面积为高*间距
                int area = (j - i) * hei;
                //循环比较保留与较大值
                if(area > maxRes) {
                    maxRes = area;
                }
            }
        }
        System.out.println("最大容积为："+maxRes);
    }


    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。a,e,i,o,u
     * 输入: "hello"
     * 输出: "holle"
     * 输入: "leetcode"
     * 输出: "leotcede"
     */
    private static void reVowel(){
        //这里为了方便暂时不用大写字母，若需要自行换小写
        String vowelWord = "aha!leetcode";
        char[] vowel = vowelWord.toCharArray();
        int left = 0;
        int right = vowelWord.length()-1;
        while (left < right){
            if (!isVowel(vowel[left])){
                left++;
            }else if (!isVowel(vowel[right])){
                right--;
            }else if(isVowel(vowel[left]) && isVowel(vowel[right])){
                char a = vowel[left];
                vowel[left] = vowel[right];
                vowel[right] = a;
                left ++;
                right --;
            }
        }
        System.out.println("反转结果为：");
        System.out.println(vowel);
    }

    /**
     * 给你字符串 s 和整数 k 。
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     * 输入：s = "abciiidef", k = 3
     * 输出：3
     * 解释：子字符串 "iii" 包含 3 个元音字母。
     *
     * 输入：s = "leetcode", k = 3
     * 输出：2
     * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        //从左到右遍历窗口
        int right =0;
        //每一轮新的字串得到的当前解
        int sum = 0;
        //最优解的临时存储变量
        int max = 0;
        while (right < s.length()) {
            //判断当前字符是否是元音，元音就数量+1
            sum += isVowel(s.charAt(right)) ? 1 : 0;
            //+完右移继续下一位
            right++;
            if (right >=k) {
                //保留符合条件的最优解
                max = Math.max(max, sum);
                //固定只要 k 位，多了就要去掉第一位（是否元音），继续右移直到将字符串中所有字符可能出现情况都计算
                sum -= isVowel(s.charAt(right-k)) ? 1 : 0;
            }
        }
        return max;
    }

    /**
     * 是否元音字母
     */
    private static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }

    private static void ifPalindrome(){
        String word = "Able was I ere I saw Elba";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("题目125-指针对撞");
        System.out.println(palindrome(word));
        stopWatch.stop();
        stopWatch.start("题目125-ASCII码");
        System.out.println(palindrome2(word));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    private static void twoNumSum(){
        int[] array = new int[]{1,2,3,4,8,23,26,30,34,45,56,78};
        int target = 26;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("题目193-指针对撞");
        getTarget(array,target);
        stopWatch.stop();
        stopWatch.start("题目193-暴力");
        getTarget2(array,target);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 0, index2 = 1 。
     * @param arrays
     * @param target
     */
    private static void getTarget(int[] arrays, int target){

        int left = 0;
        int right = arrays.length - 1;
        for (int i = 0 ; i < arrays.length ; i++){
            if (arrays[left] + arrays[right] < target){
                left ++;
            }else if (arrays[left] + arrays[right] > target){
                right--;
            }
            if (arrays[left] + arrays[right] == target){
                System.out.println("下标：["+left+","+right+"]");
                break;
            }
        }
    }

    private static void getTarget2(int[] arrays,int target){
        for (int i = 0;i < arrays.length-1;i++){
            for (int j = i+1;j < arrays.length;j++){
                if (arrays[i]+arrays[j] == target){
                    System.out.println("下标：["+i+","+j+"]");
                    break;
                }
            }
        }
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 本题中，我们将空字符串定义为有效的回文串。
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 输入: "race a car"
     * 输出: false
     * @param word
     */
    public static boolean palindrome(String word){
        //"Able was I ere I saw Elba"
        char[] chars = word.toCharArray();
        //如果当前字符不是字母或数字、或首尾两个字符相同，向中间逼近，否则退出
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            if (!Character.isLetterOrDigit(chars[left])){
                left++;
            }else if (!Character.isLetterOrDigit(chars[right])){
                right--;
            }else if (Character.toLowerCase(chars[left])==Character.toLowerCase(chars[right])){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * A~Z:65-90
     * a~z:97-122
     * @param s
     */
    public static boolean palindrome2(String s){
        //字符串转换数组，通过ASCII码过滤字母，还要将大写字母转成小写字母的ASCII码，然后判断-麻烦
        if (s==null){
            return true;
        }
        byte[] bytes1 = s.getBytes();
        int count = 0;
        int[] bytes = new int[bytes1.length];
        for (int i = 0; i < bytes1.length; i++) {
            if (bytes1[i]>=48&&bytes1[i]<58){
                bytes[count] = bytes1[i];
                count++;
            }
            if (bytes1[i]>96&&bytes1[i]<123){
                bytes[count] = bytes1[i];
                count++;
            }
            if (bytes1[i]>64&&bytes1[i]<91){
                //将大写字母的ASCII码值转换成小写的
                bytes[count] = bytes1[i]+32;
                count++;
            }
        }
        //找到回文数的中间值
        int flag = count/2;
        for (int i = 0; i < flag; i++) {
            if (bytes[i]!=bytes[count-i-1]){
                return false;
            }
        }
        return true;

    }


























}
