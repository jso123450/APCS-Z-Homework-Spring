import java.lang.Math;

public class Lab{

    /* CURRENT STATUS
       - lake making (100% functional)
       - cow travelling (only setup variables & display...not sure how to do the route calculation)
     */
    
    private String input1, input2;
    private int rows, cols;
    private int[][] lake;
    private int finalElevation;
    private int numInstructions;
    private char[][] pasture;
    private int rows2, cols2;
    private int time;
    private String coords;

    public Lab(String in1, String in2){
	input1 = in1;
	setupLake(input1);
	input2 = in2;
	setupPasture(input2);
    }

    /* --------------------------------- LAKE MAKING --------------------------------- */
    public void setupLake(String input){
	String inputcopy = input;
	String firstline = inputcopy.split("\n")[0];
	int row = Integer.parseInt(firstline.split(" ")[0]);
	int col = Integer.parseInt(firstline.split(" ")[1]);
	rows = row;
	cols = col;
	lake = new int[row][col];
	finalElevation = Integer.parseInt(firstline.split(" ")[2]);
	numInstructions = Integer.parseInt(firstline.split(" ")[3]);
	genLake(input, row, col);
    }

    public void genLake(String input, int row, int col){
	String inputcopy = input;
	for (int r = 1; r < row + 1; r++){
	    String line = inputcopy.split("\n")[r];
	    for (int c = 0; c < col; c++){
		int depth = Integer.parseInt(line.split(" ")[c]);
		lake[r-1][c] = depth;
	    }
	}
    }

    public int findMax(int R_s, int C_s){
	int maxElev = lake[R_s-1][C_s-1];
	for (int r = R_s - 1; r < R_s + 2; r++){
	    for (int c = C_s; c < C_s + 2; c++){
		if (lake[r][c] > maxElev){
		    maxElev = lake[r][c];
		}
	    }
	}
	return maxElev;
    }

    public void cowStomp(int R_s, int C_s, int D_s){
	int maxElevation = findMax(R_s, C_s);
	for (int inchesLeft = D_s; inchesLeft > 0; inchesLeft--){
	    for (int r = R_s - 1; r < R_s + 2; r++){
		for (int c = C_s - 1; c < C_s + 2; c++){
		    if (lake[r][c] == maxElevation){
			lake[r][c] = lake[r][c] - 1;
		    }
		}
	    }    
	    maxElevation--;
	}
    }

    public void finalDig(int finalElev){
	for (int r = 0; r < lake.length; r++){
	    for (int c = 0; c < lake[0].length; c++){
		lake[r][c] = lake[r][c] - finalElev;
	    }
	}
    }

    public int totalVol(){
	int aggregatedDepth = 0;
	for (int r = 0; r < lake.length; r++){
	    for (int c = 0; c < lake[0].length; c++){
		if (lake[r][c] < 0){
		    aggregatedDepth = aggregatedDepth + (-1 * lake[r][c]);
		}
	    }
	}
	int totalVolume = aggregatedDepth * 72 * 72;
	return totalVolume;
    }

    public void lakeMake(String input, int row, int col){
	String inputcopy = input;
	for (int i = rows + 1; i < row + numInstructions + 1; i++){
	    String line = inputcopy.split("\n")[i];
	    int R_s = Integer.parseInt( line.split(" ")[0] );
	    int C_s = Integer.parseInt( line.split(" ")[1] );
	    int D_s = Integer.parseInt( line.split(" ")[2] );
	    cowStomp(R_s, C_s, D_s);
	}
	finalDig( finalElevation);
    }

    public int lakeMake(){
	lakeMake(input1, rows, cols);
	int total = totalVol();
	return total;
    }

    public String printLake(){
	String output = "";
	for (int r = 0; r < lake.length; r++){
	    output+= "row " + (r+1) + ": ";
	    for (int c = 0; c < lake[0].length; c++){
		output+= lake[r][c] + " ";
	    }
	    output+= "\n";
	}
	return output;
    }

    /* --------------------------------- COW TRAVELLING --------------------------------- */

    public void setupPasture(String input){
	String inputcopy = input;
	String firstline = inputcopy.split("\n")[0];
	int row = Integer.parseInt( firstline.split(" ")[0] );
	int col = Integer.parseInt( firstline.split(" ")[1] );
	rows2 = row;
	cols2 = col;
	pasture = new char[rows2][cols2];
	String lastline = inputcopy.split("\n")[rows2+1];
	coords = lastline;
	genPasture(input);
    }

    public void genPasture(String input){
	String inputcopy = input;
	for (int r = 1; r < rows2+1; r++){
	    String line = input.split("\n")[r];
	    for (int c = 0; c < cols2; c++){
		pasture[r-1][c] = line.charAt(c);
	    }
	}
    }

    public int path(String coord){
	int r1 = Integer.parseInt( coord.substring(0, 1) );
	int c1 = Integer.parseInt( coord.substring(2, 3) );
	int r2 = Integer.parseInt( coord.substring(4, 5) );
	int c2 = Integer.parseInt( coord.substring(6) );
	int t = time;
	int possiblepaths = cowTravel(r1, c1, r2, c2, t);
	return possiblepaths;
    }

    public int path(){
	int paths = path( coords );
	return paths;
    }
    
    // does not work :((
    public int cowTravel(int r1, int c1, int r2, int c2, int t){
	int possiblepaths = 0;
	if ((t == 0) && (r1 == r2) && (c1 == c2))
	    return 1;
	else if (t == 0){
	    return 0;
	}
	else if (pasture[r1][c1] == '*')
	    return 0;
	else {
	    possiblepaths+= cowTravel(r1+1,c1,r2,c2,t--);
	    possiblepaths+= cowTravel(r1,c1+1,r2,c2,t--);
	    possiblepaths+= cowTravel(r1-1,c1,r2,c2,t--);
	    possiblepaths+= cowTravel(r1,c1-1,r2,c2,t--);
	}
	return possiblepaths;
    }

    public String printPasture(){
	String output = "";
	for (int r = 0; r < rows2; r++){
	    for (int c = 0; c < cols2; c++){
		output+= pasture[r][c];
	    }
	    output+= "\n";
	}
	return output;
    }


    /* --------------------------------- MAIN --------------------------------- */
    public static void main(String[] args){
	String lakemake = "4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
	String cowtravel = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	Lab lab = new Lab(lakemake, cowtravel);
	System.out.println(lab.printLake());
	//lab.cowStomp(1,4,4);
	//System.out.println(lab);
	//lab.cowStomp(1,1,10);
	//System.out.println( lab.findMax(1,1) );
        int vol = lab.lakeMake();
	System.out.println(lab.printLake());
	System.out.println(vol);
	System.out.println();
	System.out.println(lab.printPasture());
	int paths = lab.path();
	System.out.println(paths);
    }

}
