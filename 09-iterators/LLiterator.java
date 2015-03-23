import java.io.*; 
import java.util.*;

public class LLiterator<E> implements Iterator<E>{

    private Node<E> l;
    private Node<E> lprev;
    private boolean removeisValid = false;

    public LLiterator(Node<E> n){
	l = n;
	lprev = n;
    }

    public boolean hasNext(){
	return l != null;
    }

    /*
      move to the next node
      returns the value in original node
    */
    public E next(){
	E data = l.getData();
        removeisValid = true;
	lprev = l;
	l = l.getNext();
	return data;
    }
    
    public void remove() {
	// if next has not yet been called or remove has
	// already been called after the last call to next
	if (!(removeisValid))
	    throw new IllegalStateException();
	lprev.setNext( l.getNext() );
	//l = l.getNext();
	removeisValid = false;
    }



}
