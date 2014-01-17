package com.ds.implementation.test;

import org.junit.Test;

import com.ds.implementation.AVLTree;
import com.ds.implementation.util.BinaryTreePrinter;
import com.ds.implementation.util.NodeUtil;

public class AVLTree_Test {
	
	private AVLTree<Character,Byte> tree;

	@Test
	public void addTest1(){
		tree = new AVLTree<Character,Byte>('F');	
		tree.addNode('B');
		tree.addNode('A');
		tree.addNode('D');
		BinaryTreePrinter.printNode(tree.getRoot());
	}
	
	@Test
	public void addTest2(){
		tree = new AVLTree<Character,Byte>('G');	
		tree.addNode('C');
		tree.addNode('E');
		BinaryTreePrinter.printNode(tree.getRoot());
	}

	@Test
	public void addTest3(){
		tree = new AVLTree<Character,Byte>('G');	
		tree.addNode('C');
		tree.addNode(NodeUtil.getNodeWithBothChildObject('E', new Byte("1"), 'D', null, 'F', null));
		
		BinaryTreePrinter.printNode(tree.getRoot());
	}

}
