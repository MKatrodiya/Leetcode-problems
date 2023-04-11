import java.util.*;
public class DecodeString {
    public String decodeString(String s) {
        int i = 0;
        Stack<String> stack = new Stack<String>();
        StringBuilder result = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                StringBuilder curr = new StringBuilder();
                while(!(stack.peek()).equals("[")) {
                    curr.insert(0, stack.pop());
                }
                stack.pop(); // Remove '['
                int count = Integer.parseInt(stack.pop()); // Get count to repeat string in bracket
                StringBuilder temp = new StringBuilder();
                while (count > 0) {
                    temp.append(curr);
                    count--;
                }
                stack.push(String.valueOf(temp));
                i++;
            } else {
                if (!Character.isDigit(s.charAt(i))) {
                    stack.push(String.valueOf(s.charAt(i)));
                    i++;
                } else {
                    StringBuilder temp = new StringBuilder();
                    while (Character.isDigit(s.charAt(i))) {
                        temp.append(s.charAt(i));
                        i++;
                    }
                    stack.push(temp.toString());
                }
            }
        }
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
