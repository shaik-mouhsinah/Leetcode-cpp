import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // total numbers
        int m = in.nextInt(); // subarray size

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            deque.addLast(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // Maintain window size m
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                freq.put(removed, freq.get(removed) - 1);
                if (freq.get(removed) == 0) {
                    freq.remove(removed);
                }
            }

            // Update max unique count
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, freq.size());
            }
        }

        System.out.println(maxUnique);
    }
}
