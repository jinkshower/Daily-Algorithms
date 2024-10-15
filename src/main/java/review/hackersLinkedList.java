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
}
