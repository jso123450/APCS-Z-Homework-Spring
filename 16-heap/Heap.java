public class Heap {

    /* ------------------------ SETUP ------------------------ */

    private Node root;
    private ArrayList<Node> a;

    public Heap(Node root){
	setRoot(root);
	a = new ArrayList<Integer>();
	a.add(root);
    }

    public void setRoot(Node root){
	this.root = root;;
    }

    public Integer getRoot(){
	return root.getData();
    }

    /* ------------------------ HEAP STUFF ------------------------ */

    public void pushDown(){

    }

    public void sort(){

    }

}
