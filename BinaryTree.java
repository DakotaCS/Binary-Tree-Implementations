/***********************************************************************
 * Adapted for COMP272 Intro to DS & A, 
 *		SCIS, Athabasca University. 
 *
 * Assignment1, COMP272
 * Class: BinaryTree.java
 * 
 * Purpose: Creates a generic BinaryTree object 
 * 
 * @author: Dakota Soares
 * 
 * Student ID: 3318342
 * @date: December 18th, 2018
 *
 */
//import needed libraries
import java.util.ArrayList;

/** 
 *  Creates an object of type BinaryTree.  
 *  @param n/p 
 *  @return n/p
 *  @throws n/p
 */
public class BinaryTree<T>
{
	//create the root of the tree
    private static Node root;

    /** 
	*  Constructor. Creates an object of type BinaryTree.  
	*  @param data
	*  @return BinaryTree<T>
    *  @throws 
	*/
    public BinaryTree(int data)
    {
    	//assign the tree's root:
        root = new Node(data);
    }

    /** 
	*  Constructor. Creates an object of type BinaryTree.  
	*  @param 
	*  @return BinaryTree<T>
    *  @throws	
    *  */
	public BinaryTree() 
	{
		
	}

    /** 
	*  Adds a node to the tree. 
	*  @param parent, child, orientation
	*  @return 
    *  @throws 
	*/
	public void insert(Node parent, Node child, String orientation)
    {
		//if the orientation is left: 
        if (orientation.equals("left"))
        {
        	//insert the object...
           System.out.println("Inserted " + child.getKey() + " to the left of " + parent.getKey());
           //set the parent's left node
           parent.setLeft(child);
           //set the child's parent
           child.setParent(parent);
        }
        //otherwise we go right...
        else
        {
        	//insert the object...
        	System.out.println("Inserted " + child.getKey() + " to the right of " + parent.getKey());
            //set the parent's right node
        	parent.setRight(child);
        	//set the child's parent
            child.setParent(parent);
        }
    }
	
    /** 
	*  Gets the tree's root.
	*  @param 
	*  @return Node
    *  @throws 
	*/
	public Node getRoot() 
	{
		return root;
	}
	
    /** 
	*  Adds a node to the tree. 
	*  @param value
	*  @return 
    *  @throws 
	*/
    public void add(int value) 
    {
    	//if the root is null
    	if (root == null)
    	{
    		//then create a Node 
    		Node curroot = new Node(value);
    		//set it as the root
    		root = curroot; 
    		//print confirmation
    		System.out.println("root value set as: " + root.key);
    		//return
    		return; 
    	}
    	//otherwise
    	else
    	{
    		//insert it below the root
    		this.insert(root, value);
    	}
    }
	
    /** 
	*  Adds a node to the tree. 
	*  @param node, value
	*  @return 
    *  @throws 
	*/
	public void insert(Node node, int value) 
	{
		//if the value is less then the node's key...
        if (value < node.key) 
        {
        	//and if the node's left child is not null...
            if (node.left != null) 
            {
            	//recurse on the left side...
                insert(node.left, value);
            } 
            else 
            {
            	//print confirmation
                System.out.println("Inserted " + value + " to left of Node " + node.key);
                //create the node and insert it
                node.left = new Node(value);
            }
            
        }
        //if the value is greater then the key
        else if (value > node.key) 
        {
        	//if the node is not null
            if (node.right != null) 
            {
            	//recurse down the left side
                insert(node.right, value);
            } 
            else 
            {
            	//print confirmation
                System.out.println("Inserted " + value + " to right of Node " + node.key);
                //create the node and insert it
                node.right = new Node(value);
            }
        }
    }
	
    /** 
	*  Find a Node. 
	*  @param key
	*  @return Node
    *  @throws 
	*/
	public Node find(int key)
	{
		//try searching for the node from the root
		try 
		{
			Node find = search(this.getRoot(), key); 
			//if an equality is found
			if (find.key == key)
			{
				//return the node
				return find; 
			}
			else
			{
				//otherwise return null
				return null; 
			}
		}
		catch (NullPointerException e)
		{
			//catch our null return and print out that the node could not be found. 
			System.out.println("Node not found!");
			return null; 
		}
	}
	
    /** 
	*  Search for a Node
	*  @param root, int 
	*  @return 
    *  @throws NullPointerException 
	*/
	public Node search(Node root, int key) throws NullPointerException
	{ 
	    //if the root is null or the root is the searched value
	    if (root==null || root.key==key) 
	    {
	    	//return the root
	    	return root; 
	    }
	  
	    //if the root's key is greater then the key
	    if (root.key > key) 
	    	//recurse to the left
	        return search(root.left, key); 
	  
	    // otherwise recurse to the right 
	    return search(root.right, key); 
	} 
	
	//arraylists holding our traversals:
	public ArrayList<Node> preOrderList = new ArrayList<Node>(); 
	public ArrayList<Node> inOrderList = new ArrayList<Node>(); 
	public ArrayList<Node> postOrderList = new ArrayList<Node>(); 

    /** 
	*  Pre-Order traversal
	*  @param Node
	*  @return 
    *  @throws  
	*/
    public void preOrder(Node node) 
    { 
    	//if the node is null
        if (node == null) 
        {
        	//return
            return; 
        }
        //othewise add the node to the list
        preOrderList.add(node);  
        //recurse left
        preOrder(node.getLeft()); 
        //recurse right
        preOrder(node.getRight()); 
    } 
    
