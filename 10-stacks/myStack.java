public class myStack<E> {

    private Node<E> top;
    
    public myStack(){
	top = new Node<E>();
    }

    public void push(E data){
	Node<E> newTop = new Node<E>(data);
	newTop.setNext(top);
	top = newTop;
    }

    public E pop(){
	E data = top.getData();
	top = top.getNext();
	return data;
    }

    public boolean empty(){
	return top.getData() == null;
    }

    public E top(){
	return top.getData();
    }

    public String toString(){
	String s = "";
	Node<E> i = top;
	while (i.getNext() != null){
	    s+= i + " --> ";
	    i = i.getNext();
	}
	return s;
    }

}
