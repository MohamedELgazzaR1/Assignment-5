package eg.edu.alexu.csd.datastructure.stack.cs70;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {

	@Test
	void test() {
		
		//TESTING INFIXTOPOSTFIX FUNCTION
		
		ExpressionEvaluator test=new ExpressionEvaluator();
		
		//TEST CASES && CORNER TEST CASES:
		String Case1 = "2 + 3 * 4";
		assertEquals(test.infixToPostfix(Case1),"2 3 4 * +");
		
		String Case2 = "a * b + 5";
		assertEquals(test.infixToPostfix(Case2),"a b * 5 +");
		
		String Case3 = "(1 + 2) * 7";
		assertEquals(test.infixToPostfix(Case3),"1 2 + 7 *");
		
		String Case4 = "a * b / c";
		assertEquals(test.infixToPostfix(Case4),"a b * c /");
		
		String Case5 = "(a/(b-c+d))*(e-a)*c";
		assertEquals(test.infixToPostfix(Case5),"a b c - d + / e a - * c *");
		
		String Case6 = "a / b - c + d * e - a * c";
		assertEquals(test.infixToPostfix(Case6),"a b / c - d e * + a c * -");
		
		String Case7 = "ab* ec / gd";
		assertEquals(test.infixToPostfix(Case7),"ab ec * gd /");
		
		
		String Case8 = "(13554+246545)*75555/77785";
		assertEquals(test.infixToPostfix(Case8),"13554 246545 + 75555 * 77785 /");
		
		
		String Case9 = "a*-b+5";
		assertEquals(test.infixToPostfix(Case9),"a 0 b - * 5 +");
		
		String Case10 = " (-1+-27)*-7";
		assertEquals(test.infixToPostfix(Case10),"0 1 - 0 27 - + 0 7 - *");
		
		String Case11 = "-abc - -def / gh + li";
		assertEquals(test.infixToPostfix(Case11),"0 abc - 0 def - gh / - li +");
		
		String Case12 = "a1* -b55+566";
		assertEquals(test.infixToPostfix(Case12),"a1 0 b55 - * 566 +");
		
		String Case13 = "aaaaaaa";
		assertEquals(test.infixToPostfix(Case13),"aaaaaaa");
		
		String Case14 = "a3333 ";
		assertEquals(test.infixToPostfix(Case14),"a3333");

		
		
		String Case15 = "(m/k/((f/r/q*o/i/x/c)-h/(((u-n+v*g/b)-w)-e-(l*z))-s*a)+t*j)";
		assertEquals(test.infixToPostfix(Case15),"m k / f r / q / o * i / x / c / h u n - v g * b / + w - e - l z * - / - s a * - / t j * +");
		
		String Case16 = "m*k/((l/d/((v*w/(z/i+(h))/s*x))))";
		assertEquals(test.infixToPostfix(Case16),"m k * l d / v w * z i / h + / s / x * / /");
		
		String Case17 = "(c*q/t/(n/v/e*f*m/h/s-(a))*((p))+((x*g)+y/(b*z*(o/(j*d/l)))/r)*w)";
		assertEquals(test.infixToPostfix(Case17),"c q * t / n v / e / f * m * h / s / a - / p * x g * y b z * o j d * l / / * / r / + w * +");
		
		String Case18 = "d/x/m*b*q*n/u/r/(w/y-(o+k+z/(c)*p)/f-e/a)";
		assertEquals(test.infixToPostfix(Case18),"d x / m / b * q * n * u / r / w y / o k + z c / p * + f / - e a / - /"); 
		
		String Case19 = "((g*h/((k*f/v*(z*t*l-(y*x/s)*o*(i/(m/(q)+a*w*(u*c*d)))/p*j)))))-r";
		assertEquals(test.infixToPostfix(Case19),"g h * k f * v / z t * l * y x * s / o * i m q / a w * u c * d * * + / * p / j * - * / r -");
		
		String Case20 = "(w/n*(((v/((q/a/f/j)+x*t*b*(((y)/l/p*k-d+u)/e)/m*g)/(o*r/i/c))-s))/h)-z";
		assertEquals(test.infixToPostfix(Case20),"w n / v q a / f / j / x t * b * y l / p / k * d - u + e / * m / g * + / o r * i / c / / s - * h / z -");
		
		
		String Case21 = "a/d*v*l/(e/y/x*(q/z-s)/p/j)";
		assertEquals(test.infixToPostfix(Case21),"a d / v * l * e y / x / q z / s - * p / j / /");
		
		
		String Case22 = "b/a/(v/(w*g/i*q/j*(((l-c)))-(d/(y/(m)*f)+o+p)*s))/(x)-r";
		assertEquals(test.infixToPostfix(Case22),"b a / v w g * i / q * j / l c - * d y m / f * / o + p + s * - / / x / r -");
		
		
		
		//EXCEPTION CASES :
		assertThrows(RuntimeException.class,()->test.infixToPostfix("+aaaa"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("aaaa+"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("---"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("b*****a"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix(""));
		assertThrows(RuntimeException.class,()->test.infixToPostfix(null));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("*/lq"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("()"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("a d ++ b */ c"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("a5 # bc"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("            "));
		assertThrows(RuntimeException.class,()->test.infixToPostfix(")((((())"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("(1 + 2)) * 7"));
		
		
	}
	
	
	@Test
	void test2() {
		
		//TESTING EVALUATE FUNCTION
		
		ExpressionEvaluator test=new ExpressionEvaluator();
		
		//TEST CASES:
		String Case1 = "2 3 4 * +";
		assertEquals(test.evaluate(Case1),14);
	
		String Case2 = "120 50 + 200 /";
		assertEquals(test.evaluate(Case2),0);
			
		String Case3 = "35 2 + 13 *";
		assertEquals(test.evaluate(Case3),481);
		
		String Case4 = "0 0 5 * 3 / - 2 +";
		assertEquals(test.evaluate(Case4),2);
		
		String Case5 = "0 0 7";
		assertEquals(test.evaluate(Case5),7);

		String Case6 = "0 7 -";
		assertEquals(test.evaluate(Case6),-7);
		
		String Case7 = "0 1 - 0 27 - + 0 7 - *";
		assertEquals(test.evaluate(Case7),196);
		
		String Case8 = "2 3 1 * + 9 -";
		assertEquals(test.evaluate(Case8),-4);

		String Case9 = "1 2 3 + * 8 -";
		assertEquals(test.evaluate(Case9),-3);
		
		String Case10 = "20 50 3 6 + * * 300 / 2 -";
		assertEquals(test.evaluate(Case10),28);

			
		//EXCEPTION CASES
		
		assertThrows(RuntimeException.class,()->test.evaluate("5 0 /"));
		assertThrows(RuntimeException.class,()->test.evaluate("---"));
		assertThrows(RuntimeException.class,()->test.evaluate(""));
		assertThrows(RuntimeException.class,()->test.evaluate(""));
		assertThrows(RuntimeException.class,()->test.evaluate("()"));
		assertThrows(RuntimeException.class,()->test.evaluate("a ++ b */ c"));
		assertThrows(RuntimeException.class,()->test.evaluate("a5 # bc"));
		assertThrows(RuntimeException.class,()->test.evaluate("            "));
		assertThrows(RuntimeException.class,()->test.evaluate(")((((())"));
		assertThrows(RuntimeException.class,()->test.evaluate("(1 + 2)) * 7"));
	
	
	}

}
