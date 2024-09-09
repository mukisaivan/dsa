
import java.util.NoSuchElementException;

public class javadsa {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class DoublyListNode {
        int data;
        DoublyListNode prev;
        DoublyListNode next;

        public DoublyListNode(int data) {
            this.data = data;
        }

    }

    ListNode head;
    static DoublyListNode dhead;
    static DoublyListNode tail;
    int length = 0;
    ListNode csllLast;

    public static void main(String[] args) {

        javadsa javadsa = new javadsa();

        // INTRODUCTION
        javadsa.hollowrectangle();
        javadsa.gettingthesecondmax(new int[] { 3, 4, 6, 5, 1, 3, 7 });
        javadsa.findmissingvalue(new int[] { 1, 2, 4, 5, 6 });
        javadsa.isPalindrome("string");

        // LINKED LISTS

        /*
         * javadsa.creatingSinglyLinkedList();
         * javadsa.insertFirst(5);
         * javadsa.insertFirst(2);
         * javadsa.insertFirst(3);
         * 
         * javadsa.displaylist();
         * 
         * javadsa.insertLast(10);
         * javadsa.insertLast(20);
         * javadsa.insertLast(30);
         * javadsa.displaylist();
         */

        /*
         * javadsa.insert_at_a_given_position(1, 99);
         * javadsa.insert_at_a_given_position(2, 88);
         * javadsa.insert_at_a_given_position(3, 66);
         * javadsa.displaylist();
         */

        /*
         * javadsa.creatingSinglyLinkedList();
         * javadsa.deleteFirstNodefromLinkedList();
         * javadsa.displaylist();
         */

        /*
         * javadsa.creatingSinglyLinkedList();
         * javadsa.deleteNodeAtPosn(2);
         * javadsa.displaylist();
         */

        /*
         * javadsa.creatingSinglyLinkedList();
         * javadsa.deleteLastNode();
         * javadsa.displaylist();
         */

        /*
         * javadsa.creatingSinglyLinkedList();
         * javadsa.itemSearching(3);
         */

        /*
         * javadsa list = new javadsa();
         * list.head = new ListNode(1);
         * list.head.next = new ListNode(2);
         * list.head.next.next = new ListNode(3);
         * list.head.next.next.next = new ListNode(4);
         * System.out.println("Original List:");
         * list.displaylist2(list.head);
         * // Reversing the linked list
         * ListNode reversedHead = list.reversingLinkedList();
         * System.out.println("Reversed List:");
         * list.displaylist2(reversedHead);
         */

        /*
         * javadsa list = new javadsa();
         * list.head = new ListNode(1);
         * list.head.next = new ListNode(2);
         * list.head.next.next = new ListNode(3);
         * list.head.next.next.next = new ListNode(4);
         * System.out.println("Original List:");
         * list.displaylist2(list.head);
         * list.getNthNodeFromEndList(2, list.head);
         */

        /*
         * javadsa list = new javadsa();
         * list.head = new ListNode(1);
         * list.head.next = new ListNode(1);
         * list.head.next.next = new ListNode(3);
         * list.head.next.next.next = new ListNode(4);
         * System.out.println("Original List:");
         * list.displaylist2(list.head);
         * // removing duplicates the linked list
         * list.removeduplicated(list.head);
         * System.out.println("\nRemoved dupes");
         * list.displaylist2(list.head);
         * javadsa list = new javadsa();
         * 
         */

        /*
         * javadsa list = new javadsa();
         * list.head = new ListNode(1);
         * list.head.next = new ListNode(1);
         * list.head.next.next = new ListNode(3);
         * list.head.next.next.next = new ListNode(4);
         * list.head.next.next.next.next = new ListNode(5);
         * System.out.println("Original List:");
         * list.displaylist2(list.head);
         * list.insertingNode(list.head, new ListNode(2));
         * System.out.println("\nNew Linked List ");
         * list.displaylist2(list.head);
         */

        /*
         * javadsa list = new javadsa();
         * list.head = new ListNode(1);
         * list.head.next = new ListNode(1);
         * list.head.next.next = new ListNode(3);
         * list.head.next.next.next = new ListNode(4);
         * list.head.next.next.next.next = new ListNode(5);
         * System.out.println("Original List:");
         * list.displaylist2(list.head);
         * list.removingKeyInLinkedList(list.head, new ListNode(3));
         * System.out.println("\nNew Linked List ");
         * list.displaylist2(list.head);
         */

        /*
         * javadsa soln = new javadsa();
         * javadsa list1 = new javadsa();
         * javadsa list2 = new javadsa();
         * 
         * list1.head = new ListNode(9);
         * list1.head.next = new ListNode(4);
         * list1.head.next.next = new ListNode(7);
         * 
         * list2.head = new ListNode(6);
         * list2.head.next = new ListNode(5);
         * 
         * System.out.println("Original Lists:");
         * list1.displaylist2(list1.head);
         * System.out.println("");
         * list2.displaylist2(list2.head);
         * 
         * ListNode neww = soln.ADDLISTNODES(list1.head, list2.head);
         * System.out.println("\nAfter adding Linked Lists ");
         * soln.displaylist2(neww);
         */

        /*
         * javadsa list1 = new javadsa();
         * list1.insertLastInDoubly(3);
         * list1.insertLastInDoubly(4);
         * list1.insertLastInDoubly(5);
         * list1.insertLastInDoubly(6);
         * 
         * list1.doublyLinkedListFromFront(dhead);
         * list1.doublyLinkedListFromBack(tail);
         * 
         */

        /*
         * javadsa list1 = new javadsa();
         * list1.insertLastInDoubly(3);
         * list1.insertLastInDoubly(4);
         * list1.insertLastInDoubly(5);
         * list1.insertLastInDoubly(6);
         * 
         * list1.doublyLinkedListFromFront(dhead);
         * 
         * list1.deleteFirstNodeinDoubly();
         * list1.deleteLastNodeinDoubly();
         * 
         * list1.doublyLinkedListFromFront(dhead);
         */

        /*
         * javadsa list1 = new javadsa();
         * list1.createCircularSinglyLinkedList();
         * list1.displayingCircularSinglyLL();
         * // list1.insertAtBeginningOfCircular(66);
         * // list1.insertAtEndOfCircular(44);
         * list1.deleteFirstNodeinCircularSinglyLinkedList();
         * System.out.println("\n");
         * list1.displayingCircularSinglyLL();
         */

        javadsa list1 = new javadsa();

        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);

