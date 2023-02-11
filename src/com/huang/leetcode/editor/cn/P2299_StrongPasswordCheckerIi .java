package com.huang.leetcode.editor.cn;

//如果一个密码满足以下所有条件，我们称它是一个 强 密码： 
//
// 
// 它有至少 8 个字符。 
// 至少包含 一个小写英文 字母。 
// 至少包含 一个大写英文 字母。 
// 至少包含 一个数字 。 
// 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。 
// 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。 
// 
//
// 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：password = "IloveLe3tcode!"
//输出：true
//解释：密码满足所有的要求，所以我们返回 true 。
// 
//
// 示例 2： 
//
// 输入：password = "Me+You--IsMyDream"
//输出：false
//解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
// 
//
// 示例 3： 
//
// 输入：password = "1aB!"
//输出：false
//解释：密码不符合长度要求。所以我们返回 false 。 
//
// 
//
// 提示： 
//
// 
// 1 <= password.length <= 100 
// password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。 
// 
//
// Related Topics 字符串 👍 41 👎 0

/**
 * 强密码检验器 II
 *
 * @author HRD
 */
class P2299_StrongPasswordCheckerIi{
    public static void main(String[] args) {
        Solution solution = new P2299_StrongPasswordCheckerIi().new Solution();
        solution.strongPasswordCheckerII(
                "IloveLe3tcode!");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean[] key = new boolean[6]; // 分别表示6个条件
        if (password.length() < 8) {
            return false;
        }
        key[0] = true;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                key[1] = true;
            }
            if (c >= 'A' && c <= 'Z') {
                key[2] = true;
            }
            if (c >= '0' && c <= '9') {
                key[3] = true;
            }
            if (c == '!' || // 特殊符号
                c == '@' ||
                c == '#' ||
                c == '$' ||
                c == '%' ||
                c == '^' ||
                c == '&' ||
                c == '*' ||
                c == '(' ||
                c == ')' ||
                c == '+' ||
                c == '-'
            ) {
                key[4] = true;
            }
            if (i > 0 && password.charAt(i - 1) == c) { // 如果出现连续直接返回
                return false;
            }
        }
        key[5] = true;
        for (boolean b : key) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
