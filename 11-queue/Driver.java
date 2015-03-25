public class Driver {

    public static void main(String[] args){
	myQueue<Integer> q = new myQueue<Integer>();
	System.out.println( q.empty() );
	System.out.println( q.head() );
	q.enqueue(5);
    }

}
