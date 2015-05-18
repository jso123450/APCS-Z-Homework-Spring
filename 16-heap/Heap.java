// with much thanks/courtesy to Leon Cheng !!

import java.util.*;
import java.io.*;

public class Heap {

    /* ------------------------ SETUP ------------------------ */

    private ArrayList<Integer> data;

    public Heap(){
	data = new ArrayList<Integer>();
    }

    /* ------------------------ HEAP STUFF ------------------------ */

    public void insert(int n){
	data.add(n);
	siftUp(n);
    }

    public void siftUp(int x){
	int tmp = data.indexOf(x);
	int parentI = tmp/2;
	while (data.get(parentI)>data.get(tmp)){
	    int holder = data.get(parentI);
	    data.set(parentI,data.get(tmp));
	    data.set(tmp,holder);
	    tmp = parentI;
	    parentI = parentI/2;
	}
    }

    public int removeMin(){
	int output = data.get(0);
	int n = data.remove(data.size()-1);
	data.set(0,n);
	pushDown(n);
	return output;
    }

    public void pushDown(int n){
	int holder = data.indexOf(n);
	int leftChildIndex = holder*2;
	int rightChildIndex = holder*2+1;
	while(leftChildIndex<data.size() && rightChildIndex<data.size() &&
	      (data.get(holder)>data.get(leftChildIndex) || data.get(holder)>data.get(rightChildIndex))){
	    if (data.get(leftChildIndex)<data.get(rightChildIndex)){
		int tmp = data.get(holder);
		data.set(holder,data.get(leftChildIndex));
		data.set(leftChildIndex,tmp);
		holder = leftChildIndex;
	    }
	    else{
		int tmp = data.get(holder);
		data.set(holder,data.get(rightChildIndex));
		data.set(rightChildIndex,tmp);
		holder = rightChildIndex;
	    }
	    leftChildIndex = holder*2;
	    rightChildIndex = holder*2+1;
	}
    }

    public String toString(){
	return data+"";
    }

    public void sort(){
	sort(data);
    }

    public void sort(ArrayList<Integer> intAL){
	for (int i = intAL.size()-1; i>=0; i--)
	    pushDown(intAL.get(i));
    }

    /* ------------------------ MAIN ------------------------ */
    public static void main(String[] args){
	Heap h = new Heap();
	h.insert(5);
	h.insert(1337);
	h.insert(3051);
	h.insert(210321);
	h.insert(1203);
	h.insert(120);
	System.out.println(h);
	h.removeMin();
	System.out.println(h);
	h.sort();
	System.out.println(h);
    }
	

}
