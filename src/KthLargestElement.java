public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, result = 0;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }

        for(int i = 0; i < k; i++) {
            result = nums[0];
            nums[0] = nums[n - 1];
            maxHeapify(nums, n - 1, 0);
            n = n - 1;
        }
        return result;
    }

    private void maxHeapify(int[] nums, int size, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < size && nums[left] > nums[i]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            maxHeapify(nums, size, largest);
        }
    }
}
