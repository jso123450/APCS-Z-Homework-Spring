import java.io.*;
import java.util.*;

public class Maze {

    private char[][] board;
    private int maxX;
    private int maxY;
    private char wall = ' ';
    private char exit = '$';
    private int exitx;
    private int exity;
    private char path = '#';
    private char me = 'z';
    private char visited = '.';
    private boolean solved = false;
    private Frontier f;
    //private StackFront f;
    private PriorityFrontier pf;

    public Maze(){
	// instantiate variables
        maxX = 40;
        maxY = 20;
        board = new char[maxX][maxY];
	// read in (load) the maze
	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j = 0;
	    while (sc.hasNext()){
		String line = sc.nextLine();
		for (int i = 0; i < maxX; i++)
		    {
			board[i][j] = line.charAt(i);
			if (line.charAt(i) == '$'){
			    exitx = i;
			    exity = j;
			}
		    }
		j++;
	    }
	}
	catch (Exception e){} // do nothing
    }

    // gives a delay of n milliseconds
    public void wait(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e){} // do nothing
    }

    // print out the maze
    public String toString(){
	String s = "[2J\n";
	for (int y = 0; y < maxY; y++){
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	return s;
    }

    // a type of Path Finding
    //    known as a blind/exhaustive/depth first/linear/recursive/backtracking search
    //    this tries basically all the possibilities
    //    possible until we reach the end
    public void solve(int x, int y){
	if (board[x][y] == exit){
	    System.out.println(this);
	    solved = true;
	}
	if (board[x][y] != path || solved)
	    return;
	System.out.println(this);
	System.out.println("(" + x + "," + y + ")");
	wait(50);
        board[x][y] = me;
	solve(x+1,y);
	solve(x-1,y);
	solve(x,y+1);
	solve(x,y-1);
	if (!solved)
	    board[x][y] = visited;
    }


    // Breadth First Search
    public void addToFrontier(int x, int y, MazeNode current){
	if (board[x][y] == '#' || board[x][y] == '$'){
	    MazeNode tmp = new MazeNode(x,y);
	    tmp.setPrev(current);
	    f.add(tmp);
	}
    }

    public void bfs(int x, int y){
	f = new Frontier();
	//f = new StackFront();
	// add initial node to the frontier
	f.add(new MazeNode(x,y));
	
	board[x][y] = 'x';
	MazeNode current = null;
	int tx = 0;
	int ty = 0;
	MazeNode tmp = null;

	while (!(f.isEmpty())){
	    current = f.remove();
	    int cx = current.getX();
	    int cy = current.getY();
	    if (board[cx][cy] == exit)
		break;
	   
	    board[cx][cy] = me;

	    addToFrontier(cx+1,cy,current);
	    addToFrontier(cx-1,cy,current);
	    addToFrontier(cx,cy+1,current);
	    addToFrontier(cx,cy-1,current);

	    wait(50);
	    System.out.println(this);

	}

	// recover the path
	for (MazeNode p = current.getPrev(); p != null; p = p.getPrev()){
	    board[p.getX()][p.getY()] = 'P';
	    wait(50);
	    System.out.println(this);
	}

    }

    // Best First Search
    // when you add each node to the frontier,
    // first assign a priority and then add to the frontier
    // which is a priority queue (ordered list)

    // Maze Heuristics (which)
    // 0. distance formula (euclidean)
    // 1. Manhatttan (taxi cab) distance (deltax + deltay)
    // 2. astar

    // A*
    // priority = # steps so far + estimate to exit
    //            ^ tracked in node

    public void addToPriorityFrontier(int x, int y, MazeNode current, int which){
	if (board[x][y] == '#' || board[x][y] == '$'){
	    MazeNode tmp = new MazeNode(x,y,exitx,exity,current);
	    //System.out.println(tmp.getManhattanPriority());
	    //System.out.println(tmp.getEuclidPriority());
	    pf.add(tmp,which);
	    //System.out.println("added? " + pf.l.size());
	    //System.out.println(pf.toStringManhattan());
	}
    }

    public void bestfs(int x, int y, int which){
	pf = new PriorityFrontier();
        pf.add(new MazeNode(x,y,exitx,exity,0));
	
	board[x][y] = 'x';
	MazeNode current = null;
	int tx = 0;
	int ty = 0;
	MazeNode tmp = null;

        while (!(pf.isEmpty())){
	    current = pf.remove();
	    int cx = current.getX();
	    int cy = current.getY();
	    if (board[cx][cy] == exit)
		break;
	   
	    board[cx][cy] = me;

	    addToPriorityFrontier(cx+1,cy,current,which);
	    //System.out.println(1);
	    //System.out.println(pf);
	    addToPriorityFrontier(cx,cy+1,current,which);
	    //System.out.println(2);
	    //System.out.println(pf);
	    addToPriorityFrontier(cx-1,cy,current,which);
	    //System.out.println(3);
	    //System.out.println(pf);
	    addToPriorityFrontier(cx,cy-1,current,which);
	    //System.out.println(4);
	    //System.out.println(pf);

	    //System.out.println(pf.toStringManhattan());

	    wait(50);
	    System.out.println(this);

	}

	// recover the path
	for (MazeNode p = current.getPrev(); p != null; p = p.getPrev()){
	    board[p.getX()][p.getY()] = 'P';
	    wait(50);
	    System.out.println(this);
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	//System.out.println(m.exitx);
	//System.out.println(m.exity);
	//m.solve(1,1);
	//m.bfs(1,1);
	m.bestfs(1,1,2);
    }

}
