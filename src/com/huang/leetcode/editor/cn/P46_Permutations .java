package com.huang.leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2368 👎 0

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author HRD
 */
class P46_Permutations{
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);

            backtracking(nums, used); // 回溯
            path.removeLast();
            used[i] = false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
