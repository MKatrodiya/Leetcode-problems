import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHalvesAlike {
  public boolean halvesAreAlike(String s) {
    List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                                                           'A', 'E', 'I', 'O', 'U'));

    int half = s.length() / 2;
    int count = 0;
    for (int i = 0; i < half; i++) {
      if (vowels.contains(s.charAt(i))) {
        count++;
      }
      if (vowels.contains(s.charAt(half + i))) {
        count--;
      }
    }
    return count == 0;
  }
}
