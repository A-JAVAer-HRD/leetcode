package com.huang.leetcode.editor.cn;

//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 344 👎 0

/**
 * 二叉搜索树的第k大节点
 *
 * @author HRD
 */
class ChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(2);
        Solution solution = new Solution();
        int i = solution.kthLargest(root, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
static class Solution {
    int res;
    int count;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        recur(root);
        return res;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        recur(root.right); // 右
        if (--count == 0) {
            res = root.val;
            return;
        } // 中
        recur(root.left); // 左
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
