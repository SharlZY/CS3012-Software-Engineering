import java.util.ArrayList;
public class DAG {
		private ArrayList<Node> nodes;
		private Node root;
		DAG(Node node){
			this.root = node;
			nodes.add(this.root);
		}
		private void addNodetoDAG(Node node){
			nodes.add(node);
		}
		
}
