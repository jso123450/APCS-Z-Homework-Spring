import java.util.*;

public class Frontier {

    // just because we're going to extend frontier
    public LinkedList<MazeNode> l = new LinkedList<MazeNode>();

    public void add(MazeNode n){
	l.add(n);
    }
    
    public MazeNode remove(){
        return l.remove();
    }

    public boolean isEmpty(){
	return l.isEmpty();
    }

    public String toString(){
	return Arrays.toString( l.toArray() );
    }
    
}
