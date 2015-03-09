import java.util.*;

public class Selection {

    private int[] data;

    public Selection(int[] input){
	data = input;
    }

    public Selection(){
	int[] input = randomize(100);
	data = input;
    }

    public int[] randomize(int len){
	Random r = new Random();
	int[] output = new int[len];
	for (int i = 0; i < output.length; i++)
	    output[i] = r.nextInt(len);
	return output;
    }
    
    // chooses an element "pivot" from array L
    // then sorts the rest of L (from SI to EI) based on whether
    // it is smaller or greater than the pivot
    // and then returns pivot's sorted index
    /*
    public int partition(int[] L, int SI, int EI){
	int[] Lcopy = L;
	int[] D = new int[Lcopy.length];
	int Di;
	int start = SI;
	int end = EI;
	for (Di = 0; Di < start; Di++)
	    D[Di] = Lcopy[Di];
	for (Di = end + 1; Di < Lcopy.length; Di++)
	    D[Di] = Lcopy[Di];
	int pivot = Lcopy[start];
	System.out.println("pivot: " + pivot);
	start++;
	while (start != end){
	    if (Lcopy[start] < pivot){
		D[start] = Lcopy[start];
		start++;
	    }
	    if (Lcopy[start] > pivot){
		D[end] = Lcopy[start];
		Lcopy[start] = Lcopy[end];
		end--;
	    }
	    System.out.println("D: " + Arrays.toString(D));
	    System.out.println("Lcopy: " + Arrays.toString(Lcopy));
	}
	D[start] = Lcopy[start];
	System.out.println("Final D: " + Arrays.toString(D));
	if (Lcopy[start] > pivot)
	    return start-1;
	else
	    return start+1;
    }
*/

    public int partition(int k, int low, int high){
	int pivot = data[low];
	int pivotindex = low;
	int lowi = low;
	int highi = high;
	data[lowi] = data[highi];
	data[highi] = pivot;
	highi--;
	while (lowi < highi){
	    if (data[lowi] < pivot)
		lowi++;
	    else{
		int holder = data[lowi];
		data[lowi] = data[highi];
		data[highi] = holder;
		highi--;
	    }
	}
	if (data[lowi] < pivot){
	    int holder = data[lowi++];
	    data[lowi++] = pivot;
	    data[high] = holder;
	    pivotindex = lowi++;
	}
	if (pivotindex == k){
	    return pivot;
	}
	else {
	    if (pivotindex < k){
		select(
    }

    public int partition(){
	int index = partition(3, 0, data.length-1);
	return index;
    }

    public String toString(){
	return Arrays.toString(data);
    }

    // Main
    public static void main(String[] args){
	int[] test = new int[]{5, 4, 1, 97, 24, 948, 14, 2, 13, 21, 69, 74};
	Selection s = new Selection(test);
	System.out.println(s);
	int index = s.partition();
	System.out.println(index);
    }

}
