public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root){
	setRoot(root);
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

    /*
    public String toString(){
	Node r = root;
	if (r == null)
	    return "r" + r;
	String s = "R"+r;
	int spacing = 0;
	s+= "\n";
	if (r.getLeft() != null)
	    s+= traverse(r.getLeft());
	if (r.getRight() != null)
	    s+= traverse(r.getRight());
	return s;
    }

    public String traverse(Node n, int spacing){
	if (n == null)
	    return n.toString();
	String s = "";
	for (int i = 0; i < spacing; i++)
	    s+= " ";
	s+= n + "\n";
	if (n.getLeft() != null)
	    s+= "l" + traverse(n.getLeft(),spacing+1);
	if (n.getRight() != null)
	    s+= "r" + traverse(n.getRight(),spacing+1);
	return s;
    }
    */
    
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
	System.out.println(bst.getRoot().getRight().getData());
	bst.insert(3);
	System.out.println(bst.getRoot().getLeft().getData());
	System.out.println(bst.search(3) + " should equal " + bst.getRoot().getLeft());
	System.out.println(bst.recSearch(3) + " should equal " + bst.getRoot().getLeft());
	bst.insert(4);
	bst.insert(6);
	System.out.println(bst.getRoot().getLeft().getRight().getData());
	System.out.println(bst.getRoot().getRight().getLeft().getData());
	System.out.println(bst);
	bst.insert(9);
	bst.insert(1);
	bst.insert(2);
	bst.insert(8);
	System.out.println(bst);
    }

}
