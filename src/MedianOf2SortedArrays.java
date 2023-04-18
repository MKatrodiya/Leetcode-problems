public class MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { // Keep nums1 as smaller array to apply binary search on it
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = nums1.length + nums2.length;
        int half = total / 2; // Number of elements on the left side of the median
        int left = 0, right = nums1.length - 1, midNums1, midNums2;
        while (true) {
            midNums1 = (left <= right) ? left + (right - left) / 2 : -1; // Elements from nums1 that are included in final merged array in left subpart
            midNums2 = half - midNums1 - 2; // Elements from nums2 that are included in final merged array in left subpart
            // Boundary elements from both left and right subpart of final merged array
            int left1 = (midNums1 >= 0) ? nums1[midNums1] : Integer.MIN_VALUE;
            int left2 = (midNums2 >= 0) ? nums2[midNums2] : Integer.MIN_VALUE;
            int right1 = ((midNums1 + 1) < nums1.length) ? nums1[midNums1 + 1] : Integer.MAX_VALUE;
            int right2 = ((midNums2 + 1) < nums2.length) ? nums2[midNums2 + 1] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) { // both mids are correct
                if (total % 2 == 1) { // total number of elements is odd
                    return Math.min(right1, right2);
                } else { // total number of elements is even
                    return (double)(Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                }
            } else if (left1 > right2) { // Too many elements from nums1
                right = midNums1 - 1;
            } else {
                left = midNums1 + 1;
            }
        }
    }
}
