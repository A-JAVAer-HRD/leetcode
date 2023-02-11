package com.huang.leetcode.editor.cn;

//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。 
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5 
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
// 
//
// 示例 2： 
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 1 <= low <= high <= 2 * 10⁴ 
// 
//
// Related Topics 位运算 字典树 数组 👍 77 👎 0

/**
 * 统计异或值在范围内的数对有多少
 *
 * @author HRD
 */
class P1803_CountPairsWithXorInARange{
    public static void main(String[] args) {
        Solution solution = new P1803_CountPairsWithXorInARange().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int countPairs(int[] nums, int low, int high) {
//        int res = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 1; j < nums.length; j++) {
//                int x = nums[i] ^ nums[j];
//                if (x >= low && x <= high) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//}

    class Trie { // 字典树
        private Trie[] children = new Trie[2]; // 左右节点
        private int cnt; // 记录数

        public void insert(int x) {
            Trie node = this;
            for (int i = 15; i >= 0; --i) {
                // 从高到底，取各位
                int v = (x >> i) & 1; // 取值为 0 或 1
                if (node.children[v] == null) {
                    node.children[v] = new Trie();
                }
                node = node.children[v];
                ++node.cnt;
            }
        }

        public int search(int x, int limit) {
            Trie node = this;
            int ans = 0;
            for (int i = 15; i >= 0 && node != null; --i) {
                // 从高到底，取各位
                int v = (x >> i) & 1;
                if (((limit >> i) & 1) == 1) {
                    if (node.children[v] != null) {
                        ans += node.children[v].cnt;
                    }
                    node = node.children[v ^ 1];
                } else {
                    node = node.children[v];
                }
            }
            return ans;
        }
    }

    class Solution {
        public int countPairs(int[] nums, int low, int high) {
            Trie trie = new Trie();
            int ans = 0;
            for (int x : nums) {
                ans += trie.search(x, high + 1) - trie.search(x, low);
                trie.insert(x);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
