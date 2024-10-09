import java.util.ArrayList;
import java.util.List;

public class matrices {

  public static void main(String[] args) {

    int[][] matrix = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 },
    };

    for (int i = 0; i < matrix.length; i++) {

      for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print(matrix[i][j] + " ");
        // System.out.println(matrix[j].length);
      }
      System.out.println("");
    }

    int[][] result = new int[3][4];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < result.length; j++) {
        result[i][j] = matrix[i][j] * 2;
      }
    }

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result.length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println("");
    }

    List<ArrayList<Integer>> listOfLists = new ArrayList<>();

    // Adding some ArrayLists to the list
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(4);
    list2.add(5);
    list2.add(6);

    ArrayList<Integer> list3 = new ArrayList<>();
    list3.add(7);
    list3.add(8);
    list3.add(9);

    listOfLists.add(list1);
    listOfLists.add(list2);
    listOfLists.add(list3);

    // Printing out the lists using a for loop
    for (int i = 0; i < listOfLists.size(); i++) {
      ArrayList<Integer> currentList = listOfLists.get(i);
      System.out.println("List " + (i + 1) + ": " + currentList);
    }
  }
}
