package review;

public class hackersLinkedList {
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        SinglyLinkedListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;

        return head;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (llist == null) {
            llist = newNode;
            return llist;
        }

        newNode.next = llist;
        return newNode;
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (llist == null) {
            llist = newNode;
            return llist;
        }

        if (position == 0) {
            newNode.next = llist;
            return newNode;
        }

        SinglyLinkedListNode current = llist;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return llist;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (position == 0) {
            llist = llist.next;
            return llist;
        }

        SinglyLinkedListNode current = llist;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        current.next = current.next.next;
        return llist;
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode newHead = null;

        while (llist != null) {
            SinglyLinkedListNode next = llist.next;
            llist.next = newHead;

            newHead = llist;
            llist = next;
        }

        while (newHead != null) {
            System.out.println(newHead.data);

            newHead = newHead.next;
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == head2;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode current = null;
        while (head1 != null && head2 != null) {
            SinglyLinkedListNode newNode;
            if (head1.data < head2.data) {
                newNode = new SinglyLinkedListNode(head1.data);
                head1 = head1.next;
            } else {
                newNode = new SinglyLinkedListNode(head2.data);
                head2 = head2.next;
            }

            if (newHead == null) {
                newHead = newNode;
                current = newHead;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }

        if (head1 != null) { //둘다 sorted라고 명시되어 있음
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return newHead;
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode offset = llist;
        for (int i = 0; i < positionFromTail; i++) {
            offset = offset.next;
        }

        while (offset.next != null) {
            offset = offset.next;
            llist = llist.next;
        }

        return llist.data;
    }
}
