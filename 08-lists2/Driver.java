import java.util.Random;

public class Driver {

    public static void main(String[] args){
	Random r = new Random();
	LList ll = new LList();
	for (int i = 0; i < 10; i++)
	    ll.add(r.nextInt(100) + "");
	System.out.println(ll);
	ll.add(0,"ABCD");
	System.out.println(ll);
	ll.add(5,"TEST");
	System.out.println(ll);
	System.out.println(ll.getLen());
    }

}
