package com.huang.leetcode.editor.cn;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 3844 👎 0

/**
 * 盛最多水的容器
 *
 * @author HRD
 */
class P11_ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new P11_ContainerWithMostWater().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 双指针
     * 面积：高*宽 min(height[left], height[right]) * (right - left)
     * 1. 初始化两个指针指向两个边，这个时候宽是最大的。
     * 2. 当两个边向内缩小的时候,如果高是增大的话，才有可能会增大，如果高是减小的就不能增大。
     * 3. 因此在缩小的时候，让高尽可能变大，即缩小高小的一边。相等的话，任意。（有可能存在山峰的形状）
     * 4. 这样保证了在每一次选择时都是选择最大的，在遍历过程中用result记录最大值返回。
     * 只进行了一次遍历。
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int sum = (Math.min(height[left], height[right]) * (right - left));
            result = Math.max(sum, result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
