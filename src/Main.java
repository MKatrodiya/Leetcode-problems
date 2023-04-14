import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        String strInput = "";
        System.out.println("answer: " + Arrays.toString(new FindKClosestElements().findClosestElements(input, 4, -1).toArray()));
    }
}