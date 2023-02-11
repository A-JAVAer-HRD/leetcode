package com.huang.leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8834 👎 0

/**
 * 两数相加
 *
 * @author HRD
 */
class P2_AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2_AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(1);
        ListNode l2 = new ListNode(5);
        solution.addTwoNumbers(l1 , l2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /***
     * 构建新链表
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int out = 0;//记录进位
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (cur1 != null || cur2 != null) {
            cur.next = new ListNode(0);
            if (cur1 == null) {
                cur.next.val = cur2.val + out;
                cur2 = cur2.next;
            } else if (cur2 == null) {
                cur.next.val = cur1.val + out;
                cur1 = cur1.next;
            } else {
                cur.next.val = cur1.val + cur2.val + out;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            if (cur.next.val > 9) { // 2 位数
                cur.next.val = cur.next.val % 10;
                out = 1;
            } else {
                out = 0;
            }
            cur = cur.next;
        }
        if (out == 1) { //如果有进位 填上进位
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    /**
     * 在原链表上改值
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre = l1;
        int out = 0;
        while (cur1 != null && cur2 != null) {
            if (cur1.next == null) { //cur1 小拼接
                cur1.next = cur2.next;
                cur2.next = null;
            }
            cur1.val = cur1.val + cur2.val + out;
            out = 0;
            if (cur1.val > 9) {
                cur1.val = cur1.val % 10;
                out = 1;
            }
            pre = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 == null && out == 1) { //位数相同 有一个进位
            pre.next = new ListNode(1);
        }
        while (cur1 != null) { //如果存在拼接的情况，则可能存在进位未加的情况
            cur1.val += out;
            out = 0;
            if (cur1.val > 9) {
                cur1.val = cur1.val % 10;
                out = 1;
            }
            if (cur1.next == null && out == 1) {
                cur1.next = new ListNode(1);
                out = 0;
            }
            cur1 = cur1.next;
        }
        return l1;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
