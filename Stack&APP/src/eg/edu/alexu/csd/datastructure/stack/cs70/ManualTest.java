package eg.edu.alexu.csd.datastructure.stack.cs70;

public class ManualTest {

	public static void main(String[] args) {
		
		ExpressionEvaluator test=new ExpressionEvaluator(); 
		
		
	//	System.out.println(test.SpacePutter(test.SpaceRem("a*-b+5")));
		
		System.out.println(test.infixToPostfix("b/a/(v/(w*g/i*q/j*(((l-c)))-(d/(y/(m)*f)+o+p)*s))/(x)-r"));

	}										 

}
