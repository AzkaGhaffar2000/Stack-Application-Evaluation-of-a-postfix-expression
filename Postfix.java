

import java.util.*;
import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
		/* The main method asks the user for input and uses Scanner 
		to read the input. It then calls the postfix evaluation method
		and sends expression as a parameter to get the value of expression 
		and prints it. Then it asks the user if they want to evaluate another 
		expression and to handle whether the user wants or don't want to 
		continue, it uses a do/while loop which takes care of case if the 
		user wants to continue or does not want to*/
		String answer;		
		do{
			Scanner reader = new Scanner(System.in); 
			System.out.print("Enter a postfix expression: ");
			String expression = reader.nextLine(); 
			System.out.println("Answer: " + postfixEvaluate(expression));
			System.out.print("Would you like to evaluate another postfix expression (Type y or n): ");
			answer = reader.next();
        } 
		while (answer.equals("y") == true || answer.equals("Y") == true);                
    }
	/* This method uses the expression that is sent as an argumnet to 
	evaluates the postfix expression and returns the value as a double. 
	It uses push method of Stack to store the operands and as soon as
	it scans an operator it uses pop method to take two of the operands out 
	and them apply operator on operand which gives it a value and then it 
	continues scanning until the end of expression. If the expression is invalid such as if it has 
	operand other than * / % + - or is divided by 0 or has more operands 
	than digits or has more digits than operands then it returns null. 
	Following are some postfix expression that can be used to run the 
	program and there answers after running: 
		4 7 *         // 28.0
        4 7 2 + *       // 36.0
        4 7 * 20 -       // 8.0
		3 4 7 * 2 / +       // 17.0
		8 2 4 * 3 % -       // 6.0
		5 7 + 3 40 - *              // -444.0
		4 2 3 5 1 8 - + * % /       // 2.0
		6 1 7 * 0 % -       // null
        3 4 7 * 0 / +   // null
        6 8 2 / 1 - $        // null
		5 1 2 + 4 * + 3 - 7 8       // null
		8 2 4 * 3 % - 3 4 7 * 2 / + 4 7 2 + * 4 7 * 20 -    //null
		4 8 + 6 5 - * 3 2 – 2 2 + * / 8 2 4 * 3 % - 15 + *  //63.0
		4 8 + 6 5 - * 3 2 – 2 2 + * / 8 2 4 * 0 % - 15 + *  //null
	*/
    public static Double postfixEvaluate(String expression) {
	 	ListStack<Double> theStack = new ListStack<>(); 
		Scanner digit = new Scanner(expression);
		while (digit.hasNext()) {
			if (digit.hasNextDouble()) {
				theStack.push(digit.nextDouble());
			} else {
				double num2 = theStack.pop();
				double num1 = theStack.pop();
				String operand = digit.next();
				
				if (operand.equals("+")) {
					if (!operand.equals("+")) {
						return null;
					}
					theStack.push(num1 + num2);
				} else if (operand.equals("-")) {
					if (!operand.equals("-")) {
						return null;
					}
					theStack.push(num1 - num2);
				} else if (operand.equals("*")) {
					if (!operand.equals("*")) {
						return null;
					}
					theStack.push(num1 * num2);
				} else if (operand.equals("/")) {
					if (!operand.equals("/")) {
						return null;
					}
					if (num2 == 0) {
						return null;
					}
					theStack.push(num1 / num2);
				} else {
					if (!operand.equals("%")) {
						return null;
					}
					if (num2 == 0) {
						return null;
					}
					theStack.push(num1 % num2);
				}
			}
		}
		if (!(theStack.size() == 1)) {
			return null;
		} 
		return theStack.pop();
    }
}


