package com.huang.leetcode.editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
//
// Related Topics 字符串 回溯 👍 617 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 字符串的排列
 *
 * @author HRD
 */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    Set<String> res; // 记录结果集 顺便用HashSet去重
    StringBuilder path; // 路径 用StringBuilder
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        res = new HashSet<>();
        path = new StringBuilder();
        boolean[] used = new boolean[s.length()];// 记录有没有遍历过
        backtracking(chars, used);
        return res.toArray(new String[0]);
    }

    private void backtracking(char[] chars, boolean[] used) {
        if (path.length() == chars.length) { // 已经搜索到根了，记录
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                path.append(chars[i]);
                used[i] = true;
                backtracking(chars, used);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

