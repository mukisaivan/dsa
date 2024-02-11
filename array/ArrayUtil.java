package array;
public class ArrayUtil {

  public static void main(String[] args) {

    int[] mixedarray = {3, 2, 4, 7, 10, 6, 5};


    System.out.println("\n+++++++++++++++++++++ mixed array below +++++++++++++++++++");

    printArray(mixedarray);

    System.out.println("\n+++++++++++++++++++++ removing even numbers +++++++++++++++++++");

    int[] result = removingEvenNumbers(mixedarray);
    printArray(result);

    System.out.println(" ");

    System.out.print("\n+++++++++++++++++++++ reversing array +++++++++++++++++++");
    System.out.println(" ");

    int[] arraytobereversed = mixedarray;
    int[] reversedarray = reversingarray(arraytobereversed);
    printArray(reversedarray);

    System.out.println(" ");

    System.out.print("\n+++++++++++++++++++++ minumum value in the array +++++++++++++++++++");
    System.out.println(" ");

    minimumnumberinarray(mixedarray);

    System.out.print("\n+++++++++++++++++++++ move zeros to the end of an array +++++++++++++++++++");
    System.out.println(" ");
    int[] myarray = { 0, 0, 3, 0, 2, 8, 5 };
    movezerostotheendofarray(myarray);
    printArray(myarray);


    System.out.print("\n+++++++++++++++++++++ resizing an array +++++++++++++++++++");
    System.out.println(" ");

    int[] arraytoberesized = { 1, 2, 3, 4 };
    System.out.println(arraytoberesized.length);
    int[] newarr = resizinganarray(arraytoberesized, 8);
    printArray(arraytoberesized);
    System.out.println(newarr.length);

    
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  

  public static int[] removingEvenNumbers(int[] arr) {
    int oddCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        oddCount++;
      }
    }
    int[] result = new int[oddCount];
    int idx = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        result[idx] = arr[i];
        idx++;
      }
    }
    return result;
  }
  

  public static int[] reversingarray(int[] numbers) {
    int startidx = 0;
    int endidx = numbers.length - 1;

    while (startidx < endidx) {
      int temp = numbers[startidx];
      numbers[startidx] = numbers[endidx];
      numbers[endidx] = temp;
      startidx++;
      endidx--;
    }
    return numbers;
  }
  

  int MaximumNumberInAnArray(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max)
        max = array[i];
    }
    return max;
  }
  
  public static int minimumnumberinarray(int[] arr) {
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    System.out.println(min);
    return min;
  }



  public static int returnsecondmaximuminarray(int[] arr) {
    int maxvalue = Integer.MIN_VALUE;
    int secondmaxvalue = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > maxvalue) {
        secondmaxvalue = maxvalue;
        maxvalue = arr[i];
      } else if (arr[i] > secondmaxvalue && arr[i] != maxvalue) {
        secondmaxvalue = arr[i];
      }
    }
    return secondmaxvalue;
  }

  public static int[] movezerostotheendofarray(int[] arr) {
    int j = 0; // focus on the zeroth elements
    for (int i = 0; i < arr.length; i++) {
      if (arr[j] == 0 && arr[i] != 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
      if (arr[j] != 0) {
        j++;
      }
    }
    return arr;
  }
  
  public static int[] resizinganarray(int[] arr, int size) {
    int[] newarr = new int[size];
    for (int i = 0; i < arr.length; i++) {
      newarr[i] = arr[i];
    }
    arr = newarr;

    return newarr;
  }
}
