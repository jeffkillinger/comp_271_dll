package doublylinkedlist;


public class DoublyLinkedList {
	//Reference to first node
	private Node head;
	
	//constructor
	//QUESTION: What is the work being done here?
	//Do I need to add a tail?
	//If I were to initialize a tail, would it be
	// tail = newNode();?
	//If so, wouldn't that set both head and tail to 2 different new nodes?
	public DoublyLinkedList(){
		head = new Node();
	}

	public void add(int i){
		//Create new node and set data and add data to new node
		Node newNode = new Node();
		newNode.setData(i);
		
		//Sets new node's "next" pointer to the reference of node after current head
		newNode.setNext(head.getNext());
		
		//Sets new node's "previous" to null
		newNode.setPrevious(null);
		
		//QUESTION: How to set newNode as the previous of current head???
		
		// Sets newNode as head
		head.setNext(newNode);
		
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
	
	public void delete(int x){
		//QUESTION: Above, in isEmpty(), it returned as empty if head.getNext() was null
		//Now, head.getNext() seems to be the node AFTER the head.
		//If head.getNext() refers to node AFTER head, how can list
		//be empty if there's a head to refer to (as below with 'previous')
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
		
		//If the item is found, set next and previous to go around it
		if(found){
			previous.setNext(current.getNext());
			//QUESTION: ADDED THIS -- Does it adequately bypass the deleted node?
			current.setPrevious(previous.getPrevious());
		}
	}
	
	
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
			//QUESTION: Is this all that's needed for insert? 
			//Just make sure incoming has a previous?
			//And current sets previous to incoming?
			incoming.setPrevious(previous);
			current.setPrevious(incoming);
		}else{
			System.out.println("The position specified is beyond/outside the current list.");
		}
	}
}