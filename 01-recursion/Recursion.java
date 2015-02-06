public class Recursion{

    public int factorial(int n){
	if (n == 0)
	    return 1;
	else if (n > 0)
	    return (n * factorial(n-1));
	// to catch negs
	else
	    return 0;
    }

}
