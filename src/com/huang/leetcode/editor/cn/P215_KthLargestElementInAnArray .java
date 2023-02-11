package com.huang.leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2004 👎 0

/**
 * 数组中的第K个最大元素
 *
 * @author HRD
 */
class P215_KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(arr, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    /**
     * 快速排序
     */
    private void quickSort(int[] nums, int l, int r) {
        // 子数组长度为1，终止递归
        if (l >= r) return;
        // 哨兵划分(以arr[l]作为基准数)
        int i = l, j = r;
        while (i < j) {
            // 从大到小 排序
            while (i < j && nums[j] <= nums[l]) j--;
            while (i < j && nums[i] >= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        // 递归 左右子数组，执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }

    /**
     * 线性时间选择
     */
    private int quickSort(int[] nums, int k, int l, int r) {
        // 哨兵划分(以arr[l]作为基准数)
        int i = l, j = r;
        while (i < j) {
            // 从大到小 排序
            while (i < j && nums[j] <= nums[l]) j--;
            while (i < j && nums[i] >= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l); // 划分值 和 最后一个<他的元素交换
        // 递归 左右子数组，执行哨兵划分
        // 递归
        if (i > k - 1) return quickSort(nums, k, l, i - 1);
        else if (i < k - 1) return quickSort(nums, k, i + 1, r);
        else return nums[i]; // nums[i] 就是 第K大的数
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
