import java.io.*;
import java.util.*;
import java.lang.System;

public class TimeTest{

    private ArrayList<Integer> AL = new ArrayList<Integer>();
    private LList LL = new LList();
    private LinkedList<Integer> biLL = new LinkedList<Integer>();
    private Random r = new Random();

    public void setupAL(int len){
        for (int i = 0; i < len; i++)
	    AL.add(r.nextInt(11));
    }

    public int sumAL(){
	int sum = 0;
	for (int i = 0; i < AL.size(); i++)
	    sum+= AL.get(i);
	return sum;
    }
    
    public void setupLL(int len){
	for (int i = 0; i < len; i++)
	    LL.add(r.nextInt(11));
    }

    public int sumLL(){
	int sum = 0;
	for (int i = 0; i < LL.getLen(); i++)
	    sum+= LL.get(i);
	return sum;
    }

    public LList getLL(){
	return LL;
    }

    public void setupBILL(int len){
	for (int i = 0; i < len; i++)
	    biLL.add(r.nextInt(11));
    }

    public int sumBILL(){
	int sum = 0;
	for (int i = 0; i < biLL.size(); i++)
	    sum+= biLL.get(i);
	return sum;
    }

    public void clear(){
	AL = new ArrayList<Integer>();
	LL = new LList();
	biLL = new LinkedList<Integer>();
    }

    public void test(int len){
	long start, elapsed;

	System.out.println("Lists with Lengths of " + len);

	System.out.println();

        setupAL(len);
	System.out.println("ArrayList Sum");
	start = System.currentTimeMillis();
	int sumAL = sumAL();
	elapsed = System.currentTimeMillis() - start;
	System.out.println("Time Elapsed: " + elapsed + " ms");

	System.out.println();

	setupLL(len);
	System.out.println("Our LinkedList Sum");
	start = System.currentTimeMillis();
	int sumLL = sumLL();
	elapsed = System.currentTimeMillis() - start;
	System.out.println("Time Elapsed: " + elapsed + " ms");

	System.out.println();

	setupBILL(len);
	System.out.println("Built-in LinkedList Sum");
	start = System.currentTimeMillis();
	int sumBILL = sumBILL();
	elapsed = System.currentTimeMillis() - start;
	System.out.println("Time Elapsed: " + elapsed + " ms");

	System.out.println();
    }

}
