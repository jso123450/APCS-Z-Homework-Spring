import java.lang.Math;

public class MazeNode {

    private int x;
    private int y;
    private MazeNode prev;
    // lower priority = lower distance = closer
    private double euclidPriority;
    private int manhattanPriority;
    private int steps;
    private int astarPriority;

    public MazeNode(int x, int y){
	this.x = x;
	this.y = y;
	// arbitrary default
	euclidPriority = 9001.9001;
	manhattanPriority = 9001;
    }

    public MazeNode(int x, int y, int exitx, int exity){
	this.x = x;
	this.y = y;
        setEuclidPriority(exitx,exity);
	setManhattanPriority(exitx,exity);
    }
    
    public MazeNode(int x, int y, int exitx, int exity, int steps){
        this(x,y,exitx,exity);
	this.steps = steps;
    }

    public MazeNode(int x, int y, int exitx, int exity, MazeNode prev){
	this(x,y,exitx,exity);
	this.prev = prev;
	this.steps = prev.getSteps() + 1;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setPrev(MazeNode p){
	prev = p;
    }

    public MazeNode getPrev(){
	return prev;
    }

    public void setSteps(int s){
	steps = s;
    }

    public int getSteps(){
	return steps;
    }

    public void setASTARPriority(){
	astarPriority = steps + manhattanPriority;
    }

    public int getASTARPriority(){
	return astarPriority;
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
