package com.huang.leetcode.editor.cn;

//在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二
//维数组和一个整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 833 👎 0

/**
 * 二维数组中的查找
 *
 * @author HRD
 */
class Offer04_ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 递归
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            return traversal(matrix, matrix.length - 1, 0, target);
        }

        private boolean traversal(int[][] matrix, int startX, int startY, int target) {
            if (startX < 0 || startY >= matrix[0].length) {
                return false;
            }
            if (matrix[startX][startY] == target) {
                return true;
            } else if (matrix[startX][startY] > target) {
                return traversal(matrix, startX - 1, startY, target);
            } else { // <
                return traversal(matrix, startX, startY + 1, target);
            }
        }

        public boolean findNumberIn2DArray2(int[][] matrix, int target) {
            int i = matrix.length - 1, j = 0;
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] > target) {
                    i--;
                } else if (matrix[i][j] < target) {
                    j++;
                } else
                    return true;
            }
            return false;
        }
//leetcode submit region end(Prohibit modification and deletion)
    }
}
