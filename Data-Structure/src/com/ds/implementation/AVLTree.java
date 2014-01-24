package com.ds.implementation;

import com.ds.implementation.util.BinaryTreeUtil;

/**
 * The Class AVLTree.
 *
 * @param <T> the generic type
 * @param <E> the element type
 */
public class AVLTree<T extends Comparable<T>, E> {
	
	private Node<T,Byte> root;

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
		
		//Rearrangement as per AVL tree properties
		if(temp.getParentNode()==null)
			preserveHeightOnAddition(root);
		else
			preserveHeightOnAddition(temp.getParentNode());
	}

	/**
	 * Preserve AVL Tree properties.
	 *
	 * @param parent the parent
	 */
	private void preserveHeightOnAddition(Node<T,Byte> parent){
		if(parent==null)
			return;
			
		int leftHeight  = parent.getLeftNode() !=null ? BinaryTreeUtil.height(parent.getLeftNode()) : 0;
		int rightHeight = parent.getRightNode()!=null ? BinaryTreeUtil.height(parent.getRightNode()): 0;
		if(Math.abs(leftHeight-rightHeight)>1){
			
			//Balancing unbalanced subtree on the basis if left subtree is big or right subtree.
			if(leftHeight>rightHeight){
				
				Node<T,Byte> leftNode = parent.getLeftNode();
				//Rotation on the basis if left child of the parent node has right child or not.
				if(leftNode.getRightNode()==null){
					leftNode.setParentNode(parent.getParentNode());
					leftNode.setRightNode(parent);
					//In-case parent node is root
					if(leftNode.getParentNode()==null)
						root = leftNode;
					
					parent.setParentNode(leftNode);
					parent.setLeftNode(null);
				}else{
					Node<T,Byte> grandRightNode = leftNode.getRightNode();
					
					//rearrangements for left node
					leftNode.setRightNode(grandRightNode.getLeftNode());
					leftNode.setParentNode(grandRightNode);
					
					Node<T,Byte> temp = grandRightNode.getRightNode();
					//rearrangement for grandRight node
					grandRightNode.setParentNode(parent.getParentNode());
					grandRightNode.setLeftNode(leftNode);
					grandRightNode.setRightNode(parent);
					if(parent.getParentNode()==null)
						root = grandRightNode;
					
					//rearrangement for parent node
					parent.setParentNode(grandRightNode);
					parent.setLeftNode(temp);
				}
					
			}else{
				Node<T,Byte> rightNode = parent.getRightNode();
				//Rotation on the basis if right child of the parent node has left child or not.
				if(rightNode.getLeftNode()==null){
					
					//rearrangement for right node to become parent of parent node.
					rightNode.setParentNode(parent.getParentNode());
					rightNode.setLeftNode(parent);
					
					//In-case parent node is root
					if(parent.getParentNode()==null){
						root = rightNode;
					}
					
					////rearrangement for parent node for becoming left node of right node..
					parent.setParentNode(rightNode);
					parent.setRightNode(null);
				}else{
					Node<T,Byte> grandLeftNode = rightNode.getLeftNode();
					
					//rearrangement for right node 
					rightNode.setLeftNode(grandLeftNode.getRightNode());
					rightNode.setParentNode(grandLeftNode);
					
					Node<T,Byte> temp = grandLeftNode.getLeftNode();
					//rearrangement for grand left node
					grandLeftNode.setLeftNode(parent);
					grandLeftNode.setRightNode(rightNode);
					grandLeftNode.setParentNode(parent.getParentNode());
					if(parent.getParentNode()==null)
						root = grandLeftNode;
					
					//rearrangement for parent node
					parent.setParentNode(grandLeftNode);
					parent.setRightNode(temp);
				}
				
			}
		}
	}
}
