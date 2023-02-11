package com.huang.leetcode.editor.cn;

//找出数组中重复的数字。 
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
//
// Related Topics 数组 哈希表 排序 👍 1017 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 *
 * @author HRD
 */
class Offer03_ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 哈希set
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            else set.add(num);
        }
        return -1;
    }

    /**
     * 数组记录
     */
   public int findRepeatNumber2(int[] nums) {
        byte[] arr = new byte[100000];
        for (int num : nums) {
            if (arr[num] == 1) return num;
            else arr[num] = 1;
        }
        return -1;
   }

    /**
     * 原地交换
     */
   public int findRepeatNumber3(int[] nums) {
       int i = 0;
       while (i < nums.length) {
           if (nums[i] == i) { // 已经有序
               i++;
               continue;
           }
           if (nums[nums[i]] == nums[i]) { // 排好序后，遇到了第二个这个数
               return nums[i];
           }
           // 交换
           int tmp = nums[i];
           nums[i] = nums[nums[i]];
           nums[nums[i]] = tmp;
       }
       return -1;
   }
}
//leetcode submit region end(Prohibit modification and deletion)

}
