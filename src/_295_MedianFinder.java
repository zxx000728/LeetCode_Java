import java.util.PriorityQueue;

public class _295_MedianFinder {
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> big;
    private int balance;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        this.big = new PriorityQueue<>();
        this.balance = 0;
    }

    public void addNum(int num) {
        if (this.small.isEmpty() || (num <= this.small.peek())) {
            this.small.offer(num);
            this.balance++;
        } else {
            this.big.offer(num);
            this.balance--;
        }
        if (this.balance > 1) {
            this.big.offer(this.small.poll());
            this.balance = 0;
        } else if (this.balance < -1) {
            this.small.offer(this.big.poll());
            this.balance = 0;
        }
    }

    public double findMedian() {
        if (((this.small.size() + this.big.size()) & 1) == 1 && this.balance >= 0) {
            return (double) this.small.peek();
        } else if (((this.small.size() + this.big.size()) & 1) == 1 && this.balance < 0) {
            return (double) this.big.peek();
        } else {
            return ((double) this.small.peek() + (double) this.big.peek()) / 2;
        }
    }
}
