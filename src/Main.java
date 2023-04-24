import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{1,6,1};
        char[] charInput = new char[]{'c','f','j'};
        String strInput = "";
        System.out.println("answer: " + new KthSmallestPairDistance().smallestDistancePair(input, 3));
    }
}