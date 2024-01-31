import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> results = new Stack<>();
    for (String token : tokens) {
      int op1, op2;
      int operator;
      try {
        op1 = Integer.parseInt(token);
        results.push(op1);
      } catch(NumberFormatException e) {
        op2 = results.pop();
        op1 = results.pop();
        if (token.equals("+")) {
          results.push(op1 + op2);
        } else if (token.equals("-")) {
          results.push(op1 - op2);
        } else if (token.equals("*")) {
          results.push(op1 * op2);
        } else {
          results.push(op1 / op2);
        }
      }
    }
    return results.pop();
  }
}
