package customqueue;
import customqueue.Node;

public class CustomLinkedQueue<E> implements QueueInterface<E>{
	private Node<E> tail;
	int numItems;

	// Constructor 1: Creating an LinkedQueue.
	public CustomLinkedQueue( ) {
		//**********************************//
		// 			Initialize tail 		//
		numItems = 0;
		tail = null;
		//**********************************//
	}
 
	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	/* public int enqueue(E newItem) {
		if (newItems = null) {
			return -1;
		} else {
			try {
				Node <E> newNode = new Node<>();
				if(tail == null) {
					newNode.next = newNode;
					tail = newNode;
				} else {

				}
			}
		}
	}   */
		
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the dequeue operation
	//blic E dequeue( ) {

	// }
		
	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Return false otherwise
	public E front() {
		if(isEmpty()) {
			return null;
		} else {
			return tail.next.item;
		}
	}
		
	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty() {
		return numItems == 0;
	}
		 
	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
		tail = null;
		numItems = 0;
	} 
	
	/////////////////////////////////////////////////////
	public void printAll() {
		Node<E> t = tail;
		System.out.println("Queue from front to tail");
		if (!isEmpty()) 
			do {
				t = t.next;
				System.out.println(t.item);
			} while (t != tail);
		else System.out.println("Empty Queue!");
	}
} 