    /** 
	*  In-Order traversal
	*  @param Node
	*  @return 
    *  @throws  
	*/
    public void inOrder(Node node)
    {
    	//if the node is null
    	if (node == null)
    	{
    		//return 
    		return; 
    	}
    	//otherwise recurse left
        inOrder(node.getLeft());
        //add the node to the list
        inOrderList.add(node); 
        //recurse right
        inOrder(node.getRight()); 
    }
    
    /** 
	*  Post-Order traversal
	*  @param Node
	*  @return 
    *  @throws 
	*/
    public void postOrder(Node node)
    {
    	//if the node is null
    	if (node == null)
    	{
    		//return
    		return; 
    	}
    	//recurse left
        postOrder(node.getLeft());
        //recurse right
        postOrder(node.getRight());
        //add the node to the list
        postOrderList.add(node); 
    }
    
    /** 
	*  Pre-Order traversal
	*  @param Node
	*  @return Node
    *  @throws IndexOutOfBoundsException 
	*/
    public Node preorderNext(Node x) throws IndexOutOfBoundsException 
    {
    	//get the preorder traversal starting at the root
    	preOrder(root); 
    	//create a node
    	Node cur = null;
    	//for every node in the list...
    	for (int i =0 ; i < preOrderList.size(); i++)
    	{
    		//the cur is equal to the current Node in the list
    		cur = preOrderList.get(i);
    		//if the current node is equal to the parameter
    		if (cur == x)
    		{
    			//return the node that is next in the list
    			return preOrderList.get(i + 1); 
    		}
    	}
    	//return cur
    	return cur; 
    }
    
    /** 
	*  In-Order traversal
	*  @param Node
	*  @return Node
    *  @throws IndexOutOfBoundsException 
	*/
    public Node inorderNext(Node x) throws IndexOutOfBoundsException 
    {
    	//get the inorder traversal starting at the root
    	inOrder(root); 
    	//create a node
    	Node cur = null;
    	//for every node in the list...
    	for (int i =0 ; i < inOrderList.size(); i++)
    	{
    		//the cur is equal to the current Node in the list
    		cur = inOrderList.get(i);
    		//if the current node is equal to the parameter
    		if (cur == x)
    		{
    			//return the node that is next in the list
    			return inOrderList.get(i + 1); 
    		} 
    	}
    	//return cur
    	return cur; 
    }
    
    /** 
	*  Post-Order traversal
	*  @param Node
	*  @return Node
    *  @throws IndexOutOfBoundsException 
	*/
    public Node postorderNext(Node x) throws IndexOutOfBoundsException 
    {
    	//get the postorder traversal starting at the root
    	postOrder(root); 
    	//create a node
    	Node cur = null;
    	//the cur is equal to the current node in the list
    	for (int i =0 ; i < postOrderList.size(); i++)
    	{
    		//the cur is equal to the current node in the list
    		cur = postOrderList.get(i); 
    		//if the current node is equal to the parameter
    		if (cur == x)
    		{
    			//return the node that is next in the list
    			return postOrderList.get(i + 1); 
    		}
    	}
    	//return cur
    	return cur; 
    }    
}

/** 
*  Inner Class: Creates a Node object
*  @param 
*  @return 
*  @throws 
*/
class Node 
{
	//the Node's key
    public int key;
    //the node to the left of the Node
    public Node left;
    //the node to the right of the node
    public Node right;
    //the parent node
    public Node parent; 

    /** 
	*  Creates a Node
	*  @param key
	*  @return Node
    *  @throws  
	*/
    Node (int key) 
    {
    	//set the key equal to the parameter
        this.key = key;
        //the nodes around the node set to defaults
        right = null;
        left = null;
        parent = null; 
    }
    
    /** 
	*  Creates a Node
	*  @param 
	*  @return Node
    *  @throws I
	*/
    Node()
    {
    	right = null; 
    	left = null; 
    	parent = null; 
    }

    /** 
	*  Sets the Node's Key
	*  @param key
	*  @return 
    *  @throws 
	*/
    public void setKey(int key) 
    {
        this.key = key;
    }

    /** 
	*  Gets the Node's Key
	*  @param key
	*  @return int 
    *  @throws 
	*/
    public int getKey() 
    {
        return key;
    }

    /** 
	*  Sets the Node's Left Node
	*  @param Node
	*  @return 
    *  @throws 
	*/
    public void setLeft(Node left) 
    {
        this.left = left;
    }

    /** 
	*  Gets the Node's Left Node
	*  @param 
	*  @return Node
    *  @throws 
	*/
    public Node getLeft() 
    {
        return left;
    }

    /** 
	*  Sets the Node's Right Node
	*  @param Node
	*  @return 
    *  @throws 
	*/
    public void setRight(Node right ) 
    {
        this.right = right;
    }

    /** 
	*  Gets the Node's Right Node
	*  @param 
	*  @return Node 
    *  @throws 
	*/
    public Node getRight() 
    {
        return right;
    }
    
    /** 
	*  Sets the Node's Parent Node
	*  @param Node
	*  @return 
    *  @throws 
	*/
    public void setParent(Node newParent)
    {
    	parent = newParent; 
    }
    
    /** 
	*  Gets the Node's Left Node
	*  @param 
	*  @return Node 
    *  @throws 
	*/
    public Node getParent()
    {
    	return parent; 
    }
//end of Class BinaryTree.java  
}