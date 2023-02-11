package com.huang.leetcode.editor.cn;

//在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。 
//
// 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，
//那么学生就坐在 0 号座位上。) 
//
// 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位
//置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在
//座位 p 上。 
//
// 
//
// 示例： 
//
// 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[]
//,[4],[]]
//输出：[null,0,9,4,2,null,5]
//解释：
//ExamRoom(10) -> null
//seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
//seat() -> 9，学生最后坐在 9 号座位上。
//seat() -> 4，学生最后坐在 4 号座位上。
//seat() -> 2，学生最后坐在 2 号座位上。
//leave(4) -> null
//seat() -> 5，学生最后坐在 5 号座位上。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。 
// 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。 
// 
//
// Related Topics 设计 有序集合 堆（优先队列） 👍 154 👎 0

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 考场就座
 *
 * @author HRD
 */
class P855_ExamRoom{
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(4);
        examRoom.seat();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class ExamRoom {
        PriorityQueue<int[]> q;
        TreeSet<Integer> set;
        int n;
        public ExamRoom(int n) {
            this.n = n;
            q = new PriorityQueue<>((a, b) -> {
                int d1 = (a[1] - a[0]) / 2, d2 = (b[1] - b[0]) / 2;
                return d1 == d2 ? a[0] - b[0] : d2 - d1; //当长度相等时，坐标更小先弹出，当不相等时，长度更大的先弹出
            });
            set = new TreeSet<>(); //创建有序集合
        }

        public int seat() {
            if (set.size() == 0) { set.add(0); return 0;} //1.没有人时，一定返回0
            int d1 = set.first(), d2 = n - 1 - set.last(); //获取最左和最右放置学生能获取的长度
            while (set.size() >= 2) { //2.大于等于两个人的时候，可以选择最左最右 或者中间的区间
                int[] t = q.poll();
                if (!set.contains(t[0]) || !set.contains(t[1]) || set.higher(t[0]) != t[1]) continue; //无效区间，某个端点已经被删除
                int d3 = (t[1] - t[0]) / 2;
                if (d3 <= d1 || d3 < d2) {q.add(new int[]{t[0], t[1]}); break;}; //选择最左或者最右
                int mid = (t[0] + t[1]) / 2; //选择中点
                q.add(new int[]{t[0], mid});
                q.add(new int[]{mid, t[1]});
                set.add(mid);
                return mid;
            }
            //3.选择最左或者最右的位置
            int l = 0, r = set.first(), sel = 0;
            if (d1 < d2) {l = set.last(); r = n - 1; sel = n - 1;}
            q.add(new int[]{l, r});
            set.add(sel);
            return sel;
        }

        public void leave(int p) {
            if (p != set.first() && p != set.last()) q.add(new int[]{set.lower(p), set.higher(p)}); //如果不是删除两端点, 那么会增加新区间
            set.remove(p);
        }
    }

    static class ExamRoom2 {
    int n;
    TreeSet<Integer> set;

    public ExamRoom2(int n) {
        this.n = n;
        set = new TreeSet<>();
    }

    /**
     * 选取位置
     */
    public int seat() {
        if (set.size() == 0) { // 第一次选取0号位置
            set.add(0);
            return 0;
        }
        int pre = set.first(), ans = set.first(), idx = 0; // 初始化：选择最左的长度
        for (int x : set) {
            if (ans < (x - pre) / 2) {
                ans = (x - pre) / 2; // 记录最大的距离
                idx = (x + pre) / 2; // 记录最大距离的位置
            }
            pre = x;
        }
        // 判断最右的边界
        int d = n - 1 - set.last();
        if (ans < d) { // 没有末尾的距离大，选用最右边界
            ans = d;
            idx = n - 1;
        }
        set.add(idx);
        return idx;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
