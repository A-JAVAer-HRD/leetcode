package com.huang.leetcode.editor.cn;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//
// Related Topics 数学 双指针 枚举 👍 495 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 * @author HRD
 */
class Offer57II_HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target <= 2) return new int[][] {};
        List<int[]> res = new LinkedList<>();
        int slow = 1; // 左边界
        int faster = 2; // 右边界
        int sum = 3;  // 维护的区间的和
        while (faster <= target / 2 + 1 && slow < faster) {
            if (sum < target) { // 扩右区间
                sum += ++faster;
            } else if (sum > target) { // 缩左区间
                sum -= slow++;
            } else { // 加入数组
                int[] temp = new int[faster - slow + 1];
                temp[0] = slow;
                for (int i = 1; i < temp.length; i++) {
                    temp[i] = temp[i - 1] + 1;
                }
                res.add(temp);
                sum -= slow++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
