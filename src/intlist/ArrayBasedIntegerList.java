/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 *
 */
package intlist;

public class ArrayBasedIntegerList implements SimpleIntegerListADT {
	
	//Declare (private) constants and instance variables.
	private final int MAX_SIZE = 5;
	private int[] items;
	private int itemCount;
	
	/**
	 * Default constructor - Creates an empty list.
	 */
	public ArrayBasedIntegerList() {
		this.items = new int[MAX_SIZE];
		this.itemCount = 0;
	}
	
	@Override
	public boolean add(int value) {
		if(this.itemCount < MAX_SIZE) {
			//There is space. Add element to the end.
			this.items[itemCount] = value; //Add item.
			this.itemCount++; //Increment the count.
			return true;
		}
		//No Space. Return false.
		return false;
	}

	@Override
	public boolean add(int index, int value) throws IndexOutOfBoundsException {
		if( index < 0 || index > this.itemCount)
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not not valid. Index should be between 0 and " + this.itemCount);
		else if(index >= MAX_SIZE || this.itemCount == MAX_SIZE) //No space to add elements.
			return false; //Return false.
		else { //Add item to the specified position.
			//Shift items from given index onwards.
			for(int i=this.itemCount; i>index; i--)
				this.items[i] = this.items[i-1];
			//Add the value to the specified index.
			this.items[index] = value;
			//Increase item count.
			this.itemCount++;
			return true;
		}
	}

	@Override
	public boolean remove(int value) {
		int i=0;
		//Cheek for the item starting from the beginning.
		while(i<this.itemCount) {
			if(this.items[i] == value) //Item found.
				break; //Stop at that index.
			i++;
		}
		if(i<this.itemCount) { //Item present in the list.
			//Shift all the items after this item to left by 1.
			while(i<this.itemCount && i<MAX_SIZE-1) {
				this.items[i] = this.items[i+1];
				i++;
			}
			//Reduce the item count.
			this.itemCount--; 
			return true;
		}
		return false;
	}

	@Override
	public int removeAt(int index) throws IndexOutOfBoundsException {
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		else{ //There is an item in the specified index.
			//Get item at index to return.
			int retVal = this.items[index];
			//Shift all the items after this item to left by 1.
			for(int i=index+1; i<this.itemCount; i++) {
				this.items[i-1] = this.items[i];
			}
			//Reduce the item count.
			this.itemCount--;
			return retVal;
		}
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException{
		if( index < 0 || index >= this.itemCount)  //There is no item in the specified index.
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		return this.items[index];
	}

	@Override
	public boolean set(int index, int value) throws IndexOutOfBoundsException {
		if( index < 0 || index >= this.itemCount)  //There is no item in the specified index to replace.
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		//Replace value.
		this.items[index] = value;		
		return true;
	}

	@Override
	public int indexOf(int value) {
		//Search for the item from the start of the list.
		for(int i=0; i<this.itemCount; i++)
			if(this.items[i] == value)
				return i;
		//Item not found. return -1.
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
		this.itemCount = 0;
	}

	@Override
	public String toString() {
		if(this.itemCount == 0)
			return "List is empty!";
		String retVal = "List Items (Count: " + this.itemCount + "): ";
		for(int i=0; i<this.itemCount-1; i++)
			retVal += this.items[i] + ", ";
		retVal += this.items[this.itemCount-1];
		return retVal;
	}
}
