public class _19_removeNthFromEnd {
    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast;
        slow = fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) // 如果fast等于null，说明倒数第n个结点就是第一个结点
            return head.next;
        while (fast.next != null) { // 找到要删除结点的前一个结点
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // 删除结点
        return head;
    }
}
