public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid;
        if (letters[right] <= target) {
            return letters[0];
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }
}
