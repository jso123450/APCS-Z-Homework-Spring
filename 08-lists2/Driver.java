import java.util.Random;

public class Driver {

    public static void main(String[] args){
	Random r = new Random();
	LList ll = new LList();
	for (int i = 0; i < 10; i++)
	    ll.add(r.nextInt(100));
	// Testing add
	System.out.println(ll);
	ll.add(0,1337);
	System.out.println(ll);
	ll.add(5,666);
	// Testing removes
	System.out.println(ll);
	ll.remove(5);
	System.out.println(ll);

	boolean removed = ll.removeFirstOccur(666);
	System.out.println("RemovedFirstOccur of 666? " + removed);

	System.out.println();

	System.out.println(ll);
	ll.add(5,667);
	System.out.println(ll);
	ll.add(7,667);
	System.out.println(ll);
	removed = ll.removeFirstOccur(667);
	System.out.println("RemovedFirstOccur of 667? " + removed);
	System.out.println(ll);
    }

}
