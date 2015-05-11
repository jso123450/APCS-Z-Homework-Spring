import java.util.*;
import java.lang.Integer;

public class BinarySearchTree {

    /* -------------------------- SETUP -------------------------- */

    private Node dummy = new Node(Integer.MIN_VALUE);
    private Node root;

    public BinarySearchTree(Node root){
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

    // within itself
    public Node search(int i){
        Node output = search(root,i);
	return output;
    }

    //for others...?
    public Node search(Node t, int i){
	Node n = t;
	while (n != null){
	    int c = n.getData().compareTo(i);
	    if (c > 0)
		n = n.getLeft();
	    else if (c < 0)
		n = n.getRight();
	    else
		return n;
	}
	return null;
    }
    
    // within itself
    public void insert(int i){
	insert(root,i);
    }
    
    public void insert(Node t, int i){
	Node insertion = new Node(i);
	if (t == null)
	    t = insertion;
	// insert as new leaf
	Node iter = t;
	Node piggybacker = null;
	while (iter != null){
	    piggybacker = iter;
	    int c = t.getData().compareTo(i);
	    if (c == 0)
		return; // assume unique values in tree
	    else if (c < 0)
		iter = iter.getRight();
	    else if (c > 0)
		iter = iter.getLeft();
	}
	if (i > piggybacker.getData())
	    piggybacker.setRight(insertion);
	else if (i < piggybacker.getData())
	    piggybacker.setLeft(insertion);
    }

    /* -------------------------- RECURSIVE -------------------------- */

    public int nodecount(){
	return nodecount(root);
    }

    public int nodecount(Node T){
	if (T == null)                   // if null return 0
	    return 0;
	else                                // 1 + branch going left + branch going right
	    return 1 + nodecount(T.getLeft()) + nodecount(T.getRight());
    }

    // within its own tree
    public Node recSearch(int i){
	Node r = root;
	r = recSearch(r,i);
	return r;
    }

    public Node recSearch(Node t, int i){
	if (t == null || t.getData() == i)
	    return t;
	else if (i < t.getData())
	    return recSearch(t.getLeft(),i);
	else if (i > t.getData())
	    return recSearch(t.getRight(),i);
	return null;
    }

    public void recInsert(int i){
	Node r = root;
	recInsert(r,i);
    }

    public void recInsert(Node t, int i){
	Node insertion = new Node(i);
	if (t == null){
	    t = insertion;
	}
	else {
	    int c = t.getData().compareTo(i);
	    if (c > 0){
		if (t.getLeft() == null){
		    t.setLeft(insertion);
		    return;
		}
		else
		    t = t.getLeft();
	    }
	    else if (c < 0){
		if (t.getRight() == null){
		    t.setRight(insertion);
		    return;
		}
		else
		    t = t.getRight();
	    }
	    this.recInsert(t,i);
	}
    }

    /* removing
       1. get a pointer to the node (T) to delete and its parent (TL)
       ( same thing as the second part of insert but you stop @ the node to delete )
          a) T is a leaf
	       point TL's left/right to null
          b) T has one child
	       point TL's left or right to T's only child
	  c) T has two children
	       1) find the largest in the left subtree (or smallest in the right)
	          L = T.getLeft();
		  while (L.getRight() != null)
		     L = L.getRight();
		  (& vice versa for smallest on right)
		  copy the data from L into T
		  remove L.getData() from T.getLeft()
     */

    public void remove(Node T){
	Node TL = T.getParent();
	if (T.getChildren() == 0){
	    if (TL.getRight() == T)
		TL.setRight(null);
	    else if (TL.getLeft() == T)
		TL.setLeft(null);
	}
	else if (T.getChildren() == 1){
	    if (TL.getRight() == T){
		if (T.getRight() != null)
		    TL.setRight(T.getRight());
		else if (T.getLeft() != null)
		    TL.setLeft(T.getLeft());
	    }
	    else if (TL.getLeft() == T){
		if (T.getRight() != null)
		    TL.setLeft(T.getRight());
		if (T.getLeft() != null)
		    TL.setLeft(T.getLeft());
	    }
	}
	else if (T.getChildren() == 2){
	    Node leftBiggest = T.getLeft();
	    while (leftBiggest.getRight() != null)
		leftBiggest = leftBiggest.getRight();
	    T.setData( leftBiggest.getData() );
	    leftBiggest.setData(null);
	}
    }
 
    public String toString(){
	Node r = root;
	return traverse(r);
    }

    public String traverse(Node n){
	if (n == null)
	    return "";
	else // puts it in ascending order bcuz left -> n -> right
	    return traverse(n.getLeft()) + n.getData() + ", " + traverse(n.getRight());
    }

    /* -------------------------- MAIN -------------------------- */

    public static void main(String[] args){
	BinarySearchTree bst = new BinarySearchTree(new Node(5));
	bst.insert(7);
	bst.insert(20);
	bst.insert(10);
	bst.insert(30);
	bst.insert(50);
	bst.insert(41);
	bst.insert(61);
	bst.insert(60);
	bst.insert(63);
	bst.insert(45);
	bst.insert(67);
	System.out.println(bst);
	System.out.println(bst.nodecount());
    }

}
