public class Lab{

    /* CURRENT STATUS
       - only lake making is functional
     */
    
    private String input1, input2;
    private int rows, cols;
    private int[][] lake;
    private int finalElevation;
    private int numInstructions;
    private char[][] travel;

    public Lab(String in1, String in2){
	input1 = in1;
	setupLake(input1);
	input2 = in2;
    }

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

    public String toString(){
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



    public static void main(String[] args){
	String lakemake = "4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
	String cowtravel = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	Lab lab = new Lab(lakemake, cowtravel);
	System.out.println(lab);
	//lab.cowStomp(1,4,4);
	//System.out.println(lab);
	//lab.cowStomp(1,1,10);
	//System.out.println( lab.findMax(1,1) );
        int vol = lab.lakeMake();
	System.out.println(lab);
	System.out.println(vol);
    }

}
