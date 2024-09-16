
import java.util.LinkedList;
import java.util.Queue;

public class JQueue {

  private ListNode front;
  private ListNode rear;
  int length;

  public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String[] args) {

    JQueue inst = new JQueue();
    /*
     * inst.enqueue(1);
     * inst.enqueue(2);
     * inst.enqueue(3);
     * inst.displayQueue();
     * inst.dequeue();
     * inst.dequeue();
     * inst.displayQueue();
     */

    String[] binaryNumbers = inst.generateBinaryNumbers(4);
    inst.displayBinaryNumbers(binaryNumbers);

  }

  int length() {
    return length;
  }

  boolean isEmpty() {
    return length == 0;
  }

  void enqueue(int data) {
    ListNode newNode = new ListNode(data);
    if (isEmpty()) {
      front = newNode;
    } else {
      rear.next = newNode;
    }
    rear = newNode; // try assigning rear to newNode and see what happens
    length++;

  }

  void dequeue() {
    if (length == 0) {
      System.out.println("Nothing to delete");
    }

    ListNode secondNode = front.next;

    System.out.println("\nElement removed " + front.data);
    front.next = null;
    front = secondNode;
    if (front == null) {
      rear = null;
    }
    length--;

  }

  void displayQueue() {
    ListNode temp = front;
    System.out.print("[ ");
    while (temp != null) {
      System.out.print(temp.data + ",");
      temp = temp.next;
    }
    System.out.print("]");

    System.out.println("\nlength is " + length);
  }

  /*
   * QUESTION
   * Generate binary numbers from 1 to n using a Queue
   * example
   * input n= 3
   * output = {"1", "10", "11" }
   */

  String[] generateBinaryNumbers(int n) {

    String[] resultArray = new String[n];
    Queue<String> q = new LinkedList<>();
    q.offer("1");

    for (int i = 0; i < n; i++) {
      resultArray[i] = q.poll();
      String n1 = resultArray[i] + "0";
      String n2 = resultArray[i] + "1";
      q.offer(n1);
      q.offer(n2);
    }

    return resultArray;
  }

  void displayBinaryNumbers(String[] arr) {
    for (String arr1 : arr) {
      System.out.print(arr1 + ",");
    }
  }

}