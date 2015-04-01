public class MazeNode{
 
    private int x, y;
    private MazeNode next;

    // no <E> in constructor
    public MazeNode(){
        x = 0;
	y = 0;
	next = null;
    }

    public MazeNode(int x, int y){
        setData(x,y);
	next = null;
    }

    public void setData(int x, int y){
	this.x = x;
	this.y = y;
    }

    public int[] getData(){
	int[] coor = new int[x,y];
	return coor;
    }

    public void setNext(MazeNode n){
	next = n;
    }

    public MazeNode getNext(){
	return next;
    }

    public String toString(){
	return "(" + x + ", " + y + ")";
    }

}
