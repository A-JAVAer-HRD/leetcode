package com.huang.leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1243 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author HRD
 */
class P54_SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54_SpiralMatrix().new Solution();
        int[][] arr = {{1, 2}, {3, 4}};
        solution.spiralOrder(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //保持左闭右开
        List<Integer> res = new ArrayList<>();

        int i = 0;//循环的次数
        int m = matrix.length;
        int n = matrix[0].length;
        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;

        while (i < count) {
            //上侧 左->右
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }
            //右侧 上->下
            for (int j = i + 1; j < m - i; j++) {
                res.add(matrix[j][(n - 1) - i]);
            }
            //下册 右->左
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
                res.add(matrix[(m - 1) - i][j]);
            }
            //左侧 下->上
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
