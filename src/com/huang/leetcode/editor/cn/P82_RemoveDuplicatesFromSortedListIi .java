package com.huang.leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1057 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author HRD
 */
class P82_RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        solution.deleteDuplicates(head);
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
    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            ListNode cur = head.next;
            while (cur != null && cur.val == head.val) {
                cur = cur.next;
            }
            return deleteDuplicates(cur);
        }
        return head;
    }
    // 一次遍历
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                // pre和cur之间没有重复节点，pre后移
                pre = pre.next;
            } else {
                // pre.next指向cur的下一个位置（相当于跳过了当前的重复元素）
                // 但是pre不移动，仍然指向已经遍历的链表结尾
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    // 忽略有序性，二次遍历
    public ListNode deleteDuplicates3(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode dummy = new ListNode(101);
        ListNode cur = head;
        while (cur != null) { // 统计节点出现的次数
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (map.get(cur.val) == 1) { // 节点没有重复
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
