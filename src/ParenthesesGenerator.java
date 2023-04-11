import java.util.*;

public class ParenthesesGenerator {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<String>();
            char[] parenthesis = new char[]{'(', ')'};
            generate(n, 2 * n, result, new StringBuilder(), parenthesis); // 2n is no. of levels in binary tree
            return result;
        }

        private void generate(int n, int level, List<String> result, StringBuilder current, char[] parenthesis) {
            if (level == 0) {
                result.add(new String(current));
                return;
            }
            for (char c : parenthesis) {
                current.append(c);
                if (isValid(current, n)) {
                    generate(n, level - 1, result, current, parenthesis);
                }
                current.deleteCharAt(current.length() - 1);
            }
        }

        private boolean isValid(StringBuilder s, int n) {
            int openingCount = 0, closingCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    openingCount++;
                }
                if (s.charAt(i) == ')') {
                    closingCount++;
                }
            }
            return (closingCount <= openingCount) && (openingCount <= n) && (closingCount <= n);
        }
}
