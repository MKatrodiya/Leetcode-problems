public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            float temp = (float) num / mid;
            if (temp == mid) {
                return true;
            } else if (temp < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
