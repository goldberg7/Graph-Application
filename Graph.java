import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {

	private int[][] nodeMatrix;
	private ArrayList<GraphNode> nodeList;
	
	/*There may be up to and including 26 nodes in the graph, with names given
	 * alphabetically according to this array*/
	public static String[] nodeNames = 
								  {"A", "B", "C", "D", "E", "F", "G", "H", "I",
								  "J", "K", "L", "M", "N", "O", "P", "Q", "R",
								  "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	/*Default constructor*/
	public Graph(){
		this.nodeMatrix = null;
		this.nodeList = new ArrayList<GraphNode>();
	}
	/*Constructor with passed in adjacency matrix*/
	public Graph(int[][] matrix){
		this.nodeMatrix = matrix;
		nodeList = new ArrayList<GraphNode>();
	}
	
	/*Copy Constructor*/
	public Graph(Graph aGraph){
		this.nodeMatrix = aGraph.getMatrix();
		this.nodeList = aGraph.getNodes();
	}
	/*Methods to include
	 * 	-print the connected nodes in the graph
	 * 	-convert the matrix node matrix into a graph
	 * 	-get list of graphNodes
	 * 	-search?*/
	public void printGraph(){
		if(nodeList.size() == 0){
			System.out.println("***There are no nodes in the graph***");
			return;
		}
		
		
		for(GraphNode n : nodeList){
			System.out.println(n.toString() + "\nNeighbors: " + n.printNeighbors());
		}
	}
	
	public void printMatrix(){
		for(int i = 0; i < nodeMatrix.length; i++){
			for(int j = 0; j < nodeMatrix.length; j++){
				System.out.print(nodeMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void convertMatrixToGraph(){
		for(int i = 0; i < this.nodeMatrix.length; i++){
			/*Do a once-over to add all nodes to the list*/
			GraphNode node = new GraphNode(nodeNames[i]);
			this.nodeList.add(node);
			
		}
		
		/*Now do a traversal for adding neighbors*/
		for(int i = 0; i < this.nodeMatrix.length; i++){
			
			GraphNode node = nodeList.get(i);
			
			for(int j = 0; j < nodeMatrix[i].length; j++){
				if(nodeMatrix[i][j] != 0)
					node.addNeighbor(this.getNodeFromName(nodeList.get(j).toString()));
			}
		}
	}
	
	/*DFS algorithm*/
	public void DFS(GraphNode start, GraphNode end){
		
		ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
		Stack<GraphNode> stack = new Stack<GraphNode>();
		
		stack.push(start);
		visited.add(start);
		
		while(!stack.isEmpty()){
			GraphNode curr = stack.pop();
			
			System.out.println("Expanding "+ curr.toString());
			
			if(curr.equals(end)){
				System.out.println("Reached " + curr.toString());
				return;
			}
			
			for(GraphNode node : curr.getNeighbors()){
				if(!visited.contains(node)){
					visited.add(node);
					stack.push(node);
				}
				
			}
		}
		
		System.out.println("Could not reach " + end.toString()
				+ " from " + start.toString());
	}
	
	public void BFS(GraphNode start, GraphNode end){
		ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		
		queue.add(start);
		visited.add(start);
		
		while(!queue.isEmpty()){
			GraphNode curr = queue.remove();
			
			System.out.println("Expanding " + curr.toString());
			
			if(curr.equals(end)){
				System.out.println("Reached " + end.toString());
				return;
			}
			
			for(GraphNode node : curr.getNeighbors()){
				if(!visited.contains(node)){
					visited.add(node);
					queue.add(node);
				}
			}
			
		}
		
		System.out.println("Could not reach " + end.toString() 
				+ " from " + start.toString());
	}
	
	private GraphNode getNodeFromName(String name){
		
		for(GraphNode g : nodeList)
			if(g.toString().equals(name))
				return g;
		
		return null;
	}
	
	public ArrayList<GraphNode> getNodes(){
		return this.nodeList;
	}
	
	public int[][] getMatrix(){
		return this.nodeMatrix;
	}
}
