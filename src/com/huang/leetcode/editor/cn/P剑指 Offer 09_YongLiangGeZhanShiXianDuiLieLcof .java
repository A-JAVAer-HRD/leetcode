package com.huang.leetcode.editor.cn;

//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
//[[],[3],[],[],[]]
//输出：[null,null,3,-1,-1]
// 
//
// 示例 2： 
//
// 
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
//
// Related Topics 栈 设计 队列 👍 623 👎 0

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author HRD
 */
class Offer09_YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) { // 情况一B栈不空
            return stack2.pop();
        } else if (stack1.isEmpty()) { // 情况二AB都为空
            return -1;
        }else { // 情况三A不为空 B为空
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}

class CQueue2 {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public CQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }else {
            while (!stack1.isEmpty()) {
                Integer i = stack1.pop();
                stack2.push(i);
            }
            int head = stack2.pop();
            while (!stack2.isEmpty()) {
                Integer i = stack2.pop();
                stack1.push(i);
            }
            return head;
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
