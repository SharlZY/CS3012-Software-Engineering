import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
public class LCA2Test {

	@Test
	public void dagCreation() {
		Node nodeA = new Node('A');
		Node nodeB = new Node('B');
		Node nodeC = new Node('C');
		Node nodeD = new Node('D');
		Node nodeE = new Node('E');
		Node nodeF = new Node('F');
		Node nodeG = new Node('G');
		nodeG.addOutEdge(nodeD);
		nodeG.addOutEdge(nodeF); //need to write code for possible duplicate values in list
		nodeF.addOutEdge(nodeE);
		nodeD.addOutEdge(nodeC);
		nodeC.addOutEdge(nodeB);
		nodeE.addOutEdge(nodeB);
		nodeB.addOutEdge(nodeA);
		
		ArrayList<Node> gNeighbours = new ArrayList<Node>();
		gNeighbours.add(nodeD);
		gNeighbours.add(nodeF);
		
		ArrayList<Node> results = new ArrayList<Node>();
		results = nodeG.getNeighbours();
		assertEquals(gNeighbours, results);
	}

}
