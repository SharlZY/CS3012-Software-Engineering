import java.util.ArrayList;

public class Node {
	private char value;
	private ArrayList<Node> outEdges = new ArrayList<Node>();
	
	Node(char value){
		this.setValue(value);
	}
	public void addOutEdge(Node node){
		outEdges.add(node);
	}
	public int getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public ArrayList<Node> getNeighbours(){
		return outEdges;
	}
}
