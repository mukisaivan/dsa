
import java.util.Arrays;

public class Sorting {

  void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println("");
  }

  void bubbleSort(int[] array) {
    boolean isSwapped;
    for (int i = 0; i < array.length - 1; i++) {
      isSwapped = false;
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          System.out.println(j + " " + array[j] + " ::: " + i + " " + array[i]);

          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
        isSwapped = true;
      }

      // if no swap happens above then all of them are in the correct order

      if (isSwapped == false) {
        break;
      }
    }
    System.out.println(Arrays.toString(array));
  }

  void insertionSort(int[] arr) { // 25:00:00
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }

  void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {

      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }

      int temp2 = arr[i];
      arr[i] = arr[min];
      arr[min] = temp2;

      // int temp = arr[min];
      // arr[min] = arr[i];
      // arr[i] = temp;
    }
  }

  int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
    int arr1_length = arr1.length;
    int arr2_length = arr2.length;
    int result_arr_length = arr1_length + arr2_length;
    int[] result_arr = new int[result_arr_length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < arr1_length && j < arr2_length) { // both arr1 and arr2 are of equal length none is exhausted yet
      if (arr1[i] < arr2[j]) {
        result_arr[k] = arr1[i];
        i++;
      } else {
        result_arr[k] = arr2[j];
        j++;
      }
      k++;
    }
    // either arr1 or arr2 got exhausted
    while (i < arr1_length) { // arr2 got exhausted
      result_arr[k] = arr1[i]; // storing remaining arr1 into result array
      i++;
      k++;
    }
    while (j < arr2_length) {
      result_arr[k] = arr2[j];
      j++;
      k++;
    }
    System.out.println(Arrays.toString(result_arr));
    return result_arr;
  }

  void mergeSort(int[] arr, int[] temp, int low, int high) { // divide and conquer // 27: 00:00

    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(arr, temp, low, mid); // for the left array
      mergeSort(arr, temp, mid + 1, high); // for the right array
      merge(arr, temp, low, mid, high);
    }

  }

  void merge(int[] arr, int[] temp, int low, int mid, int high) {

    for (int i = low; i <= high; i++) {
      temp[i] = arr[i];
    }
    int i = low;
    int j = mid + 1;
    int k = low;
    while (i <= mid && j <= high) {
      if (temp[i] < temp[j]) {
        arr[k] = temp[i];
        i++;
      } else {
        arr[k] = temp[j];
        j++;
      }
      k++;
    }
    while (i <= mid) { // if all the right array is exhausted copy the remaining left array elements
                       // into the result array

      arr[k] = temp[i];
      i++;
      k++;
    }

  }

  void dutchFlagProblem(int[] arr) {
    int i = 0;
    int j = 0;
    int k = arr.length - 1;

    while (i <= k) {
      if (arr[i] == 0) {
        swap(arr, i, j);
        i++;
        j++;
      }

      else if (arr[i] == 1) {
        i++;
      }

      else if (arr[i] == 2) {
        swap(arr, i, k);
        k--;
      }
    }

    System.out.println(Arrays.toString(arr));

  }

  void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  // another divide and conquer
  void quickSort(int[] arr, int low, int high) {
    // pivot selection
    // partitioning
    // recursion

    if (low < high) {
      int p = partition(arr, low, high); // p is the pivot
      quickSort(arr, low, p - 1);
      quickSort(arr, p + 1, high);
    }
  }

  int partition(int[] arr, int low, int high) {
    int i = low;
    int j = low;
    int pivot = arr[high];

    while (i <= high) {
      if (arr[i] < pivot) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
      i++;
    }
    return j - 1;

  }

  int[] squares_of_a_sorted_array(int[] arr) {
    int[] result_arr = new int[arr.length];

    int i = 0;
    int j = arr.length - 1;

    for (int k = arr.length - 1; k >= 0; k--) {

      if (Math.abs(arr[i]) > Math.abs(arr[j])) {
        result_arr[k] = arr[i] * arr[i];
        i++;
      } else {
        result_arr[k] = arr[j] * arr[j];
        j--;

      }
    }
    return result_arr;
  }

  void rearrange_sorted_array_in_min_max_form(int[] arr) {

    // note: largest numbers ==> located at even indicies maxIdx
    // note: smallest numbers ==> located at odd indicies maxIdx

    int maxIdx = arr.length - 1;
    int minIdx = 0;

    int max = arr[maxIdx] + 1;

    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 0) { // even index (largest)
        arr[i] = arr[i] + (arr[maxIdx] % max * max);
        maxIdx--;

      } else { // odd index (smallest)
        arr[i] = arr[i] + (arr[minIdx] % max * max);
        minIdx++;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / 10;
    }

  }

  public static void main(String[] args) {
    Sorting s = new Sorting();

    int[] arr = new int[] { 1, 3, 5, 2, 6, 4 };

    // s.printArray(arr);
    // s.selectionSort(arr);
    // s.printArray(arr);

    // s.mergeTwoSortedArrays(arr, arr2);

    // s.printArray(arr);
    // s.mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    // s.printArray(arr);

    // s.dutchFlagProblem(new int[] { 2, 2, 0, 0, 1, 1, 0, 0, 2, 2 });

    s.rearrange_sorted_array_in_min_max_form(arr);

  }

}
