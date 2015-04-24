public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root){
	this.root = root;
    }

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
		n = n.getRight();
	    else if (c < 0)
		n = n.getLeft();
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
	    int c = n.getData().compareTo(i);
	    if (c < 0)
		iter = iter.getLeft();
	    else if (c > 0)
		iter = iter.getRight();
	}
	if (i > piggybacker.getData())
	    piggybacker.setRight(insertion);
	else if (i < piggybacker.getData())
	    piggybacker.setLeft(insertion);
    }

}
