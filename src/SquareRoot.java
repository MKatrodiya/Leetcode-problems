public class SquareRoot {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 0, high = x, mid = 0;
        long temp;
        while (low != high) {
            mid = low + (high - low) / 2;
            temp = (long) mid * mid;
            if (temp == x) {
                return mid;
            } else if (temp > x) {
                high = mid;
            } else {
                low = mid;
            }
            if (low + 1 == high) {
                break;
            }
        }
        return low;
    }
}
