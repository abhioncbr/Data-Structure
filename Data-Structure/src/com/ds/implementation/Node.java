package com.ds.implementation;

/**
 * The Class Node.
 *
 * @param <T> the generic type
 * @param <E> the element type
 * @author Abhishek Sharma
 */
public class Node<T extends Comparable<T>,E>{
	
	private T value;
	private Node<T,E> leftNode;
	private Node<T,E> rightNode;
	private Node<T,E> parentNode;
	private E property;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param value the value
	 * @param leftNode the left node
	 * @param rightNode the right node
	 * @param parentNode the parent node
	 * @param property the property
	 */
	public Node(T value, Node<T,E> leftNode, Node<T,E> rightNode, Node<T,E> parentNode,E property) {
		super();
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.parentNode = parentNode;
		this.property = property;
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param value the value
	 * @param property the property
	 */
	public Node(T value, E property) {
		super();
		this.value = value;
		this.property = property;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Gets the left node.
	 *
	 * @return the left node
	 */
	public Node<T,E> getLeftNode() {
		return leftNode;
	}

	/**
	 * Sets the left node.
	 *
	 * @param leftNode the left node
	 */
	public void setLeftNode(Node<T,E> leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * Gets the right node.
	 *
	 * @return the right node
	 */
	public Node<T,E> getRightNode() {
		return rightNode;
	}

	/**
	 * Sets the right node.
	 *
	 * @param rightNode the right node
	 */
	public void setRightNode(Node<T,E> rightNode) {
		this.rightNode = rightNode;
	}

	/**
	 * Gets the parent node.
	 *
	 * @return the parent node
	 */
	public Node<T,E> getParentNode() {
		return parentNode;
	}

	/**
	 * Sets the parent node.
	 *
	 * @param parentNode the parent node
	 */
	public void setParentNode(Node<T,E> parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * Gets the property.
	 *
	 * @return the property
	 */
	public E getProperty() {
		return property;
	}

	/**
	 * Sets the property.
	 *
	 * @param property the new property
	 */
	public void setProperty(E property) {
		this.property = property;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leftNode == null) ? 0 : leftNode.hashCode());
		result = prime * result
				+ ((parentNode == null) ? 0 : parentNode.hashCode());
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
		result = prime * result
				+ ((rightNode == null) ? 0 : rightNode.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T,E> other = (Node<T,E>) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
