package bst;

import java.io.PrintStream;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		boolean added = false;
		if (root == null) {
			root = new BinaryNode<E>(x);
			added = true;
		} else {
			added = add(x, root);
		}
		if (added)
			size++;
		return added;
	}

	private boolean add(E x, BinaryNode<E> node) {
		if (x.compareTo(node.element) == 0) {
			return false;
		}

		boolean isLessThanRoot = x.compareTo(node.element) < 0;
		if (isLessThanRoot) {
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				return true;
			}
			return add(x, node.left);
		} else {
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				return true;
			}
			return add(x, node.right);
		}
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		if (root == null) {
			return 0;
		}
		return height(root);
	}

	private int height(BinaryNode<E> node) {
		if (node.left == null && node.right == null)
			return 1;
		if (node.left == null)
			return height(node.right) + 1;
		if (node.right == null)
			return height(node.left) + 1;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BinaryNode<E> node) {
		if (node == null)
			return;
		printTree(node.left);
		System.out.print(node.element + " ");
		printTree(node.right);
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		if (root == null)
			return;
		E[] a = (E[]) new Comparable[size];
		toArray(root, a, 0);
		root = buildTree(a, 0, size - 1);
	}

	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n == null)
			return index;
		index = toArray(n.left, a, index);
		a[index] = n.element;
		index++;
		index = toArray(n.right, a, index);
		return index;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in
	 * the array a are assumed to be in ascending order. Returns the root of
	 * tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int middle = (first + last) / 2;
		BinaryNode<E> node = new BinaryNode<E>(a[middle]);
		if (first == last) {
			return node;
		} else if (first >= last) return null;
		else {
			node.left = buildTree(a, first, middle - 1);
			node.right = buildTree(a, middle + 1, last);
			return node;
		}
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> empty;
		BinarySearchTree<Integer> full; 
		BinarySearchTree<Integer> straight;
		
		empty = new BinarySearchTree<Integer>(); 
		full = new BinarySearchTree<Integer>(); 
		straight = new BinarySearchTree<Integer>();

	    
		full.add(3);
		full.add(1);
		full.add(4);
		
		straight.add(3);
		straight.add(2);
		straight.add(1);
		
		straight.printTree();
		straight.rebuild();
		straight.printTree();
	}
}
