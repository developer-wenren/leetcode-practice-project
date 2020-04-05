package com.one.learn.linkedlist.K个一组翻转链表;

import com.one.learn.linkedlist.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 */
class Solution0405 {
    /**
     * 补充一个临时节点 dummy,用来关联最终首节点
     * 链表分为三部分：一翻转，待翻转，未翻转
     * for 截取指定k长度的链表
     * 时间复杂度为 O(n*K)O(n∗K) 最好的情况为 O(n)O(n) 最差的情况未 O(n^2)O(n
     * 2
     *  )
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse3(start);
            start.next = next;

            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverse3(ListNode start) {
        ListNode prev = null, current = start;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    /**
     * 思路：
     * 两两交换
     * 每轮交换 k-1 次
     * <p>
     * 能不能用递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            ListNode reverse = reverse2(start);
            pre.next = reverse;
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse2(ListNode start) {
        ListNode prev = null, current = start;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            current = next;
            prev = current;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 1. 找到待翻转的尾节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            // 2. 待翻转首节点
            ListNode start = pre.next;
            // 3. 未翻转的首节点
            ListNode next = end.next;
            // 4. 截断翻转的链表，然后进行翻转
            end.next = null;
            ListNode reverse = reverse(start);
            // 5.连接新的首节点
            pre.next = reverse;
            // 6.续上未翻转的首节点
            start.next = next;
            // 7.移动前驱和后继节点
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    /**
     * 反向链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}