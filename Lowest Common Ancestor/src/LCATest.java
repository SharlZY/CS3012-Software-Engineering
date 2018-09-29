import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testNodeCreation() {
		/*Check Value*/
		Node node3 = new Node(3); 
		assertEquals(3, node3.getValue());
		
		Node node2 = new Node(2);
		assertEquals(2, node2.getValue());
		
		/*Create a Tree*/
		Node root = new Node(1);
		
		/* Left Side of Tree*/
		root.setLeftNode(node2);
		node2.setRightNode(new Node(4));
		
		/*Right Side of Tree*/
		root.setRightNode(node3);
		node3.setRightNode(new Node(6));
		Node node5 = new Node(5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));
		
		/*Test the tree*/
		assertEquals(8, node5.getRightNode().getValue());
	}
	
}
