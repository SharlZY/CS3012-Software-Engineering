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
		node3.setLeftNode(node5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));
		
		/*Test the tree*/
		assertEquals(8, node5.getRightNode().getValue());
		assertEquals(4, node2.getRightNode().getValue());
		assertEquals(2, root.getLeftNode().getValue());
		assertEquals(3, root.getRightNode().getValue());
	}
	@Test 
	public void testPathExists(){
		/*Create a Tree*/
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		/* Left Side of Tree*/
		root.setLeftNode(node2);
		node2.setRightNode(new Node(4));
		
		/*Right Side of Tree*/
		root.setRightNode(node3);
		node3.setRightNode(new Node(6));		
		Node node5 = new Node(5);
		node3.setLeftNode(node5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));
		
		assertTrue(LCA.pathExists(root, node2));
		assertTrue(LCA.pathExists(root, node2.getRightNode()));
		
		assertTrue(LCA.pathExists(root, root.getRightNode()));
/*		assertTrue(LCA.pathExists(root, node5.getRightNode()));
		assertTrue(LCA.pathExists(root, node5.getLeftNode()));
		assertTrue(LCA.pathExists(root, node2.getRightNode()));
		assertFalse(LCA.pathExists(root, node2.getLeftNode()));		
*/		
	}
	
}
