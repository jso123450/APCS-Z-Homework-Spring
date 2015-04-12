public class NodeCoordinate {

    private int xcor;
    private int ycor;
    private NodeCoordinate next;

    public NodeCoordinate(int x, int y){
	xcor = x;
	ycor = y;
	next = null;
    }

    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }

    public void setNext(NodeCoordinate n){
	next = n;
    }

    public NodeCoordinate getNext(){
	return next;
    }

    public String toString(){
	return "(" + xcor + "," + ycor + ")";
    }

}
