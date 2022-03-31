/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 *
 */
package genericlist;

public class SimpleLinkedList <AnyType> {
	
	//Instance variables
	private ListNode<AnyType> head;
	private int itemCount;
	
	/**
	 * Default constructor.
	 */
	public SimpleLinkedList() {
		super();
		this.head = null;
		this.itemCount = 0;
	}

	public boolean add(AnyType value) {
		ListNode<AnyType> newNode = new ListNode<AnyType>(value);
		if(null == this.head) { //Adding to empty list
			this.head = newNode; //Set new node as head
			this.itemCount = 1; //Set item count to 1
			return true;
		}
		else {
			//Find the last node.
			ListNode<AnyType> currNode = this.head;
			//Last node does not have a next node (null). Therefore, update the currNode to current nodes' next while it is not null.
			while(null != currNode.getNext()) 
				currNode = currNode.getNext();
			//Set next of last node to new node.
			currNode.setNext(newNode);
			//Increment item count
			this.itemCount++;
			return true;
		}
	}

	public boolean add(int index, AnyType value) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if(index < 0 || index > itemCount)
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not not valid. Index should be between 0 and " + this.itemCount);
		else if(0 == index){ //Add new value as the first (head) element
			ListNode<AnyType> newNode = new ListNode<AnyType>(value);
			//Update the next node of new node as the current head node
			newNode.setNext(this.head); 
			//Update the head to point to this node
			this.head = newNode;
			//Increment item count
			this.itemCount++;
			return true;
		}
		else {
			ListNode<AnyType> newNode = new ListNode<AnyType>(value);
			//Find the node at location index-1
			ListNode<AnyType> currNode = this.head;
			for(int i=1; i<index; i++) //Note here i goes from 1 to index-1
				currNode = currNode.getNext();
			//Update the new node to point to the next node of the current node.
			newNode.setNext(currNode.getNext());
			//Update the current node to point to the new node.
			currNode.setNext(newNode);
			//Increment item count
			this.itemCount++;
			return true;
		}
	}

	public boolean remove(AnyType value) {
		if(null == this.head) //List is empty.
			return false;
		else if(this.head.getValue().equals(value)) { //Head node has the value to be removed. Remove head node
			this.head = this.head.getNext();
			this.itemCount--;
			return true;
		}
		else {
			//Search form the first node for the specified value.
			//Here we need to keep a pointer to the previous node of the node we are checking.
			ListNode<AnyType> prevNode = this.head;
			while(null != prevNode.getNext()) {
				if(prevNode.getNext().getValue().equals(value)) { //Next node has the value that should be deleted. Remove it from the list. Set the next of prevNode to next of the next node.
					prevNode.setNext(prevNode.getNext().getNext());
					itemCount--;
					return true;
				}
				prevNode = prevNode.getNext(); //Update prevNode to point to the next node (next of prevNode)
			}
			return false;
		}
	}

	public AnyType removeAt(int index) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		else {
			if(0 == index) { //Remove first (head) value
				AnyType retVal = this.head.getValue(); //Get value at location to return
				this.head = this.head.getNext(); // Update head to point to next of current head.
				itemCount--; //Decrement the item count.
				return retVal;
			}
			else {
				//Traverse to the node before the node to be removed.
				ListNode<AnyType> prevNode = this.head;
				for(int i=1; i<index; i++) //Note here i goes from 1 to index-1
					prevNode = prevNode.getNext();
				AnyType retVal = prevNode.getNext().getValue(); //Get value at location to return.
				prevNode.setNext(prevNode.getNext().getNext()); // Update previous node to point to next of node to be removed.
				itemCount--; //Decrement the item count.
				return retVal;
			}
		}
	}

	public AnyType get(int index) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		//Get the Node at the index.
		ListNode<AnyType> currNode = this.head;
		for(int i=0; i<index; i++) //Note here i goes from 0 to index-1
			currNode = currNode.getNext();
		//return the value of the node.
		return currNode.getValue();
	}

	public boolean set(int index, AnyType value) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		//Get the Node at the index.
		ListNode<AnyType> currNode = this.head;
		for(int i=0; i<index; i++) //Note here i goes from 0 to index-1
			currNode = currNode.getNext();
		//Set the value of the node.
		currNode.setValue(value);
		return true;
	}

	public int indexOf(AnyType value) {
		if(null == this.head || 0 == this.itemCount) //Check for empty list.
			return -1;
		//Search for item starting from the beginning.
		ListNode<AnyType> currNode = this.head;
		int currIndex = 0;
		while(null != currNode) {
			if(currNode.getValue().equals(value)) //Item found.
				return currIndex; //Return index.
			//Increment to the next node.
			currNode = currNode.getNext();
			currIndex++;
		}
		//Item not present in the list.
		return -1;
	}

	public boolean contains(AnyType value) {
		//Search using the indexOf method.
		if(this.indexOf(value) >= 0)
			return true;
		//Item not found.
		return false;
	}

	public int size() {
		return this.itemCount;
	}

	public void clear() {
		this.head = null;
		this.itemCount = 0;
	}
	
	public String toString() {
		if(null == this.head || 0 == this.itemCount)
			return "List is empty!";
		String retVal = "List Items (Count: " + this.itemCount + "): ";
		ListNode<AnyType> currNode = this.head;
		while(null != currNode) {
			retVal += currNode.getValue().toString() + ", ";
			currNode = currNode.getNext();
		}
		return retVal.substring(0, retVal.length()-2);
	}
}
