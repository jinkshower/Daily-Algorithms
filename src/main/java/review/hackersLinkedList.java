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

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode current = llist;
        while (current != null) {
            while (current.next != null && current.data == current.next.data) {
                current.next = current.next.next;
            }
            current = current.next;
        }

        return llist;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int len1 = getLength(head1); //각 길이를 구하고
        int len2 = getLength(head2);

        if (len1 > len2) { // 길이가 긴건 긴만큼 이동
            head1 = move(head1, len1 - len2);
        } else if (len1 < len2) {
            head2 = move(head2, len2 - len1);
        }

        while (head1 != head2) { // 같은 노드를 찾을 때까지 이동
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1.data;
    }

    static int getLength(SinglyLinkedListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    static SinglyLinkedListNode move(SinglyLinkedListNode head, int length) {
        while (length > 0 && head != null) {
            head = head.next;
            length--;
        }
        return head;
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        // Write your code here
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (llist == null) {
            return newNode;
        }
        //가장 작은 값이면
        if (data < llist.data) {
            newNode.next = llist;
            llist.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode current = llist;
        //move untill insertion node
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        // 끝 값이면
        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
            //일반적인 경우
        } else {
            newNode.next = current.next;
            newNode.prev = current;

            current.next.prev = newNode;
            current.next = newNode;
        }

        return llist;
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Write your code here
        if (llist == null) {
            return llist;
        }

        DoublyLinkedListNode newHead = null;

        while (llist != null) {
            DoublyLinkedListNode next = llist.next;
            llist.next = newHead;
            llist.prev = next;
            if (newHead != null) {
                newHead.prev = llist;
            }

            newHead = llist;
            llist = next;
        }
        return newHead;
    }
}
