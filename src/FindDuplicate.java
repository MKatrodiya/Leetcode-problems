public class FindDuplicate {
    public int findDuplicate(int[] nums) {
//        // Using binary search
//        // Only duplicate number will have counts of num less than or equal to itself greater than its value
//        int left = 1, right = nums.length, mid, duplicate = 0;
//        while (left != right) {
//            mid = left + (right - left) / 2;
//            int count = 0;
//            for (int num : nums) {
//                if (num <= mid) {
//                    count++;
//                }
//            }
//            if (count > mid) {
//                duplicate = mid;
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return duplicate;

        // Using cycle detection algo
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast); // slow and fast will meet at some point in cycle
        slow = nums[0];
        while (slow != fast) { // Move both pointers at same pace
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
