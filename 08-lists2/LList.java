public class LList {

    // empty list has a dummy node
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

    public void add(String s){
        Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len++;
    }

    public Node get(int i){
	Node placeholder = l;
	int index = 0;
	while (placeholder != null && index < i + 1){
	    placeholder = placeholder.getNext();
	    index++;
	}
	return placeholder;
    }

    public void add(int i, String s){
	Node insertion = new Node(s);
	int index = i+1;
	Node after = get(index);
	if (index > 1){
	    Node previous = get(index-1);
	    previous.setNext(insertion);
	}
	insertion.setNext(after);
	if (index == 0)
	    l = insertion;
	len++;
    }

    public Node remove(int i){
	if (i > len)
	    throw new IndexOutOfBoundsException();
	Node placeholder = get(i);
	Node previous = get(i-1);
	Node after = get(i+1);
	previous.setNext(after);
	return placeholder;
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
