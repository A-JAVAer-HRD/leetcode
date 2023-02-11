package com.huang.leetcode.editor.cn;

//给你一个下标从 0 开始的整数数组 nums ，其长度是 2 的幂。 
//
// 对 nums 执行下述算法： 
//
// 
// 设 n 等于 nums 的长度，如果 n == 1 ，终止 算法过程。否则，创建 一个新的整数数组 newNums ，新数组长度为 n / 2 ，下标从 
//0 开始。 
// 对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * 
//i + 1]) 。 
// 对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * 
//i + 1]) 。 
// 用 newNums 替换 nums 。 
// 从步骤 1 开始 重复 整个过程。 
// 
//
// 执行算法后，返回 nums 中剩下的那个数字。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [1,3,5,2,4,8,2,2]
//输出：1
//解释：重复执行算法会得到下述数组。
//第一轮：nums = [1,5,4,2]
//第二轮：nums = [1,4]
//第三轮：nums = [1]
//1 是最后剩下的那个数字，返回 1 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3]
//输出：3
//解释：3 就是最后剩下的数字，返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1024 
// 1 <= nums[i] <= 10⁹ 
// nums.length 是 2 的幂 
// 
//
// Related Topics 数组 模拟 👍 29 👎 0

/**
 * 极大极小游戏
 *
 * @author HRD
 */
class P2293_MinMaxGame {
    public static void main(String[] args) {
        Solution solution = new P2293_MinMaxGame().new Solution();
        solution.minMaxGame(new int[] {93, 40});
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int minMaxGame(int[] nums) {
        while(nums.length > 1) {
            int[] newNums = new int[nums.length / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) { // 偶数
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else { // 计数
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }*/
    public int minMaxGame(int[] nums) {
        for (int len = nums.length / 2; len > 1; len /= 2) {
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) { // 偶数
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else { // 计数
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
        }
        return nums[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
