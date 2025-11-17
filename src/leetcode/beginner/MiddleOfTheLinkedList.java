package leetcode.beginner;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        return list.get(list.size() / 2);
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode middle = head;
        ListNode end = head;

        while (end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        }

        return middle;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
