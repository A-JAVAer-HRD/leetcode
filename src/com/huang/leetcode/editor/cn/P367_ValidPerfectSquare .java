package com.huang.leetcode.editor.cn;

//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
//
// Related Topics 数学 二分查找 👍 443 👎 0

/**
 * 有效的完全平方数
 *
 * @author HRD
 */
class P367_ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new P367_ValidPerfectSquare().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
    * 二分法
    * [left,right]左闭右闭
    * */
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            long square = (long) mid * mid;
            if (square > num) {
                right = mid - 1;
            } else if (square < num) {
                left = mid + 1;
            } else{
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
