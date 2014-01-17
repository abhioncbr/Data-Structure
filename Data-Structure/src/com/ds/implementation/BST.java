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
		Node<T,Byte> temp = BinaryTreeUtil.search(value, root);

		Node<T,Byte> newNode = new Node<T,Byte>(value,null,null,temp,null);
		
		if(temp.getValue().compareTo(value) < 0){
			temp.setRightNode(newNode);
		} else if(temp.getValue().compareTo(value) > 0){
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
		
		if(toBeDeleted.getValue().compareTo(value) == 0){
			if(toBeDeleted.getLeftNode()==null &&
					toBeDeleted.getRightNode()==null){
				BinaryTreeUtil.deleteNode(toBeDeleted);
			}else if(toBeDeleted.getLeftNode()!=null &&
					toBeDeleted.getRightNode()==null){
				Node<T,Byte> temp = toBeDeleted.getLeftNode();
				Node<T,Byte> parent = toBeDeleted.getParentNode();
				BinaryTreeUtil.deleteNode(toBeDeleted);
				parent.setLeftNode(temp);
			}else if(toBeDeleted.getLeftNode()==null &&
					toBeDeleted.getRightNode()!=null){
				Node<T,Byte> temp = toBeDeleted.getRightNode();
				Node<T,Byte> parent = toBeDeleted.getParentNode();
				BinaryTreeUtil.deleteNode(toBeDeleted);
				temp.setParentNode(parent);
				parent.setRightNode(temp);
			}else if(toBeDeleted.getLeftNode()!=null &&
					toBeDeleted.getRightNode()!=null){
				LinkedList<Node<T,Byte>> inorder = BinaryTreeUtil.inorderSequence(toBeDeleted);
				
 			}
		}
			
		return null;
	}
	
	public int getBSTHeight(){
		return BinaryTreeUtil.height(root)-1;
	}
	
	/**
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
