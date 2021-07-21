/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // pA走过的路径为A链+B链
    //pB走过的路径为B链+A链
    //pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐，如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        if (a == null || b == null) return null;
        while(a != b) {
            // if (a == null) {
            //     a = headB;
            // } else {
            //     a = a.next;
            // }
            // if (b == null) {
            //     b = headA;
            // } else {
            //     b = b.next;
            // }
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
// @lc code=end

