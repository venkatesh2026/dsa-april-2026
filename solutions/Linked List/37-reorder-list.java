package LinkedList;

public class ReOrder {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        for (int i = 1; i <= 4; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        ReOrder reOrder = new ReOrder();

        reOrder.reorderList(listNode.next);

    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        ListNode previous = null;
        ListNode current = slow;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode firstNode = head;
        ListNode secondNode = previous;

        ListNode dummy = new ListNode(0);
        current = dummy;

        while (secondNode != null && secondNode != firstNode) {
            current.next = firstNode;
            ListNode headPrevious = firstNode;
            firstNode = firstNode.next;
            current = current.next;
            if (secondNode != headPrevious) {
                current.next = secondNode;
                current = current.next;
                secondNode = secondNode.next;
            }
        }
        if( secondNode == firstNode) {
            current.next = secondNode;
        }
        head = dummy.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
