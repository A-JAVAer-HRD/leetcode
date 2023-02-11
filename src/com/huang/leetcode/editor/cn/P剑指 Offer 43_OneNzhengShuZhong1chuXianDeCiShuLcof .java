package com.huang.leetcode.editor.cn;

//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
//
// Related Topics 递归 数学 动态规划 👍 387 👎 0

/**
 * 1～n 整数中 1 出现的次数
 *
 * @author HRD
 */
class Offer43OneNzhengShuZhong1chuXianDeCiShuLcof{
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] += dp[i - 1] + clcOne(i);
        }
        return dp[n];
    }

    private int clcOne(int x) {
        int res = 0;
        while (x > 0) {
            if (x % 10 == 1) {
                res++;
                x /= 10;
            }
        }
        return res;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
