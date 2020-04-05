package com.one.learn.linkedlist.反转链表;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author one
 * @date 2020/04/05
 */

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution0405 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = new Solution0405().reverseList(listNode1);
        System.out.println(listNode);
    }

    /**
     * 双指针迭代法
     * 定义新的头节点默认指向null，从旧头节点开始遍历，临时记录下一个节点，将当前节点的next指向新的头节点，
     * 新头节点指向当前节点，当前头节点移至下一个节点
     *
     * @param head
     * @return
     */
    public ListNode reverseList7(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }
        return newHead;
    }

    public ListNode reverseList6(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 双指针迭代 时间复杂度O（N）
     * current 记录当前节点，next 记录下一个节点，默认为null
     * temp 记录临时的下一个节点
     * 当前节点的next指向下一个节点，同时 current.next 向左移,current 指向到了 temp 所对应节点，next 指向了原来current位置
     * 直到 current 指向了 null，说明节点遍历完毕，返回 next 即最后的节点
     *
     * @param head
     * @return
     */
    public ListNode reverseList5(ListNode head) {
        ListNode next = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNode = current.next;
            current.next = next;
            next = current;
            current = tempNode;
        }
        return next;
    }


    public ListNode reverseList4(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }
        return prev;
    }


    /**
     * 双指针迭代 O(n)，临时存储下一个节点，两个节点间交换;
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        return prev;
    }

    /**
     * 递归方式 O(N）当前节点的next节点的next指向为当前节点
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }


    /**
     * 1. 从尾到头迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 0) {
            return head;
        }
        ListNode newLinked = list.get(list.size() - 1);
        for (int i = list.size() - 1; i > 0; i--) {
            if (i > 0) {
                ListNode listNode = list.get(i - 1);
                listNode.next = null;
                ListNode temp = newLinked;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = listNode;
            } else {
                newLinked.next = null;
            }
        }
        return newLinked;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
