package com.huang.leetcode.editor.cn;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 510 👎 0

import java.util.HashMap;
import java.util.Objects;

/**
 * 最长不含重复字符的子字符串
 *
 * @author HRD
 */
class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        solution.lengthOfLongestSubstring("abba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (Objects.equals(s, "") || s == null) {
            return 0;
        }
        //dp[i]表示以s[i]结尾的最长不重复字符的字符串长度
        int[] dp = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 1;
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.getOrDefault(c, -1) == -1) { //表中没存记录
                dp[i] = dp[i - 1] + 1;
            } else {
                // 在表中有记录
                int index = map.get(c);//拿到他的位置
                dp[i] = Math.min(i - index, dp[i - 1] + 1);
            }
            map.put(c, i);// 存入map or 理解为更新map的值
            res = Math.max(dp[i], res);// res取最大值
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
