import java.io.*; 
import java.util.*;

public class LList<E> implements Iterable<E> {

    // empty list has a dummy node (kept at the start of the linked list)
    // dummy node does not correspond to any index
    // 0 based indexing starts at the node after the dummy
    // keeps track of length in an instance var
    // add(String) -> still adds at the front
    // add(index, String) -> adds Node with String at index
    // find -> get
    // remove(index) -> removes & returns node at specified index
    // removeFirstOccur(int) -> removes the first node in the list with value int

    // l is the Node at the start of the linked list
    private Node l;
    private int len = 0;

    public LList(){
	l = new Node<E>();
    }

    public void checkIndex(int i){
	if (i > len || i < 0)
	    throw new IndexOutOfBoundsException();
    }

    public Iterator<E> iterator(){
	LLiterator<E> llit = new LLiterator<E>(l.getNext());
	return llit;
    }

    public void add(E d){
        Node<E> tmp = new Node<E>(d);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len++;
    }

    public E get(int i){
	checkIndex(i);
	Node<E> placeholder;
	if (i > 0){
	    placeholder = l;
	    int index = 0;
	    while (placeholder != null && index < i){
		placeholder = placeholder.getNext();
		index++;
	    }
	}
	// if finding the "zeroth" node; return the node after the dummy
	else
	    placeholder = l.getNext();
	return placeholder.getData();
    }

    public void add(int i, E d){
	checkIndex(i);
	Node<E> insertion = new Node<E>(d);
	Node<E> previous = l;
	for (int index = 0; index < i; index++){
	    previous = previous.getNext();
	}
	Node<E> after = previous.getNext();
	previous.setNext(insertion);
	insertion.setNext(after);
	len++;
    }

    public E remove(int i){
        checkIndex(i);
        Node<E> placeholder = l;
	for (int index = 0; index < i; index++)
	    placeholder = placeholder.getNext();
	E d = placeholder.getNext().getData();
	placeholder.setNext( placeholder.getNext().getNext() );
	len--;
	return d;
    }

    public boolean removeFirstOccurr(E data){
	int i = 0;
	Node<E> placeholder = l.getNext();
	for ( ; i < len; i++){
	    if (placeholder.getData() == data){
		remove(i);
		return true;
	    }
	    else
		placeholder = placeholder.getNext();
	}
	return false;
    }

    public int size(){
	return len;
    } 

    public String toString(){
	String s = "";
	Node<E> tmp;
	for (tmp = l; tmp != null; tmp = tmp.getNext())
	    s = s + tmp + " --> ";
	s = s + "null";
	return s;
    }

}
