package com.ds.implementation.test;

import java.util.LinkedList;

import org.junit.Test;
import com.ds.implementation.util.*;
import com.ds.implementation.BST;
import com.ds.implementation.Node;

public class BST_Test {
	
	private BST<Character,Byte> bst;
	private BinaryTreePrinter<Character, Byte> bTreePrinter;
	
	@Test
	public void addTest(){
		bst = new BST<Character,Byte>('F');	
		bst.addNode('B');
		bst.addNode('A');
		bst.addNode('D');
		System.out.println(bst.getBSTHeight());
		bTreePrinter = new BinaryTreePrinter<Character, Byte>();
		bTreePrinter.printNode(bst.getRoot());
	}
	
	//@Test
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
		
		bst.deleteNode('G');
		
		LinkedList<Node<Character,Byte>> inorder = bst.inorderSequence();
		for(Node<Character,Byte> node:inorder){
			System.out.print(node.getValue() + "\t");
		}
	}
	
//	@Test
	public void inorderSequenceTest(){
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
		for(Node<Character,Byte> node:inorder){
			System.out.print(node.getValue() + "\t");
		}
		
		System.out.println();
		
		LinkedList<Node<Character,Byte>> preorder = bst.preorderSequence();
		for(Node<Character,Byte> node:preorder){
			System.out.print(node.getValue() + "\t");
		}
		
		System.out.println();
		
		LinkedList<Node<Character,Byte>> postorder = bst.postorderSequence();
		for(Node<Character,Byte> node:postorder){
			System.out.print(node.getValue() + "\t");
		}

	}
}
