package com.one.learn.linkedlist.环形链表2;

import com.one.learn.linkedlist.ListNode;

import java.util.HashSet;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * <p>
 * <p>
 *  
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class Solution0405 {
    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode4;
        listNode4.next = listNode2;
        new Solution0405().detectCycle5(listNode3);
    }

    /**
     * 头节点到环节点的距离等于快慢节点相遇点到环节点的距离
     *
     * @param head
     * @return
     */
    public ListNode detectCycle5(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 另一个节点
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }


    /**
     * 相同时间，速度差就是距离差，
     * 快指针走的路：a + b + c (a为入环点前的距离，b为首次相遇减去a的距离，c为快指针多走的路减去b的距离)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle4(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle3(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 思路：
     * 1. hash 方式，找到了返回这个 node; o-n
     * 2. 双指针，快慢指针相等的节点, 先找到首次相遇点，快指针调整速度和位置再找到第二次相遇点
     *
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 首先判断有没有环
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 找出二次相遇点, 慢指针剩下走的路，就是从head到第二次相遇点的路，让fast走
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (!hashSet.contains(head)) {
                hashSet.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }
}