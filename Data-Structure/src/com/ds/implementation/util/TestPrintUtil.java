package com.ds.implementation.util;

import java.util.Map;

import com.ds.implementation.Node;

/**
 * The Class TestUtil.
 */
public class TestPrintUtil {
	
	/**
	 * Prints the tree.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param root the root
	 * @param testName the test name
	 * @param printHeader the print header
	 * @param printFooter the print footer
	 */
	public static <T extends Comparable<T>, E> void printTree(Node<T,E> root,  String testName, boolean printHeader, boolean printFooter){
		if(printHeader)
			printHeader(testName);
			
		if(root!=null){
			BinaryTreePrinter.printNode(root);
		}

		if(printFooter)
			printFooter();
	}
	
	/**
	 * Prints the test.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param content the content
	 * @param testName the test name
	 * @param root the root
	 */
	public static <T extends Comparable<T>, E> void print(Map<String, String> content, String testName, Node<T,E> root,
			boolean printHeader, boolean printFooter){
		if(printHeader)
			printHeader(testName);
		
		if(content!=null)
			for(String str : content.keySet()){
				System.out.print(str);
				for(int i=0; i<(30 -str.length()) ; i++)
					System.out.print(" ");
				System.out.print("  :  ");
				System.out.println(content.get(str));
			}
		
		if(root!=null){
			BinaryTreePrinter.printNode(root);
		}
		
		if(printFooter)
			printFooter();
	}
	
	/**
	 * Prints the header.
	 *
	 * @param testName the test name
	 */
	private static void printHeader(String testName){
		int hashCount =40 - (testName.length() + 2);
		for(int i=0; i<hashCount/2; i++){
			System.out.print("#");
		}
		System.out.print(" ");
		System.out.print(testName);
		System.out.print(" ");
		for(int i=0; i<hashCount/2; i++){
			System.out.print("#");
		}
		System.out.println(" ");
	}
	
	/**
	 * Prints the footer.
	 */
	private static void printFooter(){
		for(int i=0; i<40; i++){
			System.out.print("#");
		}
		System.out.println(" ");
	}

}
