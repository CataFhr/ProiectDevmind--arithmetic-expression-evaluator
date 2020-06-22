package evaluator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Convert infix expressions to postfix  expressions (reverse Polish notation)
public class ShuntingYard {

	public static List<String> convertInfixToRPN(String expresion) throws Exception {
		List<String> elements = ShuntingYard.splitExpression(expresion);
		Deque<String> stack = new LinkedList<>();
		List<String> postFixed = new ArrayList<>();
		for (String str : elements) {
			if (ShuntingYard.isNumber(str)) {
				postFixed.add(str);
			} else if (ShuntingYard.isOperator(str)) {
				while (!stack.isEmpty() && !ShuntingYard.isLeftP(stack.peek())
						&& (ShuntingYard.elPriority(stack.peek()) > ShuntingYard.elPriority(str)
								|| ShuntingYard.elPriority(stack.peek()) == ShuntingYard.elPriority(str))
						&& !str.equals("^")) {
					postFixed.add(stack.pop());
				}
				stack.push(str);
			} else if (ShuntingYard.isLeftP(str)) {
				stack.push(str);
			} else if (ShuntingYard.isRightP(str)) {
				while (!stack.isEmpty() && !ShuntingYard.isLeftP(stack.peek())) {
					postFixed.add(stack.pop());
				}
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					throw new Exception("Wrong parentheses");
				}
			}
		}
		while (!stack.isEmpty()) {
			if (ShuntingYard.isLeftP(stack.peek())) {
				throw new Exception("Wrong parentheses");
			}
			postFixed.add(stack.pop());
		}
		return postFixed;
	}

	// method separates numbers/(multi-digit numbers) from operators and adds them
	// in order to a list
	private static List<String> splitExpression(String str) throws Exception {
		List<String> list = new ArrayList<>();
		if (str == null || str.trim().length() == 0) {
			throw new Exception("Empty expression or null");
		}
		if (str.startsWith("-")) {
			str = "0" + str;
		}
		str = str.trim().replaceAll("\\s+", "").replace("(-", "(0-");
		
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (!Character.isDigit(ch)) {
				if (!sb.toString().equals("")) {
					list.add(sb.toString());
				}
				list.add(String.valueOf(ch));
				sb.delete(0, sb.length());
			} else {
				sb.append(ch);
			}
		}
		if (!sb.toString().equals("")) { // in case there is a number at the end
			list.add(sb.toString());
		}
		return list;
	}
	private static int elPriority(String s) {
		int priority = 0;
		switch (s) {
		case "^":
			priority = 3;
			break;
		case "*":
		case "/":
			priority = 2;
			break;
		case "+":
		case "-":
			priority = 1;
			break;
		}
		return priority;
	}

	private static boolean isNumber(String s) {
		for (char ch : s.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isLeftP(String s) {
		return s.equals("(");
	}

	private static boolean isRightP(String s) {
		return s.equals(")");
	}

	private static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
	}

	public static void printPostfixExpresion(List<String> list) {
		for (String ch : list) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}
}
