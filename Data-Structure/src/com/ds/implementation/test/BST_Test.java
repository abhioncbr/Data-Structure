package com.ds.implementation.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

import com.ds.implementation.BST;
import com.ds.implementation.Node;
import com.ds.implementation.util.TestPrintUtil;

public class BST_Test {
	
	private BST<Character,Byte> bst;
	
	/**
	 * Adds the test.
	 */
	@Test
	public void addTest(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		
		Map<String,String> content = new HashMap<String,String>();
		content.put("Height of a tree", bst.getBSTHeight() + "");
		TestPrintUtil.print(content,"addTest", bst.getRoot(),true,true);
	}
	
	/**
	 * Delete test.
	 */
	@Test
	public void deleteTest(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		bst.addNode('C');
		bst.addNode('E');
		bst.addNode('G');
		bst.addNode('I');
		bst.addNode('H');
		
		TestPrintUtil.printTree(bst.getRoot(), "deleteTest", true, false);
		Map<String,String> content = new HashMap<String,String>();
		content.put("Deleted Node", bst.deleteNode('G').getValue() + "");
		TestPrintUtil.print(content,"deleteTest", bst.getRoot(), false, true);
	}
	
	@Test
	public void deleteTest1(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		bst.addNode('C');
		bst.addNode('E');
		bst.addNode('G');
		bst.addNode('I');
		bst.addNode('H');
		
		TestPrintUtil.printTree(bst.getRoot(), "deleteTest1", true, false);
		Map<String,String> content = new HashMap<String,String>();
		content.put("Deleted Node", bst.deleteNode('F').getValue() + "");
		TestPrintUtil.print(content,"deleteTest", bst.getRoot(), false, true);
	}
	
	@Test
	public void deleteTest2(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		bst.addNode('C');
		bst.addNode('E');
		bst.addNode('G');
		bst.addNode('I');
		bst.addNode('H');
		
		TestPrintUtil.printTree(bst.getRoot(), "deleteTest2", true, false);
		Map<String,String> content = new HashMap<String,String>();
		content.put("Deleted Node", bst.deleteNode('H').getValue() + "");
		TestPrintUtil.print(content,"deleteTest", bst.getRoot(), false, true);
	}
	
	
	@Test
	public void deleteTest3(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		bst.addNode('C');
		bst.addNode('E');
		bst.addNode('G');
		bst.addNode('I');
		bst.addNode('H');
		
		TestPrintUtil.printTree(bst.getRoot(), "deleteTest3", true, false);
		Map<String,String> content = new HashMap<String,String>();
		content.put("Deleted Node", bst.deleteNode('I').getValue() + "");
		TestPrintUtil.print(content,"deleteTest", bst.getRoot(), false, true);
	}
	
	
	@Test
	public void deleteTest4(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		bst.addNode('C');
		bst.addNode('E');
		bst.addNode('G');
		bst.addNode('I');
		bst.addNode('H');
		
		TestPrintUtil.printTree(bst.getRoot(), "deleteTest4", true, false);
		Map<String,String> content = new HashMap<String,String>();
		content.put("Deleted Node", bst.deleteNode('D').getValue() + "");
		TestPrintUtil.print(content,"deleteTest", bst.getRoot(), false, true);
	}


	/**
	 * Inorder sequence test.
	 */
	@Test
	public void sequenceTest(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		bst.addNode('C');
		bst.addNode('E');
		bst.addNode('G');
		bst.addNode('I');
		bst.addNode('H');
		
		LinkedList<Node<Character,Byte>> inorder = bst.inorderSequence();
		StringBuilder inorderBuilder = new StringBuilder();
		for(Node<Character,Byte> node:inorder){
			inorderBuilder.append(node.getValue() + "\t");
		}
		
		
		LinkedList<Node<Character,Byte>> preorder = bst.preorderSequence();
		StringBuilder preorderBuilder = new StringBuilder();
		for(Node<Character,Byte> node:preorder){
			preorderBuilder.append(node.getValue() + "\t");
		}
		
		
		LinkedList<Node<Character,Byte>> postorder = bst.postorderSequence();
		StringBuilder postorderBuilder = new StringBuilder();
		for(Node<Character,Byte> node:postorder){
			postorderBuilder.append(node.getValue() + "\t");

		}
		
		
		Map<String,String> content = new HashMap<String,String>();
		content.put("Inorder Sequence", inorderBuilder.toString());
		content.put("Preorder Sequence", preorderBuilder.toString());
		content.put("Postorder Sequence", postorderBuilder.toString());
		TestPrintUtil.print(content,"addTest", bst.getRoot(),true,true);

	}
}
