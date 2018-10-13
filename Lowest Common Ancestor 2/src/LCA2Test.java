import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
public class LCA2Test {

	@Test
	public void dagCreation() {
		DAG sample = new DAG(7);
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		Node nodeF = new Node('F');
		Node nodeG = new Node('G');
		
		sample.addEdge(nodeG, nodeD);
		sample.addEdge(nodeG, nodeF);
		sample.addEdge(nodeD, nodeC);
		sample.addEdge(nodeC, nodeB);
		sample.addEdge(nodeB, nodeA);
		sample.addEdge(nodeF, nodeE);
		sample.addEdge(nodeE, nodeB);
		
		LCA2 lca = new LCA2();
		lca.bfs(nodeG, sample);
	}

}
