#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] 两数相加
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # h = t = None
        # carry = 0
        # while l1 is not None or l2 is not None:
        #     if l1 is not None:
        #         n1 = l1.val
        #     else:
        #         n1 = 0
        #     if l2 is not None:
        #         n2 = l2.val
        #     else:
        #         n2 = 0
        #     sum = n1 + n2 + carry
        #     if h is None:
        #         h = t = ListNode(sum % 10)
        #     else:
        #         t.next = ListNode(sum % 10)
        #         t = t.next
        #     carry = int(sum / 10)
        #     if l1 is not None:
        #         l1 = l1.next
        #     if l2 is not None:
        #         l2 = l2.next
        # if carry > 0:
        #     t.next = ListNode(carry)
        # return h
        h1 = l1
        h2 = l2
        #h1前一个指针
        h1_pre = None
        num = 0
        while h1 is not None or h2 is not None:
            #提前补0
            if h1.next is None and h2.next is not None:
                h1.next = ListNode(0)
            #提前补0
            if h2.next is None and h1.next is not None:
                h2.next = ListNode(0)
            val = (h1.val + h2.val + num) % 10
            num = int((h1.val + h2.val + num) / 10)
            #改变l1链表为目标链表
            h1.val = val
            h1_pre = h1
            h1 = h1.next
            h2 = h2.next
        if num != 0:
            h1_pre.next = ListNode(num)
        #复用l1，节省空间
        return l1

# @lc code=end

