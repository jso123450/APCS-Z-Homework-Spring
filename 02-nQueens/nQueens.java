import java.util.*;
import java.lang.Math;

public class nQueens {

    private char[][] board;
    private char queen = 'Q';
    private char space = '.';
    private int num; // num = (target) n Queens

    public nQueens(int n){
	num = n;
	board = new char[num][num];
	for (int r = 0; r < num; r++){
	    for (int c = 0; c < num; c++)
		board[r][c] = space;
	}
    }

    public String toString(){
	//String s = "^[[2J\n";
	String s = "";
	for (int r = 0; r < num; r++){
	    for (int c = 0; c < num; c++)
		s+= board[r][c] + " ";
	    s+= "\n";
	}
	return s;
    }

    public boolean check(int row, int col){
	int r;
	int c;
	// check everything up to the left
	for (c = 0; c < col; c++){
	    if (board[row][c] == queen)
		return false;
	}
	// check left diagonals
	for (r = row, c = col; c >= 0 && r < num; r++, c--){
	    if (board[r][c] == queen)
		return false;
	}
	for (r = row, c = col; r >= 0 && c >= 0; r--, c--){
	    if (board[r][c] == queen)
		return false;
	}
	// if nothing, then the position is safe
	return true;
    }

    public boolean solve(int col){
	// col # essentially is queen #
	if (col == num)
	    return true;
	// loops to check for a valid position
	for (int row = 0; row < num; row++){
	    if (check(row,col)){
		board[row][col] = queen;
		System.out.println(this);
		// recursively calls solve on the next column
		if (solve(col+1))
		    return true;
		// if the above doesnt return true
		// then it's not the solution
		// and we need to go back
		board[row][col] = space;
	    }
	}
	// if there are no valid positions
	// in this column then return false
	return false;
    }

    public void solve(){
	// prints out a solution if there is one
	if (solve(0)){
	    System.out.println("A Solution:");
	    System.out.println(this);
	}
	else
	    System.out.println("No Possible Solutions For A : " + num + "x" + num + " Board");
    }

    public static void main(String[] args){
	nQueens nQ2 = new nQueens(2);
	System.out.println(nQ2);
	nQ2.solve();
	System.out.println();
	nQueens nQ3 = new nQueens(3);
	System.out.println(nQ3);
	nQ3.solve();
	System.out.println();
	nQueens nQ4 = new nQueens(4);
	System.out.println(nQ4);
	nQ4.solve();
	System.out.println();
	/*
	nQueens nQ8 = new nQueens(8);
	System.out.println(nQ8);
	nQ8.solve();
	*/
    }
    
}
