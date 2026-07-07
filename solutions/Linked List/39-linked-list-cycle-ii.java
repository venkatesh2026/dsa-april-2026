package LinkedList;

public class LinkedListCycleTwo {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCyclePresent = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isCyclePresent = true;
                break;
            }
        }
        slow = head;
        if (isCyclePresent) {
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;

        } else {
            return null;
        }
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
