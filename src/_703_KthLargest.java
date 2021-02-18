import java.util.PriorityQueue;

public class _703_KthLargest {
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    class KthLargest {
        PriorityQueue<Integer> priorityQueue;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.priorityQueue = new PriorityQueue<>();
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            priorityQueue.offer(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }
}
