package com.huang.leetcode.editor.cn;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 419 👎 0

/**
 * 斐波那契数列
 *
 * @author HRD
 */
class I_FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new I_FeiBoNaQiShuLieLcof().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 记忆化搜索
     * */
    public int fib1(int n) {
        int[] dp = new int[n + 1];//记录之前搜索的数据
        return fibonacci(n, dp);
    }

    private int fibonacci(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n];//如果之前有记录 直接返回
        else dp[n] = (fibonacci(n - 1, dp) + fibonacci(n - 2, dp)) % 1000000007;
        return dp[n];
    }

    /**
     * 动态规划
     * */
    public int fib2(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
