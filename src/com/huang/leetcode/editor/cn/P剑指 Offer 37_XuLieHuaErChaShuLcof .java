package com.huang.leetcode.editor.cn;

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 360 👎 0

/**
 * 序列化二叉树
 *
 * @author HRD
 */

    //leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    // 序列化二叉树
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);// 加入头节点
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    res.append(tmp.val).append(",");
                    // 之前BFS是跳过空节点的
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }else {
                    res.append("null,");
                }
            }
        }
        res.deleteCharAt(res.length() - 1);// 删除最后一个","
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    // 反序列化
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;

        String[] vals = data.substring(1, data.length() - 1).split(","); // 切掉[] 和,
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            // 不强调分层的话 可以不用size遍历
            TreeNode tmp = queue.poll();
            if (!vals[i].equals("null")) { // 处理左节点
                tmp.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(tmp.left);
            }
            i++;
            if (!vals[i].equals("null")) { // 处理右节点
                tmp.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(tmp.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

