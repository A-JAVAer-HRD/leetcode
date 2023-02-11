package com.huang.leetcode.editor.cn;

//有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候
//进入锁住的房间。 
//
// 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。 
//
// 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[1],[2],[3],[]]
//输出：true
//解释：
//我们从 0 号房间开始，拿到钥匙 1。
//之后我们去 1 号房间，拿到钥匙 2。
//然后我们去 2 号房间，拿到钥匙 3。
//最后我们去了 3 号房间。
//由于我们能够进入每个房间，我们返回 true。
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[1,3],[3,0,1],[2],[0]]
//输出：false
//解释：我们不能进入 2 号房间。
// 
//
// 
//
// 提示： 
//
// 
// n == rooms.length 
// 2 <= n <= 1000 
// 0 <= rooms[i].length <= 1000 
// 1 <= sum(rooms[i].length) <= 3000 
// 0 <= rooms[i][j] < n 
// 所有 rooms[i] 的值 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 284 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 钥匙和房间
 *
 * @author HRD
 */
class P841_KeysAndRooms{
    public static void main(String[] args) {
        Solution solution = new P841_KeysAndRooms().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return bfs(rooms);
    }

    private boolean bfs(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];  // 标记房间是否被访问过
        visited[0] = true; //  0 号房间开始
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); //  0 号房间开始
        // 广度优先搜索的过程
        while (!queue.isEmpty()) {
            int key = queue.poll();
            for (int x : rooms.get(key)) {
                if (!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
        // 检查房间是不是都遍历过了
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }


        public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()]; // 记录有没有访问过该房间
        dfs(rooms, 0, visited);
        // 检查是否都访问过了
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    // 写法一：处理当前访问的节点
    private void dfs(List<List<Integer>> rooms, int key, boolean[] visited) {
        if (visited[key]) {
            // 之前访问过，直接返回
            return;
        }
        visited[key] = true; // 设置值，表示该房间访问过
        for (int x : rooms.get(key)) {
            dfs(rooms, x, visited);
        }
    }

    // 写法二：处理下一个访问的节点
    private void dfs2(List<List<Integer>> rooms, int key, boolean[] visited) {
        visited[key] = true; // 设置值，表示该房间访问过
        for (int x : rooms.get(key)) {
            if (visited[x]) { // 下一个房间访问过，跳过
                continue;
            }
            dfs(rooms, x, visited); // 递归
        }
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
