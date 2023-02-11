package com.huang.leetcode.editor.cn;

//你现在手里有一份大小为
// n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。 
//
// 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回 -1。 
//
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - 
//x1| + |y0 - y1| 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 不是 0 就是 1 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 313 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地图分析
 *
 * @author HRD
 */
class P1162_AsFarFromLandAsPossible{
    public static void main(String[] args) {
        Solution solution = new P1162_AsFarFromLandAsPossible().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[][] grid) {
        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 由于题目中给出了 grid 的范围，因此不用做输入检查
        int N = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }

        int step = 0;
        while (!queue.isEmpty()) {
            // 注意：先把当前队列的长度保存下来
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] direction : directions) { // 遍历上下左右四个方向
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (inArea(newX, newY, N) && grid[newX][newY] == 0) {
                        // 赋值成为一个不等于 0 的整数均可，因为后续逻辑只关心海洋（0）
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        // 注意：由于最后一步，没有可以扩散的的区域，但是 step 加了 1，故在退出循环的时候应该减 1
        return step - 1;
    }

    /**
     * @param x 二维表格单元格横坐标
     * @param y 二维表格单元格纵坐标
     * @param N 二维表格行数（列数）
     * @return 是否在二维表格有效范围内
     */
    private boolean inArea(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
