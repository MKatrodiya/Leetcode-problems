import java.util.*;

public class LargestRectHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0, i;
        Stack<Integer> s = new Stack<>();
        int[] left = findNearestSmallestToLeft(s, heights);
        s.clear();
        int[] right = findNearestSmallestToRight(s, heights);
        for (i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    private int[] findNearestSmallestToLeft(Stack<Integer> s, int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else if (arr[s.peek()] < arr[i]) {
                result[i] = s.peek();
            } else {
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = s.peek();
                }
            }
            s.push(i);
        }
        return result;
    }

    private int[] findNearestSmallestToRight(Stack<Integer> s, int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                result[i] = arr.length;
            } else if (arr[s.peek()] < arr[i]) {
                result[i] = s.peek();
            } else {
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    result[i] = arr.length;
                } else {
                    result[i] = s.peek();
                }
            }
            s.push(i);
        }
        return result;
    }
}
