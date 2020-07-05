package com.one.learn.linkedlist.两数相加;

import com.one.learn.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SolutionOld {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(9);
        a.next.next = new ListNode(9);
        a.next.next.next = new ListNode(9);
        a.next.next.next.next = new ListNode(9);
        a.next.next.next.next.next = new ListNode(9);
        Long number = new SolutionOld().getNumber(a);
        ListNode b = new ListNode(9);
        Long number2 = new SolutionOld().getNumber(b);
        ListNode listNode = new SolutionOld().addTwoNumbers(a, b);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long left = getNumber(l1);
        Long right = getNumber(l2);
        Long sum = left + right;
        ListNode node = splitNumber(sum);
        return node;
    }

    private ListNode splitNumber(Long sum) {
        // 分割数字
        // 807 ==> 7-0-8
        // i=7,firtNode=7,sum = 80
        // i = 0,firtNode=0,sum = 8;
        // i = 8,firsstNdo=8,sum = 0;
        int i = (int) (sum % 10);
        ListNode firstNode = new ListNode(i);
        ListNode temp = firstNode;
        sum = sum / 10;
        while (sum != 0) {
            i = (int) (sum % 10);
            temp.next = new ListNode(i);
            sum = sum / 10;
            temp = temp.next;
        }
        return firstNode;
    }

    private Long getNumber(ListNode l1) {
        Long temp = Long.valueOf(l1.val);
        ListNode tempNode = l1.next;
        int count = 1;
        while (tempNode != null) {
            int val = tempNode.val;
            temp = temp + Long.valueOf((long) (val * Math.pow(10, count++)));
            tempNode = tempNode.next;
        }
        return Long.valueOf(temp);
    }
}