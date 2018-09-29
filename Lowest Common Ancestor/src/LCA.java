import java.util.ArrayList;

public class LCA {
	public ArrayList<Integer> path1 = new ArrayList<Integer>();
	public ArrayList<Integer> path2 = new ArrayList<Integer>();
	
	public static boolean pathExists(Node current, Node dst){
		if(current == null || dst == null){
			return false;
		}
		if(current.getValue() == dst.getValue()){
			return true;
		}
		if(current.getLeftNode() != null && pathExists(current.getLeftNode(), dst)){
			return true;
		}
		if(current.getRightNode() != null && pathExists(current.getRightNode(), dst)){
			return true;
		}
		return false;
	}
	
	public static ArrayList<Integer> findPath(Node current, Node dst, ArrayList<Integer> pathStore){
		if(pathExists(current, dst)){
			if(current == null || dst == null){
				return pathStore;
			}
			if(current.getValue() == dst.getValue()){
				return pathStore;
			}
			if(current.getLeftNode() != null){
				pathStore.add(current.getLeftNode().getValue());
				return findPath(current.getLeftNode(), dst, pathStore);
			}
			if(current.getRightNode() != null ){
				pathStore.add(current.getRightNode().getValue());
				return findPath(current.getRightNode(), dst, pathStore);
			}		
		}
		return pathStore;
	}
}
