package LinkedList;

public class IntersectionOfTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int countA = 0;
        int countB = 0;
        while (tempA != null || tempB != null) {
            if (tempA != null) {
                countA++;
                tempA = tempA.next;
            }

            if (tempB != null) {
                countB++;
                tempB = tempB.next;
            }
        }

        int diff = Math.abs(countA - countB);
        tempA=headA;
        tempB=headB;

        while (countA != countB) {
            if (countA > countB) {
                tempA = tempA.next;
                countA--;
            } else {
                tempB = tempB.next;
                countB--;
            }
        }

        while (tempA!=tempB) {
            tempA=tempA.next;
            tempB=tempB.next;
        }

        return tempA;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
