public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root){
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
    
    // assuming no other nodes with int i already in tree
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
	    if (c < 0)
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

    // within its own tree
    public Node recSearch(int i){
	Node r = root;
	r = recSearch(r,i);
	return r;
    }

    public Node recSearch(Node t, int i){
	if (t == null)
	    return null;
	else {
	    int c = t.getData().compareTo(i);
	    if (c == 0)
		return t;
	    else if (c < 0)
		t = t.getRight();
	    else if (c > 0)
		t = t.getLeft();
	    this.recSearch(t,i);
	}
	return null;
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


}
