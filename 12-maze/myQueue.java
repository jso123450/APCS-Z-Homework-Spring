import java.util.*;

public class myQueue {

    private MazeNode head;
    private MazeNode tail;

    public myQueue(){
	head = null;
	tail = head;
    }

    public void enqueue(int x1, int y1){
	MazeNode newpos = new MazeNode(x1,y1);
	if (empty()){
	    tail = newpos;
	    head = newpos;
	}
	else {
	    tail.setNext(newpos);
	    tail = newpos;
	}
    }

    public void enqueue(MazeNode newpos){
	if (empty()){
	    tail = newpos;
	    head = newpos;
	}
	else {
	    tail.setNext(newpos);
	    tail = newpos;
	}
    }

    public MazeNode dequeue(){
	if (empty())
	    throw new NoSuchElementException();
	MazeNode output = head;
	head = head.getNext();
	if (head == null)
	    tail = null;
	return output;
    }

    public boolean empty(){
	return ((head == tail) && (head == null));
    }

    public MazeNode head(){
	if (empty())
	    throw new NoSuchElementException();
        return head;
    }

    public String toString(){
	String s = "";
	MazeNode iter = head;
	while (iter != null){
	    s+= iter + " --> ";
	    iter = iter.getNext();
	}
	return s;
    }

}
 
