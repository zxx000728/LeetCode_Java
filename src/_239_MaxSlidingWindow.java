import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _239_MaxSlidingWindow {

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        HashMap<Integer, Integer> debt = new HashMap<>();
//        int[] result = new int[nums.length - k + 1];
//        int i = 0, j = k - 1, index = 0;
//        for (int m = 0; m < k; m++) { // init
//            priorityQueue.offer(nums[m]);
//        }
//        result[index++] = priorityQueue.peek();
//        while (++j < nums.length) {
//            deleteElement(nums, debt, priorityQueue, i++);
//            insertElement(nums, priorityQueue, j);
//            while (debt.getOrDefault(priorityQueue.peek(), 0) > 0) {
//                debt.put(priorityQueue.peek(), debt.get(priorityQueue.peek()) - 1);
//                priorityQueue.poll();
//            }
//            result[index++] = priorityQueue.peek();
//        }
//        return result;
//    }
//
//    private void insertElement(int[] nums, PriorityQueue<Integer> priorityQueue, int j) {
//        priorityQueue.offer(nums[j]);
//    }
//
//    private void deleteElement(int[] nums, HashMap<Integer, Integer> debt, PriorityQueue<Integer> priorityQueue, int i) {
//        int curr = nums[i];
//        debt.put(curr, debt.getOrDefault(curr, 0) + 1);
//    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // (num,index)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