        head.next = sec;
        sec.next = third;
        third.next = four;
        four.next = head;

        ListNode laListNode = four;

        list1.displayCircularLL(head, laListNode);
        ListNode result = list1.deleteLastNodeinCircularSinglyLinkedList(head, laListNode);

        list1.displayCircularLL(head, result);

    }

    // printing an array
    void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    // reversing an array
    int[] reversearray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return numbers;
    }

    // hollow rectangle
    void hollowrectangle() {
        int height = 5;
        int width = 10;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // getting second max
    int gettingthesecondmax(int[] arr) {
        int max = 0;
        int secondmax = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            } else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }
        System.out.println("second max  " + secondmax);
        return secondmax;
    }

    public class Result {
        int number1;
        int number2;

        public Result(int number1, int number2) {
            this.number1 = number1;
            this.number2 = number2;
        }

        @Override
        public String toString() {
            return "Number1: " + number1 + ", Number2: " + number2;
        }

    }

    // finding missing value
    Result findmissingvalue(int[] arr) {
        int n = arr.length + 1;
        int missingnumber = n * (n + 1) / 2;
        int total = n * (n + 1) / 2;

        for (int number : arr) {
            total -= number;
        }

        for (int i = 0; i < arr.length; i++) {
            missingnumber = missingnumber - arr[i];
        }

        System.out.println("Missing value: " + total + "  " + missingnumber);
        return new Result(total, missingnumber);
    }

    // is a string a palindrome
    boolean isPalindrome(String string) {
        char[] charArray = string.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                System.out.println("palindrome: false");
                return false;
            }
            start++;
            end--;
        }
        System.out.println("palindrome: true");
        return true;
    }

    // creating a singly linked list
    void creatingSinglyLinkedList() {

        head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(6);

        head.next = second;
        second.next = third;
        third.next = fourth;

        ListNode current = head;

        int count = 0;

        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
            count++;
        }
        System.out.print("null");
        System.out.println("\nNode Count " + count);
    }

    // displaying linked list alternative
    void displaylist() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print(" null ");
    }

    void displaylist2(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print(" null ");
    }

    // place item at the beginning of a singly linked list
    void insertFirst(int val) {
        ListNode newListNode = new ListNode(val);
        newListNode.next = head;
        head = newListNode;
    }

    // place item at the end of a singly linked list
    void insertLast(int val) {
        ListNode newlistNode = new ListNode(val);

        if (head == null) {
            head = newlistNode;
            return;
        }

        ListNode current = head;

        while (null != current.next) {
            current = current.next;
        }
        current.next = newlistNode;
    }

    // inserting a node at a given position
    void insert_at_a_given_position(int posn, int val) {
        ListNode node = new ListNode(val);

        if (posn == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;

            while (count < posn - 1) {
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    // deleteFirstNodefromLinkedList
    ListNode deleteFirstNodefromLinkedList() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // delete note at the last position
    void deleteLastNode() {

        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            // If there's only one node in the list
            head = null;
        } else {
            ListNode current = head;

            // Traverse to the second-to-last node
            while (current.next.next != null) {
                current = current.next;
            }

            // Set the second-to-last node's next to null
            current.next = null;
        }
    }

    // delete node at certain position
    void deleteNodeAtPosn(int posn) {

        if (posn == 1) {
            head = head.next;
        }

        int count = 1;
        ListNode previous = head;
        while (count < posn - 1 && previous.next != null) {
            previous = previous.next;
            count++;
        }

        ListNode current = previous.next;
        ListNode temp = current;
        ListNode future = temp.next;

        temp.next = null;

        previous.next = future;
    }

    // searching items in a singly linked list
    boolean itemSearching(int searchTerm) {
        ListNode current = head;
        while (current.next != null) {
            if (current.data == searchTerm) {
                System.out.print(true);
                return true;
            }
            current = current.next;
        }
        System.out.print(false);
        return false;
    }

    // reversing a linked list
    ListNode reversingLinkedList() {

        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        System.out.println("prevfdvf " + previous);

        return previous;

    }

    // get nth node in a linked list

    ListNode getNthNodeFromEndList(int nth, ListNode head) {
        ListNode refPtr = head;
        ListNode mainPtr = head;

        int count = 0;

        if (head == null) {
            return null;
        }

        while (count < nth) {
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        System.out.println("\n" + mainPtr.data);
        return mainPtr;
    }

    // remove duplicate
    void removeduplicated(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

    }

    // insert node in order of the linkedList
    void insertingNode(ListNode head, ListNode newNode) {

        ListNode current = head;
        ListNode prev = null;
        while (current != null && current.data < newNode.data) {
            prev = current;
            current = current.next;
        }
        newNode.next = current;
        prev.next = newNode;
    }

    void removingKeyInLinkedList(ListNode head, ListNode key) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null && current.data != key.data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node not in the list");
            return;
        }
        prev.next = current.next;
    }

    boolean isLinkedListHavingLoop(ListNode head) {

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    // flloyd's cycle detection algorithm
    ListNode getWhereLoopStartsinLinkedList(ListNode head) {

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                getNodeWhereLoopStarts(head, slowPtr);
                // removeLoopFromLinkedList(head, slowPtr); return;
            }
        }
        return null;
    }

    ListNode getNodeWhereLoopStarts(ListNode head, ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    // remove loop from linked list
    void removeLoopFromLinkedList(ListNode head, ListNode slowPtr) {
        ListNode temp = head;
        while (temp.next != slowPtr.next) {
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
    }

    ListNode mergegSortLinkedLists(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null) {
            tail.next = b;
        }
        if (b == null) {
            tail.next = a;
        }

        return tail.next;

    }

    ListNode reverselist(ListNode head) {

        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    ListNode ADDLISTNODES(ListNode a, ListNode b) {

        // Reverse both lists
        a = reverselist(a);
        b = reverselist(b);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return reverselist(dummy.next);
    }

    // ------------------- DOUBLRY LINLED LIST -------------------
    // ---------------------------------------------------------

    // ----------------------------------------------------------------
    // | |
    // | |
    // | |
    // | |
    // | DOUBLY LINLED LIST |
    // | |
    // | |
    // | |
    // | |
    // ---------------------------------------------------------------

    boolean isEmpty() {
        return length == 0;
    }

    void insertLastInDoubly(int newNodedata) {
        DoublyListNode newNode = new DoublyListNode(newNodedata);
        if (dhead == null) {
            dhead = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
    }

    void insertFirstInDoubly(int newNodeData) {
        DoublyListNode newNode = new DoublyListNode(newNodeData);
        if (isEmpty()) {
            tail = newNode;
        } else {
            dhead.prev = newNode;
        }
        newNode.next = dhead;
        dhead = newNode;
    }

    void doublyLinkedListFromFront(DoublyListNode head) {
        if (head == null) {
            return;
        }
        DoublyListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
            length++;
        }
        System.out.println(" null");
    }

    void doublyLinkedListFromBack(DoublyListNode tail) {
        if (tail == null) {
            return;
        }
        DoublyListNode current = tail;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.prev;
            length++;
        }
        System.out.println(" null");
    }

    void insertNodeAtEndofDoublyListmethod2(int nodeData) {
        DoublyListNode newNode = new DoublyListNode(nodeData);
        if (dhead == null) {
            dhead = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    DoublyListNode deleteFirstNodeinDoubly() {
        DoublyListNode temp = dhead;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (dhead == tail) {
            tail = null;
        } else {
            dhead.next.prev = null;
        }
        dhead = dhead.next;
        temp.next = null;
        return temp;
    }

    DoublyListNode deleteLastNodeinDoubly() {
        DoublyListNode temp = tail;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (tail == dhead) {
            dhead = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        return temp;
    }

    // ------------------- CIRCULAR SINGLY LINKED LIST -------------------
    // ---------------------------------------------------------

    // ----------------------------------------------------------------
    // | |
    // | |
    // | |
    // | |
    // | CIRCULAR SINGLY LIST
    // | |
    // | |
    // | |
    // ---------------------------------------------------------------

    void createCircularSinglyLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        csllLast = fourth;

    }

    void displayingCircularSinglyLL() {

        if (csllLast == null) {
            return;
        }

        ListNode first = csllLast.next;
        while (first != csllLast) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.print(first.data + "");
    }

    void insertAtBeginningOfCircular(int data) {
        ListNode newListNode = new ListNode(data);

        if (csllLast == null) {
            csllLast = newListNode;
        }
        ListNode temp = csllLast.next;
        csllLast.next = newListNode;
        newListNode.next = temp;
    }

    void insertAtEndOfCircular(int data) {
        ListNode newListNode = new ListNode(data);

        if (csllLast == null) {
            csllLast = newListNode;
            csllLast.next = csllLast;
        }

        ListNode temp = csllLast.next;
        csllLast.next = newListNode;
        newListNode.next = temp;
        csllLast = newListNode;
    }

    void deleteFirstNodeinCircularSinglyLinkedList() {

        if (csllLast.next == csllLast) {
            csllLast = null;
            throw new NoSuchElementException("\nlist is empty");
        }

        ListNode originalfirst = csllLast.next;
        ListNode originalsec = originalfirst.next;

        csllLast.next = originalsec;
        originalfirst.next = null;

    }

    ListNode deleteLastNodeinCircularSinglyLinkedList(ListNode head, ListNode laListNode) {
        ListNode firstnode = laListNode.next;

        ListNode temp = head;
        while (temp.next.next != firstnode) {
            temp = temp.next;
        }
        temp.next = firstnode;
        laListNode = temp;

        return temp;
    }

    void displayCircularLL(ListNode head, ListNode laListNode) {

        System.out.println("\n");
        if (laListNode == null) {
            return;
        }

        ListNode currentNode = laListNode.next;
        while (currentNode != laListNode) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.print(currentNode.data + " ");

    }
}
