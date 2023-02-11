package com.huang.leetcode.editor.cn;

//给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 10⁹ + 7 取余 后的结果。 
//
// 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abbcccaa"
//输出：13
//解释：同构子字符串如下所列：
//"a"   出现 3 次。
//"aa"  出现 1 次。
//"b"   出现 2 次。
//"bb"  出现 1 次。
//"c"   出现 3 次。
//"cc"  出现 2 次。
//"ccc" 出现 1 次。
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13 
//
// 示例 2： 
//
// 输入：s = "xy"
//输出：2
//解释：同构子字符串是 "x" 和 "y" 。 
//
// 示例 3： 
//
// 输入：s = "zzzzz"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写字符串组成 
// 
//
// Related Topics 数学 字符串 👍 35 👎 0

/**
 * 统计同构子字符串的数目
 *
 * @author HRD
 */
class P1759_CountNumberOfHomogenousSubstrings{
    public static void main(String[] args) {
        Solution solution = new P1759_CountNumberOfHomogenousSubstrings().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        int n = s.length();
        long ans = 0;
        int len = 0;
        char tmp = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (tmp == c) len++;
            else {
                ans += (long) len * (len + 1) / 2;
                len = 1;
                tmp = c;
            }
        }
        ans += (long) len * (len + 1) / 2;
        return (int) (ans % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
