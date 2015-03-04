import java.util.*;

public class MergeWithArrays{

    private int[] data;
    
    public MergeWithArrays(int[] input){
	data = input;
    }

    public int[] merge(int[] stuff, int[] stuff2){
	int[] newData = new int[ stuff.length + stuff2.length ];
	int newDataCounter = 0;
	int i = 0;
	int i2 = 0;
	while ( i < stuff.length && i2 < stuff2.length ){
	    if ( stuff[i] <= stuff2[i2] ){
		newData[newDataCounter] = stuff[i];
		i++;
	    }
	    else if ( stuff2[i2] < stuff[i] ){
		newData[newDataCounter] = stuff2[i2];
		i2++;
	    }
	    newDataCounter++;
	}
	while ( i < stuff.length ){
	    newData[newDataCounter] = stuff[i];
	    i++;
	    newDataCounter++;
	}
	while ( i2 < stuff2.length ){
	    newData[newDataCounter] = stuff2[i2];
	    i2++;
	    newDataCounter++;
	}
	return newData;
    }

    public int[] split(int[] stuff, int start, int stop){
	int[] A = new int[ stop - start ];
	int i = start;
	int j = stop;
	int Acounter = 0;
	while ( i < j ){
	    A[Acounter] = stuff[i];
	    Acounter++;
	    i++;
	}
	return A;
    }

    public int[] mergeSort(int[] stuff){
	int[] result = new int[ stuff.length ];
	if (stuff.length <= 1)
	    return stuff;
	else {
	    int[] A = split(stuff, 0, stuff.length/2 );
	    int[] B = split(stuff, stuff.length/2, stuff.length );
	    A = mergeSort(A);
	    B = mergeSort(B);
	    result = merge(A,B);
	}
	return result;
    }

    public int[] mergeSort(){
	int[] result = mergeSort( data );
	data = result;
	return data;
    }

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
	for (int i = 0; i < data.length; i++){
	    if (i < data.length - 1)
		output+= data[i] + " ";
	    else
		output+= data[i];
	}
	output+= "]";
	return output;
    }

  /* ---------------------------------- MAIN ---------------------------------- */

    public static void main(String[] args){
	int[] stuff;
	Random r = new Random();
	stuff = new int[10];
	for (int i = 0; i < 10; i++){
	    int randomInt = r.nextInt(100);
	    stuff[i] = randomInt;
	}
	/*
	// if only one integer-parseable argument, it functions as the # of randomInts
	else if (args.length == 1 && isNumeric(args[0])){
	    Random r = new Random();
	    stuff = new int[ Integer.parseInt(args[0]) ];
	    for (int i = 0; i < stuff.length; i++){
		int randomInt = r.nextInt(100);
		stuff[i] = randomInt;
	    }
	}
	else {
	    for (int i = 0; i < args.length; i++){
		// ignores any non-integer-parseable element
	        if (isNumeric(args[i]))
		    stuff[i] = Integer.parseInt(args[i]);
	    }
	}
	*/
	MergeWithArrays m = new MergeWithArrays(stuff);
	System.out.println( m );
	m.mergeSort();
	System.out.println( m );
    }
}
