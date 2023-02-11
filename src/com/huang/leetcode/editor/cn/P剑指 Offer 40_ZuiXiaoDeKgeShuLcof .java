package com.huang.leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 500 👎 0

import java.util.Arrays;

/**
 * 最小的k个数
 *
 * @author HRD
 */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1); // 左闭右闭[,]
    }

    private int[] quickSort(int[] arr, int k, int left, int right) {
        // 哨兵划分
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left])
                j--;
            while (i < j && arr[i] <= arr[left])
                i++;
            swap(arr, i, j);
        }
        swap(arr, i, left);//划分值 和 最后一个<他的元素交换
        // 递归
        if (i > k) quickSort(arr, k, left, i - 1);
        else if (i < k) quickSort(arr, k, i + 1, right);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

