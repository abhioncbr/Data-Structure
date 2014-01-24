package com.ds.implementation.test;

import org.junit.Test;

import com.ds.implementation.BST;
import com.ds.implementation.Node;
import com.ds.implementation.util.BinaryTreePrinter;
import com.ds.implementation.util.BinaryTreeUtil;
import com.ds.implementation.util.NodeUtil;

/**
 * The Class BinaryTreeUtilTest.
 */
public class BinaryTreeUtilTest {
	
	private BST<Character,Byte> tree;
	
	/**
	 * In-order predecessor test.
	 */
	@Test
	public void inorderPredecessorTest(){
		tree = new BST<Character,Byte>('F');	
		tree.addNode('B');
		tree.addNode('A');
		
		Node<Character,Byte> node = NodeUtil.getNodeObject('D', new Byte("1"));
		tree.addNode(node);
		
		tree.addNode('C');
		tree.addNode('E');
	
		Node<Character,Byte> node1 = NodeUtil.getNodeObject('G', new Byte("1"));
		tree.addNode(node1);

		tree.addNode('I');
		tree.addNode('H');
		
		printTree("inorderPredecessorTest");
		System.out.println(BinaryTreeUtil.getInorderPredecessor(node, tree.getRoot()));
		System.out.println(BinaryTreeUtil.getInorderPredecessor(node1, tree.getRoot()));
	}
	
	/**
	 * Pre-order successor test.
	 */
	@Test
	public void preorderSuccessorTest(){
		tree = new BST<Character,Byte>('F');	
		tree.addNode('B');
		tree.addNode('A');
		
		Node<Character,Byte> node = NodeUtil.getNodeObject('D', new Byte("1"));
		tree.addNode(node);
		
		tree.addNode('C');
		tree.addNode('E');
		
		Node<Character,Byte> node1 = NodeUtil.getNodeObject('G', new Byte("1"));
		tree.addNode(node1);
		
		tree.addNode('I');
		tree.addNode('H');
		
		printTree("preorderSuccessorTest");
		System.out.println(BinaryTreeUtil.getInorderSuccessor(node, tree.getRoot()));
		System.out.println(BinaryTreeUtil.getInorderSuccessor(node1, tree.getRoot()));
	}
	
	/**
	 * Prints the tree.
	 *
	 * @param testName the test name
	 */
	private void printTree(String testName){
		System.out.println("################################ " + testName +  " ###########################################");
		BinaryTreePrinter.printNode(tree.getRoot());
		System.out.println("#####################################################################################"+"\n");
	}

}
