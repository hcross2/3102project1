package pkg3102hw;
import java.util.*;
import java.io.*;
/**
 * @author Hunter Crossett and Steven Truong
 * @class CSC 3102 with Raul Shah Fall 2014
 * @purpose Implement K-ary heap and AVL Trees.
 * @naming Lots of puns. Please do not count off for pun variables.
 */
public class Main 
{
    public class Node // should i make something like Node(node , key)?
    {
        int data;
        Node right = null;
        Node left = null;
        Node parent;        
        int numNodes = 0;
        int height = 1;
        Node(int data)
        {
            this.data = data;
            numNodes++;
        }
    }
    public class kAry
    {
        //public int[] heap;
        public List<Integer> poop = new ArrayList<Integer>(); // lets try arraylist to add stuff
                
        public void insert(int x) //key
    {
        poop.add(x); // add element to the end
        int m = poop.size()-1; // and find the location of that element
        if (m == 0)
            return;
        int index = ((int) Math.floor(((double) m-1)/x)); // index of parent
        //compare & swap parent until not bigger
        while(m!=0  &&(poop.get(m) < poop.get(index) )) // comparing nodes, maybe theres a better way
        {
            int par = ((int) Math.floor(((double) m-1)/x)); // the new node that will be swapped
            int temp = poop.get(m);	// starting to swap stuff
            poop.set(m, poop.get(par)); 
            poop.set(par, temp);
            m = par;
        }
    }
        
        public Integer extractMin() //removes and returns the element of heap with the smallest key
        {
            int min = poop.get(0); // sets min to first node
            if (poop.size() <= 0)
                return -9999;
            if (poop.size() == 1)
                poop.remove(0);
            else
            {
                poop.set(0, poop.get(poop.size()-1));
                poop.remove(poop.size()-1);
            }
            // swap item/key w/ the child that has the lesser key 
        // repeat this until heap-order achieved
        // return the item originally at root                      
            
            return min;
        }
    }
    
    public class AVLtree 
    {
        public Node root; // the 1st node
        public Node current;
        public List<Integer> gun = new ArrayList<Integer>(); // lets try arraylist to add stuff  
        
        public int balanceFact(Node current) // making life ez
        {
            if (current == null)
                    return 0;
            return(height(current.left) - height(current.right));
        }
        
        public int height(Node current) // making life ez
        {
            if (current == null)
                return 0;
            return current.height;
        }
        
        public Node minValue (Node current) // making life ez
        {
            
            while (current.left != null)            
                current = current.left;
           
            return current;
        }
        
        public void insert(int data) //might need a Node*x and int somethign
        {
            Node node = new Node(data); // made some node
            if (root == null) // if theres nothing, add the new node
                root = node;
            else
            {
                current = root;
                while (true) // this keeps going until 1 of those breaks
                {
                    if (data < current.data)  // doing the left
                    {
                        if (current.left == null) // nothing, then add
                        {
                            current.left = node;
                            break;
                        }
                        else
                            current = current.left;
                    }
                    else
                    {
                        if (current.right == null) // doing the right, nothing then add
                        {
                            current.right = node;
                            break;
                        }
                        else
                            current = current.right;
                    }
                }
            }
            // time to fix & check balance factors
            int bal = balanceFact(current);
            //zig zig or left left
            if (bal > 1 && data < current.left.data)
                return ROTATE_RIGHT(current);  /// HAVE TO RIGHT ROTATE
            //zig zig or right right
            if (bal < -1 && data > current.right.data)
                return ROTATE_LEFT(current);
            //zig zag || left right
            if ( bal > 1 && data > current.left.data)
            {
               current.left = ROTATE_LEFT(current.left);
               return ROTATE_RIGHT(current);
            } 
            //zig zag || right left
            if ( bal < -1 && data < current.right.data)
            {
                current.right = ROTATE_RIGHT(current.right);
                return ROTATE_LEFT(current);
            }
            
        }
        
           
        public boolean search(Node root, int x) //x = key
        {
            // this shit is probaly wrong
            if (node == null)
                return false;
            if 
            return true;
        }
        
        public Node successor(Node root, Node x) //key
        {
            if (current.right != null)  // if Rsub != null, succ in Rsub
                return minValue (x.right);
            
            //setting that node as the par & we start going up
            //the parent pointer u ntil we see a node which is 
            //Left child of it's parent. That parent node == successor.
            Node suc = x.parent;
            while( suc != null &&  x == suc.right) // is this right wtf
            {
                x = suc;
                suc = suc.parent;
            }
            return suc;
        }
        
        public int select(int x) // key
        {
            return 1;
        }
        
        public int rank(int x) //x = key
        {
            return 1;
        }
        
    }
    
    public static void main(String[] args) 
    {
        boolean debugAVL = true;
        boolean debugKary = false;
        if (debugAVL)
        {
            try
            {
                Scanner MRIscan = new Scanner(new File("AVLtree-input.txt"));
                while(MRIscan.hasNext())
                {
                    int[] treesome; //idk what I am doing
                    String[] beans = MRIscan.next().split(" ");
                    if (beans[0].equals("IN"))
                        treesome.insert(Integer.parseInt(beans[1]));//insert call
                    else if(beans[0].equals("SR"))
                        treesome.search(beans[1]);
                    else if(beans[0].equals("SC"))
                        treesome.successor(beans[1]);
                    else if(beans[0].equals("SE"))
                        treesome.search(beans[1]);
                    else
                        treesome.rank(beans[1]);
            }
        }catch (FileNotFoundException e) {System.out.println("This shit ain't here");}
        }
        
        if (debugKary)
        {
            try
            {
                int[] something; //idk. what is life?
                Scanner bodyScan = new Scanner(new File("KARYtree-input.txt")); //may not be right.
                while(bodyScan.hasNext())
                {
                    String[] cheese = bodyScan.next().split(" ");
                    if (cheese[0].equals("IN"))
                        something.insert(cheese[1]);
                    else
                        something.extractMin(cheese[1]);
                }
                
            }catch (FileNotFoundException f) {System.out.println("Now this shit ain't right.");}
        
        }
    }
    
}