import java.lang.Integer;

public class Tree {

    /* -------------------------- SETUP -------------------------- */

    private Node dummy = new Node(Integer.MIN_VALUE);
    private Node root;

    public Tree(Node root){
	setRoot(root);
	dummy.setNext(root);
    }

    public Node getRoot(){
	return root;
    }

    public void setRoot(Node root){
	this.root = root;
    }

    /* -------------------------- LOOPING -------------------------- */

    public int nodecount(){
	return nodecount(root);
    }

    public int nodecount(Node T){
	if (T == null)
	    return 0;
	else
	    return 1 + nodecount(T.getLeft()) + nodecount(T.getRight());
    }

    public int maxValue(){}
    public int maxValue(Node T){}

    public int height(){}
    public int height(Node T){}
    
    public int longest(){}
    public int longest(Node T){}

    public int splitDupes(){}
    public int splitDupes(Node T){}

    public Node search(int i){
	Node output = search(root,i);
	return output;
    }

    public Node search(Node T, int i){
	Node n = T;
	if (n == null || n.getData() == i)
	    return n;
	else {
	    search(n.getLeft());
	    search(n.getRight());
	}
	return null;
    }

    public void insert(int i, String LorR){
	Node r = root;
	insert(r,i,LorR);
    }

    public void insert(Node T, int i, String LorR){
	Node insertion = new Node(i);
	if (T == null)
	    T = insertion;
	else {
	    if (LorR.equals("L"))
		T.setLeft(insertion);
	    else if (LorR.equals("R"))
		T.setRight(insertion);
	}
    }

    public void remove(Node T){
	Node TL = T.getParent();
	if (T.getChildren() == 0){
	    if (TL.getRight() == T)
		TL.setRight(null);
	    else if (TL.getleft() == T)
		TL.setLeft(null);
	}
	else if (T.getChildren() == 1){
	    if (TL.getRight() == T){
		if (T.getRight() != null)
		    TL.setRight(T.getRight());
		else if (TL.getLeft() != null)
		    TL.setLeft(T.getLeft());
	    }
	    else if (TL.getLeft() == T){
		if (T.getRight() != null)
		    TL.setLeft(T.getRight());
		else if (T.getLeft() != null)
		    TL.setLeft(T.getLeft());
	    }
	}
	else if (T.getChildren() == 2){
	    Node leftrightmost = T.getLeft();
	    while (leftrightmost.getRight() != null)
		leftrightmost = leftrightmost.getRight();
	    T.setData( leftrightmost.getData() );
	    leftrightmost.setData(null);
	}
    }

    public String toString(){
	Node r = root;
	return traverse(r);
    }

    public String traverse(Node n){
	if (n == null)
	    return "";
	else
	    return traverse(n.getLeft()) + n.getData() + ", " + traverse(n.getRight());
    }



}
