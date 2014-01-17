package com.ds.implementation.util;

import java.util.LinkedList;

import com.ds.implementation.Node;

public class BinaryTreeUtil {
	
	/**
	 * Height.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param node the node
	 * @return the int
	 */
	public static <T extends Comparable<T>, E> int height(Node<T,E> node){
		int height = 0;
		
		if(node==null){
			height = 0;
		} else if(node.getLeftNode()== null && node.getRightNode()== null){
			height = 1;
		} else if(node.getLeftNode()!= null && node.getRightNode()== null){
			height =1 + height(node.getLeftNode()); 
		} else if(node.getLeftNode()== null && node.getRightNode()!= null){
			height =1 + height(node.getRightNode()); 
		} else if(node.getLeftNode()!= null && node.getRightNode()!= null){
				height = 1 + Math.max(height(node.getLeftNode()), height(node.getRightNode()));
		}
		
		return height;
	}
	

	/**
	 * Search.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param node the node
	 * @return the node
	 */
	public static <T extends Comparable<T>, E> Node<T,E> search(T value, Node<T,E> node){
		if(node == null)
			return null;
			
		if(node.getValue().compareTo(value) < 0 && 
				node.getRightNode() != null){
			return search(value, node.getRightNode());
		}else if(node.getValue().compareTo(value) > 0 && 
				node.getLeftNode() != null){
			return search(value,node.getLeftNode());
		}else if(node.getValue().compareTo(value) == 0){
			return node;
		}
		return node;
	}
	
	/**
	 * Inorder sequence.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param node the node
	 * @return the linked list
	 */
	public static <T extends Comparable<T>, E> LinkedList<Node<T,E>> inorderSequence(Node<T,E> node){
		if(node == null)
			return null;

		LinkedList<Node<T,E>> order = new LinkedList<Node<T,E>>();
		
		if(node.getLeftNode() != null){
			order.addAll(inorderSequence(node.getLeftNode())); 
		}
		
		order.add(node);
		
		if(node.getRightNode() != null){
			order.addAll(inorderSequence(node.getRightNode())); 
		}
		
		return order;
	}
	
	

	/**
	 * Preorder sequence.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param node the node
	 * @return the linked list
	 */
	public static <T extends Comparable<T>, E> LinkedList<Node<T,E>> preorderSequence(Node<T,E> node){
		if(node == null)
			return null;

		LinkedList<Node<T,E>> order = new LinkedList<Node<T,E>>();
		
		order.add(node);
		
		if(node.getLeftNode() != null){
			order.addAll(preorderSequence(node.getLeftNode())); 
		}
		
		if(node.getRightNode() != null){
			order.addAll(preorderSequence(node.getRightNode())); 
		}
		
		return order;
	}
	
	/**
	 * Postorder sequence.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param node the node
	 * @return the linked list
	 */
	public static <T extends Comparable<T>, E> LinkedList<Node<T,E>> postorderSequence(Node<T,E> node){
		if(node == null)
			return null;

		LinkedList<Node<T,E>> order = new LinkedList<Node<T,E>>();
		
		if(node.getLeftNode() != null){
			order.addAll(postorderSequence(node.getLeftNode())); 
		}
		
		if(node.getRightNode() != null){
			order.addAll(postorderSequence(node.getRightNode())); 
		}
		
		order.add(node);
		
		return order;
	}
	
	/**
	 * Delete node.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param toBeDeleted the to be deleted
	 */
	public static <T extends Comparable<T>, E> void deleteNode(Node<T,E> toBeDeleted){
		if(toBeDeleted.equals(toBeDeleted.getParentNode().getLeftNode())){
			toBeDeleted.getParentNode().setLeftNode(null);
		} else if(toBeDeleted.equals(toBeDeleted.getParentNode().getRightNode())){
			toBeDeleted.getParentNode().setRightNode(null);
		}
		toBeDeleted.setParentNode(null);
	}

}
