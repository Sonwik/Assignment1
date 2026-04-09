import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class seven {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2)
        );

        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll();
        }

        return top;
    }
}
