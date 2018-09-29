import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testNodeCreation() {
		/*Check Value*/
		Node node = new Node(5, 0); 
		assertEquals(5, node.getValue());
		
		Node node2 = new Node(1, 0);
		assertEquals(1, node2.getValue());
		
		/*Check Number of Sub Nodes*/
		Node node3 = new Node(1, 3);
		assertEquals(3, node3.getNumSubNodes());
		
		Node node4 = new Node(4, 2);
		assertEquals(2, node4.getNumSubNodes());
	}
	
}
