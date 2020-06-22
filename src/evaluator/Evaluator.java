package evaluator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Evaluator {

	public static void main(String[] args) {

		try (FileReader fr = new FileReader("input.txt"); BufferedReader br = new BufferedReader(fr)) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Enter infix expression:");
				System.out.println("Expression is: " + line);
				List<String> q = ShuntingYard.convertInfixToRPN(line);
				System.out.print("Postfix expression is: ");
				ShuntingYard.printPostfixExpresion(q);
				System.out.print("Result is: ");
				System.out.println(PostfixEvaluation.evalRPN(Evaluator.convertListToStringArray(q)));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

	private static String[] convertListToStringArray(List<String> list) {
		int index = 0;
		String[] result = new String[list.size()];
		for (String el : list) {
			result[index++] = el;
		}
		return result;
	}
}
