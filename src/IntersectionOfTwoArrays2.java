import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> visited = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums1) {
            visited.add(num);
        }
        for (int num : nums2) {
            if (visited.contains(num)) {
                intersection.add(num);
                visited.remove((Integer) num);
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
