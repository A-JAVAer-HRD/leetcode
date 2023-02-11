package com.huang.leetcode.editor.cn;

//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// 
//
// 
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
//
// Related Topics 递归 链表 👍 98 👎 0

import java.util.List;
import java.util.Stack;

/**
 * 反转链表
 *
 * @author HRD
 */
class OfferII024_UHnkqh{
    public static void main(String[] args) {
        Solution solution = new OfferII024_UHnkqh().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        solution.reverseList(node1);
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
    /**
     * 迭代：利用栈
     * */
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        while (newHead != null) {
            stack.push(newHead);
            newHead = newHead.next;
        }
        head = stack.pop();
        newHead = head;
        while (!stack.isEmpty()) {
            newHead.next = stack.pop();
            newHead = newHead.next;
        }
        newHead.next = null;
        return head;
    }

    /**
     * 迭代：双指针
     * */
    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;// 暂存后继节点 cur.next
            cur.next = pre;// 修改 next 引用指向
            pre = cur;// pre 暂存 cur
            cur = temp; // cur 访问下一节点
        }
        return pre;
    }

    /**
     * 迭代
     * */
    public ListNode reverseList(ListNode head) {
        return recur(head,null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) { // 终止条件
            return pre;
        }

        ListNode res = recur(cur.next, cur);//递归后续节点

        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
