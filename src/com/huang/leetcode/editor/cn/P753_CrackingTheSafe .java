package com.huang.leetcode.editor.cn;

//有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。 
//
// 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。 
//
// 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符. 
//
// 请返回一个能打开保险箱的最短字符串。 
//
// 
//
// 示例1: 
//
// 输入: n = 1, k = 2
//输出: "01"
//说明: "10"也可以打开保险箱。
// 
//
// 
//
// 示例2: 
//
// 输入: n = 2, k = 2
//输出: "00110"
//说明: "01100", "10011", "11001" 也能打开保险箱。
// 
//
// 
//
// 提示： 
//
// 
// n 的范围是 [1, 4]。 
// k 的范围是 [1, 10]。 
// k^n 最大可能为 4096。 
// 
//
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 152 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 破解保险箱
 *
 * @author HRD
 */
class P753_CrackingTheSafe{
    public static void main(String[] args) {
        Solution solution = new P753_CrackingTheSafe().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static String crackSafe(int n,int k){
        Map<String,Integer> map = new HashMap<>();
        int kn = (int) Math.pow(k,n);//路径数量
        int kn_1 = (int) Math.pow(k,n-1);//结点数量
        StringBuffer ans = new StringBuffer();
        //初始结点为000...
        for(int i = 1;i < n;i++){
            ans.append('0');
        }
        if(ans.length() == 0){
            for(int i = 0;i < k; i++){
                ans.append(i);
            }
            return ans.toString();
        }
        //遍历所有的路
        while (kn != 0){
            String substring = ans.substring(ans.length() - n + 1, ans.length());
            if(!map.containsKey(substring))
                map.put(substring,k-1);
            ans.append(map.get(substring));
            map.put(substring,map.get(substring) - 1);
            kn--;
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
