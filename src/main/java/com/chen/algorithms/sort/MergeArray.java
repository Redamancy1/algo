package com.chen.algorithms.sort;

/**
 * 二叉树的后序遍历
 *
 * 给定两个[有序]整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * @author Redamancy
 * @date 2022/3/8 - 21:00
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0,0};
        int[] arr2 = new int[]{2,5,6,8};
        int[] arr3 = new int[]{1,2,3,0,0,0,0};
        //两个数组有效数字数量
        int m = 3,n = 4;
        //借助额外数组，从左到右
        mergeArray(arr1,arr2,m,n);
        //直接操作原数组，从右到左
        mergeArray2(arr3,arr2,m,n);
    }

    private static void mergeArray(int[] arr1,int[] arr2,int m,int n){
        int[] result = new int[m+n];
        int i = 0,j = 0,k = 0;
        //有序，依次比较两个数组中谁元素大
        while (i<m && j<n){
            if (arr1[i] <= arr2[j]){
                result[k++] = arr1[i++];
            }else {
                result[k++] = arr2[j++];
            }
        }
        //当某一数组已经全用完了，将剩余数组元素全部赋值
        while (i < m){
            result[k++] = arr1[i++];
        }
        while (j < n){
            result[k++] = arr2[j++];
        }
        //将result结果赋值给arr1
        //for-循环；
        // Object.clone()：int[] b=(int[]) a.clone()
        System.arraycopy(result,0,arr1,0,k);

        for (int a : arr1){
            System.out.println(a);
        }
    }

    private static void mergeArray2(int[] arr1,int[] arr2,int m,int n){
        int k = m+n;
        //两个数组都还没比较完
        while(m>0 && n>0){
            if(arr1[m-1] >= arr2[n-1]){
                arr1[k-1] = arr1[m-1];
                --k;
                --m;
            }
            else{
                arr1[k-1] = arr2[n-1];
                --k;
                --n;
            }
        }
        //如果n先到达0就能直接得到合并好的数组，因为本来就是有序的，m数组不需再操作
        //如果m先到达0，只需将n剩下的元素复制到nums1中即可
        while(n > 0){
            arr1[k-1] = arr2[n-1];
            --k;
            --n;
        }
    }
}
