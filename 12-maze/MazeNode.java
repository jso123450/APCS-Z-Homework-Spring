public class MazeNode {
 
    private int xcor;
    private int ycor;
    private MazeNode next;
    private MazeNode prev;

    public MazeNode(){
	xcor = -5;
	ycor = -5;
	next = null;
	prev = null;
    }

    public MazeNode(int x, int y){
        setData(x,y);
	next = null;
	prev = null;
    }

    public void setData(int x, int y){
	this.xcor = x;
	this.ycor = y;
    }

    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }

    public void setNext(MazeNode n){
	next = n;
    }

    public MazeNode getNext(){
	return next;
    }

    public void setPrev(MazeNode n){
	prev = n;
    }

    public MazeNode getPrev(){
	return prev;
    }

    public String toString(){
	return "(" + xcor + ", " + ycor + ")";
    }

}
