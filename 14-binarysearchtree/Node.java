public class Node {

    private Integer data;
    private Node left,right,parent;
    private int children = 0;
    // just for dummy
    private Node next;
    
    public Node(Integer data){
        setData(data);
    }

    public Node(Integer data, Node left, Node right){
	setData(data);
	setLeft(left);
	setRight(right);
    }

    public void setData(Integer data){
	this.data = data;
    }

    public Integer getData(){
	return data;
    }

    public void setLeft(Node left){
	this.left = left;
	left.setParent(this);
    }

    public Node getLeft(){
	return left;
    }

    public void setRight(Node right){
	this.right = right;
	right.setParent(this);
    }

    public Node getRight(){
	return right;
    }

    public void setParent(Node parent){
	this.parent = parent;
    }

    public Node getParent(){
	return parent;
    }

    public void setChildren(){
	if (right != null)
	    children++;
	else if (left != null)
	    children++;
    }

    public int getChildren(){
	return children;
    }

    /* for dummy only */
    public void setNext(Node next){
	this.next = next;
    }

    public String toString(){
	return ""+data;
    }

}
