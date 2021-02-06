public class _24_SwapPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode one = head;
        ListNode two;
        ListNode three;
        while (one != null && one.next != null) {
            two = one.next;
            three = one.next.next;
            one.next = three;
            two.next = one;
            one = three;
        }
        return newHead;
    }
}
