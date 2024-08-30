package singly_linked_list;

public class SinglyLinkedList {

  public static void main(String[] args) {

    Listnoder listnoder = new Listnoder(null);
    
  }


  private ListNode head;
  private static class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    } 
  }

 
  
}


class Listnoder<T> {
  T data;
  Listnoder<T> next;

  public Listnoder(T x) {
    this.data = x;
    this.next = null;
  }
}
