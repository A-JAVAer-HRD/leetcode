package com.huang.leetcode.editor.cn;

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 1729 👎 0

/**
 * 缺失的第一个正数
 *
 * @author HRD
 */
class P41_FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new P41_FirstMissingPositive().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 原地哈希
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 // 负数不用管
                    && nums[i] <= len // 大于数组长度的数不用管
                    && nums[nums[i] - 1] != nums[i] // 数组 i - 1 的位置已经 == i 了不用交换
            ) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // 找第一个不匹配的位置
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
