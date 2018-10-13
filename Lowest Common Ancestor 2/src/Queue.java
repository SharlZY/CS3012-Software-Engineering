import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Queue <T extends Comparable<T>> {
	public class DLLNode {
		public final T data; 
		public DLLNode next; 
		public DLLNode prev;
		
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}	
	}
	public DLLNode head, tail;
	
	///////////QUEUE CONSTRUCTOR/////////////////
	public Queue() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		if (this.head == null) { // Θ(1) if the head is null and then the tail is null, they are not pointing at any node. So
			//there is no node in the DLL which means its empty.
			return true;
		}
		return false;
	}
	
	/////////ENQUEUE//////////
	public void enqueue(T item) { // Assuming the end of the queue is at the tail pointer of the DLL. If we call the enqueue function,
		// it will place the item at the end of the DLL
		if(!isEmpty()){ // Θ(1) - If the list isnt empty
		DLLNode tailPointer = this.tail; // Retrieve data of the current node at the tail pointer
		DLLNode newNode = new DLLNode(item,tailPointer,null); // Create the new node with the given item
		tailPointer.next = newNode; // The next node of the tail pointer node will now point to the new node
		this.tail = newNode; // The tail pointer will now point at the new Node as its the last node of the DLL
		}
		else{ // If the DLL is empty
			DLLNode newNode = new DLLNode(item,null,null); //Create a new node for the DLL
			this.head = newNode; // The head pointer will point to this node
			this.tail = newNode; // The tail pointer will point to this node
		}
		
	}
	
	///////////DEQUEUE/////////////
	public T dequeue() { // Assuming that the first item placed onto the DLL, is at the head pointer, and the most recent item enqueued onto 
		//the DLL, is at the tail pointer. 
		if(!isEmpty()){ // Θ(1)
			DLLNode headPointer = this.head; // Store head pointer node data into head pointer variable
			DLLNode nextHead = headPointer.next; // Store the new head pointer data into the next head variable
			T data = headPointer.data; // retrieve the data of the head pointer
			headPointer.next = null; // The next current head pointer will have no links
			this.head = nextHead; // The head pointer will now point to the new head node	
			return data; // return retrieved data
		}
		else{
		return null;
		}
	}
}
