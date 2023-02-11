package com.huang.leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 583 👎 0

/**
 * 机器人的运动范围
 *
 * @author HRD
 */
class iQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new iQiRenDeYunDongFanWeiLcof().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        /*
        * 记录[i,j]位置有没有访问过，true访问过，false没访问过
        * */
        boolean[][] visit = new boolean[m][n];
        return backtarcking(visit, 0, 0, k);
    }

        private int backtarcking(boolean[][] visit, int row, int col, int k) {
            if (row < 0 || col < 0 || row > visit.length || col > visit[0].length || (row % 10 + row / 10 + col % 10 + col / 10) > k || visit[row][col]) {
                return 0;
            }
            visit[row][col] = true;
            //向四个方向搜索
            int a = backtarcking(visit, row - 1, col, k);//上
            int b = backtarcking(visit, row + 1, col, k);//下
            int c = backtarcking(visit, row, col - 1, k);//左
            int d = backtarcking(visit, row, col + 1, k);//右

            return 1 + a + b + c + d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
