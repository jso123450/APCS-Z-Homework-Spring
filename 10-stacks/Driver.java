public class Driver {

    public static void main(String[] args){
	myStack<Integer> s = new myStack<Integer>();
	// EmptyStackExceptions thrown
	//System.out.println(s.pop());
	//System.out.println(s.peek());
	System.out.println(s.empty());
	s.push(5);
	s.push(6);
	System.out.println(s.pop());
	s.push(1323);
	System.out.println(s.peek());
	System.out.println(s);
    }

}
