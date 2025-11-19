package leetcode.sorting;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // 더미 노드 생성 (정렬된 리스트의 시작점)
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;

        while (current != null) {
            ListNode prev = dummy;

            // 삽입 위치 찾기
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            ListNode next = current.next;
            // current를 적절한 위치에 삽입
            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
