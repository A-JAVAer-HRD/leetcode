package com.huang.leetcode.editor.cn;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics 递归 链表 👍 299 👎 0

/**
 * 合并两个排序的链表
 *
 * @author HRD
 */
class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        new Solution().mergeTwoLists(l1, l2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
static class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else{
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode pre;
            ListNode head;
            if (l1.val < l2.val) {
                pre = l1;
                cur1 = cur1.next;
            } else {
                pre = l2;
                cur2 = cur2.next;
            }
            head = pre;
            while (true) {
                if (cur1 == null) {
                    pre.next = cur2;
                    break;
                } else if (cur2 == null){
                    pre.next = cur1;
                    break;
                } else {
                    if (cur1.val > cur2.val) {
                        pre.next = cur2;
                        cur2 = cur2.next;
                    } else {
                        pre.next = cur1;
                        cur1 = cur1.next;
                    }
                    pre = pre.next;
                }
            }
            return head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
