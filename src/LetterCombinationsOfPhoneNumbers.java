import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumbers {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        generateLetterCombinations(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    private void generateLetterCombinations(String digits, int currIndex, StringBuilder current, HashMap<Character, List<Character>> map, List<String> result) {
        if (currIndex >= digits.length()) {
            result.add(new String(current));
            return;
        }
        List<Character> choices = map.get(digits.charAt(currIndex));
        for (char c : choices) {
            current.append(c);
            generateLetterCombinations(digits, currIndex + 1, current, map, result);
            current.deleteCharAt(currIndex); // Backtrack - last character added
        }
    }
}
