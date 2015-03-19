public class LList {

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
	l = new Node(-1);
    }

    public void checkIndex(int i){
	if (i > len || i < 0)
	    throw new IndexOutOfBoundsException();
    }

    public void add(int d){
        Node tmp = new Node(d);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len++;
    }

    public int get(int i){
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

    public void add(int i, int d){
	checkIndex(i);
	Node insertion = new Node(d);
	Node previous = l;
	for (int index = 0; index < i; index++){
	    previous = previous.getNext();
	}
	Node after = previous.getNext();
	previous.setNext(insertion);
	insertion.setNext(after);
	len++;
    }

    public int remove(int i){
        checkIndex(i);
        Node placeholder = l;
	for (int index = 0; index < i; index++)
	    placeholder = placeholder.getNext();
	int d = placeholder.getNext().getData();
	placeholder.setNext( placeholder.getNext().getNext() );
	len--;
	return d;
    }

    public boolean removeFirstOccur(int data){
	int i = 0;
	int index = -1;
	Node placeholder = l.getNext();
	for ( ; i < len; i++){
	    if (placeholder.getData() == data){
		index = i;
		remove(index);
		break;
	    }
	    else
		placeholder = placeholder.getNext();
	}
	if (index != -1)
	    return true;
	else
	    return false;
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
