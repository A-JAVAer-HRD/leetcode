package com.huang.leetcode.editor.cn;

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
//
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 326 👎 0

/**
 * 0～n-1中缺失的数字
 *
 * @author HRD
 */
class OfferII_QueShiDeShuZiLcof{
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        /**
         * 二分查找
         * 0 <= nums[i] <= n-1
         */
        public int missingNumber(int[] nums) {
            int right = nums.length - 1;
            int left = 0;
            while (left <= right) {
                int mid = left + ((right - left) / 2); // mid
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else right = mid - 1;
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
