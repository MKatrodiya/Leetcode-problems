public class MergeSortIterative {
    public int[] sortArray(int[] nums) {
        int i, p, right, mid;
        for (p = 1; p <= nums.length; p = p * 2) { // p represents passes/no. of elements
            for (i = 0; i < nums.length - p; i = i + 2 * p) {
                if (i + 2 * p - 1 > nums.length - 1) {
                    right = nums.length - 1;
                } else {
                    right = i + 2 * p -1;
                }
                mid = i + p - 1;
                merge(nums, i, mid, right);
            }
        }
        //if there are odd number of elements, merge last pass
        if (p / 2 < nums.length) {
            merge(nums, 0, p / 2 - 1, nums.length - 1);
        }
        return nums;
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        int[] result = new int[right + 1];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            result[k++] = nums[i++];
        }
        while (j <= right) {
            result[k++] = nums[j++];
        }
        for (i = left; i <= right; i++) {
            nums[i] = result[i];
        }
    }
}
