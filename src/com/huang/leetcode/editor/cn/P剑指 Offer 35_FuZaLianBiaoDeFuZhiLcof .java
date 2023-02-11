//package com.huang.leetcode.editor.cn;
//
////请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
////向链表中的任意节点或者 null。
////
////
////
//// 示例 1：
////
////
////
//// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
////输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
////
////
//// 示例 2：
////
////
////
//// 输入：head = [[1,1],[2,1]]
////输出：[[1,1],[2,1]]
////
////
//// 示例 3：
////
////
////
//// 输入：head = [[3,null],[3,0],[3,null]]
////输出：[[3,null],[3,0],[3,null]]
////
////
//// 示例 4：
////
//// 输入：head = []
////输出：[]
////解释：给定的链表为空（空指针），因此返回 null。
////
////
////
////
//// 提示：
////
////
//// -10000 <= Node.val <= 10000
//// Node.random 为空（null）或指向链表中的节点。
//// 节点数目不超过 1000 。
////
////
////
////
//// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
////pointer/
////
////
////
//// Related Topics 哈希表 链表 👍 606 👎 0
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 复杂链表的复制
// *
// * @author HRD
// */
//class FuZaLianBiaoDeFuZhiLcof{
//    public static void main(String[] args) {
//        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
//
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
///*
//// Definition for a Node.
//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}
//*/
//class Solution {
//    /**
//     * 哈希表
//     * */
//    public Node copyRandomList1(Node head) {
//        if (head == null) return null;
//
//        Map<Node, Node> map = new HashMap<>();
//        Node cur = head;
//        while (cur != null) { //构造节点
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        while (cur != null) { //复制引用 复制新节点的引用
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }
//
//    /**
//     * 拼接 + 拆分
//     * */
//    public Node copyRandomList2(Node head) {
//        if (head == null) {
//            return null;
//        }
//        // 复制各节点，构建拼接链表
//        Node cur = head;
//        while (cur != null) {
//            Node temp = new Node(cur.val);
//            temp.next = cur.next;
//            cur.next = temp;
//            cur = temp.next;
//        }
//        // 构建新链表各节点的 random 指向
//        cur = head;
//        while (cur != null) {
//            if (cur.random != null)
//                cur.next.random = cur.random.next;
//            cur  = cur.next.next;
//        }
//        // 拆分两链表
//        cur = head.next;
//        Node pre = head, res = head.next;
//        while (cur.next != null) {
//            pre.next = pre.next.next;
//            cur.next = cur.next.next;
//            pre = pre.next;
//            cur = cur.next;
//        }
//        pre.next = null;
//        return res;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
