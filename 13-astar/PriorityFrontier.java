public class PriorityFrontier extends Frontier {

    public void add(MazeNode n, int which){
	//System.out.println(l.size());
	//System.out.println(n.getManhattanPriority());
	if (l.size() == 0){
	    l.addFirst(n);
	    //System.out.println(l.size());
	}
	else if (l.size() > 0){
	    for (int i = 0; i < l.size(); i++){
		//System.out.println("hello");
		MazeNode y = l.get(i);
		//System.out.println(y.getManhattanPriority());
		if (which == 0){
		    //System.out.println("ehello");
		    if (n.getEuclidPriority() <= y.getEuclidPriority()){
			//System.out.println("e");
			if (i == 0)
			    l.addFirst(n);
			else
			    l.add(i,n);
			//System.out.println("e2");
			return;
		    }
		}
		else if (which == 1){
		    //System.out.println("mhello");
		    //System.out.println("n " +  n.getManhattanPriority());
		    //System.out.println("y " + y.getManhattanPriority());
		    if (n.getManhattanPriority() <= y.getManhattanPriority()){
			//System.out.println("m");
			if (i == 0)
			    l.addFirst(n);
			else
			    l.add(i,n);
			//System.out.println("m2");
			return;
		    }
		}
		else if (which == 2){
		    if (n.getASTARPriority() <= y.getASTARPriority()){
			if (i == 0)
			    l.addFirst(n);
			else
			    l.add(i,n);
			return;
		    }
		}
	    }
	}
    }

    /*
    public void add(MazeNode n, int which){
	if (l.size() == 0)
	    l.add(n);
	else {
	    if (which == 0)
		if (n.getEuclidPriority() < l.get(0).getEuclidPriority()){
		    this.remove();
		    l.add(n);
		}
	    if (which == 1)
		if (n.getManhattanPriority() < l.get(0).getManhattanPriority()){
		    this.remove();
		    l.add(n);
		}
	}
    }
    */

    public String toStringManhattan(){
	String s = "";
	for (int i = 0; i < l.size(); i++){
	    MazeNode y = l.get(i);
	    s+= y.getManhattanPriority() + ", ";
	}
	return s;
    }

    // remove is the same

}
