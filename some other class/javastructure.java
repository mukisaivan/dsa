
import java.util.Arrays;

public class javastructure {

  public static void main(String[] args) {
    // int[] result = removingEvenNumbers(new int[] { 2, 3, 4, 5, 6 });

    int[] result = remvevn(new int[] { 2, 3, 4, 5, 6 });
    System.out.println("Result array: " + Arrays.toString(result));
  }

  public static int[] removingEvenNumbers(int[] arr) {
    int oddCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        int midarr = arr[i];
        System.out.println("{index: " + i + ", value " + midarr + "}");
        oddCount++;
      }
    }
    System.out.println("Odd count: " + oddCount);

    int[] result = new int[oddCount];
    System.out.println(">>>> result: " + Arrays.toString(result));

    int idx = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        System.out.println("{next loop: " + i + ", value " + arr[i] + "}");
        result[idx] = arr[i];
        System.out.println("Adding " + arr[i] + " to result array at index " + idx);
        idx++;
      }
    }
    return result;
  }

  public static int[] remvevn(int[] arr) {
    int oddcount = 0;
    int idx = 0;
    for (int i = 0; i < arr.length; i++) {

      if (arr[i] % 2 != 0) {
        oddcount++;
      }
    }
    System.out.println(oddcount);
    int[] temparr = new int[oddcount];
    System.out.println("Temp arr" + Arrays.toString(temparr));

    for (int i = 0; i < arr.length; i++) {

      if (arr[i] % 2 != 0) {
        System.out.println("-------------------------------Found a value that doesnt give remainder 0");

        System.out.println("original array >>>>>>>> " + "{ " + "value: " + arr[i] + " , " + " index: " + i + " , "
            + " new array index: " + idx + "," + " array: " + Arrays.toString(arr) + " } ");

        temparr[idx] = arr[i];

        System.out.println("final array >>>>>>>> " + "{" + "value: " + temparr[idx] + " , " + " index: " + idx + " , "
            + " replaced array index: " + i + "," + " array: " + Arrays.toString(temparr) + " } ");

        idx++;
      }
    }

    System.out.println("Final Array " + Arrays.toString(temparr));

    return temparr;
  }

}
