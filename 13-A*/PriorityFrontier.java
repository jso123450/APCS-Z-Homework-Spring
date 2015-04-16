public class PriorityFrontier extends Frontier {

    public void add(Node n, int which){
	for (int i = 0; i < l.size(); i++){
	    Node y = l.get(i);
	    if (which == 0){
		if (y.getEuclidPriority() < n.getEuclidPriority())
		    l.add(i,n);
	    }
	    else {
		if (y.getManhattanPriority() < n.getManhattanPriority())
		    l.add(i,n);
	    }
	}
    }

    // remove is the same

}
