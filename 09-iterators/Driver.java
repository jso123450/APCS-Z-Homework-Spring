import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args) {
	LList<String> l = new LList<String>();

	l.add("Hello");
	l.add("world");
	l.add("abc");
	l.add("something");
	l.add("else");

	System.out.println(l);

	LList<Integer> l2 = new LList<Integer>();
	//ArrayList<Integer> l2 = new ArrayList<Integer>();
	//LinkedList<Integer> l2 = new LinkedList<Integer>();
	for (int i=0;i < 5; i++){
	    l2.add(i);
	}

	System.out.println(l2);

	Iterator<String> i = l.iterator();
	while (i.hasNext())
	    System.out.println(i.next());
				
	Iterator<Integer> i2 = l2.iterator();
	while (i2.hasNext())
	    System.out.println(i2.next());
				
	for (String s : l)
	    System.out.println(s + ", ");
	System.out.println();
	for (int j : l2)
	    System.out.println(j + ", ");

	System.out.println();

	LList<Integer> l3 = new LList<Integer>();
	for (int number = 0; number < 10; number++)
	    l3.add(number);
	System.out.println(l3);
	Iterator<Integer> i3 = l3.iterator();
        while (i3.hasNext())
	    System.out.println(i3.next());
	System.out.println();
	Iterator<Integer> i3remove = l3.iterator();
	i3remove.next();
	i3remove.remove();
	while (i3remove.hasNext())
	    System.out.println(i3remove.next());
	
    }
}
