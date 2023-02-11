package com.huang.leetcode.editor.cn;

//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 370 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 水果成篮
 *
 * @author HRD
 */
class P904_FruitIntoBaskets{
    public static void main(String[] args) {
        Solution solution = new P904_FruitIntoBaskets().new Solution();
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        solution.totalFruit(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 滑动窗口 + hashmap
     * */
    public int totalFruit(int[] fruits) {
        int res = 1;//返回的最多收集个数
        int j = 0;//起始位置
        HashMap<Integer, Integer> map = new HashMap<>(3);//篮子
        //遍历终止位置i
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);//利用map不含重复元素
            while (map.size() > 2) {//当篮子数大于2时，缩短窗口
                if (map.get(fruits[j]) - 1 == 0) {
                    map.remove(fruits[j]);
                }else {
                    map.put(fruits[j], map.get(fruits[j]) - 1);
                }
                j++;
            }
            int subLength = i - j + 1;
            res = Math.max(res, subLength);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public int totalFruit(int[] fs) {
        int len = fs.length, res = 0;
        //cnts用来统计每种水果树的数量
        int[] cnts = new int[len + 10];
        //i是窗口的右边，j是左边，tot表示当前篮子里水果的种类（至多有两种水果），也表示窗口中的水果种类数量
        for (int i = 0, j = 0, tot = 0; i < len; i++) {
            cnts[fs[i]]++;
            if (cnts[fs[i]] == 1) tot++;//第一次出现 篮子的种类++
            //当种类数量大于2时，使窗口左侧收缩，并且除去对应的水果种类在cnts中的数量
            //当为0时则彻底在窗口中除去该种水果
            while (tot > 2) {
                cnts[fs[j]]--;//缩窗口
                if (cnts[fs[j]] == 0) tot--;//篮子种类数--
                j++;
            }
            //即时比较判断窗口中水果树的数量，经过前两步窗口中的东西一定是满足题义的
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
