package com.ds.implementation.util;

import java.util.Iterator;
import java.util.LinkedList;

import com.ds.implementation.Node;

/**
 * The Class BinaryTreeUtil.
 */
public class BinaryTreeUtil {
	private static final String LEFT = "LEFT";
	private static final String RIGHT = "RIGHT";
	
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
	 * Gets the in-order predecessor.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param node the node
	 * @return the in-order predecessor
	 */
	public static <T extends Comparable<T>, E> T getInorderPredecessor(Node<T,E> node, Node<T,E> root){
		LinkedList<Node<T,E>> inorderList = BinaryTreeUtil.inorderSequence(root);
		Iterator<Node<T,E>> iterator = inorderList.iterator();
		Node<T,E> previous = null;
		while(iterator.hasNext()){
			Node<T,E> object = iterator.next();
			if(object.equals(node)){
				break;
			}
			previous = object;
		}
		return previous != null ? previous.getValue() : null;
	}
	
	/**
	 * Gets the in-order successor.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param node the node
	 * @return the in-order successor
	 */
	public static <T extends Comparable<T>, E> T getInorderSuccessor(Node<T,E> node, Node<T,E> root){
		LinkedList<Node<T,E>> inorderList = BinaryTreeUtil.inorderSequence(root);
		Iterator<Node<T,E>> iterator = inorderList.iterator();
		while(iterator.hasNext()){
			Node<T,E> object = iterator.next();
			if(object.getValue().compareTo(node.getValue())==0){
				Node<T,E> temp =  iterator.next();
				return temp != null ? temp.getValue() : null;
			}
		}
		return null;
	}
	
	/**
	 * Delete node.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param toBeDeleted the to be deleted
	 * @return true, if successful
	 */
	public static <T extends Comparable<T>, E> Node<T,E> deleteNode(Node<T,E> toBeDeleted){
		if(toBeDeleted.getLeftNode()==null &&
				toBeDeleted.getRightNode()==null){
			BinaryTreeUtil.delete(toBeDeleted);
			return toBeDeleted;
		}else if(toBeDeleted.getLeftNode()!=null &&
				toBeDeleted.getRightNode()==null){
			Node<T,E> temp = toBeDeleted.getLeftNode();
			Node<T,E> parent = toBeDeleted.getParentNode();
			
			String result = BinaryTreeUtil.delete(toBeDeleted);
			if(LEFT.equals(result)){
				parent.setLeftNode(temp);
			}else{
				parent.setRightNode(temp);
			}
			
			temp.setParentNode(parent);
			
			return toBeDeleted;
		}else if(toBeDeleted.getLeftNode()==null &&
				toBeDeleted.getRightNode()!=null){
			Node<T,E> temp = toBeDeleted.getRightNode();
			Node<T,E> parent = toBeDeleted.getParentNode();
			
			String result = BinaryTreeUtil.delete(toBeDeleted);
			if(LEFT.equals(result)){
				parent.setLeftNode(temp);
			}else{
				parent.setRightNode(temp);
			}
			
			temp.setParentNode(parent);

			return toBeDeleted;
		}
		
		return null;
	}
	
	/**
	 * Delete node.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param toBeDeleted the to be deleted
	 * @param inorderSuccessor the in-order successor
	 * @param inorderPredecssor the in-order predecessor
	 * @return true, if successful
	 */
	public static <T extends Comparable<T>, E> Node<T,E> deleteNode(Node<T,E> toBeDeleted, 
					Node<T,E> inorderPredecessor,Node<T,E> inorderSuccessor){
		T toBeDeletedValue = toBeDeleted.getValue();
		if(inorderPredecessor==null && inorderSuccessor!=null){
			toBeDeleted.setValue(inorderSuccessor.getValue());
			if(inorderSuccessor.getRightNode()!=null){
				inorderSuccessor.getParentNode().setLeftNode(inorderSuccessor.getRightNode());
				inorderSuccessor.getRightNode().setParentNode(inorderSuccessor.getParentNode());
			}
			delete(inorderSuccessor);
			inorderSuccessor.setValue(toBeDeletedValue);
			return inorderSuccessor;
		}else{
			toBeDeleted.setValue(inorderPredecessor.getValue());
			if(inorderPredecessor.getLeftNode()!=null){
				inorderPredecessor.getParentNode().setRightNode(inorderPredecessor.getLeftNode());
				inorderPredecessor.getLeftNode().setParentNode(inorderPredecessor.getParentNode());
			}
			delete(inorderPredecessor);
			inorderPredecessor.setValue(toBeDeletedValue);
			return inorderPredecessor;
		}
	}
	
	/**
	 * Delete.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param toBeDeleted the to be deleted
	 */
	public static <T extends Comparable<T>, E> String delete(Node<T,E> toBeDeleted){
		String output = null;
		
		Node<T,E> toBeDeletedParent = toBeDeleted.getParentNode();
		if(toBeDeleted.getParentNode() !=null){
			T toBeDeletedValue = toBeDeleted.getValue();
			T parentLeftNodeValue  = toBeDeletedParent.getLeftNode()!=null? toBeDeletedParent.getLeftNode().getValue() : null;
			T parentRightNodeValue = toBeDeletedParent.getRightNode()!=null? toBeDeletedParent.getRightNode().getValue() : null;
			
			if(parentLeftNodeValue!=null && toBeDeletedValue.compareTo(parentLeftNodeValue)==0){
				toBeDeleted.getParentNode().setLeftNode(null);
				output= LEFT;
			} else if(parentRightNodeValue !=null && toBeDeletedValue.compareTo(parentRightNodeValue)==0){
				toBeDeleted.getParentNode().setRightNode(null);
				output= RIGHT;
			}
		}
		toBeDeleted.setParentNode(null);
		
		return output;
	}
}
