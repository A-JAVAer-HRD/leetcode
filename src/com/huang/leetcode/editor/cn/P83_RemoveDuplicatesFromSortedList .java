package com.huang.leetcode.editor.cn;

//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 👍 934 👎 0

/**
 * 删除排序链表中的重复元素
 *
 * @author HRD
 */
class P83_RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
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
        if (head == null || head.next == null) { // base case
            return head;
        }

        if (head.next.val == head.val) { // 跳过下一个节点
            head.next = deleteDuplicates(head.next.next);
            // 了防止删除了下个节点，与下下个节点还是一样，继续递归，如[1,1,1]这种情况，跳过了第二个节点，还剩下[1,1]
            return deleteDuplicates(head);
        } else {
            deleteDuplicates(head.next);
        }
        return head;
    }

    // 一次遍历
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
