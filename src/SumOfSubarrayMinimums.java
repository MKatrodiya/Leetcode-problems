import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfSubarrayMinimums {
  public int sumSubarrayMins(int[] arr) {
    List<Map<Integer, Integer>> dp = new ArrayList<>();
    Map<Integer, Integer> m;
    long result = 0;
    for (int i = 0; i < arr.length; i++) {
      m = new HashMap<>();
      m.put(1, arr[i]);
      dp.add(m);
      result += arr[i];
    }
    for (int n = 2; n <= arr.length; n++) {
      for (int i = 0; i <= arr.length - n; i++) {
        int min = dp.get(i).getOrDefault(n - 1, 0); //get the minimum for subarray of n-1 length
        min = Math.min(min, arr[i + n - 1]);
        result += Math.min(min, arr[i + n - 1]);
        dp.get(i).put(n, min);
      }
    }
    return (int) (result % (int)(Math.pow(10, 9) + 7));
  }

  private int parity(int[] numbers) {
    boolean even = numbers[0] % 2 == 0;
    for (int i = 1; i < numbers.length; i++) {
      if (even) {
        if (numbers[i] % 2 != 1) {
          return i;
        }
      } else {
        if (numbers[i] % 2 != 0) {
          return i;
        }
      }
      even = !even;
    }
    return -1;
  }

  private int triples(String sentence) {
    sentence = sentence.toLowerCase();
    int[] freq = new int[26];
    boolean isTriple = false;
    int result = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == ' ') {
        if (isTriple) {
          result++;
          isTriple = false;
        }
        Arrays.fill(freq, 0);
      } else {
        freq[sentence.charAt(i) - 'a']++;
        if (freq[sentence.charAt(i) - 'a'] >= 3) {
          isTriple = true;
        }
      }
    }
    return result;
  }
}
