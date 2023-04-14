import java.util.*;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /* Using heap
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1 - x) < Math.abs(o2 - x)) ? 1 : -1;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
        for (int num : arr) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>(pq);
        Collections.sort(result);
        return result;
         */
        // Using binary search with window
        int left = 0, right = arr.length - k, mid;
        while(left < right) {
            mid = left + (right - left) / 2;
            // Consider mid as starting point of window of size k to the right
            if (x - arr[mid] > arr[mid + k] - x) { // Compare current mid with the element just after window ends
                left = mid + 1; // discard current mid
            } else {
                right = mid; // discard everything on right of current mid as array is sorted
            }
        }
        // When loop ends left=right
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
