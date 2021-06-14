package com.dsaa.stack;

import java.util.Scanner;

public class PostFixCalculator {

	public Stack<Integer> argumentsStack;
	
	public PostFixCalculator() {
		argumentsStack = new Stack<Integer>();
	}
	
	public Stack<Integer> runInputs(String[] arguments) {
		for(String value : arguments) {
			
			Scanner characterTypeCheck = new Scanner(value);
			
			if(characterTypeCheck.hasNextInt()) {
				System.out.println("Int: " + value);
				Integer numberArgument = Integer.parseInt(value);
				argumentsStack.push(numberArgument);
			}
			else{
				System.out.println("Operation: " + value);
				Integer firstArg = argumentsStack.pop();
				Integer secondArg = argumentsStack.pop();
				try {
					argumentsStack.push(calculateOperation(value, firstArg, secondArg));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			characterTypeCheck.close();
		}
		
		return argumentsStack;
	}
	
	public static void main(String args[]) {
		
		String[] instructionSet = {"1","2","+"};
		String[] instructionSet2 = {"1","5", "3","-"};
		String[] instructionSet3 = {"1","2","3", "*", "-"};
		
		Stack<Integer> calc = new PostFixCalculator().runInputs(instructionSet2);
		
			while(calc.peek() != null) {
				System.out.println(calc.pop());
			}

		System.out.println("Done");
	}
	
	public Integer calculateOperation(String operator, Integer firstOperand, Integer secondOperand) throws Exception{
		
		Integer result = null;
		
		  switch(operator) {
    	  case "+":
    		  result = firstOperand + secondOperand;
    		  break;
    	  case "-":
    		  result = firstOperand - secondOperand;
    		  break;
    	  case "*":
    		  result = firstOperand * secondOperand;
    		  break;
    	  case "/":
    		  result = firstOperand / secondOperand;
    		  break;
    	  default:
    		  //If the character isn't a number and isn't an operation we support,
    		  //throw an exception.
    		  throw new Exception();	
		  }

		return result;
    }
		
	
}
