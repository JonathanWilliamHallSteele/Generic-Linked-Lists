/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 *
 */
package genericlist;

public class SimpleLinkedListTester {

	public static void main(String[] args) {
		System.out.println("Integer List");
		SimpleLinkedList<Integer> myIntegerList = new SimpleLinkedList<Integer>();
		
		System.out.println(myIntegerList);
		for(int i=2; i<8; i+=2)
			myIntegerList.add(i);
		System.out.println(myIntegerList);
		myIntegerList.add(1, 10);
		System.out.println(myIntegerList);
		myIntegerList.add(66);
		System.out.println(myIntegerList);
		myIntegerList.add(44);
		System.out.println(myIntegerList);
		
		myIntegerList.remove(66);
		System.out.println(myIntegerList);
		myIntegerList.remove(4);
		System.out.println(myIntegerList);
		myIntegerList.remove(2);
		System.out.println(myIntegerList);
		
		myIntegerList.add(0, 44);
		System.out.println(myIntegerList);
		
		myIntegerList.add(3, 22);
		System.out.println(myIntegerList);
		
		myIntegerList.add(4, 33);
		System.out.println(myIntegerList);
		
		myIntegerList.add(5, 55);
		System.out.println(myIntegerList);
		
		myIntegerList.add(2, 55);
		System.out.println(myIntegerList);
		
		System.out.println(myIntegerList.contains(44));
		System.out.println(myIntegerList.indexOf(44));
		System.out.println(myIntegerList.contains(10));
		System.out.println(myIntegerList.indexOf(10));
		System.out.println(myIntegerList.contains(33));
		System.out.println(myIntegerList.indexOf(33));
		System.out.println(myIntegerList.contains(11));
		System.out.println(myIntegerList.indexOf(11));
		
		
		System.out.println("\n\nString List");
		SimpleLinkedList<String> myStringList = new SimpleLinkedList<String>();
		
		System.out.println(myStringList);
		for(int i=2; i<8; i+=2)
			myStringList.add(Integer.toString(i));
		System.out.println(myStringList);
		myStringList.add(1, "10");
		System.out.println(myStringList);
		myStringList.add("66");
		System.out.println(myStringList);
		myStringList.add("44");
		System.out.println(myStringList);
		
		myStringList.remove("66");
		System.out.println(myStringList);
		myStringList.remove("4");
		System.out.println(myStringList);
		myStringList.remove("2");
		System.out.println(myStringList);
		
		myStringList.add(0, "44");
		System.out.println(myStringList);
		
		myStringList.add(3, "22");
		System.out.println(myStringList);
		
		myStringList.add(4, "33");
		System.out.println(myStringList);
		
		myStringList.add(5, "55");
		System.out.println(myStringList);
		
		myStringList.add(2, "55");
		System.out.println(myStringList);
		
		System.out.println(myStringList.contains("44"));
		System.out.println(myStringList.indexOf("44"));
		System.out.println(myStringList.contains("10"));
		System.out.println(myStringList.indexOf("10"));
		System.out.println(myStringList.contains("33"));
		System.out.println(myStringList.indexOf("33"));
		System.out.println(myStringList.contains("11"));
		System.out.println(myStringList.indexOf("11"));

	}
	
	

}
