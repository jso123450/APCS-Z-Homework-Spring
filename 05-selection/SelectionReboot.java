import java.util.*;

public class SelectionReboot {

    private int[] data;

    public SelectionReboot(int[] input){
	data = input;
    }

    public SelectionReboot(){
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
    
    public void swap(int index1, int index2){
	int holder = data[index1];
	data[index1] = data[index2];
	data[index2] = holder;
    }

    // returns kth smallest element in an array of ints

    public int select(int k){
	int kthsmallest = select(k,0,data.length-1);
	return kthsmallest;
    }

    public int select(int k, int l, int h){
	//System.out.println(this);
	int pivotindex = (l + h)/2;
	int pivot = data[pivotindex];
	swap(pivotindex, h);
	pivotindex = h;
	int lowi = l;
	int highi = h - 1;
	//System.out.println(pivot);
	//System.out.println(lowi);
	//System.out.println(h);
	while (lowi < highi){
	    if (data[lowi] < pivot)
		lowi++;
	    else {
		swap(lowi,highi);
		highi--;
	    }
	    //System.out.println(this);
	}
	if (data[lowi] < pivot){
	    swap(lowi+1, pivotindex);
	    pivotindex = lowi+1;
	}
	else {
	    swap(lowi, pivotindex);
	    pivotindex = lowi;
	}
	//System.out.println(this);
	if (pivotindex + 1 == k)
	    return pivot;
	else {
	    if (pivotindex + 1 > k){
		int output = select(k,l,pivotindex);
		return output;
	    }
	    else {
		int output = select(k,pivotindex,h);
		return output;
	    }
	}
	//return output;
    }

    public String toString(){
	return Arrays.toString(data);
    }

    /*----------------------------- MAIN -----------------------------*/ 

    public static void main(String[] args){
	int[] test = new int[]{5, 4, 1, 97, 24, 948, 14, 2, 13, 21, 69, 74};
	SelectionReboot sR = new SelectionReboot(test);
	System.out.println(sR);
	int fourthSmallest = sR.select(4); // should return 5; YES
	System.out.println(sR);
	System.out.println(fourthSmallest);
    }


}
