package doublylinkedlist;


/* There is a default Java invoked constructor, which will automatically set the 
 * next ref to null. 
 */

public class Node {
	//Data
	private int data; 		//data stores the data portion of the LL node; this is an integer node
	private Node next;		//Reference to the next node
	private Node previous;	//Reference to the previous node
	
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
	
	public void setPrevious(Node P) {
		previous = P;
	}
	
	public Node getPrevious() {
		return previous;
	}
}