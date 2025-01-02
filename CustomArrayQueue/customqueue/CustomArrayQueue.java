package customqueue;

public class CustomArrayQueue<E> implements QueueInterface<E> {

	private E queue[];
	private int front, tail, numItems;
	private static final int DEFAULT_CAPACITY = 10; // Do not change this value

	// Constructor 1: Creating an ArrayQueue with DEFAULT_CAPACITY.
	public CustomArrayQueue() { 
		queue = (E[]) new Object[DEFAULT_CAPACITY];
		//**********************************//
		// Initialize front, tail, numItems //
		//**********************************//
		numItems = 0;
		front = 0;
		tail = -1;
	}

	// Constructor 2: Creating an ArrayQueue of size n.
	public CustomArrayQueue(int n) { 
		queue = (E[]) new Object[n];
		//**********************************//
		// Initialize front, tail, numItems //
		//**********************************//
		numItems = 0;
		front = 0;
		tail = -1;
	}

	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	public int enqueue(E newItem) {
	// ----------------- write your code here ----------------- // 
// Behavior: When queue is 10 or above, operation returns -1.
		if(isFull()) {
			return -1;
		} else {
			tail = (tail + 1) % queue.length;

			queue[tail] = newItem;

			numItems++;

			return 0;
		}
	// -------------------------------------------------------- //
	}

	// Implementation of isFull(): Checking if the list is full
	// Return true if the list is full
	// Return false otherwise
	public boolean isFull() {
	// ----------------- write your code here ----------------- //
		return numItems == queue.length;
	
	// -------------------------------------------------------- //
	}
 
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the dequeue operation
	public E dequeue() {
	// ----------------- write your code here ----------------- //
		if(isEmpty()) {
			return null;
		} else {
			E removedItem = queue[front];
			front = (front + 1) % queue.length;
			numItems--;
			return removedItem;
		}
	
	// -------------------------------------------------------- //
	}

	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Otherwise, return the front element 
	public E front() {
	// ----------------- write your code here ----------------- //
		if(isEmpty()) {
			return null;
		}
		return queue[front];
	// -------------------------------------------------------- //
	}

	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty( ) {
	// ----------------- write your code here ----------------- //
		return numItems == 0;
	
	// -------------------------------------------------------- //
	}

	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
	// ----------------- write your code here ----------------- //
		numItems = 0;
		front = 0;
		tail = -1;
		return;
	
	// -------------------------------------------------------- //
	}

	//////////////////////////////////////////////////////////////////
	public void printAll() {
		int j = front;
		System.out.print("PrintAll: ");
		for(int i = 0; i < numItems; i++) {
			System.out.print(queue[j] + " ");
			j = (j+1) % queue.length;
		}
		System.out.println();
	}
}  
