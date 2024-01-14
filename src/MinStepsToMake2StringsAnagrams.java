public class MinStepsToMake2StringsAnagrams {
  public int minSteps(String s, String t) {
    int n = s.length();
    int[] freq = new int[26];
    int result = 0;
    for (int i  = 0; i < n; i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      result += Math.max(freq[i], 0);
    }
    return result;
  }
}
