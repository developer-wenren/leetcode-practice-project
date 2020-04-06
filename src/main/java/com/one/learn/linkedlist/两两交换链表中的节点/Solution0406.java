package com.one.learn.linkedlist.两两交换链表中的节点;

import com.one.learn.linkedlist.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution0406 {
    /**
     * 思路：
     * 两个节点交换，然后原头节点next执行下一个节点
     * 新建 dump 节点，然后关联的头节点，prev 执行 需要交换的前一个节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode current = head;
        while (current != null) {
            ListNode firstNode = current;
            ListNode second = current.next;
            firstNode.next = second.next;
            second.next = firstNode;
            prev.next = second;
            current = firstNode.next;
            prev = firstNode;
        }
        return dummy.next;
    }
}