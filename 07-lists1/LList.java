public class LList {

    // l is the Node at the start of the linked list
    private Node l = null;

    public void add(String s){
        Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
    }

    public Node find(int i){
	Node placeholder = l;
	int index = 0;
	while (index < i){
	    placeholder = placeholder.getNext();
	    index++;
	}
	return placeholder;
    }

    public void insert(int i, String s){
	Node insertion = new Node(s);
	Node after = find(i);
	if (i > 0){
	    Node previous = find(i-1);
	    previous.setNext(insertion);
	}
	insertion.setNext(after);
	if (i == 0)
	    l = insertion;
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
