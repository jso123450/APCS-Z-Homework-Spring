public class Node {

    private Integer data;
    private Node left,right;
    
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
    }

    public Node getLeft(){
	return left;
    }

    public void setRight(Node right){
	this.right = right;
    }

    public Node getRight(){
	return right;
    }

    public String toString(){
	return ""+data;
    }

}
