package com.huang.leetcode.editor.cn;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 910 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 被围绕的区域
 *
 * @author HRD
 */
class P130_SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new P130_SurroundedRegions().new Solution();
        char[][] chars = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}};
        solution.solve3(chars);
        System.out.println(Arrays.deepToString(chars));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dfs 递归
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 从边界的O开始搜索
                boolean isEdge = i == 0 || j == 0 || i == M - 1 || j == N - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i , j);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 这个时候就是被围绕的
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                // 还原原来的边界
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (!inBord(board, i, j)) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    /**
     * 判断在不在格子内
     * */
    private boolean inBord(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }


    // dfs 递归
    public void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 从边界的O开始搜索
                boolean isEdge = i == 0 || j == 0 || i == M - 1 || j == N - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs2(board, i , j);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 这个时候就是被围绕的
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                // 还原原来的边界
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs2(char[][] board, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        board[i][j] = '#';
        while (!stack.isEmpty()) {
            // 取出当前stack 顶, 不弹出.
            int[] peek = stack.peek();
            int r = peek[0];
            int c = peek[1];
            // 上下左右四个位置放入栈中
            if (inBord(board, r - 1, c) && board[r - 1][c] == 'O') {
                stack.push(new int[] {r - 1, c});
                board[r - 1][c] = '#';
                continue;
            }
            if (inBord(board, r + 1, c) && board[r + 1][c] == 'O') {
                stack.push(new int[] {r + 1, c});
                board[r + 1][c] = '#';
                continue;
            }
            if (inBord(board, r, c - 1) && board[r][c - 1] == 'O') {
                stack.push(new int[] {r, c - 1});
                board[r][c - 1] = '#';
                continue;
            }
            if (inBord(board, r, c + 1) && board[r][c + 1] == 'O') {
                stack.push(new int[] {r, c + 1});
                board[r][c + 1] = '#';
                continue;
            }
            // 如果上下左右都搜索不到,本次搜索结束，弹出stack
            stack.pop();
        }
    }

    // bfs迭代
    public void solve3(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 从边界的O开始搜索
                boolean isEdge = i == 0 || j == 0 || i == M - 1 || j == N - 1;
                if (isEdge && board[i][j] == 'O') {
                    bfs(board, i , j);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 这个时候就是被围绕的
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                // 还原原来的边界
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.offer(new int[]{i, j});
        board[i][j] = '#';
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            for (int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];
                if (inBord(board, newR, newC) && board[newR][newC] == 'O') {
                    queue.add(new int[]{newR, newC});
                    board[newR][newC] = '#';
                }
            }
        }
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
