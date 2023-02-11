package com.huang.leetcode.editor.cn;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// Related Topics 数组 矩阵 模拟 👍 463 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 *
 * @author HRD
 */
class  Offer29_ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new Offer29_ShunShiZhenDaYinJuZhenLcof().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();

        int i = 0;//控制循环圈数
        int m = matrix.length;
        int n = matrix[0].length;
        int loop = (Math.min(m, n) + 1) / 2;

        while (i < loop) {
            //上 从左到右
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }
            //右 从上到下
            for (int j = i + 1; j < m - i; j++) {
                res.add(matrix[j][(n - 1) - i]);
            }
            //下 从右到左
            for (int j = n - 1 - i - 1; j >= i && m - 1 - i != i; j--) {
                res.add(matrix[(m - 1 - i)][j]);
            }
            //左 从下到上
            for (int j = m - 1 - 1 - i; j >= i + 1 && n - 1 - i != i; j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
