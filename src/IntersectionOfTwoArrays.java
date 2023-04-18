import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for (int num : nums1) {
            visited.add(num);
        }
        for (int num : nums2) {
            if (visited.contains(num)) {
                intersection.add(num);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
