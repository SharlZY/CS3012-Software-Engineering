public class Node {
	private char value;
	
	Node(char value){
		this.setValue(value);
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public int intVal(){
//		System.out.print(value-0x40);
    	return (value-0x40);
    }
}
