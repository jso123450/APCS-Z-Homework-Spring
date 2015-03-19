public class LLiterator{

    private Node l;

    public LLiterator(Node n){
	l = n.getNext();
    }

    public boolean hasNext(){
	return l != null;
    }

    /*
      move to the next node
      returns the value in original node
    */
    public int next(){
	int data = l.getData();
	l = l.getNext();
	return s;
    }


}
