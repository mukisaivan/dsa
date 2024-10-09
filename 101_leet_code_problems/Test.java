
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

  /*
   * 
   * You are given a linked list that contains
   * integers. You have performed the following reverse operation on the list:
   * 
   * Select all the subparts of the list that contain only even integers. For
   * example, if the list is
   * {1,2,8,9,12,16}
   * then the selected subparts will be
   * {2,8},
   * {12,16}.
   * Reverse the selected subpart such as {8,2}
   * and
   * {12,16}.
   * Now, you are required to retrieve the original list.
   * 
   * Note: You should use the following definition of the linked list for this
   * problem:
   */

}

class Node {
  Object data;
  Node next;

  Node(Object data) {
    this.data = data;
    this.next = null;
  }
}

class TestClass {
  Node head;

  // Method to print the linked list
  public void printList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  // Method to create a linked list from an array of integers
  public void createList(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      Node newNode = new Node(arr[i]);
      if (head == null) {
        head = newNode; // Set head if it's the first node
      } else {
        Node temp = head;
        while (temp.next != null) {
          temp = temp.next; // Traverse to the end of the list
        }
        temp.next = newNode; // Link new node at the end
      }
    }
  }

  // Method to reconstruct the original list
  public Node reconstructOriginalList(Node head) {
    Stack<Object> evenStack = new Stack<>();
    Node current = head;
    Node dummy = new Node(null); // Dummy node to construct the new list
    Node tail = dummy;

    while (current != null) {
      if (current.data instanceof Integer && (Integer) current.data % 2 == 0) {
        // Found an even number, push onto stack
        evenStack.push(current.data);
      } else {
        // If we hit an odd number and the stack is not empty
        while (!evenStack.isEmpty()) {
          // Pop from stack to reverse the even subpart
          tail.next = new Node(evenStack.pop());
          tail = tail.next;
        }
        // Add the odd number directly to the new list
        tail.next = current;
        tail = tail.next;
      }
      current = current.next;
    }

    // If there are any remaining even numbers in the stack at the end
    while (!evenStack.isEmpty()) {
      tail.next = new Node(evenStack.pop());
      tail = tail.next;
    }

    return dummy.next; // Return the new list without dummy node
  }

  public static void main(String args[]) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Read the number of elements (can be ignored in this case)
    int n = Integer.parseInt(reader.readLine().trim());

    // Read the input line
    String inputLine = reader.readLine();

    // Split the input into an array of strings, then parse into integers
    String[] inputStrings = inputLine.split(" ");
    int[] inputData = new int[inputStrings.length];

    for (int i = 0; i < inputStrings.length; i++) {
      inputData[i] = Integer.parseInt(inputStrings[i]);
    }

    // Create an instance of TestClass
    TestClass list = new TestClass();

    // Create the linked list from the input data
    list.createList(inputData);

    // Reconstruct the original linked list
    list.head = list.reconstructOriginalList(list.head);

    // Output the final list after processing
    list.printList(list.head);
  }
}
