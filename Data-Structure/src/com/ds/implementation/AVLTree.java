package com.ds.implementation;

import com.ds.implementation.util.BinaryTreeUtil;

public class AVLTree<T extends Comparable<T>, E> {
	
	private Node<T,Byte> root;
	private final BinaryTreeUtil<T,Byte> util = new BinaryTreeUtil<T,Byte>();

	public AVLTree(T value) {
		super();
		root = new Node<T,Byte>(value,null,null,null,null);
	}
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Node<T, Byte> getRoot() {
		return root;
	}
	
	/**
	 * Adds the node.
	 *
	 * @param value the value
	 */
	public void addNode(T value){
		Node<T,Byte> temp = util.search(value, root);

		//Inserted node as per BST and default red color
		Node<T,Byte> newNode = new Node<T,Byte>(value, null, null, temp, null);
		if(temp.getValue().compareTo(value) < 0){
			temp.setRightNode(newNode);
		} else if(temp.getValue().compareTo(value) > 0){
			temp.setLeftNode(newNode);
		}
		
		//Rearrangement as per AVL tree properties
		preserveAVL(temp.getParentNode());
	}

	private void preserveAVL(Node<T,Byte> parent){
		if(parent==null)
			return;
			
		int leftHeight  = parent.getLeftNode() !=null ? util.height(parent.getLeftNode()) : 0;
		int rightHeight = parent.getRightNode()!=null ? util.height(parent.getRightNode()): 0;
		if(Math.abs(leftHeight-rightHeight)>1){
			
			if(leftHeight>rightHeight){
				
				Node<T,Byte> leftNode = parent.getLeftNode();
				if(leftNode.getRightNode()==null){
					leftNode.setParentNode(parent.getParentNode());
					leftNode.setRightNode(parent);
					//In-case parent node is root
					if(leftNode.getParentNode()==null)
						root = leftNode;
					
					parent.setParentNode(leftNode);
					parent.setLeftNode(null);
				}
					
			}else{
				
			}
		}
	}
}
