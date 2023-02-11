package com.huang.leetcode.editor.cn;

//给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upperi, percenti] ，表示第 i 个税级的上
//限是 upperi ，征收的税率为 percenti 。税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，
//upperi-1 < upperi）。 
//
// 税款计算方式如下： 
//
// 
// 不超过 upper0 的收入按税率 percent0 缴纳 
// 接着 upper1 - upper0 的部分按税率 percent1 缴纳 
// 然后 upper2 - upper1 的部分按税率 percent2 缴纳 
// 以此类推 
// 
//
// 给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。与标准答案误差不超 10⁻⁵ 的结果将被视作正确答案。 
//
// 
//
// 示例 1： 
//
// 输入：brackets = [[3,50],[7,10],[12,25]], income = 10
//输出：2.65000
//解释：
//前 $3 的税率为 50% 。需要支付税款 $3 * 50% = $1.50 。
//接下来 $7 - $3 = $4 的税率为 10% 。需要支付税款 $4 * 10% = $0.40 。
//最后 $10 - $7 = $3 的税率为 25% 。需要支付税款 $3 * 25% = $0.75 。
//需要支付的税款总计 $1.50 + $0.40 + $0.75 = $2.65 。
// 
//
// 示例 2： 
//
// 输入：brackets = [[1,0],[4,25],[5,50]], income = 2
//输出：0.25000
//解释：
//前 $1 的税率为 0% 。需要支付税款 $1 * 0% = $0 。
//剩下 $1 的税率为 25% 。需要支付税款 $1 * 25% = $0.25 。
//需要支付的税款总计 $0 + $0.25 = $0.25 。
// 
//
// 示例 3： 
//
// 输入：brackets = [[2,50]], income = 0
//输出：0.00000
//解释：
//没有收入，无需纳税，需要支付的税款总计 $0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= brackets.length <= 100 
// 1 <= upperi <= 1000 
// 0 <= percenti <= 100 
// 0 <= income <= 1000 
// upperi 按递增顺序排列 
// upperi 中的所有值 互不相同 
// 最后一个税级的上限大于等于 income 
// 
//
// Related Topics 数组 模拟 👍 41 👎 0

/**
 * 计算应缴税款总额
 *
 * @author HRD
 */
class P2303_CalculateAmountPaidInTaxes{
    public static void main(String[] args) {
        Solution solution = new P2303_CalculateAmountPaidInTaxes().new Solution();
        System.out.println(solution.calculateTax(new int[][]{{2, 7}, {3, 17}, {4,37},{7,6},{9,83},{16,67},{19,29}}, 18));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int pre = 0;
        double res = 0;
        for (int[] bracket : brackets) {
            if (income <= bracket[0]) { // 没超过当前的 upper
                res += (income - pre) * bracket[1] / 100.0;
                break;
            } else { // 超过了当前的 upper
                res += (bracket[0] - pre) * bracket[1] / 100.0;
            }
            pre = bracket[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
