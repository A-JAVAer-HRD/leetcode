package com.huang.leetcode.editor.cn;

//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 312 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最大人工岛
 *
 * @author HRD
 */
class P827_MakingALargeIsland{
    public static void main(String[] args) {
        Solution solution = new P827_MakingALargeIsland().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestIsland(int[][] grid) {
        int value = 2; // 岛屿编号
        Map<Integer, Integer> islandAreas = new HashMap<>(); // 岛屿编号 -> 岛屿面积的 map

        for (int r = 0; r < grid.length; r++) { // 寻找岛屿 计算每一个岛屿的面积 放入map
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c, value);
                    islandAreas.put(value, a);
                    value++;
                }
            }
        }

        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 依次尝试填海
                int ta = thisArea(grid, r, c, islandAreas);
                res = Math.max(res, ta);
            }
        }

        return res;
    }

    // 把 (r, c) 填海之后，最大的岛屿面积
    int thisArea(int[][] grid, int r, int c, Map<Integer, Integer> islandAreas) {
        if (grid[r][c] != 0) { // 是陆地，直接返回对应编号岛屿的面积
            return islandAreas.get(grid[r][c]);
        }
        int res = 0;
        Set<Integer> adjs = new HashSet<>();
        // 填海之后 判断前后左右是不是陆地 是的话加入set
        if (inArea(grid, r-1, c) && grid[r-1][c] > 0) {
            adjs.add(grid[r-1][c]);
        }
        if (inArea(grid, r+1, c) && grid[r+1][c] > 0) {
            adjs.add(grid[r+1][c]);
        }
        if (inArea(grid, r, c-1) && grid[r][c-1] > 0) {
            adjs.add(grid[r][c-1]);
        }
        if (inArea(grid, r, c+1) && grid[r][c+1] > 0) {
            adjs.add(grid[r][c+1]);
        }
        for (int adj : adjs) {
            // 加上填海后的面积
            res += islandAreas.get(adj);
        }
        return res + 1;
    }

    // value 表示当前岛屿编号
    int area(int[][] grid, int r, int c, int value) {
        if (!inArea(grid, r, c)) {
            return 0;
        }

        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = value;

        return 1 + area(grid, r - 1, c, value)
                + area(grid, r + 1, c, value)
                + area(grid, r, c - 1, value)
                + area(grid, r, c + 1, value);

    }

    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
