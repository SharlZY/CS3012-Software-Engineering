import java.util.ArrayList;
import java.lang.Math;;
public class LCA {
	
	public static int findLCA(Node root, Node current, Node dst){
		ArrayList<Integer> path1 = new ArrayList<Integer>();
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		int LCA = 1;
		findPath(root, current, path1);
		findPath(root, dst, path2);
		if(findPath(root, current, path1).isEmpty() || findPath(root, dst, path2).isEmpty()){
			return LCA;
		}
		else{
			return cmpLists(path1, path2);
		}
	}
	
	public static int cmpLists(ArrayList<Integer> path1, ArrayList<Integer> path2){
		int commonNum = 1;
		for(int i = 0; i < Math.min(path1.size(), path2.size()); i++){
			if(path1.get(i).equals(path2.get(i))){
				commonNum = path1.get(i);
			}
		}
		return commonNum;
	}

	public static boolean pathExists(Node current, Node dst) {
		if (current == null|| dst == null) {
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
			if (current.getValue() == dst.getValue()) {
				return pathStore;
			}
			if (current.getLeftNode() != null) {
				findPath(current.getLeftNode(), dst, pathStore);
			}

			if (current.getRightNode() != null) {
				findPath(current.getRightNode(), dst, pathStore);
			}
			return pathStore;
		}
		return pathStore;
	}
}
