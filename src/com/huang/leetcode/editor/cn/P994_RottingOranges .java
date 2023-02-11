package com.huang.leetcode.editor.cn;

//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 646 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * @author HRD
 */
class P994_RottingOranges{
    public static void main(String[] args) {
        Solution solution = new P994_RottingOranges().new Solution();
        solution.orangesRotting(new int[][]{{1}, {2}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 好橘子的数量
        int count = 0;

        int M = grid.length; // 行
        int N = grid[0].length; // 列


        Queue<int[]> queue = new LinkedList<>();
        // 将所有腐烂的橘子加入队列中
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // 如果我们的网格上只有好橘子或者没有烂橘子橘子，返回 -1。
        // 如果我们的网格上只有烂橘子没有好橘子，返回 0。
        if (queue.isEmpty()) {
            return -1;
        } else if (count == 0) {
            return 0;
        }

        int time = 0;
        while (count > 0 && !queue.isEmpty()) {
            // 先取出队列的size就是这一层的全部元素
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                // 遍历四个方向
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (isArea(newX, newY, M, N) && grid[newX][newY] == 1) {
                        // 感染成烂橘子
                        grid[newX][newY] = 2;
                        count--;
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
            time++;
        }

        if (count == 0) {
            return time;
        } else {
            return -1;
        }
    }

    /**
     * @param x 二维表格单元格横坐标
     * @param y 二维表格单元格纵坐标
     * @param N 二维表格列数
     * @param M 二维表格行数
     * @return 是否在二维表格有效范围内
     */
    private boolean isArea(int x, int y, int M, int N) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
