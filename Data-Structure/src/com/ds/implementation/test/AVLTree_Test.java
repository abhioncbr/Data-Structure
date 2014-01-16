package com.ds.implementation.test;

import org.junit.Test;

import com.ds.implementation.AVLTree;
import com.ds.implementation.util.BinaryTreePrinter;

public class AVLTree_Test {
	
	private AVLTree<Character,Byte> tree;
	private BinaryTreePrinter<Character, Byte> bTreePrinter;

	
	
	@Test
	public void addTest(){
		tree = new AVLTree<Character,Byte>('F');	
		tree.addNode('B');
		tree.addNode('A');
		tree.addNode('D');
		bTreePrinter = new BinaryTreePrinter<Character, Byte>();
		bTreePrinter.printNode(tree.getRoot());
	}

}
