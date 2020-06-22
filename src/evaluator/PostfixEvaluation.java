package evaluator;

import java.util.Deque;
import java.util.LinkedList;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation(postfix notation)
public class PostfixEvaluation {

	public static int evalRPN(String[] input) throws Exception {
		if (input == null) {
			throw new Exception("Null expression");
		}
		Deque<Integer> stack = new LinkedList<>();
		int result = 0;
		for (String str : input) {
			if (PostfixEvaluation.isOperator(str)) {
				if (stack.size() >= 2) {
					int op1 = stack.pop();
					int op2 = stack.pop();
					result = PostfixEvaluation.mathResult(op1, op2, str);
					stack.push(result);
				} else {
					throw new Exception("Postfixed expresion is wrong");
				}
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		result = stack.pop();
		if (!stack.isEmpty()) {
			throw new Exception("Postfixed expresion is wrong");
		}
		return result;
	}

	private static int mathResult(int op1, int op2, String operator) throws Exception {
		switch (operator) {
		case "+":
			return op2 + op1;
		case "-":
			return op2 - op1;
		case "*":
			return op2 * op1;
		case "/":
			return op2 / op1;
		case "^":
			return (int) Math.pow(op2, op1);
		default:
			throw new Exception("Illegal operator");
		}
	}

	private static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
	}

}
