import java.util.*;

public class Merge{

    private ArrayList<Integer> data = new ArrayList<Integer>();

    public Merge(ArrayList<Integer> input){
	data = input;
    }

    public ArrayList<Integer> merge(ArrayList<Integer> stuff, ArrayList<Integer> stuff2){
	ArrayList<Integer> newData = new ArrayList<Integer>();
	int i = 0;
	int i2 = 0;
	while (i + i2 < stuff.size() + stuff2.size()){
	    if (stuff.get(i) < stuff2.get(i2)){
		newData.add( stuff.get(i) );
		i++;
	    }
	    if (stuff2.get(i2) < stuff.get(i)){
		newData.add( stuff2.get(i2) );
		i2++;
	    }
	}
	data = newData;
	return data;
    }

    public static void main(String[] args){

    }

}
