package com.huang.leetcode.editor.cn;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 900 👎 0

/**
 * 数组中的逆序对
 *
 * @author HRD
 */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        if (left >= right) { // 终止条件
            return 0;
        }
        // 递归划分
        int mid = (left + right) / 2;
        int res = mergeSort(left, mid) + mergeSort(mid + 1, right);
        // 合并阶段
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            tmp[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i == mid + 1)
                nums[k] = tmp[j++];
            else if (j == right + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else { // tmp[i]>tmp[j]
                nums[k] = nums[j++];
                res += mid - i + 1; // 统计逆序数
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

