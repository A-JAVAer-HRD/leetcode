package com.huang.leetcode.editor.cn;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
//
// Related Topics 字符串 动态规划 👍 494 👎 0

/**
 * 把数字翻译成字符串
 *
 * @author HRD
 */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solutio2n {
    public static void main(String[] args) {
        System.out.println(new Solutio2n().translateNum(506));
    }

    public int translateNum(int num) {
        String s = num + "";
        int n = s.length();
        // dp[0] [i] 第i个数字对应最多的翻译
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        //根据状态转移方程遍历
        for (int i = 2; i < n + 1; i++) {
            if (s.charAt(i - 2) < '2' && s.charAt(i - 2) > '0' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '5')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else
                dp[i] = dp[i - 1];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

