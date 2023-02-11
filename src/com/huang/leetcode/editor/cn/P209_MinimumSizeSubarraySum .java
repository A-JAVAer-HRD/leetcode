package com.huang.leetcode.editor.cn;

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1419 👎 0

/**
 * 长度最小的子数组
 *
 * @author HRD
 */
class P209_MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new P209_MinimumSizeSubarraySum().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 滑动窗口
     * */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        //滑动窗口 for i遍历的是结束的位置 j是起始的位置
        int j = 0;
        int sum = 0;//滑动窗口的大小
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) { //窗口的大小大于要求的值 起始位置向前 缩窗口
                int subLength = i - j + 1;
                res = Math.min(subLength, res);
                sum -= nums[j++];//就相当于之前的和减去了起始位置的值 起始位置++
            }
        }
        if (res == Integer.MAX_VALUE) { //数组中的和不大于target
            return 0;
        }else {
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
