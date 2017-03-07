import java.util.ArrayList;

/**Class to represent a single graph node in a graph
 * A node contains a string and a list of its neighbors
 */
public class GraphNode {
	private String name;
	private ArrayList<GraphNode> neighbors;
	
	public GraphNode(String name){
		this.name = name;
		this.neighbors = new ArrayList<GraphNode>();
	}
	
	@Override 
	public String toString(){
		return this.name;
	}
	
	public String printNeighbors(){
		StringBuilder sb = new StringBuilder();
		
		for(GraphNode n : neighbors){
			sb.append(n.toString() + " ");
		}
		
		return sb.toString();
	}
	public ArrayList<GraphNode> getNeighbors(){
		return this.neighbors;
	}
	
	public void addNeighbor(GraphNode neighbor){
		neighbors.add(neighbor);
			}
	
}
