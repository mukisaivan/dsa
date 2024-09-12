
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IVAN
 */
public class AfterLinksAndArrays {

  public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static class ArrayStack {
    int size;
    int[] stack;
    int stacktop;

    public ArrayStack(int size) {
      this.size = size;
      stack = new int[size];
      stacktop = -1;
    }

    public void pushToArrayStack(int data) {
      stacktop++;
      stack[stacktop] = data;
    }

    int popFromArrayStack() {
      int poppedElement = stack[stacktop];
      stacktop--;
      System.out.println("\n" + poppedElement + " popped from stack");
      return poppedElement;
    }

    void displayArrayStack() {
      System.out.println();
      for (int i = 0; i <= stacktop; i++) {
        System.out.print(stack[i] + " ==> ");
      }
    }

    void peek() {

      System.out.println("\npeek:  " + stack[stacktop]);
    }

    String reverseStringUsingStack(String string) {
      char[] charstring = string.toCharArray();
      Stack<Character> somestack = new Stack<>();
      for (char character : charstring) {
        somestack.push(character);
      }

      for (int i = 0; i < string.length(); i++) {
        charstring[i] = somestack.pop(); // remember stack.pop returns the last element in the stack so this is
                                         // assigning the last elements to be first
      }

      return new String(charstring);
    }

  }

  private ListNode top;
  private int length;

  public static void main(String[] args) {
    AfterLinksAndArrays inst = new AfterLinksAndArrays();
    /*
     * Pushing using Linked Lists
     * inst.pushToStack(3);
     * inst.pushToStack(2);
     * inst.pushToStack(1);
     * inst.displayStack();
     * inst.popFromStack();
     * inst.displayStack();
     */

    // Pushing using Arrays
    /*
     * ArrayStack stack = new ArrayStack(4);
     * stack.pushToArrayStack(2);
     * stack.pushToArrayStack(4);
     * stack.pushToArrayStack(3);
     * stack.displayArrayStack();
     * stack.popFromArrayStack();
     * stack.displayArrayStack();
     * stack.peek();
     */

    /*
     * String str1 = "hello";
     * String str2 = "world123";
     * System.out.println(inst.mergeStrings(str1, str2));
     */

    ArrayStack stack = new ArrayStack(4);
    System.out.println(stack.reverseStringUsingStack("reverseme"));

  }

  void pushToStack(int data) {
    ListNode newNode = new ListNode(data);
    newNode.next = top;
    top = newNode;
    length++;
  }

  void popFromStack() {
    int result = top.data;
    top = top.next;
    length--;
    System.out.println("popped " + result);
  }

  int peek() {
    return top.data;
  }

  void displayStack() {

    ListNode current = top;

    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.println("null");
    System.out.println("Length of the stack " + length);
  }

  String mergeStrings(String str1, String str2) {
    String result = "";
    int i = 0;

    char[] str1arr = str1.toCharArray();
    char[] str2arr = str2.toCharArray();
    int len1 = str1arr.length;
    int len2 = str2arr.length;

    while (i < len1 || i < len2) {
      if (i < len1) {
        result += str1arr[i];
      }
      if (i < len2) {
        result += str2arr[i];
      }
      i++;
    }
    return result;
  }

}
