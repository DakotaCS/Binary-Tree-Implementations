/***********************************************************************
 * Adapted for COMP272 Intro to DS & A, 
 *		SCIS, Athabasca University. 
 *
 * Assignment2, COMP272
 * Class: BinaryTreeTesting.java
 * 
 * Purpose: Creates a BinaryTree<T> object and tests it by performing
 * various method operations on the object. 
 * 
 * @author: Dakota Soares
 * 
 * Student ID: 3318342
 * @date: December 18th, 2018
 *
 */
public class BinaryTreeTesting 
{
	
	public static void main(String[] args) 
	{
		//Create a BinaryTree object of type Integer
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(); 
		//add some data to our tree...
		binaryTree.add(10);
		binaryTree.add(2); 
		binaryTree.add(1);
		binaryTree.add(8);
		binaryTree.add(5);
		binaryTree.add(20);
		binaryTree.add(18);
		binaryTree.add(22); 
		
		//attempt the following operations...
		try
		{
		
		//Test Case 1: 
			System.out.println("Test Case 1");	
		//get the node visited after node x in a pre-order traversal of binaryTree:
		Node preNext = binaryTree.preorderNext(binaryTree.find(2));
		//display the result
		System.out.println("Node after Node(x) - Pre-Order Traversal: " + preNext.getKey()); 
		//get the node visited after node x in a in-order traversal of binaryTree: 
		Node inNext = binaryTree.inorderNext(binaryTree.find(2));
		//display the result
		System.out.println("Node after Node(x) - In-Order Traversal: " + inNext.getKey()); 
		//get the node visited after node x in a post-order traversal of binaryTree:
		Node postNext = binaryTree.postorderNext(binaryTree.find(2));
		//display the result
		System.out.println("Node after Node(x) - Post-Order Traversal: " + postNext.getKey()); 
		
		//Test Case 2:
		System.out.println("Test Case 2");
		//get the node visited after node x in a pre-order traversal of binaryTree:
		Node preNext1 = binaryTree.preorderNext(binaryTree.find(5));
		//display the result
		System.out.println("Node after Node(x) - Pre-Order Traversal: " + preNext1.getKey()); 
		//get the node visited after node x in a in-order traversal of binaryTree: 
		Node inNext1 = binaryTree.inorderNext(binaryTree.find(5));
		//display the result
		System.out.println("Node after Node(x) - In-Order Traversal: " + inNext1.getKey()); 
		//get the node visited after node x in a post-order traversal of binaryTree:
		Node postNext1 = binaryTree.postorderNext(binaryTree.find(5));
		//display the result
		System.out.println("Node after Node(x) - Post-Order Traversal: " + postNext1.getKey()); 
		
		//Test Case 3: 
		System.out.println("Test Case 3");
		//get the node visited after node x in a pre-order traversal of binaryTree:
		Node preNext2 = binaryTree.preorderNext(binaryTree.find(22));
		//display the result
		System.out.println("Node after Node(x) - Pre-Order Traversal: " + preNext2.getKey()); 
		//get the node visited after node x in a in-order traversal of binaryTree: 
		Node inNext2 = binaryTree.inorderNext(binaryTree.find(22));
		//display the result
		System.out.println("Node after Node(x) - In-Order Traversal: " + inNext2.getKey()); 
		//get the node visited after node x in a post-order traversal of binaryTree:
		Node postNext2 = binaryTree.postorderNext(binaryTree.find(22));
		//display the result
		System.out.println("Node after Node(x) - Post-Order Traversal: " + postNext2.getKey()); 
		
		}
		//if any of the traversals end up jumping off the end of the tree:
		catch (IndexOutOfBoundsException e)
		{
			//display a msg: 
			System.out.println("The node visited after node x is not in the BinaryTree.");
		}
	}
		
//end of class BinaryTreeTesting.java
}