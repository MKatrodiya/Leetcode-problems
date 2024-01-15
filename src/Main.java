
public class Main {
  public static void main(String[] args) {
    int[] input = new int[]{0,2000000000,-294967296};
    int[] input2 = new int[]{2, 3, 4};
    int[] input3 = new int[]{5, 6, 4};
    int[][] input2d = new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
    char[] charInput = new char[]{'c', 'f', 'j'};
    String strInput = "book";
    int intInput = 2000;
//        ListNode node4 = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        ListNode node1 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        node4.next = node2;
//        node2.next = node1;
//        node1.next = node3;
//    new RotateImage().rotate(input2d);
    System.out.println("answer: " + new PlayersWithZeroOrOneLosses().findWinners(input2d));
  }
}