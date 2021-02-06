import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _480_MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> big = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        HashMap<Integer, Integer> debt = new HashMap<>();
        // index 当前滑窗位置
        int i = 0, j = k - 1, index = 0, balance = 0; // balance 小堆元素个数 - 大堆元素个数
        // init
        int[] tempArr = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(tempArr);
        int range = (k & 1) == 1 ? k / 2 : k / 2 - 1; // 计算奇偶中位数的位置
        for (int m = 0; m <= range; m++) {
            small.offer(tempArr[m]);
        }
        for (int m = range + 1; m < k; m++) {
            big.offer(tempArr[m]);
        }
        result[index++] = insertResult(small, big, k);
        while (++j < nums.length) { // start from k
            balance += deleteElement(debt, nums, i++, small, big);
            balance += insertElement(nums, j, small, big);
            makeBalance(debt, small, big, balance);
            result[index++] = insertResult(small, big, k);
            balance = 0;
        }
        return result;
    }

    private int deleteElement(HashMap<Integer, Integer> debt, int[] nums, int i, PriorityQueue<Integer> small, PriorityQueue<Integer> big) {
        int curr = nums[i];
        debt.put(curr, debt.getOrDefault(curr, 0) + 1);
        return !small.isEmpty() && nums[i] <= small.peek() ? -1 : 1;
    }

    private int insertElement(int[] nums, int j, PriorityQueue<Integer> small, PriorityQueue<Integer> big) {
        if (!small.isEmpty() && nums[j] <= small.peek()) {
            small.offer(nums[j]);
            return 1;
        }
        big.offer(nums[j]);
        return -1;
    }

    private void makeBalance(HashMap<Integer, Integer> debt, PriorityQueue<Integer> small, PriorityQueue<Integer> big, int balance) {
        if (balance == 2) {
            big.offer(small.poll());
        } else if (balance == -2) {
            small.offer(big.poll());
        }
        while (!small.isEmpty() && debt.getOrDefault(small.peek(), 0) > 0) {
            debt.put(small.peek(), debt.get(small.peek()) - 1);
            small.poll();
        }
        while (!big.isEmpty() && debt.getOrDefault(big.peek(), 0) > 0) {
            debt.put(big.peek(), debt.get(big.peek()) - 1);
            big.poll();
        }
    }

    private double insertResult(PriorityQueue<Integer> small, PriorityQueue<Integer> big, int k) {
        return (k & 1) == 1 ? (double) small.peek() : ((double) small.peek() + (double) big.peek()) / 2;
    }
}
