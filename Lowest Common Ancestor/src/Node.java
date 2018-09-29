
public class Node {
	private int value;
	private int numSubNodes;
	private Node leftNode;
	private Node rightNode;

	Node(int value, int n) {
		this.value = value;
		this.numSubNodes = n;
		this.leftNode = null;
		this.rightNode = null;
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

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}
