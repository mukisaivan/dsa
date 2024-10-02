public class Search {

  int linearSearch(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        System.out.println("item found at index: " + i);
        return i;
      }
    }
    return -1;
  }

  // binary search algorithm / divide and conquere

  int binarySearch(int[] nums, int key) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == key) {
        System.out.println("found");
        return mid;
      }
      if (key < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1; // return -1 or low if required to
  }

  // return where the target would be found
  int searchInsertProblem(int[] nums, int key) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = (low + (high - low) / 2);
      if (nums[mid] == key) {
        System.out.println("found");
        return mid;
      }
      if (key < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  public static void main(String[] args) {
    Search s = new Search();

    int[] arr = new int[] { 1, 2, 3, 4, 5 };

    s.linearSearch(arr, 3);
    s.binarySearch(arr, 3);
  }

}
