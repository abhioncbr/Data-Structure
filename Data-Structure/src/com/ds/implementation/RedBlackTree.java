package com.ds.implementation;

import com.ds.implementation.util.BinaryTreeUtil;

/**
 * The Class RedBlackTree.
 *
 * @param <T> the generic type
 * @param <E> the element type
 * 
 * Implementation of Red-Black Tree Data Structure. Properties of Red-Black Tree:
 * 1. A node is either red or black.
 * 2. The root is black. (This rule is sometimes omitted. Since the root can always be changed from red to black, 
 * 		but not necessarily vice-versa, this rule has little effect on analysis.)
 * 3. All leaves (NIL) are black. (All leaves are same color as the root.)
 * 4. Every red node must have two black child nodes.
 * 5. Every path from a given node to any of its descendant leaves contains the same number of black nodes.
 * 
 */
public class RedBlackTree<T extends Comparable<T>, E> {
	
	Node<T,Byte> root;
	
	/**
	 * Instantiates a new red black tree.
	 *
	 * @param value the value
	 */
	public RedBlackTree(T value) {
		super();
		root = new Node<T,Byte>(value,null,null,null,new Byte("1"));
	}

	/**
	 * Adds the node.
	 *
	 * @param value the value
	 */
	public void addNode(T value){
		Node<T,Byte> temp = BinaryTreeUtil.search(value, root);

		//Inserted node as per BST and default red color
		Node<T,Byte> newNode = new Node<T,Byte>(value, null, null, temp, new Byte("0"));
		if(temp.getValue().compareTo(value) < 0){
			temp.setRightNode(newNode);
		} else if(temp.getValue().compareTo(value) > 0){
			temp.setLeftNode(newNode);
		}
		
		//Rearrangement as per Red-Black tree properties
		preserveRBProperty(newNode);
	}
	
	/**
	 * Find grand parent.
	 *
	 * @param node the node
	 * @return the node
	 */
	private Node<T,Byte> findGrandParent(Node<T,Byte> node){
		if(node.getParentNode()!=null)
			return node.getParentNode().getParentNode();
		
		return null;
	}
	
	/**
	 * Find uncle.
	 *
	 * @param node the node
	 * @return the node
	 */
	private Node<T,Byte> findUncle(Node<T,Byte> node){
		Node<T,Byte> gParent = findGrandParent(node);
		
		if(gParent !=null){
			if(node.getParentNode() == gParent.getLeftNode())
				return gParent.getRightNode();
			else
				return gParent.getLeftNode();
		}
		
		return null;
	}

	private void preserveRBProperty(Node<T,Byte> node){
		
		/*if(node.getParentNode()==null){
			node.setProperty(new Byte("1"));
		}else if(){
			
		}*/
	}
}
