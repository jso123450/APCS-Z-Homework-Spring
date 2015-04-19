import java.lang.Math;

public class Node {

    private int x;
    private int y;
    private Node prev;
    // lower priority = lower distance = closer
    private double euclidPriority;
    private int manhattanPriority;

    public Node(int x, int y){
	this.x = x;
	this.y = y;
	euclidPriority = 9001.9001;
	manhattanPriority = 9001;
    }
    
    public Node(int x, int y, int exitx, int exity){
	this.x = x;
	this.y = y;
	// not sure what default would be
        setEuclidPriority(exitx,exity);
	setManhattanPriority(exitx,exity);
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setPrev(Node p){
	prev = p;
    }

    public Node getPrev(){
	return prev;
    }

    public void setEuclidPriority(int exitx, int exity){
	euclidPriority = Math.sqrt( (exitx - x)^2 + (exity - y)^2  );
    }
    
    public double getEuclidPriority(){
	return euclidPriority;
    }

    public void setManhattanPriority(int exitx, int exity){
	manhattanPriority = Math.abs(exitx - x) + Math.abs(exity - y);
    }

    public int getManhattanPriority(){
	return manhattanPriority;
    }
    
}
