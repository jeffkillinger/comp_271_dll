package doublylinkedlist;


/*This is a simple Node Class that can be used to create Node objects that 
 * can be used by the LinkedList (LL) Class in its implementation. 
 * 
 * Note that there is no constructor written. This means that there is a
 * default Java invoked constructor, which will automatically set the 
 * next ref to null. This is desirable behavior especially if many of the 
 * Node additions to the LL are likely to be adds.  
 */

public class Node {
	//Data
	private int data; 	//data stores the data portion of the LL node; this is an integer node
	private Node next;	//Reference to the next node
	private Node previous;
	
	public void setData(int i){
		data = i;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNext(Node N){
		next = N;
	}
	
	public Node getNext(){
		return next;
	}
}