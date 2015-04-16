import java.util.*;

public class Frontier {

    // just because we're going to extend frontier
    public LinkedList<Node> l = new LinkedList<Node>();

    public void add(Node n){
	l.add(n);
    }
    
    public Node remove(){
        return l.remove();
    }

    public boolean isEmpty(){
	return l.isEmpty();
    }

    public String toString(){
	return Arrays.toString( l.toArray() );
    }
    
}
