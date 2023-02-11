package com.huang.leetcode.editor.cn;

//给你一个字符串数组 words 和一个字符串 pref 。 
//
// 返回 words 中以 pref 作为 前缀 的字符串的数目。 
//
// 字符串 s 的 前缀 就是 s 的任一前导连续字符串。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["pay","attention","practice","attend"], pref = "at"
//输出：2
//解释：以 "at" 作为前缀的字符串有两个，分别是："attention" 和 "attend" 。
// 
//
// 示例 2： 
//
// 输入：words = ["leetcode","win","loops","success"], pref = "code"
//输出：0
//解释：不存在以 "code" 作为前缀的字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length, pref.length <= 100 
// words[i] 和 pref 由小写英文字母组成 
// 
//
// Related Topics 数组 字符串 👍 17 👎 0

/**
 * 统计包含给定前缀的字符串
 *
 * @author HRD
 */
class P2185_CountingWordsWithAGivenPrefix{
    public static void main(String[] args) {
        Solution solution = new P2185_CountingWordsWithAGivenPrefix().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0, n = pref.length(), i;
        for (String word : words) {
            // 判断的过程可以换成
            /*if (word.startsWith(pref)) {
                res++;
            }*/
            for (i = 0; i < n; i++) {
                if (i >= word.length() || word.charAt(i) != pref.charAt(i)) {
                    break;
                }
            }
            if (i == n - 1) {
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
