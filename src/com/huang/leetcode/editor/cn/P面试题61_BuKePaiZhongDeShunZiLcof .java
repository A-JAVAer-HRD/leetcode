package com.huang.leetcode.editor.cn;

//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
//
// Related Topics 数组 排序 👍 288 👎 0

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * @author HRD
 */
class P面试题61_BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题61_BuKePaiZhongDeShunZiLcof().new Solution();
        solution.isStraight(new int[]{0,0,2,2,5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums); // 排序：统计joker
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) { // 排除相等的两张直接为错
                return false;
            } else if (nums[i] + 1 != nums[i + 1]) {
                int res = nums[i + 1] - nums[i] - 1; // 需要几张joker
                if (res > joker) return false;
                else joker -= res;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
