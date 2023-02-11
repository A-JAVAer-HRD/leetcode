package com.huang.leetcode.editor.cn;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 664 👎 0

/**
 * 字符串相加
 *
 * @author HRD
 */
class P415_AddStrings{
    public static void main(String[] args) {
        Solution solution = new P415_AddStrings().new Solution();
        solution.addStrings("11", "123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int cur = 0;
        while (i >= 0 || j >= 0 || cur != 0) {
            if (i >= 0) {
                cur += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                cur += num2.charAt(j) - '0';
                j--;
            }
            sb.append(cur % 10);
            cur = cur / 10;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
