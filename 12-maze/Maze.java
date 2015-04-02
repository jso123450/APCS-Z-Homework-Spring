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
	return (x > 0 && x < maxX && y > 0 && y < maxY);
    }

    public ArrayList<int[]> adjacent(int x, int y){
	ArrayList<int[]> adjacentSpots = new ArrayList<int[]>();
	int xi = x-1;
	int yi = y-1;
	while (xi < x+1){
	    int[] coor = new int[]{xi,y};
	    if (checkBounds(xi, y))
		adjacentSpots.add(coor);
	    xi++;
	}
	while (yi < y+1){
	    int[] coor = new int[]{x,yi};
	    if (checkBounds(x,yi))
		adjacentSpots.add(coor);
	    yi++;
	}
	return adjacentSpots;
    }

    public String printAdjacent(int x, int y){
	String adjacent = "[";
	ArrayList<int[]> adjacentSpots = adjacent(x,y);
	for (int i = 0; i < adjacentSpots.size(); i++){
	    adjacent+= "(" + adjacentSpots.get(i)[0] + "," + adjacentSpots.get(i)[1];
	    if (i != adjacentSpots.size() - 1)
		adjacent+= ") ";
	    else
		adjacent+= ")";
	}
	adjacent+= "]";
	return adjacent;
    }

    /*
    public void solve(int x, int y){
	int[] bounds = new int[]{maxX, maxY};
	myQueue frontier = new myQueue();
	frontier.enqueue(x,y,bounds);
	board[x][y] = '.';
	MazeNode current = new MazeNode(x,y);
	while (!(frontier.empty())){
	    int[] coor = frontier.dequeue();
	    current = new MazeNode(coor[0],coor[1]);
	    
	}
    }
    */

    public static void main(String[] args){
	Maze m = new Maze();
	//System.out.println(m);
	//m.solve(1,1);
	ArrayList<int[]> test = m.adjacent(1,1);
        String t = m.printAdjacent(1,1);
	System.out.println(t);
    }

}

