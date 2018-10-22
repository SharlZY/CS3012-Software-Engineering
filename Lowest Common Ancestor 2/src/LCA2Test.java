import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
public class LCA2Test {
	public static final int V = 7;
	@Test
	public void dagCreation() {
		DAG sample = new DAG(V);
		Node nodeA = new Node('A',V);
		Node nodeB = new Node('B',V);
		Node nodeC = new Node('C',V);
		Node nodeD = new Node('D',V);
		Node nodeE = new Node('E',V);
		Node nodeF = new Node('F',V);
		Node nodeG = new Node('G',V);
		
		sample.addEdge(nodeG, nodeD);
		sample.addEdge(nodeG, nodeF);
		sample.addEdge(nodeD, nodeC);
		sample.addEdge(nodeC, nodeB);
		sample.addEdge(nodeB, nodeA);
		sample.addEdge(nodeF, nodeE);
		sample.addEdge(nodeE, nodeB);
	
		LCA2 lca = new LCA2();
		lca.bfs(nodeG, sample);
		
		int result = nodeG.shortdistTo(nodeA);
		assertEquals(4, result);
	}
	@Test
	public void testSP(){
		DAG sample = new DAG(V);
		Node nodeA = new Node('A',V);
		Node nodeB = new Node('B',V);
		Node nodeC = new Node('C',V);
		Node nodeD = new Node('D',V);
		Node nodeE = new Node('E',V);
		Node nodeF = new Node('F',V);
		Node nodeG = new Node('G',V);
		
		sample.addEdge(nodeG, nodeD);
		sample.addEdge(nodeG, nodeF);
		sample.addEdge(nodeD, nodeC);
		sample.addEdge(nodeC, nodeB);
		sample.addEdge(nodeB, nodeA);
		sample.addEdge(nodeF, nodeE);
		sample.addEdge(nodeE, nodeB);
	
		LCA2 lca = new LCA2();

		lca.bfs(nodeF, sample); //To another node
		int result = nodeF.shortdistTo(nodeB);
		assertEquals(2, result);
		
		lca.bfs(nodeD, sample); //To a node that doesn't exist in its path
		result = nodeD.shortdistTo(nodeE);
		assertEquals(-1, result);
		
		result = nodeD.shortdistTo(nodeD); //To itself
		assertEquals(0, result);
	}
	@Test 
	public void testEnqueueDequeue(){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(4);
		assertEquals(4,(int) q.dequeue());
		
		q.enqueue(5);
		q.enqueue(6);
		assertEquals(5,(int) q.dequeue());
		
		q.dequeue();
		assertEquals(null, q.dequeue());
	}
	@Test
	public void testGetters(){
		DAG sample = new DAG(V);
		Node nodeA = new Node('A',V);
		Node nodeB = new Node('B',V);
		sample.addEdge(nodeB, nodeA);
		
		assertEquals(7, sample.getV());
		assertEquals('A',nodeA.getValue());
		assertEquals(1,nodeA.intVal());
		
		assertEquals('B',nodeB.getValue());
		assertEquals(2,nodeB.intVal());
	}
	@Test 
	public void testLCA(){
		DAG sample = new DAG(V);
		Node nodeA = new Node('A',V);
		Node nodeB = new Node('B',V);
		Node nodeC = new Node('C',V);
		Node nodeD = new Node('D',V);
		Node nodeE = new Node('E',V);
		Node nodeF = new Node('F',V);
		Node nodeG = new Node('G',V);
		
		sample.addEdge(nodeG, nodeD);
		sample.addEdge(nodeG, nodeF);
		sample.addEdge(nodeD, nodeC);
		sample.addEdge(nodeC, nodeB);
		sample.addEdge(nodeB, nodeA);
		sample.addEdge(nodeF, nodeE);
		sample.addEdge(nodeE, nodeB);
		
		LCA2 lca = new LCA2();
		char result = ' ';
		result = lca.findLCA(nodeG, nodeE, sample);		
		assertEquals('E', result);
		
		result = lca.findLCA(nodeD, nodeF, sample);
		assertEquals('B', result);
		
		result = lca.findLCA(nodeC, nodeF, sample);
		assertEquals('B', result);
		
		result = lca.findLCA(nodeD, nodeE, sample);
		assertEquals('B', result);
		
		result = lca.findLCA(nodeC, nodeG, sample);
		assertEquals('C', result);
	}
	@Test
	public void testAcyclic(){
		
	}
}
