import java.util.Random;

public class _382_GetRandom {
    /**
     * Definition for singly-linked list.
     */
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

    ListNode head;
    Random random;

    public _382_GetRandom(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int reserve = 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            int r = random.nextInt(count) + 1; // r是随机到的数的下标
            if (r == count) // 以count/1的概率保留下标为count的当前数
                reserve = cur.val;
            cur = cur.next;
        }
        return reserve;
    }
}
