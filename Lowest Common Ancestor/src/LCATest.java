import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LCATest {

	@Test
	public void testNodeCreation() {
		/* Check Value */
		Node node3 = new Node(3);
		assertEquals(3, node3.getValue());

		Node node2 = new Node(2);
		assertEquals(2, node2.getValue());

		/* Create a Tree */
		Node root = new Node(1);

		/* Left Side of Tree */
		root.setLeftNode(node2);
		node2.setRightNode(new Node(4));

		/* Right Side of Tree */
		root.setRightNode(node3);
		node3.setRightNode(new Node(6));
		Node node5 = new Node(5);
		node3.setLeftNode(node5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));

		/* Test the tree */
		assertEquals(8, node5.getRightNode().getValue());
		assertEquals(4, node2.getRightNode().getValue());
		assertEquals(2, root.getLeftNode().getValue());
		assertEquals(3, root.getRightNode().getValue());
	}

	@Test
	public void testPathExists() {
		/* Create a Tree */
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		/* Left Side of Tree */
		root.setLeftNode(node2);
		node2.setRightNode(new Node(4));

		/* Right Side of Tree */
		root.setRightNode(node3);
		node3.setRightNode(new Node(6));
		Node node5 = new Node(5);
		node3.setLeftNode(node5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));

		assertTrue(LCA.pathExists(root, node2));
		assertTrue(LCA.pathExists(root, node2.getRightNode()));

		assertTrue(LCA.pathExists(root, root.getRightNode()));

		assertTrue(LCA.pathExists(root, node5.getRightNode()));
		assertTrue(LCA.pathExists(root, node5.getLeftNode()));
		assertTrue(LCA.pathExists(root, node2.getRightNode()));
		assertFalse(LCA.pathExists(root, node2.getLeftNode()));
	}

	@Test
	public void testFindPath() {
		/* Create a Tree */
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		/* Left Side of Tree */
		root.setLeftNode(node2);
		node2.setRightNode(new Node(4));

		/* Right Side of Tree */
		root.setRightNode(node3);
		node3.setRightNode(new Node(6));
		Node node5 = new Node(5);
		node3.setLeftNode(node5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));

		ArrayList<Integer> result1 = new ArrayList<Integer>();
		ArrayList<Integer> expectedVal1 = new ArrayList<Integer>();
		expectedVal1.add(1);
		expectedVal1.add(2);
		expectedVal1.add(4);
		assertEquals(expectedVal1, LCA.findPath(root, node2.getRightNode(), result1));

		ArrayList<Integer> result2 = new ArrayList<Integer>();
		ArrayList<Integer> expectedVal2 = new ArrayList<Integer>();
		expectedVal2.add(1);
		expectedVal2.add(3);
		expectedVal2.add(6);
		assertEquals(expectedVal2, LCA.findPath(root, node3.getRightNode(), result2));

		ArrayList<Integer> result3 = new ArrayList<Integer>();
		ArrayList<Integer> expectedVal3 = new ArrayList<Integer>();
		expectedVal3.add(1);
		expectedVal3.add(3);
		expectedVal3.add(5);
		expectedVal3.add(7);
		assertEquals(expectedVal3, LCA.findPath(root, node5.getLeftNode(), result3));

		ArrayList<Integer> result4 = new ArrayList<Integer>();
		ArrayList<Integer> expectedVal4 = new ArrayList<Integer>();
		expectedVal4.add(1);
		expectedVal4.add(3);
		expectedVal4.add(5);
		expectedVal4.add(8);
		assertEquals(expectedVal4, LCA.findPath(root, node5.getRightNode(), result4));

		/* Find nodes of same subtree */
		ArrayList<Integer> result5 = new ArrayList<Integer>();
		ArrayList<Integer> expectedVal5 = new ArrayList<Integer>();
		expectedVal5.add(3);
		expectedVal5.add(5);
		expectedVal5.add(8);
		assertEquals(expectedVal5, LCA.findPath(node3, node5.getRightNode(), result5));
	}

	@Test
	public void testCmpLists() {
		/* List 1 length shorter than List 2 */
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		assertEquals(-1, LCA.cmpLists(list1, list2));
		list1.add(1);
		list1.add(3);
		list1.add(6);
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(7);
		assertEquals(3, LCA.cmpLists(list1, list2));

		/* Lists of the same length */
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(3);
		list3.add(5);
		list3.add(8);
		list4.add(1);
		list4.add(3);
		list4.add(5);
		list4.add(7);
		assertEquals(5, LCA.cmpLists(list3, list4));
	}

	@Test
	public void testFindLCA() {
		/* Create a Tree */
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		/* Left Side of Tree */
		root.setLeftNode(node2);
		node2.setRightNode(new Node(4));

		/* Right Side of Tree */
		root.setRightNode(node3);
		node3.setRightNode(new Node(6));
		Node node5 = new Node(5);
		node3.setLeftNode(node5);
		node5.setLeftNode(new Node(7));
		node5.setRightNode(new Node(8));

		assertEquals(5, LCA.findLCA(root, node5.getLeftNode(), node5.getRightNode()));
		assertEquals(5, LCA.findLCA(root, node5, node5));
		assertEquals(1, LCA.findLCA(root, node2.getRightNode(), node5.getRightNode()));
		assertEquals(3, LCA.findLCA(root, node3.getRightNode(), node5.getLeftNode()));
	}
}
