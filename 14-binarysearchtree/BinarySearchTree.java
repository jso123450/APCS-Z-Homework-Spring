public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root){
	this.root = root;
    }

    public Node search(Integer i){
	Node n = root;
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

    public void insert(Node n){
	if (root == null)
	    root = n;
	// insert as new leaf
	Node iter = root;
	Node piggybacker = iter;
	while (iter != null){
	    piggybacker = iter;
	    if (iter.getData() < n.getData())
		iter = iter.getLeft();
	    else if (iter.getData() > n.getData())
		iter = iter.getRight();
	}
	    
    }

}
