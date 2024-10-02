
public class PriorityQueue_BinaryHeap {

  // max heap ====> a node children are all less than the node
  // min heap ====> a node children are all more than the node

  static Integer[] heap;
  static int n;

  public static class MaxPQ {

    MaxPQ(int capacity) {
      heap = new Integer[capacity + 1];
      n = 0;

    }

    boolean isEmpty() {
      return n == 0;
    }

    int size() {
      return n;
    }

  }

  void insertValueInMaxPQ(int value) {

    if (n == heap.length - 1) { // if the heap is full
      resizeheap(2 * heap.length);
    }

    n++;
    heap[n] = value;
    bottomUpReheapify_swim(n);

  }

  void bottomUpReheapify_swim(int k) {
    // this happens during insertion of a new element in a heap in order to reoorder
    // the elements and maintain the properties of a priority queue

    while (k > 1 && heap[k / 2] < heap[k]) {
      int temp = heap[k];
      heap[k] = heap[k / 2];
      heap[k / 2] = temp;
      k = k / 2;
    }
  }

  void resizeheap(int amount) {
    Integer[] newheap = new Integer[amount];

    for (int i = 0; i < heap.length; i++) {
      newheap[i] = heap[i];
    }

    heap = newheap;
  }

  void printMaxHeap() {

    for (Integer integer : heap) {
      System.out.print(integer + " ");
    }

    // System.out.println("\n");
    // for (int i = 1; i <= n; i++) {
    // System.out.print(heap[i] + " ");
    // }

  }

  int deleteMaxFromMaxPQ() {

    int max = heap[1];

    swap(1, n);

    topDownReheapify_sink(1);

    heap[n + 1] = null;

    if (n > 0 && (n == (heap.length - 1) / 4)) { // making the heap smaller
      resizeheap(heap.length / 2);
    }
    // n--;
    return max;

  }

  void topDownReheapify_sink(int k) {

    while (2 * k <= n) {
      int j = 2 * k;

      if (j < n && heap[j] < heap[j + 1]) {
        j++;
      }
      if (heap[k] >= heap[j]) {
        break;
      }

      swap(k, j);

      k = j;

    }
  }

  void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  public static void main(String[] args) {

    PriorityQueue_BinaryHeap pqbh = new PriorityQueue_BinaryHeap();

    MaxPQ pq = new MaxPQ(3);
    System.out.println("Is empty: " + pq.isEmpty());
    System.out.println("Heap size: " + pq.size());

    pqbh.insertValueInMaxPQ(4);
    pqbh.insertValueInMaxPQ(5);
    pqbh.insertValueInMaxPQ(2);
    pqbh.insertValueInMaxPQ(6);
    pqbh.insertValueInMaxPQ(1);
    pqbh.insertValueInMaxPQ(3);

    System.out.println("Is empty: " + pq.isEmpty());
    System.out.println("Heap size: " + pq.size());

    pqbh.printMaxHeap();

    pqbh.deleteMaxFromMaxPQ();
    pqbh.deleteMaxFromMaxPQ();
    pqbh.deleteMaxFromMaxPQ();
    System.out.println("");
    System.out.println("Heap size: " + pq.size());
    System.out.println("");
    pqbh.printMaxHeap();

  }
}
