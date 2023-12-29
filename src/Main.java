import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{7,1,5,3,6,4};
        char[] charInput = new char[]{'c','f','j'};
        String strInput = "";
//        ListNode node4 = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        ListNode node1 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        node4.next = node2;
//        node2.next = node1;
//        node1.next = node3;
        System.out.println("answer: " + new BestTimeToBuySellStock2().maxProfit(input));
    }
}