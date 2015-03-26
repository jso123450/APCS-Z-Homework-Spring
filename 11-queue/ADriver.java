import java.util.*;

public class ADriver{

    public static void main(String[] args){
	Random r = new Random();
	myAQueue aQ = new myAQueue();
	System.out.println( aQ.empty() );
	// throws new NoSuchElementException since aQ is empty
	//System.out.println( aQ.dequeue() );
	//System.out.println( aQ.head() );
	System.out.println( aQ );
	for (int i = 0; i < 500; i++){
	    aQ.enqueue( r.nextInt(500) + 1 );
	}
	System.out.println( aQ );
	for (int i = 0; i < 10; i++){
	    System.out.println( aQ.dequeue() );
	}
	System.out.println( aQ );
    }
}
