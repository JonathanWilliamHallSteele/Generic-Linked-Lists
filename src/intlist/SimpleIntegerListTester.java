/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 *
 */
package intlist;

import java.util.Scanner;

public class SimpleIntegerListTester {

	public static void main(String[] args) {
		SimpleIntegerListADT myList = null;
		System.out.println("Select the implementation type.\n\t1 for ArrayBasedIntegerList.\n\t2 for GrowingArrayBasedIntegerList.\n\t3 for LinkedIntegerList.");
		Scanner myScanner = new Scanner(System.in);
		int option = myScanner.nextInt();
		myScanner.close();
		switch(option) {
		case 3:
			myList = new LinkedIntegerList();
			break;
		case 2:
			myList = new GrowingArrayBasedIntegerList();
			break;
		case 1:
		default:
			myList = new ArrayBasedIntegerList();
		}
		
		System.out.println(myList);
		for(int i=2; i<8; i+=2)
			myList.add(i);
		System.out.println(myList);
		myList.add(1, 10);
		System.out.println(myList);
		myList.add(66);
		System.out.println(myList);
		myList.add(44);
		System.out.println(myList);
		
		myList.remove(66);
		System.out.println(myList);
		myList.remove(4);
		System.out.println(myList);
		myList.remove(2);
		System.out.println(myList);
		
		myList.add(0, 44);
		System.out.println(myList);
		
		myList.add(3, 22);
		System.out.println(myList);
		
		myList.add(4, 33);
		System.out.println(myList);
		
		myList.add(5, 55);
		System.out.println(myList);
		
		myList.add(2, 55);
		System.out.println(myList);
		
		System.out.println(myList.contains(44));
		System.out.println(myList.indexOf(44));
		System.out.println(myList.contains(10));
		System.out.println(myList.indexOf(10));
		System.out.println(myList.contains(33));
		System.out.println(myList.indexOf(33));
		System.out.println(myList.contains(11));
		System.out.println(myList.indexOf(11));
		
	}

}
