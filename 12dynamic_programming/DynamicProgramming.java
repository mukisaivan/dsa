
import java.util.Arrays;
import java.util.HashMap;

/*
 dynamic programming refers to remembering stuff to save time later

 Dynamic Programming =  Recursion + Memorization
 */

/*  ---- FIBONACCI SERIES-------
it is a series of numbers in which the first two numbers
 are 0 and 1 
after that each number is the sum of the two preceding numbers 


fib(0) = 0
fib(1) = 1
fib(n) = fib(n-1) + fib(n-2)
output = 0,1,1,2,3,5,8,13,21.....
*/

// techniques to achieve dynaamic programming 

/* 1. --- OPTIMAL SUBSTRUCTURE ------
  its when a solution to a problem can be obtained using the optimal solution of its subproblems 

  2. ---- overlapping subproblems -----
   its when the solution of a given problem is obtained by solving same subproblems multiple times

*/

// approaches to dynamic programming

/* --- bottomup approach Method(tabulation method) --------
- solve smaller problems first, use their solution to build on and arrive to bigger subproblems
- the solution is built in tabular form by using solutions of subproblems iteratively and generating solutions to bigger problems 

   --- top down approach (Memoization method) --------
  break a large porblem into multiple subproblems
  each subproblem is solved and the solution remembered
  it memoizes the solution to avoid recomputing the problem if its solution already exists

 */

public class DynamicProgramming {
  public int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int left = fib(n - 1);
    int right = fib(n - 2);
    return left + right;
  }

  public int fib_using_bottom_up_approach(int n) {

    int[] table = new int[n + 1];

    table[0] = 0;
    table[1] = 1;

    // starting from the first index
    for (int i = 2; i <= n; i++) {
      table[i] = table[i - 1] + table[i - 2];
    }

    System.out.println(table[n]);
    return table[n];
  }

  public int fib_using_top_down_approach(int memo[], int n) {

    // starting from the last index
    if (memo[n] == 0) { // not worked on yet
      if (n < 2) { // for first parts since the lists should start with 0 and 1, 1
        memo[n] = n;
      } else {
        int left = fib_using_top_down_approach(memo, n - 1);
        int right = fib_using_top_down_approach(memo, n - 2);
        memo[n] = left + right;
      }
    }
    return memo[n];
  }

  // kadane's algorithm

  /*-
    [4, 3, -2, 6,-12, 7, -1, 6]
    output == result = 12 maxsumsubarray = [7,-1,6]
   */

  public int maximum_sum_subarray(int[] arr) {
    int maxSoFar = arr[0];
    int currentMax = arr[0];

    for (int i = 1; i < arr.length; i++) {
      currentMax = currentMax + arr[i];
      if (currentMax < arr[i]) { // the current value start a new sub array
        currentMax = arr[i];
      }

      if (maxSoFar < currentMax) { // the current value continue with the existing sub array
        maxSoFar = currentMax;
      }
    }
    System.out.println(maxSoFar);
    return maxSoFar;
  }

  /*-
    given an array of integers, return indicies of the two numbers such that they
    add up to a specific target
    
    example: [2, 11, 5, 10, 7, 8] target = 9
    
   */

  public int[] twoSumProblem(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    int[] result = new int[2];

    for (int i = 0; i < numbers.length; i++) {
      if (!map.containsKey(target - numbers[i])) {
        map.put(numbers[i], i);
      } else {

        /*--
        
        below its assigning the values of the keys (i and  ..) from the hashmap which are indicies 
        
         */

        result[1] = i;// 4
        result[0] = map.get(target - numbers[i]); // 0

        System.out.println("The two indicies are: " + result[0] + " and  " + result[1]);

        return result; // output: {0,4}
      }
    }
    throw new IllegalArgumentException("Two numbers not found");
  }

  public int[] twoSumMoreEfficient(int[] arr, int target) {
    // using sorting and two pointer approach
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    int[] result = new int[2];
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (sum == target) {
        result[0] = arr[left];
        result[1] = arr[right];
        System.out
            .println("Two sum Method two indicies: " + arr[left] + " " + arr[right] + " " + Arrays.toString(result));
        return result; // output: [2, 7]
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {

    DynamicProgramming dp = new DynamicProgramming();
    dp.fib_using_bottom_up_approach(6);
    dp.fib_using_top_down_approach(new int[6 + 1], 6);

    dp.maximum_sum_subarray(new int[] { 4, 3, -2, 6, -12, 7, -1, 6 });

    dp.twoSumProblem(new int[] { 2, 11, 5, 10, 7, 8 }, 9);

    dp.twoSumMoreEfficient(new int[] { 2, 11, 5, 10, 7, 8 }, 9);
  }
}
