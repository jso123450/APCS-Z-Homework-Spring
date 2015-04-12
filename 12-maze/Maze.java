import java.io.*;
import java.util.*;

public class Maze {

    private char[][] board;
    private int maxX;
    private int maxY;
    private char wall = ' ';
    private char exit = '$';
    private char path = '#';
    private char me = 'z';
    private char visited = '.';
    private boolean solved = false;
    private myQueue frontier;

    public Maze(){
	frontier = new myQueue();
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

    public boolean checkBounds(int x, int y){
	return (x > -1 && x < maxX && y > -1 && y < maxY);
    }

    public boolean checkPath(int x, int y){
	return ( board[x][y] == path || board[x][y] == exit );
    }

    public boolean check(int x, int y){
	if (checkBounds(x,y))
	    return ( checkPath(x,y) );
	return false;
    }

    public static String correctPath(MazeNode n){
	String s = "";
	MazeNode iter = n;
	while (iter != null){
	    s+= iter + " <-- ";
	    iter = iter.getPrev();
	}
	return s;
    }

    public void solve(int x, int y){
	frontier.enqueue(x,y);
	while (!(frontier.empty())){
	    MazeNode current = frontier.dequeue();
	    int xcor = current.getX();
	    int ycor = current.getY();
	    if (board[xcor][ycor] == exit){
		solved = true;
		System.out.println(this);
		System.out.println( "(column,row)" );
		System.out.println( "A correct path is : " );
		System.out.println( correctPath(current) );
		System.exit(0);
	    }
	    board[xcor][ycor] = me;
	    //System.out.println("frontier:" + frontier);
	    //System.out.println(frontier.empty());
	    if (check(xcor, ycor+1)){
		MazeNode mn1 = new MazeNode(xcor,ycor+1);
		mn1.setPrev(current);
		frontier.enqueue(mn1);
	    }
	    if (check(xcor+1,ycor)){
		MazeNode mn2 = new MazeNode(xcor+1,ycor);
		mn2.setPrev(current);
		frontier.enqueue(mn2);
	    }
	    if (check(xcor,ycor-1)){
		MazeNode mn3 = new MazeNode(xcor,ycor-1);
		mn3.setPrev(current);
		frontier.enqueue(mn3);
	    }
	    if (check(xcor-1,ycor)){
		MazeNode mn4 = new MazeNode(xcor-1,ycor);
		mn4.setPrev(current);
		frontier.enqueue(mn4);
	    }
	    System.out.println(this);
	    wait(50);
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(1,1);
	/*
	MazeNode mn = new MazeNode(1,1);
	MazeNode mn2 = new MazeNode(1,2);
	MazeNode mn3 = new MazeNode(1,3);
	mn2.setPrev(mn);
	mn3.setPrev(mn2);
	System.out.println( correctPath(mn3) );
	*/
    }

}

