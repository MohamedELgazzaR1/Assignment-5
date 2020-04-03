package eg.edu.alexu.csd.datastructure.stack.cs70;
import java.util.*;


public class UIStack {

	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
	
		Scanner input = new Scanner (System.in);
		Stack AppStack=new Stack ();
		
		int num=5;
	while(num !=6) {	
		try {	
		while(true) {
	
		System.out.println("Please Enter A valid Choice");
		System.out.println("1: Push\r\n" + 
				"2: Pop\r\n" + 
				"3: Peek\r\n" + 
				"4: Get size\r\n" + 
				"5: Check if empty\r\n"+
				"6: Exit");
		
		String in = input.nextLine();
		try{
			 num = Integer.parseInt(in);
		}
		catch(Exception e) {
			 num =300;
		}
		if(num == 1 || num==2 || num==3 || num==4 || num==5 || num == 6) {
			break;
		}
		}
		switch (num) {
			
			case 1:
				System.out.println("Please Enter Element To Push ");
				Object Pushed=new Object();
				Pushed = input.nextLine();
				AppStack.push(Pushed);
				break;
			case 2:
				
				System.out.println("The POPED element is: "+AppStack.pop());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("The Peek Elements is: "+AppStack.peek());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Stack Size is: "+AppStack.size());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				if(AppStack.isEmpty()) {
					System.out.println("The Stack's Empty");
				}
				else {
					System.out.println("The Stack's Not Empty");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;		
		}
		
	}
	
	
	
	catch(NullPointerException e) {
		System.out.println("Error Under Flow Occured");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException f) {
			e.printStackTrace();
		}
	}
	}
	}
}
