/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 *
 */
package genericlist;

public class ListNode<AnyType> {
	
	//Instance Variables
	private AnyType value;
	private ListNode<AnyType> next;
	
	//Accessors and Mutators
	public AnyType getValue() {
		return value;
	}
	public void setValue(AnyType value) {
		this.value = value;
	}
	public ListNode<AnyType> getNext() {
		return next;
	}
	public void setNext(ListNode<AnyType> next) {
		this.next = next;
	}
	
	//Constructors
	public ListNode(AnyType value, ListNode<AnyType> next) {
		super();
		this.value = value;
		this.next = next;
	}
	
	public ListNode(AnyType value) {
		super();
		this.value = value;
		this.next = null;
	}
	
	public ListNode() {
		super();
		this.value = null;
		this.next = null;
	}
	
	
}
