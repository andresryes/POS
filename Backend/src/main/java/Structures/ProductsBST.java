package Structures;

import Models.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductsBST {

    private static int length = 0;
    private static ArrayList<Product> products = new ArrayList<>();
    /* Class containing left and right child of current node and key value*/
    class Node
    {
        Product key;
        Node left, right;

        public Node(Product item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public ProductsBST()
    {
        root = null;
    }

    //search by ID
    public Product searchByID(String key){
        return search(root, key).key;
    }

    // search function
    public Node search(Node root, String key)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || (root.key.getIdProduct()+"").equals(key))
            return root;

        // val is greater than root's key
        if (root.key.getName().compareTo(key) > 0)
            return search(root.left, key);

        // val is less than root's key
        return search(root.right, key);
    }

    public boolean edit(Node root, Product newProduct){
        Node foundNode = search(this.root, newProduct.getIdProduct()+"");
        if(foundNode != null){
            foundNode.key = newProduct;
            return true;
        }else{
            return false;
        }
    }
    // This method mainly calls deleteRec()
    public void deleteKey(Product key)
    {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    public Node deleteRec(Node root, Product key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key.getName().compareTo(root.key.getName()) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.getName().compareTo(root.key.getName()) > 0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    public Product minValue(Node root)
    {
        Product minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // This method mainly calls insertRec()
    public void insert(Product key)
    {
        length++;
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    public Node insertRec(Node root, Product key)
    {

        /* If the tree is empty, return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.getName().compareTo(root.key.getName()) < 0)
            root.left = insertRec(root.left, key);
        else if (key.getName().compareTo(root.key.getName()) > 0)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    public void inorder()
    {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    public void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            products.add(root.key);
            //System.out.print(root.key.getName() + " ");
            inorderRec(root.right);
        }
    }

    public ArrayList<Product> getList(){
        inorder();
        return products;
    }

    public int getLength(){
        return length;
    }


}
