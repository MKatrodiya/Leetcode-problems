import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
  public String intToRoman(int num) {
    Map<Integer, String> numMap = new HashMap<>();
    numMap.put(1, "I");
    numMap.put(5, "V");
    numMap.put(10, "X");
    numMap.put(50, "L");
    numMap.put(100, "C");
    numMap.put(500, "D");
    numMap.put(1000, "M");
    numMap.put(4, "IV");
    numMap.put(9, "IX");
    numMap.put(40, "XL");
    numMap.put(90, "XC");
    numMap.put(400, "CD");
    numMap.put(900, "CM");

    int[] divisors = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    int temp = num;
    StringBuilder result = new StringBuilder();
    int i = 0;
    while (temp != 0) {
      while (i < divisors.length && (temp / divisors[i] == 0)) {
        i++;
      }
      result.append(numMap.get(divisors[i]));
      temp -= divisors[i];
    }
    return result.toString();
  }
}
