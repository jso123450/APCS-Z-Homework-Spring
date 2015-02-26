import java.util.*;

public class Merge{

    private ArrayList<Integer> data = new ArrayList<Integer>();

    public Merge(ArrayList<Integer> input){
	data = input;
    }

    // combines two previously sorted arraylists into one in increasing order
    public ArrayList<Integer> merge(ArrayList<Integer> stuff, ArrayList<Integer> stuff2){
	ArrayList<Integer> newData = new ArrayList<Integer>();
	int i = 0;
	int i2 = 0;
	while ( i < stuff.size() && i2 < stuff2.size() ){
	    if (stuff.get(i) <= stuff2.get(i2)){
		newData.add( stuff.get(i) );
		i++;
	    }
	    else if (stuff2.get(i2) < stuff.get(i)){
		newData.add( stuff2.get(i2) );
		i2++;
	    }
	}
	// if anything is left over, just finish adding the rest
	while ( i < stuff.size() ){
	    newData.add( stuff.get(i) );
	    i++;
	}
	while ( i2 < stuff2.size() ){
	    newData.add( stuff2.get(i2) );
	    i2++;
	}
	return newData;
    }

    // kind of like a subArrayList function similar to a String's substring function
    // returns an ArrayList with elements stuff.get(start) inclusive to stuff.get(stop) exclusive
    public ArrayList<Integer> split(ArrayList<Integer> stuff, int start, int stop){
	ArrayList<Integer> A = new ArrayList<Integer>();
	int i = start;
	int j = stop;
        while (i < j){
	    A.add( stuff.get(i) );
	    i++;
	}
	return A;
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> stuff){
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (stuff.size() <= 1){
	    return stuff;
	}
	else {
	    ArrayList<Integer> A = split(stuff, 0, stuff.size()/2);
	    ArrayList<Integer> B = split(stuff, stuff.size()/2, stuff.size() );
	    A = mergeSort(A);
	    B = mergeSort(B);
	    result = merge(A,B);
	}
	return result;
    }

    public ArrayList<Integer> mergeSort(){
	ArrayList<Integer> result = mergeSort( data );
	data = result;
	return data;
    }

    // returns true if s is integer-parseable
    public static boolean isNumeric(String s){
	try {
	    Integer i = Integer.parseInt(s);
	} catch (NumberFormatException nfe){
	    return false;
	}
	return true;
    }

    public String toString(){
	String output = "[";
	for (int i = 0; i < data.size(); i++){
	    if (i < data.size() - 1)
		output+= data.get(i) + " ";
	    else
		output+= data.get(i);
	}
	output+= "]";
	return output;
    }

    /* ---------------------------------- MAIN ---------------------------------- */

    public static void main(String[] args){
	ArrayList<Integer> stuff = new ArrayList<Integer>();
	if (args.length == 0){
	    Random r = new Random();
	    for (int i = 0; i < 10; i++){
		int randomInt = r.nextInt(10);
		stuff.add(randomInt);
	    }
	}
	// if only one integer-parseable argument, it functions as the # of randomInts
	else if (args.length == 1 && isNumeric(args[0])){
	    Random r = new Random();
	    for (int i = 0; i < Integer.parseInt(args[0]); i++){
		int randomInt = r.nextInt(10);
		stuff.add(randomInt);
	    }
	}
	else {
	    for (int i = 0; i < args.length; i++){
		// ignores any non-integer-parseable element
	        if (isNumeric(args[i]))
		    stuff.add(Integer.parseInt(args[i]));
	    }
	}
	Merge m = new Merge(stuff);
	System.out.println( m );
	/*
	ArrayList<Integer> s1 = m.split( stuff, 0, stuff.size()/2 );
	ArrayList<Integer> s2 = m.split( s1, 0, s1.size()/2 );
	ArrayList<Integer> s3 = m.split( s1, s1.size()/2, s1.size() );
	ArrayList<Integer> s4 = m.split( s2, 0, s2.size()/2 );
	ArrayList<Integer> s5 = m.split( s2, s2.size()/2, s2.size() );
	System.out.println( s1 );
	System.out.println( s2 );
	System.out.println( s3 );
	System.out.println( s4 );
	System.out.println( s5 );
	*/
	m.mergeSort();
	System.out.println( m );
    }

}
