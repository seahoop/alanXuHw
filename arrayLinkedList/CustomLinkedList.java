package customlist;

public class CustomLinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;

	// Constructor 1: Creating an LinkedList with Dummy Head.
	// We consider that the index of Dummy Head as '-1'.
	public CustomLinkedList() { 			
		numItems = 0;
		head = new Node<>(null, null); 	//  Dummy Head (index = -1)
	}

	// Implementation of getNode(): Retrieving a node at the 'index' position in the list
	// If the index is -1, we consider that it as searching for the dummy head.
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the i-th node after the getNode operation in other cases
	public Node<E> getNode(int index) {
	//***************Write your code in the below******************//
		if (index < -1 || index >= numItems) return null;
		Node<E> curNode = head;
		for (int i = -1; i < index; i++) {
			curNode = curNode.next;
		}
		return curNode;
	//*************************************************************//
	}
	
	// Implementation of add(): Inserting element x at the 'index' position in the list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int add(int index, E item) {
	//***************Write your code in the below******************//
		if (numItems == 0) {
			if (index != 0) return -1;
			head.next = new Node<>(item, null);
			numItems++;
			return 0;
		}
		if (index < 0 || index >= numItems) return -1;

		Node<E> prevNode = getNode(index - 1);
		Node<E> curNode = new Node<>(item, prevNode.next);
		prevNode.next = curNode;
		numItems++;
		return 0;
	//*************************************************************//
	}
 
	// Implementation of append(): Adding an element to the end of the list
	// Return 0 after the add() operation
	public int append(E item) {
	//***************Write your code in the below******************//
		Node<E> curNode = head;
		while (curNode.next != null)
		{
			curNode = curNode.next;
		}
		curNode.next = new Node<>(item, null);
		numItems++;
		return 0;
	//*************************************************************//
	}

	// Implementation of remove(): Deleting an element at the 'index' position from the list
	// Return null if an exception occurs when deleting an element from the list
	// Return the removed element after the remove() operation in other cases
	public E remove(int index) {
	//***************Write your code in the below******************//
		if ( index < 0 || index >= numItems ) return null;
		Node<E> prevNode = getNode(index - 1);
		E removed_item = prevNode.next.item;
		prevNode.next = prevNode.next.next; 
		numItems--;
		return removed_item;
	//*************************************************************//
	}

	// Implementation of removeItem(): Removing element x from the list

	// If there are multiple nodes of the same item 'x', 
	// only the one node closest to the index '0' will be removed.

	// Return false if element x does not exist in the list
	// Return true after the removal operation if x exists
	public boolean removeItem(E x) {
	//***************Write your code in the below******************//
		Node<E> curNode = head;
		Node<E> prevNode = null;
		for (int i = 0; i < numItems; i++)
		{
			prevNode = curNode;
			curNode = curNode.next;
			if (x.equals(curNode.item))
			{
				prevNode.next = prevNode.next.next;
				numItems--;
				return true;
			}
		}
		return false;
	//*************************************************************//
	}

	// Implementation of get(): Retrieving an item at the 'index' position from the list
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the element at the specified index in other cases
	public E get(int index) {
	//***************Write your code in the below******************//
		if (index < 0 || index >= numItems) return null;
		return getNode(index).item;
	//*************************************************************//
	}

	// Implementation of set(): Replacing an item at the 'index' position in the list with x
	// Return -1 if attempting to access an index that is out of bounds (exception)
	// Return 0 after the set operation in other cases
	public int set(int index, E x) {
	//***************Write your code in the below******************//
		if (index < -1 || index >= numItems) return -1;
		Node<E> curNode = getNode(index);
		curNode.item = x;
		return 0;
	//*************************************************************//
	}

	// Implementation of indexOf(): Determining the position of element x in the list
	// Return -1 if the element does not exist in the list
	// Return the index of the element if it exists in other cases
	public int indexOf(E x) {
	//***************Write your code in the below******************//
		Node<E> curNode = head;
		for (int i = 0; i < numItems; i++)
		{
			curNode = curNode.next;
			if (curNode.item.equals(x))
			{
				return i;
			}
		}
		return -1;
	//*************************************************************//
	}
	
	// Implementation of len(): Retrieving the total number of elements in the list
	// Return the total number of elements in the list
	public int len() {
	//***************Write your code in the below******************//
		return numItems;
	//*************************************************************//
	}
	
	// Implementation of isEmpty(): Checking if the list is empty
	// Return true if the list is empty
	// Return false otherwise
	public boolean isEmpty() {
	//***************Write your code in the below******************//
		return numItems == 0;
	//*************************************************************//
	}

	// Implementation of clear(): Cleaning the list thoroughly
	// Empty the entire list
	public void clear() {
	//***************Write your code in the below******************//
		head.next = null;
		numItems = 0;
		return;
	//*************************************************************//
		
	}
	
	///////////////////////////////////////////////////////////////////////
	public String printAll() {
		Node<E> t;
		// System.out.print("Print list (#items=" + numItems + ") ");
		// for(t=head.next; t != null; t = t.next) {
		// 	System.out.print(t.item + " ");
		// }
		// System.out.println();

		String print_all = "Print list (#items=" + numItems + ") ";
		for(t=head.next; t != null; t = t.next) 
			print_all += t.item + " ";
		System.out.println(print_all);
		return print_all;

	}
} 

