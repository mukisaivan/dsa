
//separate chainig

public class HashTable {

  private HashNode[] buckets; // array of hashnodes
  private int numOfBuckets; // size of the array
  private int size;

  public HashTable() {
    this(10);
  }

  public HashTable(int capacity) {
    this.numOfBuckets = capacity;
    buckets = new HashNode[capacity];
    this.size = 0;
  }

  public class HashNode {
    private int key; // can be generic
    private String value; // can be generic
    private HashNode next;

    public HashNode(int key, String value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // separate chaining
  public void put(int key, String value) {

  }

  public String get(int key) {
    return null;
  }

  public String remove(int key) {
    return null;
  }

  public int getBucketIndex(int key) {
    return key % buckets.length;
  }

  public static void main(String[] args) {
    System.out.println("in hash table ");
  }

}
