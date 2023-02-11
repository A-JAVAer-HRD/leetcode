package com.huang.leetcode.editor.cn;

//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， 
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 63 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数组中好对子的数目
 *
 * @author HRD
 */
class P1814_CountNicePairsInAnArray{
    public static void main(String[] args) {
        Solution solution = new P1814_CountNicePairsInAnArray().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int revNum = rev(num); // 逆序数字
            int key = num - revNum; // nums[i] - rev(nums[i])
            map.put(key, map.getOrDefault(key, 0) + 1); // 放入哈希表
        }

        // 统计
        long res = 0;
        for (Integer value : map.values()) {
            if (value == 0 || value == 1) { // 没有相同的组合
                continue;
            }
            res = (res + (long) value * (value - 1) / 2) % MOD;
        }

        return (int) res;
    }

    // 反转数字
    private int rev(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
