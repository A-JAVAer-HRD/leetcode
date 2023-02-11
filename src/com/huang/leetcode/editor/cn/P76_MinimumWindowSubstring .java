package com.huang.leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2214 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author HRD
 */
class P76_MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //两个map,一个存放需要的字符，一个存放当前的字符
        Map<Character, Integer> sonMap = new HashMap<>();
        Map<Character, Integer> matherMap = new HashMap<>();

        //遍历匹配的字串
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            sonMap.put(cur, sonMap.getOrDefault(cur, 0) + 1);
        }

        int left = 0;//起始
        int right = 0;//终止
        int finishCount = 0;//计数器
        String res = "";
        int minLen = s.length();

        while (right < s.length()) {
            char cur = s.charAt(right);
            if (sonMap.containsKey(cur)) { //字串中需要这个字符
                matherMap.put(cur, matherMap.getOrDefault(cur, 0) + 1);
                // 两个Integer对象比较时，不能使用 == ，要使用equals，如果使用 == ，在[-128,127]范围内正常，范围外不正常
                if (sonMap.get(cur).equals(matherMap.get(cur))) { //一项已经匹配了
                    finishCount++;
                }
            }
            right++;
            //计数器满足要求，缩小窗口
            while (finishCount == sonMap.size()) {
                char leftCur = s.charAt(left);
                if (matherMap.containsKey(leftCur) && matherMap.get(leftCur) >= sonMap.get(leftCur)) {
                    //记录满足条件的最小字串
                    String temp = s.substring(left, right);
                    if (temp.length() <= minLen) {
                        res = temp;
                        minLen = temp.length();
                    }
                    matherMap.put(leftCur, matherMap.get(leftCur) - 1);
                    if (sonMap.get(leftCur) > matherMap.get(leftCur)) {
                        finishCount--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
