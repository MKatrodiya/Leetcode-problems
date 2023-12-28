public class SortColors {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        int j = 0;
        for (int num : nums) {
            counts[num] = counts[num] + 1;
        }
        for (int i = 0; i < 3; i++) {
            while (counts[i] > 0) {
                nums[j++] = i;
                counts[i] = counts[i] - 1;
            }
        }
    }
}
