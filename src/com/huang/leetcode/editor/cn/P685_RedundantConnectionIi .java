package com.huang.leetcode.editor.cn;

//在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节
//点没有父节点。 
//
// 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条
//附加的边不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
//vi 的一个父节点。 
//
// 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 
//
// 示例 1： 
// 
// 
//输入：edges = [[1,2],[1,3],[2,3]]
//输出：[2,3]
// 
//
// 示例 2： 
// 
// 
//输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
//输出：[4,1]
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 344 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 冗余连接 II
 *
 * @author HRD
 */
class P685_RedundantConnectionIi{
    public static void main(String[] args) {
        Solution solution = new P685_RedundantConnectionIi().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private DisjointSet set = new DisjointSet(); // 并查集

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[1005];
        // 计算入度
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
        }
        // 找入度为2的节点所对应的边，倒序来取，因为优先删除最后的边
        List<Integer> twoDegree = new ArrayList<>();
        for (int i = edges.length - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                twoDegree.add(i);
            }
        }

        // 处理图中情况1 和 情况2
        // 如果有入度为2的节点，那么一定是两条边里删一个，看删哪个可以构成树
        if (!twoDegree.isEmpty()) {
            if (isTreeAfterRemoveEdge(edges, twoDegree.get(0))) {
                return edges[twoDegree.get(0)];
            } else {
                return edges[twoDegree.get(1)];
            }
        }

        // 明确没有入度为2的情况，那么一定有有向环，找到构成环的边返回就可以了
        return getRemoveEdge(edges);
    }

    /**
     * 在有向图里找到删除的那条边，使其变成树
     * @param edges
     * @return 要删除的边
     */
    private int[] getRemoveEdge(int[][] edges) {
        set.init();
        for (int i = 0; i < edges.length; i++) {
            if (set.same(edges[i][0], edges[i][1])) {
                // 构成有向环了，就是要删除的边
                return edges[i];
            } else {
                set.join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    /**
     * 删一条边之后判断是不是树
     * @param edges
     * @param deleteEdge 要删除的边
     * @return  true: 是树， false： 不是树
     */
    private Boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge) {
        set.init();
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge) continue;
            if (set.same(edges[i][0], edges[i][1])) { // 构成有向环了，一定不是树
                return false;
            }
            set.join(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

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
