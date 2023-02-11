package com.huang.leetcode.editor.cn;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1476 👎 0

/**
 * 反转链表 II
 *
 * @author HRD
 */
class P92_ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        solution.reverseBetween(head,1, 2);
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode cur = head;
        ListNode leftNode = null, rightNode = null, pre = null, next, leftCur = null;
        while (cur != null) {
            if (left - 1 != 0) { // 找左节点
                --left;
                --right;
                pre = cur;
                cur = cur.next;
                continue;
            }
            if (leftNode == null){
                leftNode = cur;
                leftCur = leftNode;
            }
            // 左节点存在，反转
            next = cur.next;
            cur.next = leftCur;
            leftCur = cur;
            cur = next;

            if (rightNode != null) {
                break;
            }

            if (right - 2 != 0) { // 找右节点
                --right;
            } else {
                rightNode = cur; // 还要让rightNode向前指，多遍历一遍
            }
        }

        // 左右节点都找到，中间已经反转,cur就是rightNode的下一个位置
        leftNode.next = cur;
        if (pre != null) {
            pre.next = rightNode;
        }

        if (head == leftNode) {
            return rightNode;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
