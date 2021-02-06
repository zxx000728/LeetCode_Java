public class _86__Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode smallTail = new ListNode(0);
        ListNode smallHead = smallTail;
        ListNode bigTail = new ListNode(0);
        ListNode bigHead = bigTail;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smallTail.next = curr;
                smallTail = smallTail.next;
            } else {
                bigTail.next = curr;
                bigTail = bigTail.next;
            }
            curr = curr.next;
        }
        bigTail.next = null;
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}

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
