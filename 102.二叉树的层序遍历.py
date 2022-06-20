#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        ans = []
        if root is None:
            return ans
        q = []
        q.append(root)
        while len(q) > 0:
            level = []
            size = len(q)
            for i in range(0, size):
                tree_node = q.pop(0)
                level.append(tree_node.val)
                if tree_node.left is not None:
                    q.append(tree_node.left)
                if tree_node.right is not None:
                    q.append(tree_node.right)
            ans.append(level)
        return ans
# @lc code=end

