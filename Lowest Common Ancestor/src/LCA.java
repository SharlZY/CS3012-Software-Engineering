import java.util.ArrayList;

public class LCA {
	public ArrayList<Integer> path1 = new ArrayList<Integer>();
	public ArrayList<Integer> path2 = new ArrayList<Integer>();

	public static boolean pathExists(Node current, Node dst) {
		if (current == null || dst == null) {
			return false;
		}
		if (current.getValue() == dst.getValue()) {
			return true;
		}
		if (current.getLeftNode() != null && pathExists(current.getLeftNode(), dst)) {
			return true;
		}
		if (current.getRightNode() != null && pathExists(current.getRightNode(), dst)) {
			return true;
		}
		return false;
	}

	public static ArrayList<Integer> findPath(Node current, Node dst, ArrayList<Integer> pathStore) {
		if (pathExists(current, dst)) {
			pathStore.add(current.getValue());
			if (current.getLeftNode() != null) {
				return findPath(current.getLeftNode(), dst, pathStore);
			}
			if (current.getRightNode() != null) {
				return findPath(current.getRightNode(), dst, pathStore);
			}
			if (current.getLeftNode() == null && current.getRightNode() == null || current.getValue() == dst.getValue()) {
				return pathStore;
			}
		}
		return pathStore;
	}
}
