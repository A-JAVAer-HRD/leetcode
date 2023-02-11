package com.huang.leetcode.editor.cn;

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// Related Topics 数组 二分查找 👍 382 👎 0

/**
 * 在排序数组中查找数字 I
 *
 * @author HRD
 */
class Offer53ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        new Solution().search(new int[]{5,7,7,8,8,10}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 左闭右闭[,]
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (nums[right] != target) {
                    right--;
                }
                if (nums[left] != target) {
                    left++;
                } else if (nums[right] == nums[left]) {
                    return right - left + 1;
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
