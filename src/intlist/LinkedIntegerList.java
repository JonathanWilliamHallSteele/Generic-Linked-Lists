/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 *
 */
package intlist;

public class LinkedIntegerList implements SimpleIntegerListADT {

	//Instance variables
	private IntegerNode head;
	private int itemCount;

	/**
	 * Default constructor.
	 */
	public LinkedIntegerList() {
		super();
		this.head = null;
		this.itemCount = 0;
	}

	@Override
	public boolean add(int value) {
		IntegerNode newNode = new IntegerNode(value);
		if(null == this.head) { //Adding to empty list
			this.head = newNode; //Set new node as head
			this.itemCount = 1; //Set item count to 1
			return true;
		}
		else {
			//Find the last node.
			IntegerNode currNode = this.head;
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

	@Override
	public boolean add(int index, int value) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if(index < 0 || index > itemCount)
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not not valid. Index should be between 0 and " + this.itemCount);
		else if(0 == index){ //Add new value as the first (head) element
			IntegerNode newNode = new IntegerNode(value);
			//Update the next node of new node as the current head node
			newNode.setNext(this.head); 
			//Update the head to point to this node
			this.head = newNode;
			//Increment item count
			this.itemCount++;
			return true;
		}
		else {
			IntegerNode newNode = new IntegerNode(value);
			//Find the node at location index-1
			IntegerNode currNode = this.head;
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

	@Override
	public boolean remove(int value) {
		//TODO: Implement this method
		/***********Dummy Implementation***********/
		return false;
	}

	@Override
	public int removeAt(int index) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		//TODO: Complete this method.
		/***********Dummy Implementation***********/
		return 0;
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		//Get the Node at the index.
		IntegerNode currNode = this.head;
		for(int i=0; i<index; i++) //Note here i goes from 0 to index-1
			currNode = currNode.getNext();
		//return the value of the node.
		return currNode.getValue();
	}

	@Override
	public boolean set(int index, int value) throws IndexOutOfBoundsException {
		//TODO: Implement this method
		/***********Dummy Implementation***********/
		return false;
	}

	@Override
	public int indexOf(int value) {
		//TODO: Implement this method
		/***********Dummy Implementation***********/
		return -1;
	}

	@Override
	public boolean contains(int value) {
		//Search using the indexOf method.
		if(this.indexOf(value) >= 0)
			return true;
		//Item not found.
		return false;
	}

	@Override
	public int size() {
		return this.itemCount;
	}

	@Override
	public void clear() {
		this.head = null;
		this.itemCount = 0;
	}

	@Override
	public String toString() {
		if(null == this.head || 0 == this.itemCount)
			return "List is empty!";
		String retVal = "List Items (Count: " + this.itemCount + "): ";
		IntegerNode currNode = this.head;
		while(null != currNode) {
			retVal += currNode.getValue() + ", ";
			currNode = currNode.getNext();
		}
		return retVal.substring(0, retVal.length()-2);
	}
}
