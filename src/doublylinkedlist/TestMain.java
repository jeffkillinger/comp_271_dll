package doublylinkedlist;

public class TestMain {

	public static void main(String[] args) {
		DoublyLinkedList myLL = new DoublyLinkedList();
		
		System.out.println(myLL.isEmpty());
		
		myLL.add(9);
		
		myLL.display();
		
		myLL.add(4);
		
		myLL.add(3);
		
		myLL.display();
		
		System.out.println(myLL.search(4));
		
		myLL.delete(4);
		
		myLL.display();
		
		myLL.add(34);
		
		myLL.display();
		
		myLL.delete(34);
		
		myLL.display();
		
		myLL.insert(0, 99);
		
		myLL.display();
		
		myLL.insert(1, 67);
		
		myLL.display();
		
		myLL.delete(67);
		
		myLL.display();
		
		myLL.insert(2, 67);
		
		myLL.display();	
		
		myLL.insert(4, 398);
		
		myLL.display();	
	}

}
