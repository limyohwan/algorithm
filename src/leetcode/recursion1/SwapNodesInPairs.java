package leetcode.recursion1;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // 베이스 케이스: 비어있거나 노드가 하나만 있으면 스왑 불필요
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 세 번째 노드부터 재귀적으로 처리
        ListNode remainingList = swapPairs(head.next.next);

        // 2. 두 번째 노드를 저장 (새로운 헤드가 됨)
        ListNode newHead = head.next;

        // 3. 스왑 수행
        newHead.next = head;           // 두 번째 노드가 첫 번째 노드를 가리킴
        head.next = remainingList;     // 첫 번째 노드가 처리된 나머지를 가리킴

        // 4. 새로운 헤드 반환
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
