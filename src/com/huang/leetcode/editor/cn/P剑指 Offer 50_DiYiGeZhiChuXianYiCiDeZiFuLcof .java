package com.huang.leetcode.editor.cn;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
//
// Related Topics 队列 哈希表 字符串 计数 👍 275 👎 0

import java.util.*;

/**
 * 第一个只出现一次的字符
 *
 * @author HRD
 */
class Offer50_DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        new Solution().firstUniqChar("leetcode");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return s.charAt(i);
        }
        return ' ';
    }

        public char firstUniqChar2(String s) {
            HashMap<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                if (m.getValue() == 1) {
                    return m.getKey();
                }
            }
            return ' ';
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
