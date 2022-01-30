package labsession.Question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	
	//function to check if brackets are balanced
	static boolean checkingBalancedBracket(String expr)
	{
		Stack<Character> stack = new Stack<Character>();
		
		// To Traverse The Expression
		for (int i = 0; i < expr.length(); i++)
		{
			char character = expr.charAt(i);
			
			if (character == '(' || character =='[' || character == '{')
			{
				//pushing the element in the stack
				stack.push(character);
				continue;
			}
			
			if (stack.isEmpty())
				return false;
			
			char c;
			
			switch (character) {
			
			case '}' :
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
				
			case ']' :
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			
			case ')' :
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;	
			}
		}
		//check whether stack is empty
		return (stack.isEmpty());
	}
	
	//Driver Code
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String expr = sc.next();
		
		if (checkingBalancedBracket(expr))
			System.out.println("The entered String has Balanced Brackets");
		else 
			System.out.println("The entered String do not contain Balanced Brackets");
		sc.close();
	}

}
