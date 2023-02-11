package com.huang.leetcode.editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 752 👎 0

import java.util.Arrays;

/**
 * 排序数组
 *
 * @author HRD
 */
class P912_SortAnArray{
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快速排序
    void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        while (l < r) {
            // 哨兵划分操作
            int i = partition(nums, l, r);
            // 仅递归至较短子数组，控制递归深度
            if (i - l < r - i) {
                quickSort(nums, l, i - 1);
                l = i + 1;
            } else {
                quickSort(nums, i + 1, r);
                r = i - 1;
            }
        }
    }

    int partition(int[] nums, int l, int r) {
        // 在闭区间 [l, r] 随机选取任意索引，并与 nums[l] 交换
        int ra = (int)(l + Math.random() * (r - l + 1));
        swap(nums, l, ra);
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    // 归并排序
    private void mergeSort(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) return;
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        // 合并子数组
        int[] tmp = new int[r - l + 1]; // 暂存需合并区间元素
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];
        int i = 0, j = m - l + 1;       // 两指针分别指向左/右子数组的首个元素
        for (int k = l; k <= r; k++) {  // 遍历合并左/右子数组
            if (i == m - l + 1)
                nums[k] = tmp[j++];
            else if (j == r - l + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
            }
        }
    }

    // 插入排序:稳定排序，在接近有序的情况下，表现优异
    public int[] sortArray2(int[] nums) {
        int n = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < n; i++) {
            int temp = nums[i];// 先暂存这个元素，然后之前元素逐个后移，留出空位
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp; // 插入
        }
        return nums;
    }

    // 选择排序:每一轮选择最小元素交换到未排定部分的开头
    public int[] sortArray1(int[] nums) {
        int n = nums.length;
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < n; i++) {
            // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
