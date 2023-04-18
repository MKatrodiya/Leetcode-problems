import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{3,1,3,4,7,9,12};
        char[] charInput = new char[]{'c','f','j'};
        String strInput = "";
        System.out.println("answer: " + new KthSmallestPairDistance().smallestDistancePair(input, 6));
    }
}