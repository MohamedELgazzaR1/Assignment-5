package eg.edu.alexu.csd.datastructure.stack.cs70;

public class ExpressionEvaluator implements IExpressionEvaluator {
	@Override
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression
	* infix expression
	* @return postfix expression
	*/
	
	public String infixToPostfix(String expression) {
		int check=0;
		Stack Operations = new Stack();
		expression=this.SpaceRem(expression);
		Valid1(expression);
		Valid2(expression);
		expression=this.SpacePutter(expression);
		expression=Negtive(expression);
		String Postfix="";
		int i=0;
		if(checkempty(expression)) {
			throw new RuntimeException("The expression is empty");
		}
		else if(Check(expression.charAt(0))==0 && expression.charAt(0)!='('){
			Postfix+=expression.charAt(0);
			i++;
		}
		int Len=expression.length();
		while(i<Len) {
			
			char curr=expression.charAt(i);	
			if(curr=='(') {
				check++;
				Operations.push(curr);
				i++;
			}
			else if(curr==')') {
				if((char)Operations.peek()=='('&&check==1) throw new RuntimeException();
				while( (char)Operations.peek()!='(') {
					if(Postfix.charAt(Postfix.length()-1)!=' ')
						Postfix+=' ';
					Postfix+=Operations.pop();	
				}
				Operations.pop();
				i++;
				check=0;
			}
			else if (Check(curr)==3) {
				if(Operations.size()==0) {
					Operations.push(curr);
					i++;
				}
				else if((char)Operations.peek()=='(' || Check(curr) > Check((char)Operations.peek())) {
					Operations.push(curr);
					i++;
				}
				else {
					Postfix+=Operations.pop();
				}
			}
			else if (Check(curr)==2) {
				if(Operations.size()==0) {
					Operations.push(curr);
					i++;
				}
				else if((char)Operations.peek()=='(') {
					Operations.push(curr);
					i++;
				}
				else {
					Postfix+=Operations.pop();
					Postfix+=' ';
				}
			}
			else if(Check(curr)==0) {
				check++;
				Postfix+=curr;	
				i++;
			
				if(i<Len && expression.charAt(i)==' ') {
					Postfix+=' ';	
				}
			
			}
			else if(Check(curr)==1) {
				if(Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)!=' '&&i!=Len-1) {
					Postfix+=curr;	
				}	
				i++;
			}
		
		}
		while(Operations.size()!=0) {
			if(Postfix.charAt(Postfix.length()-1)!=' ') {
			Postfix+=' ';
			}
			if((char)Operations.peek()=='(')
				throw new RuntimeException("Error in Expression");
			Postfix+=Operations.pop();
		}
		return Postfix;
	}
	int Check(char curr) {	
		/**
		* Takes a Character as input 
		* checks the type of character which may be operator or digit or character 
		* @param curr
		* Character to be checked
		* @return certain number to detect the type of input charcater
		*/
		if(curr=='('||curr==')'){
			return 4;
		}
		else if (curr=='*'||curr=='/' ) {
			return 3;
		}
		else if (curr=='+'||curr=='-') {
			return 2;
		}
		else if (curr==' '||curr=='\t') {
			return 1;
		}
		else {
			if(!(Character.isAlphabetic(curr))&&!(Character.isDigit(curr))) throw new RuntimeException();
			return 0;
		}
	}
	
	boolean isNumeric(String expression) {
		/**
		* Boolean Function which:
		* Takes a symbolic/numeric Postfix expression as input 
		* checks whether it is numeric or not 
		* @param expression
		* infix expression
		* @return True if the expression is numeric only / False if the expression is else
		*/
		int	Len=expression.length();
		for(int i=0;i<Len;i++) {
			char curr=expression.charAt(i);
			
			if (Check(curr)==0 && Character.isLetter(curr) ) {
				return false;
			}
		}
		return true;
	}

	String Negtive(String expression) {
		/**
		* Takes a symbolic/numeric infix expression as input 
		* and change every negative number to negative with dummy zero method
		*ie: -3 >> (0 - 3)
		* @param expression
		* infix expression
		* @return the expression modified with dummy zero method
		*/	
		int Len=expression.length();
		String Out="";
		for (int i=0;i<Len;i++) {
		}
		for (int i=0;i<Len;i++) {
			if(expression.charAt(i)=='-' && i+1<Len && Check(expression.charAt(i+1))==0) {
				Out+="(0 - ";
				while(i+1<Len && Check(expression.charAt(i+1))==0){
				Out+=expression.charAt(i+1);
				i++;
				}
				Out+=')';
				}
			else {
				Out+=expression.charAt(i);
			}
		}
		return Out;
	}
	
	String SpaceRem(String expression) {
		/**
		* Takes a symbolic/numeric infix expression as input 
		* remove all spaces and tabs in it
		* @param expression
		* infix expression
		* @return infix expression with out any spaces or tabs
		*/	
		int Len=expression.length();
		String out1="";
		String out2="";
		for(int i=0;i<Len;i++) {
			char curr=expression.charAt(i);
			if(Check(curr)!=1) {
				out1+=curr;
			}
		}
		Len=out1.length();
		for(int i=0;i<Len;i++) {
			char curr=out1.charAt(i);
			if(i-1>0&&i+1<Len&&curr=='-'&&Check(out1.charAt(i+1))==0&&Check(out1.charAt(i-1))!=2&&Check(out1.charAt(i-1))!=3) {
				out2+=curr;
				out2+=' ';
			}
			else {
			out2+=curr;
			}
			}
	return out2;
	}
	
	public String SpacePutter(String expression) {
		/**
		* Takes a symbolic/numeric infix expression as input :
		*  Put spaces in certain positions to help in detection of certain cases
		* @param expression
		* infix expression
		* @return infix expression after adding spaces at certain places
		*/	
		if(expression==null)
			throw new NullPointerException();
		int	Len=expression.length();
		String out="";
		for(int i=0;i<Len;i++) {
			char curr=expression.charAt(i);
			if(Check(curr)==0) {
				out+=curr;
				while(i<Len-1 && Check(expression.charAt(i+1))==0) {
					out+=expression.charAt(i+1);
					i++;
			}
				if(i!=Len-1)
					out+=' ';
			}
			else if(curr=='-') {
				if(i+1<Len&&Check(expression.charAt(i+1))==0) {
					out+=curr;
				}
				else {
					out+=curr;
					out+=' ';
				}
			}

			else if(Check(curr)==3||Check(curr)==2) {
				out+=curr;
				out+=' ';
			}
			else if(Check(curr)==4) {
				out+=curr;
				out+=' ';
			}
			else {
				out+=curr;
			}
		}
		return out;
	}

	void Valid2(String expression) {
		/**
		* Takes a symbolic/numeric infix expression as input 
		* which check the validity of the function according to different cases
		* @param expression
		* infix expression
		* throw exception if the expression is not valid
		*/	
		int checker1=0;
		int checker2=0;
		boolean flag=true;
		boolean flag2=true;
		int Len=expression.length();
		for(int i=0;i<Len-1;i++) {
			char curr=expression.charAt(i);
			char next=expression.charAt(i+1);
			if(Check(curr)==0&&flag==true) {
				checker1++;
				flag=false;
			}
			else if(Check(curr)==2||Check(curr)==3) {
				checker2++;
				if(flag==false)
				flag2=false;
			}
			else if(Check(curr)==0&&flag2==false) {
				checker1++;
			}
			if(!CheckTr(curr,next)) {
				throw new RuntimeException();
			}
		}
		if(Check(expression.charAt(Len-1))==0&&flag2==false) {
			checker1++;
		}
		else if(Check(expression.charAt(Len-1))==2||Check(expression.charAt(Len-1))==3)
			checker2++;
		
		if(checker2==0) {
			return;
		}
		else if(checker1<2||checker2<1) {
			throw new RuntimeException();
		}
	
	}
	
	void Valid1(String expression) {
		/**
		* Takes a symbolic/numeric infix expression as input 
		* which check the validity of the function if :
		* there is two operations follows each other in forbidden way
		* @param expression
		* infix expression
		* throw exception if the expression is not valid
		*/	
		int Len=expression.length();
		for(int i=0;i<Len-1;i++) {
			char curr=expression.charAt(i);
			char next=expression.charAt(i+1);
				while(Check(curr)==0&&Check(next)==1) {
					next=expression.charAt(i+1);
					if(Check(next)==0) {
						throw new RuntimeException();
					}
				i++;
				}
			}
		}
	
	
	float Calc(float a,float b,char op) {	
		/**
		* 2 float numbers and 1 operation as input 
		* calculate the mathematical operation according to the input
		* @param a , b ,op
		* @return the value of the result 
		*/
		switch(op) {
		case'+':
			return a+b;
		case'-':
			return b-a;
		case'*':
			return a*b;
		case'/':
			if(a==0) {
				throw new RuntimeException("Error Division by Zero");
			}
			return b/a;
		}
		return 0;
	}
	
	boolean CheckTr(char a,char b) {
		/**
		* 2 characters as input
		* determine if the two operations are from the same type or not
		* @param a , b
		* @return true if the two are same false if not 
		*/
		if(b=='-') {
			return true;	
		}
		else if(Check(a)==2 && Check(b)==2) {
			return false;
		}
		else if(Check(a)==3&&Check(b)==3) {
			return false;
		}
		else if(Check(a)==3&&Check(b)==2) {
			return false;
		}
		else if(Check(a)==2&&Check(b)==3) {
			return false;
		}
		return true;
	}
	boolean checkempty(String exp) {
		for(int i=0;i<exp.length();i++) {
			if(exp.charAt(i)!=' ') {
				return false;
			}
		}
		return true;
	}
	
	@Override
	
	public int evaluate(String expression) {
		/**
		* Evaluate a postfix numeric expression, with a single space separator
		*
		* @param expression
		* postfix expression
		* @return the expression evaluated value
		*/
		Stack Calculations=new Stack();
		int	Len=expression.length();
		int i=0;
		
		if(checkempty(expression)) {
			throw new RuntimeException("The expression is empty");
		}
		else if(!(isNumeric(expression))) {
			throw new RuntimeException("The expression contain letters");
		}
		else {
			
			while(i<Len) {
				char curr=expression.charAt(i);
				int Checker = Check(curr);
				if((Checker==2||Checker==3) && ( i==Len-1 || expression.charAt(i+1)==' ') ) {
					Calculations.push(Calc((float)Calculations.pop(),(float)Calculations.pop(),curr));
				}
				else if(Checker==1) ;
				else {
					String num="";
					num+=curr;
					int j=i+1;
					while(j<Len && expression.charAt(j)!=' '){
						num+=expression.charAt(j);
						j++;
						i++;
					}
					Calculations.push((float)Integer.valueOf(num));
				}
				i++;
			}
			}
		float temp=	(float)Calculations.peek();
		int Result=(int)temp;
		return Result;
		}
	}