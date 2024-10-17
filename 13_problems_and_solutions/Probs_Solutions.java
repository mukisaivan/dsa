
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Probs_Solutions {

  public boolean subSequenceProblem(String str, String seq) {
    /*-- example 
        "ace" is a subsequence of "abcde"
        "aec" is not a subsequence of "abcde"     
    */

    int i = 0;
    int j = 0;

    while (i < str.length() && j < seq.length()) {
      if (seq.charAt(j) == str.charAt(i)) {
        j++;
      }
      i++;
    }
    System.out.println(j == seq.length());
    return j == seq.length();

  }

  /*- first non repeating character problem
  
  given a string s, return the index of first non repeating character in it. if it does not exist, return -1.the stringwill only contain lowercase letters
  example 
  input: str = "codeforcode"
  output 4
  
  explanation: the first non repeating character is 'f' at index 4 
  
  
  ---------- personal observation is:
  when dealing with hash maps to solve problems most times:
  -- make what is provided in the problem as the key e.g array or string value/ characters 
  --make the possible result the values
  
   */

  public int firstNonRepeatingCharacterProblem(String str) {

    char[] chars = str.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();

    // add key, vslue to the hash map
    for (char ch : chars) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // iterate the hash map to get the first value with 1
    for (int i = 0; i < chars.length; i++) {
      char ch = chars[i];
      if (map.get(ch) == 1) {
        return i;
      }
    }

    return -1;
  }

  /*-
    [b a n a n a] 
  
   */

  public char[] removeVowelsinString(String str) {
    char[] chars = str.toCharArray();
    char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

    char[] result = new char[str.length()];
    int resultIndex = 0;

    // Loop through characters of the input string
    for (int i = 0; i < chars.length; i++) {
      char ch = chars[i];
      boolean isVowel = false;

      // Check if the current character is a vowel
      for (char vowel : vowels) {
        if (ch == vowel) {
          isVowel = true;
          break;
        }
      }

      // If not a vowel, add to the result
      if (!isVowel) {
        result[resultIndex++] = ch;
      }
    }

    char[] finalResult = new char[resultIndex];
    System.arraycopy(result, 0, finalResult, 0, resultIndex);

    System.out.println(finalResult);
    return finalResult;
  }

  public String removeVowels(String str) {
    char[] ch = str.toCharArray();
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    StringBuilder sb = new StringBuilder();
    for (Character character : ch) {
      if (!(vowels.contains(character))) {
        sb.append(character);
      }
    }
    return sb.toString();
  }

  public long reverseAnInteger(int number) {
    boolean isNegative = number < 0;
    if (isNegative) {
      number = number * -1;
    }

    long reversed = 0;

    /*-
    1234
    
    lastdig= 4  |  last= 3    |  last= 2   |  last= 1                              
    rev= 4      |  rever= 43  |  rev= 432  |  rever= 4321                            
    num = 123   |  num= 12    |  num= 1    |  num = 0                          
    
     */

    while (number > 0) {
      int lastDigit = number % 10;
      reversed = (reversed * 10) + lastDigit;
      number = number / 10;
    }

    long answer = isNegative ? -1 * reversed : reversed;

    System.out.println(answer);

    return answer;
  }

  // reving an integer from an array (in place)

  /*- example
   
  
  input: nums = [3,2,2,3], val = 3
  outpu: 2, nums =[2,2,_, _]
  
  input: nums = [0,1,2,2,3,0,4,2], val= 2
  output: 5, nums = [0,1,4,0,3,_,_,_]
  
   */

  public int removeElement(int[] arr, int val) {
    int i = 0;
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] != val) {
        arr[i] = arr[j];
        i++;
      }
    }
    return i;
  }

  // remove duplicates from a sorted array (in-place)

  /*-
  
  example 
  input: nums = [0,0,1,1,1,2,2,3,3,4]
  output: nuiques = 5, nums = [0,1,2,3,4, _, _, _, _, _]
  
  */

  public int removeDuplicatesFromSortedArray(int[] arr) {

    /*-
     starting from 1 for both i and j since we consider the first value to beunique
     */
    int i = 1;
    for (int j = 1; j < arr.length; j++) {
      if (arr[j] != arr[j - 1]) {
        arr[i] = arr[j];
        i++;
      }
    }
    return i; // unique values
  }

  public void threeSumProblem(int[] arr, int target) {
    Arrays.sort(arr);

    /*-
    provided arr.length-2 when iterating i inorder to still have space the j and k pointers 
     */

    for (int i = 0; i < arr.length - 2; i++) {
      int j = i + 1;
      int k = arr.length - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];

        if (sum == target) {
          System.out.println(arr[i] + " , " + arr[j] + " , " + arr[k]);
          j++;
          k--;
        } else if (sum < target) {
          j++;
        } else {
          k--;
        }

      }
    }

  }

  public int[] productOfArrayExceptSelf(int[] arr) {
    /*-example 
    input: arr = {1,2,3,4}
    output: result= {24,12,8,6}
     */

    // use o(n) without using division operator

    int[] result = new int[arr.length];
    // traversing from left
    int temp = 1;
    for (int i = 0; i < result.length; i++) {
      result[i] = temp; // [1,1,2,6]
      temp = arr[i] * temp;
    }
    // traversing from right
    temp = 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      result[i] = result[i] * temp; // [24,12,8,6]
      temp = temp * arr[i];
    }
    return result; // [24,12,8,6]

  }

  public void slidingWindowMaximumProblem() {
    /*-
    QN: given an array of integers arr, there is a sliding window of size k which is moving from the very left to the right of an array.You can only see l numbers in the window. Each time teh sliddding window moves right by one position. return the max sliding window.
    
    example: 
    Input: arr = {44, 77, 33, 44, 88, 11}, k = 3
    Output: arr = [77, 77, 88, 88]
    
     */

  }

  public static void main(String[] args) {
    Probs_Solutions ps = new Probs_Solutions();
    ps.subSequenceProblem("abcde", "ace");
    ps.subSequenceProblem("abcde", "aec");
    ps.removeVowelsinString("whats your name");

    ps.removeVowels("whats your name");

    ps.reverseAnInteger(-1234);

  }

}
