package singly_linked_list;

public class SinglyLinkedList {
  
}


class Listnode<T> {
  T data;
  Listnode<T> next;

  public Listnode(T x) {
    this.data = x;
    this.next = null;
  }
}