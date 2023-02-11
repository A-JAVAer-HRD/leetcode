package com.huang.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6047 👎 0

/**
 * 最长回文子串
 *
 * @author HRD
 */
class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome2(String s) {
            if (s.equals("")) {
                return "";
            }
            String origin = s;
            String reverse = new StringBuilder(s).reverse().toString(); // 反转字符串
            int len = s.length();
            int[][] arr = new int[len][len];
            int maxLen = 0;
            int maxEnd = 0;

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (origin.charAt(i) == reverse.charAt(j)) {
                        if (i == 0 || j == 0) {
                            arr[i][j] = 1;
                        } else {
                            arr[i][j] = arr[i - 1][j - 1] + 1;
                        }
                    }
                    if (arr[i][j] > maxLen) {
                        maxLen = arr[i][j];
                        maxEnd = i; // 记录结尾
                    }
                }
            }
            return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
        }
        public boolean isPalindromic(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }

        // 暴力解法
        public String longestPalindrome(String s) {
            String ans = "";
            int max = 0;
            int len = s.length();
            for (int i = 0; i < len; i++)
                for (int j = i + 1; j <= len; j++) {
                    String test = s.substring(i, j);
                    if (isPalindromic(test) && test.length() > max) {
                        ans = s.substring(i, j);
                        max = Math.max(max, ans.length());
                    }
                }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
