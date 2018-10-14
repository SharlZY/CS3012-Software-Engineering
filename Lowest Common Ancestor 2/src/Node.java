public class Node {
	private char value;
	public static int vNum;
	public boolean[] marked;
	public char[] edgeTo;
	public int[] distTo;
	
	Node(char value, int v){
		this.setValue(value);
		vNum = v;
		marked = new boolean[vNum];
		edgeTo = new char[vNum];
		distTo = new int[vNum];
		edgeTo[intVal()-1] = value;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public int intVal(){
    	return (value-0x40);
    }
	public int shortdistTo(Node dst){
		for(int i = 0; i < edgeTo.length-1; i++){
			if(edgeTo[i] == dst.getValue()){
				return distTo[i];
			}
		}
		return -1;
	}
}
