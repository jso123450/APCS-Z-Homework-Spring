public class Driver {

    public static void main(String[] args){
	myQueue<Integer> q = new myQueue<Integer>();
	System.out.println( q.empty() );
	// throws NoSuchElementException since empty
	//System.out.println( q.head() );
	//System.out.println( q.dequeue() );
	System.out.println(q);
	q.enqueue(3);
	System.out.println(q);
	q.enqueue(5);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.enqueue(9);
	System.out.println(q);
	q.enqueue(54);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	// throws error since now empty
	//System.out.println("Head is " + q.head());
    }

}
