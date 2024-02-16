package singly_linked_list;

public class SinglyLinkedList {
  ListNode head;

  private static class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null; 
    }


  }
  
}


class Listnode<T> {
  T data;
  Listnode<T> next;

  public Listnode(T x) {
    this.data = x;
    this.next = null;
  }
}