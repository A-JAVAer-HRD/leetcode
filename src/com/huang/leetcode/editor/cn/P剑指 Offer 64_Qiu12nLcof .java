package com.huang.leetcode.editor.cn;

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
//
// Related Topics 位运算 递归 脑筋急转弯 👍 551 👎 0

/**
 * 求1+2+…+n
 *
 * @author HRD
 */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    int res = 0;
    public int sumNums(int n) {
//        if (n == 1) return 1;
//        else return  n + sumNums(n - 1);
        boolean x = n > 1 && sumNums(n - 1) >0;
        res += n;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

