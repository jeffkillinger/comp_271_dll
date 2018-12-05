package doublylinkedlist;


public class DoublyLinkedList {
	//Reference to first node
	private Node head;
	private Node tail;
	
	//constructor(s)
	public DoublyLinkedList(){
		head = new Node();
		tail = new Node();
	}
	
	
	public void add(int i){
		if (head == null) {
			
		}
		
		Node newNode = new Node();
		
		newNode.setData(i);
		
		// Sets 'next' node to the node after head
		newNode.setNext(head.getNext());
		
		// Sets newNode as head
		head.setNext(newNode);
		
		//Sets previous of new node to null
		newNode.setPrevious(null);
	}
	

	
	public boolean isEmpty(){
		return (head.getNext() == null);
	}


	public void display(){
		Node current = head.getNext();
		
		if(current == null){
			System.out.print("Linked List is empty!");
		}else{
			System.out.print("The contents of the list are : ");
		}
		
		while(current != null){
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		
		System.out.println();
	}
	
	// Search() method
	// Can I improve to show at which index data is found?
	public boolean search(int s){
		Node current = head.getNext();
		
		while(current != null){
			if(current.getData() == s){
				return true;
			}
			current = current.getNext();
		}
		
		return false;
	}
	
	/* delete() method
	 * 
	 * parameter: integer (data item) to be deleted 
	 * 
	 * Study carefully: 
	 * 1. How the list is being traversed.
	 * 2. How the node is being deleted: no delete happens, 
	 *    but the node to be deleted is bypassed.
	 * 3. Why does the delete on the head node work? 
	 *    Seems so mysterious on the surface, but works.
	 *    Understanding this is crucial to making a doubly linked list. 
	 *    The hardest part about delete on a doubly linked list is that
	 *    both direction's links have to bypass the node that is being deleted. 
	 *    
	 * A better implementation of the delete() would give the user an indication that 
	 * the item whose deletion is being attempted doesn't exist in the list. 
	 */
	public void delete(int x){
		Node current = head.getNext();
		
		Node previous = head;
		
		boolean found = false;
		
		//Traverse the list to find the item
		while(current != null){
			if(current.getData() == x){
				found = true;
				break;
			}
			previous = current;
			current = current.getNext();
		}
		
		//If the item is found delete it; otherwise do nothing
		if(found){
			previous.setNext(current.getNext());
		}
	}
	
	
	/* dinsert() method
	 * 
	 * parameters: integer (data item) to be deleted 
	 * 
	 * Study carefully: 
	 * 1. How the list is being traversed.
	 * 2. How the node is being inserted.
	 * 3. The call to add() for an insert at position 0. 
	 */
	
	public void insert(int pos, int i){
		if (pos == 0) {			//If insert is at the head it is the same as an add()
			add(i);
			return;
		}
		Node current = head.getNext();
		
		Node previous = head;
		
		int count = 0;
		
		boolean found = false;
		
		while(current != null){
			if(count == pos){
				found = true;
				break;
			}
			previous = current;
			current = current.getNext();
			count++;
		}
		
		//If the position exists in the list then add the new node
		if(found || (pos == count)){      //Account for an insert at the end
			Node incoming = new Node();
			incoming.setData(i);
			incoming.setNext(current);
			previous.setNext(incoming);
		}else{
			System.out.println("The position specified is beyond/outside the current list.");
		}
	}
}