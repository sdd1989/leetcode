/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 首先利用HashMap采用层序遍历，构建子节点指向父节点的关系图：子节点作为key，父节点作为value。这样就能够与原来的二叉树结构“结合”起来变成一个图。
*   通过map直接找到目标节点，从目标节点开始使用bfs进行遍历，每一趟遍历就将每一个节点的父节点以及左右孩子节点（如果有的话）加入下一趟遍历的队列中。
*   同时设置vis保存已经访问过的结点，防止重复访问。
*   一趟遍历结束之后，判断当前步数是否等于k，如果等于k，就可以直接将队列中的节点值直接作为结果返回了；如果不等于k，就开始下一趟遍历。
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node.left != null) {
                map.put(node.left, node);
                deque.addFirst(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                deque.addFirst(node.right);
            }
        }
        HashSet<TreeNode> vis = new HashSet<>();
        deque.addFirst(target);
        vis.add(target);
        int step = 0;
        List<Integer> ans = new ArrayList<>();
        //距离为0就是自己
        if (step==k) ans.add(deque.pollLast().val);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                //访问当前节点的父亲节点（距离为1）
                if (map.containsKey(node) && !vis.contains(map.get(node))) {
                    deque.addFirst(map.get(node));
                    vis.add(map.get(node));
                }
                //访问当前节点的左孩子（距离为1）
                if (node.left != null && !vis.contains(node.left)) {
                    deque.addFirst(node.left);
                    vis.add(node.left);
                }
                //访问当前孩子的右孩子（距离为1）
                if (node.right != null && !vis.contains(node.right)) {
                    deque.addFirst(node.right);
                    vis.add(node.right);
                }
            }
            step++;
            if (step == k) {
                while (!deque.isEmpty()) {
                    ans.add(deque.pollLast().val);
                }
            }
        }
        return ans;

    }


}
// @lc code=end

