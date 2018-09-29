
public class LCA {
	public static boolean pathExists(Node current, Node dst){
		if(current == null || dst == null){
			return false;
		}
		if(current.getValue() == dst.getValue()){
			return true;
		}
		if(current.getLeftNode() != null){
			return pathExists(current.getLeftNode(), dst);
		}
		if(current.getRightNode() != null){
			return pathExists(current.getRightNode(), dst);
		}
		return false;
	}
}
