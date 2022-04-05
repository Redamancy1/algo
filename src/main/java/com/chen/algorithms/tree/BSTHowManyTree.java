package com.chen.algorithms.tree;

/**
 * 不同的二叉搜索树 - 96
 * 给定一个正整数 n,计算 {1,2,3,... n}共有多少种BST结构
 * 考虑BST左小右大，穷举+组合
 *
 * @author Redamancy
 * @date 2022/3/29 - 20:53
*/
public class BSTHowManyTree {

    private static int[][] memo;

    public static void main(String[] args) {
        int n = 5;
        System.out.println("结果可以构成的BST共有："+mainCount(n)+"种组合");
        System.out.println(count2(5)+":"+count3(5));
    }

    private static int mainCount(int n){
        memo = new int[n+1][n+1];
        return count(1,n);
    }

    /**
     * 递归-不要纠结递归过程中的执行中间结果，只要对递归的任务是什么清楚就好
     * 计算闭区间[1,n]能够组成的BST个数
     * @param low
     * @param high
     * @return
     */
    private static int count(int low,int high){
        if (low > high) {
            return 1;
        }

        //避免重复计算-动态规划消除重叠子问题
        if (memo[low][high] != 0){
            return memo[low][high];
        }

        int res = 0;
        for (int i = low; i <= high; i++){
            //i的值作为根节点root
            int left = count(low,i - 1);
            int right = count(i+1,high);
            //左右子树的组合数乘积就是当前节点可能的 BST 总个数
            int rootTotal = left * right;
            //累加和
            res += rootTotal;
        }

        //记录计算过的结果
        memo[low][high] = res;

        return res;
    }

    /**
     * 动态规划
     * 给出的n代表有n个节点，1,2,3,4,5，……n，这些节点组成的不同形态的二叉查找树，是说中序遍历这些树，得到的序列就是 1,2,3,4,5，……n。
     * 根据二叉查找树可以知道，某根节点x，它的左子树的值全<=x（当然本题不存在等于的情况），它的右子树的值全>=x，所以，当它的根节点是 1 的时候，左子树个数为 0 ，右子树的个数为 n-1， 当它的根节点为 2 的时候， 左子树个数为 1， 右子树的个数为 n-2……
     * 还有一个规律，就是这棵树的不同形态的二叉查找树的个数，就是根节点的  左子树的个数*右子树的个数，想想还是很容易理解的，就是左边的所有情况乘以右边的所有情况，知道这个规律就好做啦。
     * 动态规划，从前到后计算出当有i个节点时,它有多少种不同形态的树。nums[i] += nums[j] * nums[i-1-j]  （初始j==0，每做完一步j++）。（这里i-1-j 减掉的 1 代表是根节点占了一个位置）
     * 当节点个数为0时有一种形态的树（也就是空树吧），当节点个数为1时有一种形态的树，之后就可以向下继续计算节点为2,3,4,5，……n。
     * @param n
     * @return
     */
    private static int count2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] nums = new int[n+1];
        nums[0] = 1; nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //左：j  右：i-j-1 看做左右子树所含的节点数量
                nums[i] += nums[j] * nums[i-1-j];
            }
        }
        return nums[n];

    }

    private static int count3(int n) {

        int sum = 0;

        if (n <= 1) {
            return 1;
        }

        // 以当前的数为根节点，左右两边的数分别构建子树
        for (int i = 1; i <= n; i++)
        {
            // 左边的数可以构建多少个二叉搜索树
            int leftNum = count3(i - 1);
            // 右边的数可以构建多少个二叉搜索树
            int rightNum = count3(n - i);

            sum += leftNum * rightNum;
        }

        return sum;
    }

}
