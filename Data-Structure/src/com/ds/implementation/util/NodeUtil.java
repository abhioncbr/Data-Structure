package com.ds.implementation.util;

import com.ds.implementation.Node;

/**
 * The Class NodeUtil.
 */
public class NodeUtil {
	
	/**
	 * Gets the node object.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @return the node object
	 */
	public static <T extends Comparable<T>,E> Node<T,E> getNodeObject(T value, E property){
		return new Node<T,E>(value, null, null, null, property);
	}
	
	/**
	 * Gets the node object.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param property the property
	 * @param parent the parent
	 * @return the node object
	 */
	public static <T extends Comparable<T>,E> Node<T,E> getNodeObject(T value, E property, Node<T,E> parent){
		return new Node<T,E>(value, null, null, parent, property);
	}

	

	/**
	 * Gets the node with left child object.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param property the property
	 * @param leftValue the left value
	 * @param leftProperty the left property
	 * @return the node with left child object
	 */
	public static <T extends Comparable<T>,E> Node<T,E> getNodeWithLeftChildObject(T value, E property, T leftValue, E leftProperty){
		Node<T,E> parentNode = getNodeObject(value,property);
		
		Node<T,E> leftNode = getNodeObject(leftValue,leftProperty,parentNode);
		
		parentNode.setLeftNode(leftNode);
		
		return parentNode;
	}

	/**
	 * Gets the node with right child object.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param property the property
	 * @param RightValue the right value
	 * @param RightProperty the right property
	 * @return the node with right child object
	 */
	public static <T extends Comparable<T>,E> Node<T,E> getNodeWithRightChildObject(T value, E property, T RightValue, E RightProperty){
		Node<T,E> parentNode = getNodeObject(value,property);
		
		Node<T,E> righttNode = getNodeObject(RightValue,RightProperty,parentNode);
		
		parentNode.setRightNode(righttNode);
		
		return parentNode;
	}
	
	/**
	 * Gets the node with both child object.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param property the property
	 * @param leftValue the left value
	 * @param leftProperty the left property
	 * @param RightValue the right value
	 * @param RightProperty the right property
	 * @return the node with both child object
	 */
	public static <T extends Comparable<T>,E> Node<T,E> getNodeWithBothChildObject(T value, E property, T leftValue, E leftProperty, T RightValue, E RightProperty){
		Node<T,E> parentNode = getNodeObject(value,property);
		
		Node<T,E> leftNode = getNodeObject(leftValue,leftProperty,parentNode);
		Node<T,E> righttNode = getNodeObject(RightValue,RightProperty,parentNode);
		
		parentNode.setLeftNode(leftNode);
		parentNode.setRightNode(righttNode);
		
		return parentNode;

		
	}

}
