import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{3,2,3,1,2,4,5,5,6};
        char[] charInput = new char[]{'c','f','j'};
        String strInput = "";
//        ListNode node4 = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        ListNode node1 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        node4.next = node2;
//        node2.next = node1;
//        node1.next = node3;
        System.out.println("answer: " + new KthLargestElement().findKthLargest(input, 4));
    }
}