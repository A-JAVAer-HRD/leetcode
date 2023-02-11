package com.huang.leetcode.editor.cn;

//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1135 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @author HRD
 */
class P93_RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new P93_RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res;
    Deque<String> path;

    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        int len = s.length();
        if (len > 12 || len < 4) {
            return res;
        }
        path = new ArrayDeque<>(4);
        backtracking(s, 0, 4, len); // 回溯
        return res;
    }

    private void backtracking(String s, int begin, int residue, int len) {
        if (begin == s.length()) { // 收集结果
            if (residue == 0) {
                res.add(String.join(".", path));
                return;
            }
        }

        for (int i = begin; i < begin + 3; i++) {
           if (i >= len) {
               break;
           }
           if (residue * 3 < len - i) {
               continue;
           }

           if (isIp(s, begin, i)) {
               String sub = s.substring(begin, i + 1);
               path.addLast(sub);

               // 递归
               backtracking(s, i + 1, residue - 1, len);
               // 回溯
               path.removeLast();
           }

        }
    }

        public boolean isIp(String s, int left, int right){
            int len = right - left + 1;
            //当前为0开头的且长度大于1的数字需要剪枝
            if(len>1 && s.charAt(left)=='0')
                return false;
            //将当前截取的字符串转化成数字
            int res = len<=0 ? 0 : Integer.parseInt(s.substring(left, right+1));
            //判断截取到的数字是否符合
            return res>=0 && res<=255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
