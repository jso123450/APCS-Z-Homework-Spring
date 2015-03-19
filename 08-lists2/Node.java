public class Node {

    private int data;
    private Node next;

    public Node(){
	this(-1);
    }

    public Node(int d){
	data = d;
	next = null;
    }

    public void setData(int d){
	data = d;
    }

    public int getData(){
	return data;
    }

    public void setNext(Node n){
	next = n;
    }

    public Node getNext(){
	return next;
    }

    public String toString(){
	return data + "";
    }

    public void getRest(){
	for (Node tmp = this; tmp != null; tmp = tmp.getNext())
	    System.out.println(tmp);
    }
}
 
