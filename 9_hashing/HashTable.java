
import java.util.HashSet;
import java.util.Set;

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
    private final int key; // can be generic
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

  public int getBucketIndex(int key) {
    return key % numOfBuckets;
  }

  // separate chaining
  public void put(Integer key, String value) {

    if (key == null || value == null) {
      throw new Error();
    }

    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];

    while (head != null) {
      if (head.key == key) {
        head.value = value;
        return;
      }
      head = head.next;
    }

    // the tutorial got it confusing this should be represented on the left hand
    // side not the right hand side
    size++;
    HashNode node = new HashNode(key, value);
    node.next = head;
    buckets[bucketIndex] = node;

  }

  public String get(Integer key) {
    int bucketInex = getBucketIndex(key);
    HashNode head = buckets[bucketInex];

    while (head != null) {
      if (head.key == key) {
        System.out.println("value for key  " + key + " found\nvalue is: " + head.value);
        return head.value;
      }
      head = head.next;
    }

    // System.out.println("Value not found " + head.value);
    return null;
  }

  public String remove(int key) {

    int bucketIndex = getBucketIndex(key);

    HashNode head = buckets[bucketIndex];

    HashNode prev = null;

    while (head != null) {

      if (head.key == key) {
        break; // stop the while loop and start removing the hashnode using below code
      }
      prev = head;
      head = head.next;
    }

    if (head == null) {
      return null;
    }

    size--;
    if (prev != null) { // removing the node if the node to be removed is somewhere in the middle
      prev.next = head.next;
    } else { // if removing the first node
      buckets[bucketIndex] = head.next; // make the current head's next as the first node
    }

    return head.value;
  }

  /*-
      QUESTION: Contains duplicate
      
      given an array of nums, return true is any value appears atleast twice in an
      array, and return false if the array element is distinct
   */

  public boolean contains_duplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }

  public static void main(String[] args) {
    HashTable table = new HashTable(10);

    table.put(105, "Tom");
    table.put(22, "Ivan");
    table.put(21, "Yeti");
    table.put(31, "Harry");

    System.out.println(table.size());
    System.out.println(table.remove(22));
    System.out.println(table.get(22));
    System.out.println(table.size());

  }

}
