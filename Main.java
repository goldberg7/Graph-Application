import java.io.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
	 
	 
	 int[][] graphMatrix = getMatrixFromFile("matrixFile.txt");
	 for(int i = 0; i < graphMatrix.length; i++){
		 for(int j = 0; j < graphMatrix.length; j++){
			// System.out.print(graphMatrix[i][j] + " ");
		 }
		// System.out.println();	
	 }
	 Graph graph = new Graph(graphMatrix);
	 
	 
	 graph.convertMatrixToGraph();
	 graph.printGraph();
	 graph.printMatrix();
	 
	 GraphNode a = graph.getNodes().get(0);
	 GraphNode e = graph.getNodes().get(4);
	 
	 graph.BFS(a, e);
	 graph.DFS(a, e);
	  
	 //GUI gui = new GUI();
	 
	}

	public static int[][] getMatrixFromFile(String filename){
		File file = new File(filename);
		 /*Initialize to null so that it can be used after try-catch*/
		 int [][] graphMatrix = null;
		 
		 /*Read from the file and convert the dimension x dimension into a 
		  * 2D integer array that can be translated as an adjacency matrix 
		  * into an undirected graph*/
		 try{
		 Scanner scnr = new Scanner(file);
		 
		 //First line of the input file contains the n x n dimension of the matrix
		 int dimension = scnr.nextInt();
		 
		 /*Advance the scanner to the next line*/
		 scnr.nextLine();
		 
		 int trace = 0;
		 graphMatrix = new int[dimension][dimension];
		 
		 while(scnr.hasNextLine() && trace < dimension){
			 String line = scnr.nextLine();
			
			 /*Convert the string matrix read in from the file 
			  * into a dimension x dimension matrix */
			 for(int i = 0; i < line.length(); i++)
				 graphMatrix[trace][i] = Character.getNumericValue(line.charAt(i));
			 
			 trace++;
		 }
		
		 scnr.close();
		 }
		 catch (FileNotFoundException e){
			 System.out.println("Invalid file");
			 e.printStackTrace();
		 } 
		 
		 return graphMatrix;
	}
}
