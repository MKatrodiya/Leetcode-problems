public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), preInsert, toInsert;
        ListNode curr = head;
        dummy.next = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val >= curr.val) { // consecutive nodes are already sorted
                curr = curr.next;
            } else { // find correct place to insert curr.next i.e. between preInsert and curr
                toInsert = curr.next;
                preInsert = dummy;
                while (preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                curr.next = toInsert.next;
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        return dummy.next;
    }
}
