package com.huang.leetcode.editor.cn;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1123 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 *
 * @author HRD
 */
class P143_ReorderList{
    public static void main(String[] args) {
        Solution solution = new P143_ReorderList().new Solution();
        
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
    // 方法二：寻找链表中点 + 链表逆序 + 合并链表
    // 目标链表即为将原链表的左半端和反转后的右半端合并后的结果
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = getMidNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        right = reverseList(right);
        mergeList(left, right);
    }

    // 合并链表
    private void mergeList(ListNode left, ListNode right) {
        while (left != null && right != null) {
            ListNode tmpLeft = left.next;
            ListNode tmpRight = right.next;

            left.next = right;
            left = tmpLeft;

            right.next = left;
            right = tmpRight;
        }
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 寻找链表中间节点
    private ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 递归
     */
     public void reorderList(ListNode head) {

         if (head == null || head.next == null || head.next.next == null) {
             return;
         }

         int len = 0;
         ListNode cur = head;
         //求出节点数
         while (cur != null) {
             len++;
             cur = cur.next;
         }

         reorderListHelper(head, len);

    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }

    /**
     * 使用线性表
     */
    public void reorderList2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) { // 把节点放入线性表中
            list.add(head);
            head = head.next;
        }

        // 双指针进行交换节点
        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            //偶数个节点的情况，会提前相遇
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
