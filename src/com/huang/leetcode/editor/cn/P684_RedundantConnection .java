package com.huang.leetcode.editor.cn;

//树可以看成是一个连通且 无环 的 无向 图。 
//
// 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信
//息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。 
//
// 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: edges = [[1,2], [1,3], [2,3]]
//输出: [2,3]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
// 
//
// 
//
// 提示: 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ai < bi <= edges.length 
// ai != bi 
// edges 中无重复元素 
// 给定的图是连通的 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 526 👎 0

/**
 * 冗余连接
 *
 * @author HRD
 */
class P684_RedundantConnection{
    public static void main(String[] args) {
        Solution solution = new P684_RedundantConnection().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet set = new DisjointSet();
        for (int i = 0; i < edges.length; i++) {
            if (set.same(edges[i][0], edges[i][1])) {
                // 并查集有这两个节点，说明边冗余了
                return edges[i];
            } else {
                // 并查集没有两个节点，加入并查集
                set.join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }
}

class DisjointSet {
    private int n; // 节点数量
    private int[] father; // 记录

    public DisjointSet() {
        this.n = 1005;
        this.father = new int[n];

        // 并查集初始化
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    public int find(int x) {
        if (x == father[x]) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    // 将v->u 这条边加入并查集 合并集合
    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    // 判断 u 和 v是否找到同一个根
    public Boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    // 初始化并查集
    public void init() {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
