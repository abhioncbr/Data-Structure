package com.ds.implementation;

import java.util.LinkedList;

import com.ds.implementation.util.BinaryTreeUtil;

/**
 * The Class BST.
 *
 * @param <T> the generic type
 */
public class BST<T extends Comparable<T>, E> {
	
	private final Node<T,Byte> root;
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Node<T, Byte> getRoot() {
		return root;
	}

	/**
	 * Instantiates a new bst.
	 *
	 * @param value the value
	 */
	public BST(T value) {
		super();
		root = new Node<T,Byte>(value,null,null,null,null);
	}

	/**
	 * Adds the node.
	 *
	 * @param value the value
	 */
	public void addNode(T value){
		Node<T,Byte> newNode = new Node<T,Byte>(value, null, null, null, null);
		addNode(newNode);
	}
	
	/**
	 * Adds the node.
	 *
	 * @param newNode the new node
	 */
	public void addNode(Node<T,Byte> newNode){
		Node<T,Byte> temp = BinaryTreeUtil.search(newNode.getValue(), root);
		newNode.setParentNode(temp);
		
		if(temp.getValue().compareTo(newNode.getValue()) < 0){
			temp.setRightNode(newNode);
		} else if(temp.getValue().compareTo(newNode.getValue()) > 0){
			temp.setLeftNode(newNode);
		}
	}

	/**
	 * Search node.
	 *
	 * @param value the value
	 * @return the node
	 */
	public Node<T,Byte> searchNode(T value){
		Node<T,Byte> node = BinaryTreeUtil.search(value, root);
		
		if(node.getValue().compareTo(value) == 0)
			return node;
		
		return null;
	}
	
	/**
	 * Delete node.
	 *
	 * @param Value the value
	 * @return the node
	 */
	public Node<T,Byte> deleteNode(T value){
		Node<T,Byte> toBeDeleted = BinaryTreeUtil.search(value, root);
		
		if(toBeDeleted.getValue().compareTo(value)==0)
			if(toBeDeleted.getLeftNode()!=null &&
					toBeDeleted.getRightNode()!=null){
				T inorderPredecessorValue= BinaryTreeUtil.getInorderPredecessor(toBeDeleted, root);
				T inorderSuccessorValue  = BinaryTreeUtil.getInorderSuccessor(toBeDeleted, root);
				Node<T,Byte> inorderPredecessor = inorderPredecessorValue!=null ? BinaryTreeUtil.search(inorderPredecessorValue, root) : null;
				Node<T,Byte> inorderSuccessor = inorderSuccessorValue!=null ? BinaryTreeUtil.search(inorderSuccessorValue, root) : null;
				return BinaryTreeUtil.deleteNode(toBeDeleted,inorderPredecessor, inorderSuccessor );
			}else return BinaryTreeUtil.deleteNode(toBeDeleted);
				
		return null;
	}
	
	public int getBSTHeight(){
		return BinaryTreeUtil.height(root)-1;
	}
	
	/**o
	 * In-order sequence.
	 *
	 * @return the linked list
	 */
	public LinkedList<Node<T,Byte>> inorderSequence(){
		return BinaryTreeUtil.inorderSequence(root);
	}
	
	/**
	 * Pre-order sequence.
	 *
	 * @return the linked list
	 */
	public LinkedList<Node<T,Byte>> preorderSequence(){
		return BinaryTreeUtil.preorderSequence(root);
	}

	/**
	 * Post-order sequence.
	 *
	 * @return the linked list
	 */
	public LinkedList<Node<T,Byte>> postorderSequence(){
		return BinaryTreeUtil.postorderSequence(root);
	}
	
}
