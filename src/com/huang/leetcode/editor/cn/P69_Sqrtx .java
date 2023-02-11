package com.huang.leetcode.editor.cn;

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1169 👎 0

/**
 * x 的平方根 
 *
 * @author HRD
 */
class P69_Sqrtx{
    public static void main(String[] args) {
        Solution solution = new P69_Sqrtx().new Solution();
        solution.mySqrt(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 二分查找
     * [left,right)
     * */
    public int mySqrt(int x) {
        //因为定义的区间为左闭右开，对于x，当x < 2的时候，x才会取0 or x 即 0 1
        if (x < 2) return x;
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (mid > x / mid) {
                right = mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else return mid;
        }
        return right - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
