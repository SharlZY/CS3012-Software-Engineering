
public class LCA {
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
}
