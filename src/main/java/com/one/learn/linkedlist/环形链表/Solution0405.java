package com.one.learn.linkedlist.环形链表;

import com.one.learn.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * 输出：false
 * 解释：链表中没有环。
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
    }

    /**
     * 快慢指针相等判断在内部
     *
     * @param head
     * @return
     */
    public boolean hasCycle5(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度O-N
     * 空间复杂度O-1
     * 双指针，设置慢指针和快指针，快指针一次跳跃2格，慢指针跳跃1个，
     * 循环迭代直到快指针碰到慢指针，或者快指针走完结束
     *
     * @param node
     * @return
     */
    public boolean hasCycle4(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 暴露解法 + Hash
     * 时间复杂度 O-N
     * 空间复杂度 O-N
     * 数组存储每一个节点，查看是否末尾节点执行的节点是否已存在
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> objects = new HashSet<>();
        // 保留最后一个节点
        while (head != null) {
            if (!objects.contains(head)) {
                objects.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针法
     * 快慢指针同时迭代
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            // 前面有 fast.next == null 判断，此处的 fast.next 必不为 null
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}