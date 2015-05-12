import java.lang.Integer;
import java.lang.Math;
import java.util.Random;
// tree is not sorted

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

    public int max3(int a, int b, int c){
	return Math.max(Math.max(a,b), c);
    }

    public int maxValue(){
	return maxValue(root);
    }

    public int maxValue(Node T){
	int max = Integer.MIN_VALUE;
	if (T == null)
	    return max;
	else
	    return maxValue(T,max);
    }

    public int maxValue(Node T, int max){
	if (T == null)
	    return max;
	if (T.getData() > max){
	    max = T.getData();
	    max = maxValue(T.getLeft(),max);
	    max = maxValue(T.getRight(),max);
	}
	return max;
    }

    public int height(){
	return height(root);
    }

    public int height(Node T){
	if (T == null)
	    return 0;
	else {
	    int h1 = 1 + height(T.getLeft());
	    int h2 = 1 + height(T.getRight());
	    return Math.max(h1,h2);
	}
    }

    public void splitDupes(){
	splitDupes(root);
    }

    public void splitDupes(Node T){
	if (T == null || T.getChildren() == 0)
	    return;
	else if (T.getLeft() != null && T.getLeft().getData() == T.getData()){
	    Node insertion = new Node(T.getData() - 1);
	    insertion.setLeft(T.getLeft());
	    T.setLeft(insertion);
	}
	else if (T.getRight() != null && T.getRight().getData() == T.getData()){
	    Node insertion = new Node(T.getData() - 1);
	    insertion.setRight(T.getRight());
	    T.setRight(insertion);
	}
	else {
	    splitDupes(T.getLeft());
	    splitDupes(T.getRight());
	}
    }

    public int diameter(){
	return diameter(root);
    }

    public int diameter(Node T){
	if (T == null)
	    return 0;
	else {
	    int path1 = height(T.getLeft()) + height(T.getRight()) + 2;
	    int path2 = diameter(T.getLeft());
	    int path3 = diameter(T.getRight());
	    return max3(path1,path2,path3);
        }
    }

    public Node search(int i){
	Node output = search(root,i);
	return output;
    }

    public Node search(Node T, int i){
	Node n = T;
	if (n == null || n.getData() == i)
	    return n;
	else {
	    search(n.getLeft(),i);
	    search(n.getRight(),i);
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
	    if (T.getLeft() == null && LorR.equals("L"))
		T.setLeft(insertion);
	    else if (T.getRight() == null && LorR.equals("R"))
		T.setRight(insertion);
	    else {
		Random r = new Random();
		int which = r.nextInt(2);
		if (which == 0)
		    insert(T.getLeft(),i,LorR);
		else
		    insert(T.getRight(),i,LorR);
	    }
	}
    }

    // inserts new Node(i) after Node n
    public void insertNext(Node n, int i, String LorR){
	Node insertion = new Node(i);
	if (n == null)
	    n = insertion;
	else {
	    if (LorR.equals("L") && n.getLeft() == null)
		n.setLeft(insertion);
	    else if (LorR.equals("R") && n.getRight() == null)
		n.setRight(insertion);
	}
    }

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

    /* -------------------------- MAIN  -------------------------- */

    public static void main(String[] args){
	Tree T = new Tree(new Node(5));
	T.insert(7,"L");
	T.insert(13,"R");
	T.insert(T.getRoot().getLeft(),9,"R");
	T.insertNext(T.getRoot().getLeft().getRight(),9,"R");
	T.insertNext(T.getRoot().getRight(),15,"R");
	System.out.println(T);
	System.out.println(T.getRoot().getLeft().getRight());
	System.out.println(T.getRoot().getLeft().getRight().getRight());
	System.out.println(T.maxValue());
	System.out.println(T.height());
	T.splitDupes();
	System.out.println(T);
	System.out.println(T.diameter());
    }


}
