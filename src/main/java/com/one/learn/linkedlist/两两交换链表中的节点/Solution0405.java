package com.one.learn.linkedlist.两两交换链表中的节点;

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
public class Solution0405 {
    public static void main(String[] args) {
        Solution0405.ListNode listNode1 = new Solution0405.ListNode(1);
        Solution0405.ListNode listNode2 = new Solution0405.ListNode(2);
        Solution0405.ListNode listNode3 = new Solution0405.ListNode(3);
        Solution0405.ListNode listNode4 = new Solution0405.ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution0405.ListNode listNode = new Solution0405().swapPairs(listNode1);
        System.out.println(listNode);

    }

    static class ListNode {
        int val;
        Solution0405.ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度：O(N)，其中 N 指的是链表的节点数量。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }
        return dummy.next;
    }


    /**
     * 思路：迭代,2个
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while ((head != null) && (head.next != null)) {
            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }
        // Return the new head node.
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            // 相邻节点交换
            ListNode first = head;
            ListNode second = head.next;
            prevNode.next = second;
            first.next = second.next;
            second.next = first;

            // head 跳跃
            prevNode = first;
            head = first.next;
        }
        return dummy.next;
    }

    /**
     * 递归
     */
    public ListNode swapPairs4(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

}