import java.util.*;

public class myAQueue {

    // default (or empty) value for indices is 0

    private int[] queue;
    private int head;
    private int place;

    public myAQueue(){
	queue = new int[100];
	head = 0;
	place = head;
    }

    public void valid(){
	if (empty())
	    throw new NoSuchElementException();
    }
    
    public boolean checkGrow(){
	return (place > queue.length - 1);
    }

    public void grow(){
	int[] newQ = new int[ queue.length * 2 ];
	for (int i = 0; i < queue.length; i++)
	    newQ[i] = queue[i];
	queue = newQ;
    }

    public void enqueue(int n){
	if (checkGrow())
	    grow();
	queue[place] = n;
	place++;
    }

    public int shift(){
	int[] shiftedQ = queue;
	for (int i = 1; i < queue.length; i++)
	    shiftedQ[i-1] = queue[i];
	queue = shiftedQ;
	int oldHead = queue[0];
	return oldHead;
    }

    public int dequeue(){
	valid();
	int oldHead = shift();
	place--;
	return oldHead;
    } 

    public boolean empty(){
	return ((place == head) && (place == 0));
    }

    public int head(){
	valid();
	return queue[head];
    }

    public String toString(){
	return Arrays.toString(queue);
    }
    

}
