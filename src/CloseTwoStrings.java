public class CloseTwoStrings {
  public boolean closeStrings(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    if (l1 != l2) {
      return false;
    }
    int[] chars1 = new int[26];
    int[] chars2 = new int[26];
    for (int i = 0; i < l1; i++) {
      chars1[word1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < l2; i++) {
      chars2[word2.charAt(i) - 'a']++;
    }
    for(int i = 0; i < 26; i++) {
      if ((chars1[i] == 0 && chars2[i] != 0) || (chars1[i] != 0 && chars2[i] == 0)) {
        return false;
      }
      if (chars1[i] == chars2[i]) {
        continue;
      }
      int j = findIndex(chars1, i,  chars2[i]);
      if (j == -1) {
        return false;
      }
      int temp = chars1[j];
      chars1[j] = chars1[i];
      chars1[i] = temp;
    }
    return true;
  }
  private int findIndex(int[] arr, int start, int val) {
    for (int i = start; i < arr.length; i++) {
      if (arr[i] == val) {
        return i;
      }
    }
    return -1;
  }
}
