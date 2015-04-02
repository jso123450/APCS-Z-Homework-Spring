import java.util.*;

public class myQueue {

    private MazeNode head;
    private MazeNode tail;
    private int size;

    public myQueue(){
	head = new MazeNode();
	tail = head;
	size = 0;
    }

    public void enqueue(int x, int y, int[] bounds){
	if (x < bounds[0] && x > 0 && y < bounds[1] && y > 0){
	    MazeNode tmp = new MazeNode(x,y);
	    if (size == 0){
		head = tmp;
		tail = tmp;
	    }
	    else {
		tail.setNext(tmp);
		tail = tmp;
	    }
	    size++;
	}
    }


    public int[] dequeue(){
	if (empty())
	    throw new NoSuchElementException();
	int[] coor = head.getData();
	if (head == tail){
	    head.setData(null, null);
	    tail.setData(null, null);
	}
	else
	    head = head.getNext();
	size--;
	return coor;
    }

    public boolean empty(){
	return ((head == tail) && (head.getData() == null));
    }

    public int[] head(){
	if (empty())
	    throw new NoSuchElementException();
	int[] coor = head.getData();
	return coor;
    }

    public int size(){
        return size;
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
 
