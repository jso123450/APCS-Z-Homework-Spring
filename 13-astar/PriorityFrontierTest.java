public class PriorityFrontierTest {

    private static PriorityFrontier pf;

    public PriorityFrontierTest(){
	pf = new PriorityFrontier();
    }

    public void addtoPF(MazeNode n, int which){
	pf.add(n,which);
    }

    public PriorityFrontier getPF(){
	return pf;
    }

    public static void main(String[] args){
	PriorityFrontierTest pft = new PriorityFrontierTest();
	int cx = 1;
	int cy = 1;
	pft.addtoPF(new MazeNode(cx,cy,26,18),1);
	while (!(pft.getPF().isEmpty())){
	    MazeNode current = pf.remove();
	    cx = current.getX();
	    cy = current.getY();
	    if (cx == 26 && cy == 18)
		break;
	    pft.addtoPF(new MazeNode(cx,cy+1,26,18),1);
	    pft.addtoPF(new MazeNode(cx+1,cy,26,18),1);
	    pft.addtoPF(new MazeNode(cx,cy-1,26,18),1);
	    pft.addtoPF(new MazeNode(cx-1,cy,26,18),1);
	}
	System.out.println(pft.getPF().toStringManhattan());
    }

}
