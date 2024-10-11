
/*
 dynamic programming refers to remembering stuff to save time later

 Dynamic Programming =  Recursion + Memorization
 */

/*  ---- FIBONACCI SERIES-------
it is a series of numbers in which the ffirst two numbers are 0 and 1 
after that each number is the sum of the two preceding numbers 


fib(0) = 0
fib(1) = 1
fib(n) = fib(n-1) + fib(n-2)
output = 0,1,1,2,3,5,8,13,21.....
*/

public class DynamicProgramming {

  public int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int result = fib(n - 1) + fib(n - 2);
    return result;
  }

  public static void main(String[] args) {

  }
}
