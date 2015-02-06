public class Recursion{

    // threw IndexOutOfBoundsException to catch 
    // negatives/cases that don't make sense

    public int factorial(int n){
	if (n == 0)
	    return 1;
	else if (n > 0)
	    return (n * factorial(n-1));
	throw IndexOutOfBoundsException;
    }

    public int fib(int n){
	if (n == 0 || n == 1)
	    return 1;
	else if (n > 1)
	    return (fib(n-1) + fib(n-2));
	throw IndexOutOfBoundsException;
    }

    public int len(String s){
	if (s.equals(""))
	    return 0;
	else
	    return (1+len(s.substring(1)));
    }

    public int count(String s, char c){
	if (s.equals(""))
	    return 0;
	else if (s.charAt(0) == c)
	    return (1+count(s.substring(1)));
	else
	    return (count(s.substring(1)));
    }

    public int bunnyEars2(int bunnies){
	if (bunnies == 0)
	    return 0;
	else if (bunnies > 0){
	    if (bunnies % 2 == 1)
		return (2 + bunnyEars2(bunnies-1));
	    else
		return (3 + bunnyEars2(bunnies-1));
	}
	throw IndexOutOfBoundsException;
    }

    public int strCount(String str, String sub) {
	int len1 = str.length();
	int len2 = sub.length();
	if (len1 < len2)
	    return 0;
	else {
	    if (str.substring(0, len2).equals(sub))
		return (1+strCount( str.substring(len2), sub ));
	    else
		return strCount( str.substring(1), sub );
	}
    }

    public int sumDigits(int n) {
	if (n < 10)
	    return n;
	else if (n > 0)
	    return n%10 + sumDigits(n/10);
        throw IndexOutOfBoundsException;
    }

    public String allStar(String str) {
	if (str.length() <= 1)
	    return str;
	else
	    return str.charAt(0)+"*"+allStar(str.substring(1));
    }


    public static void main(String[] args){
	Recursion r = new Recursion();
	
    }
}
