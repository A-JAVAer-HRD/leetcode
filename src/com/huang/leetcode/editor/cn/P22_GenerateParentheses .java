package com.huang.leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3055 👎 0

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 *
 * @author HRD
 */
public class P22_GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res;
    StringBuilder path;
    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        path = new StringBuilder();

        backtracking(n, n);
        return res;
    }

    private void backtracking(int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(path.toString());
            return;
        }

        if (leftNum > rightNum) { // 剪枝，括号不匹配
            return;
        }

        if (leftNum >= 0) {
            path.append("(");
            backtracking(leftNum - 1, rightNum);
            path.deleteCharAt(path.length() - 1);
        }

        if (rightNum >= 0) {
            path.append(")");
            backtracking(leftNum, rightNum - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
