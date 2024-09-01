import java.util.Arrays;

public class javadsa {
    public static void main(String[] args) {
        int[] result = reversearray(new int[] { 3, 2, 1, 4 });

        // printarray(result);
        // System.out.println(Arrays.toString(result));

        javadsa javadsa = new javadsa();

        javadsa.hollowrectangle();
        javadsa.gettingthesecondmax(new int[] { 3, 4, 6, 5, 1, 3, 7 });

    }

    // printing an array
    public static void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    // reversing an array
    public static int[] reversearray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return numbers;
    }

    // hollow rectangle
    void hollowrectangle() {
        int height = 5;
        int width = 10;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // getting second max
    int gettingthesecondmax(int[] arr) {
        int max = 0;
        int secondmax = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            } else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }
        System.out.println("second max  " + secondmax);
        return secondmax;
    }
}
