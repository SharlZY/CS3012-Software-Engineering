
public class Node {
	private int value;
	private int numSubNodes;
	private Node nextNode;
	private Node prevNode;
	Node(int value, int n){
		setValue(value);
		setNumSubNodes(n);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getNumSubNodes() {
		return numSubNodes;
	}
	public void setNumSubNodes(int numSubNodes) {
		this.numSubNodes = numSubNodes;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
}
