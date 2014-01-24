package com.ds.implementation.test;

import org.junit.Test;

import com.ds.implementation.AVLTree;
import com.ds.implementation.util.BinaryTreePrinter;
import com.ds.implementation.util.NodeUtil;

/**
 * The Class AVLTree_Test.
 */
public class AVLTree_Test {
	
	private AVLTree<Character,Byte> tree;

	/**
	 * Adds the test1.
	 */
	@Test
	public void addTest1(){
		tree = new AVLTree<Character,Byte>('F');	
		tree.addNode('B');
		tree.addNode('A');
		tree.addNode('D');
		printTree("addTest1");
	}
	
	/**
	 * Adds the test2.
	 */
	@Test
	public void addTest2(){
		tree = new AVLTree<Character,Byte>('G');	
		tree.addNode('C');
		tree.addNode('E');
		printTree("addTest2");
	}

	/**
	 * Adds the test3.
	 */
	@Test
	public void addTest3(){
		tree = new AVLTree<Character,Byte>('G');
		tree.addNode('H');
		tree.addNode(NodeUtil.getNodeWithLeftChildObject('C', new Byte("1"), 'A', null));
		tree.addNode(NodeUtil.getNodeWithBothChildObject('E', new Byte("1"), 'D', null, 'F', null));
		
		printTree("addTest3");
	}
	
	@Test
	public void addTest4(){
		tree = new AVLTree<Character,Byte>('C');
		tree.addNode('E');
		tree.addNode('D');
		printTree("addTest4");
	}

	@Test
	public void addTest5(){
		tree = new AVLTree<Character,Byte>('C');
		tree.addNode(NodeUtil.getNodeWithBothChildObject('E', new Byte("1"), 'D', null, 'F', null));
		printTree("addTest5");
	}
	
	private void printTree(String testName){
		System.out.println("################################ " + testName +  " ###########################################");
		BinaryTreePrinter.printNode(tree.getRoot());
		System.out.println("#####################################################################################"+"\n");
	}
}
