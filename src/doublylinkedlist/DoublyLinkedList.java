package doublylinkedlist;


public class DoublyLinkedList {
	//Reference to first node
	private Node head;
	
	//constructor(s)
	public DoublyLinkedList(){
		head = new Node();
	}
	
	//Methods
	
	/* add() method adds a node to the LinkedList. 
	 * 
	 * Parameters: takes an integer parameter as the new data item to be stored. 
	 * 
	 * Return-type: none in this implementation; 
	 * a better implementation would indicate success or failure 
	 * with a boolean true/false return type
	 * 
	 * Since adds are in random order the choice is being made to add 
	 * the new Node at the start of the Linked List instead of the end.
	 *  
	 * What is the cost [O()] difference of doing it this way instead 
	 * of at the end? Think carefully.
	 *  
	 */
	
	public void add(int i){
		Node newNode = new Node();
		
		newNode.setData(i);
		newNode.setNext(head.getNext());
		
		head.setNext(newNode);
	}
	
	/* Method isEmpty()
	 * 
	 * No parameters; boolean return type that indicates true if list is empty; false otherwise 
	 */
	public boolean isEmpty(){
		return (head.getNext() == null);
	}

	/* Method to display the List contents starting from the head node. 
	 * If the list is empty, the appropriate message is displayed to the user.  
	 */
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
	
	/* Search() method
	 * 
	 * parameters: integer for which item is being looked for. 
	 * 
	 * This implementation only indicates if the item was found or not. 
	 * 
	 * A better implementation would return the reference to the found Node;
	 * in case the user wanted to do something with the searched item. 
	 * 
	 * Study carefully how the list is being traversed
	 */
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