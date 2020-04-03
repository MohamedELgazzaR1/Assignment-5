package eg.edu.alexu.csd.datastructure.stack.cs70;

import java.util.Scanner;

public class ExpressionEvaluatorUI {

	public static void main(String[] args) {
		
			
				
				Scanner input = new Scanner (System.in);
				
				int num=5;
			while(num !=3) {	
				try {
				while(true) {
					System.out.println("Please Enter A valid Choice");
					System.out.println("1: ToPostfix\r\n" + 
							"2: Evaluate\r\n" + 
							"3: Exit\r\n" ); 
					String in = input.nextLine();
					try{
						 num = Integer.parseInt(in);
					}
					catch(Exception e) {
						 num =300;
					}
					if(num == 1 || num==2 || num==3) {
						break;
					}
					
				}	
				ExpressionEvaluator test=new ExpressionEvaluator();
				switch (num) {
				
				case 1:
					System.out.println("Please Enter the expression");
					String	exp = input.nextLine();
					System.out.println("The Postifix expression is : "+test.infixToPostfix(exp));
					break;
				case 2:
					System.out.println("Please Enter the expression");
					String	exp2 = input.nextLine();
					System.out.println("The Value is : "+test.evaluate(exp2));
					break;
			}
			
			
			
			}catch(Exception e) {
				System.out.println("There is an error in the expression");
				
			}
			}
	}
	}
