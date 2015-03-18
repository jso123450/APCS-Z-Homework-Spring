public class LList {

    // empty list has a dummy node (kept at the start of the linked list)
    // dummy node does not correspond to any index
    // 0 based indexing starts at the node after the dummy
    // keep track of length in an instance var
    // add(String) -> still adds at the front
    // add(index, String) -> adds Node with String at index
    // find -> get
    // remove(index) -> removes & returns node at specified index

    // l is the Node at the start of the linked list
    private Node l;
    private int len = 0;

    public LList(){
	l = new Node("");
    }

    public void checkIndex(int i){
	if (i > len || i < 0)
	    throw new IndexOutOfBoundsException();
    }

    public void add(String s){
        Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len++;
    }

    public String get(int i){
	checkIndex(i);
	Node placeholder;
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

    public void add(int i, String s){
	checkIndex(i);
	Node insertion = new Node(s);
	Node previous = l;
	for (int index = 0; index < i; index++){
	    previous = previous.getNext();
	}
	Node after = previous.getNext();
	previous.setNext(insertion);
	insertion.setNext(after);
	len++;
    }

    public String remove(int i){
        checkIndex(i);
        Node placeholder = l;
	for (int index = 0; index < i; index++)
	    placeholder = placeholder.getNext();
	String s = placeholder.getNext().getData();
	placeholder.setNext( placeholder.getNext().getNext() );
	len--;
	return s;
    }

    public int getLen(){
	return len;
    } 

    public String toString(){
	String s = "";
	Node tmp;
	for (tmp = l; tmp != null; tmp = tmp.getNext())
	    s = s + tmp + " --> ";
	s = s + "null";
	return s;
    }

}
