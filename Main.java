package pkg3102hw;
import java.util.*;
import java.io.*;

/**
 * @author Hunter Crossett and Steven Truong
 * @class CSC 3102 with Raul Shah Fall 2014
 * @purpose Implement K-ary heap and AVL Trees.
 * @naming Lots of puns. Please do not count off for pun variables.
 */

public class Main {

    public class Node 
    {
        public int height, balance, size, data; //Steven, use only one line to declare all these
        public Node right = null, left = null, parent = null;

        Node(int data) 
        {
            this.data = data;
            this.height = 0;
            this.balance = 0;
            this.size = 1;
        }
    }

    public class kAry 
    {
        private int x;
        public List<Integer> poop = new ArrayList<Integer>(); // lets try arraylist to add stuff
        
        public kAry(int x)
        {
            this.x = x;
        }

//        public void siftDown(int index) {
//            /* will cycle through all children of heap[index] */
//            int min = index;
//            for (int i = 1; i <= k; i++) {
//                int childIndex = k * index + i;
//                if (childIndex < size) { // index inside current heap
//                    if (heap[childIndex] < heap[min]) {
//                        min = childIndex;
//                    }
//                }
//            }
//            if (min != index) {
//                swap(min, index);
//                siftDown(min);
//            }
//        }
//    }

//        public int extractMin() throws FileNotFoundException {
//            long startTime = System.nanoTime();
//            int min = heap[0];
//            heap[0] = heap[size - 1];
//            size--;
//            siftDown(0);
//            long endTime = System.nanoTime();
//            if (DEBUG) {
//                System.out.println(min + " new min = " + heap[0]);
//            }
//            if (DEBUG) {
//                System.out.println("ExtractMin Time = " + ((endTime - startTime) / 1000));
//            }
//            return min;
//        }

        
        public void insert(int x) //key
        {
            poop.add(x); // add element to the end
            int m = poop.size() - 1; // and find the location of that element
            if (m == 0) {
                return;
            }
            int index = ((int) Math.floor(((double) m - 1) / x)); // index of parent
            //compare & swap parent until not bigger
            while (m != 0 && (poop.get(m) < poop.get(index))) // comparing nodes, maybe theres a better way
            {
                int par = ((int) Math.floor(((double) m - 1) / x)); // the new node that will be swapped
                int temp = poop.get(m);	// starting to swap stuff
                poop.set(m, poop.get(par));
                poop.set(par, temp);
                m = par;
            }
        }

        public int extractMin() //removes and returns the element of heap with the smallest key
        {
            int min = poop.get(0); // sets min to first node
            if (poop.size() <= 0)
                return -9999;            
            if (poop.size() == 1) 
                poop.remove(0);             
            else 
            {
                // swap item/key w/ the child that has the lesser key 
                // repeat this until heap-order achieved
                // return the item originally at root                    
                poop.set(0, poop.get(poop.size() - 1));
                poop.remove(poop.size() - 1);
                int fin = 0;
                int node = 0;
                while (fin == 0) 
                {
                int minchild = 1;
                fin = 1;
                for (int j = 1; j <= x; j++) 
                {
                    if ((node * x + j) >= poop.size()) 
                        break;                    
                    if (poop.get(node * x + j) < poop.get(node * x + minchild)) 
                        minchild = j;                    
                }
                if ((node * x + 1) >= poop.size()) 
                    break;                
                if (poop.get(node * x + minchild) < poop.get(node)) 
                {
                    fin = 0;
                    int temp = poop.get(node);
                    poop.set(node, poop.get(node * x + minchild));
                    poop.set(node * x + minchild, temp);
                }
                node = node * x + minchild;
                }
            }  
            return min;
        }
    }

    public class AVLtree {
        
        public Node root; // the 1st node
        public boolean heightChange = false;

        public void updateBalance(Node x)
        {
            int left, right;
            if (x.left == null)
                left = -1;
            else
                left = x.left.height;
            if (x.right == null)
                right = -1;
            else
                right = x.right.height;
            x.balance = left - right;
            x.height = Math.max(left, right) +1;
        }
        
        public void siftUp(Node x) 
        {
		updateBalance(x);
		if (Math.abs(x.balance) == 2) 
			whereRotate(x);
		while (x != root && heightChange == true)			
			siftUp(x.parent);
		heightChange = false;
	}
        
        public void rotateLeft(Node x) 
        { // can you verify the pointers are correct
		Node y = x.right;
		x.right = null;
		if (y.left != null) 
                {
			Node z = y.left;
			y.left = null;
			z.parent = x;
			x.right = z;
		}
		if (x != root) 
                {
			y.parent = x.parent;
			if (x.parent.left == x) 
				y.parent.left = y;
			else
				y.parent.right = y;			
		} 
                else 
                {
			root = y;
			y.parent = null;
		}
		x.parent = y;
		y.left = x;
		updateBalance(x);
	}
        
        public void rotateRight(Node x) 
        {
		Node y = x.left;
		x.left = null;
		if (y.right != null) 
                {
			Node z = y.right;
			y.right = null;
			z.parent = x;
			x.left = z;
		}
		if (x != root) 
                {
			y.parent = x.parent;
			if (x.parent.left == x) 
				y.parent.left = y;
			else 
				y.parent.right = y;			
		} 
                else 
                {
			root = y;
			y.parent = null;
		}
		x.parent = y;
		y.right = x;
		updateBalance(x);
	}
        
        public void whereRotate(Node x) 
        {
		// which subtree is tallest
		if (x.balance < 0) {// negative, so we are looking at the right subtree
			if (x.right.balance < 0) // Left Left rotation
				rotateLeft(x);
			else 
                        {
				rotateRight(x.right);
				rotateLeft(x);
			}
		} 
                else 
                {// left subtree
			if (x.left.balance > 0) 
				rotateRight(x);
			else 
                        {
				rotateLeft(x.left);
				rotateRight(x);
			}
		}
	}

        public Node minValue(Node x) // making life ez
        {
            if (x.left != null)
                return minValue(x.left);
            else
                return x;
        }
        
        public Node maxValue(Node x) 
        {
		if (x.right != null) 
			return maxValue(x.right);
		else 
			return x;
	}

        public void insert(int data) //ADDED NODE X
                // X REPLACED CURRENT
        {
            Node x;
            Node newNode = new Node(data); // made a new node
            if (root == null) // if theres nothing, add the new nod
            {
                root = newNode; //updates root.
                newNode.height = 1; // root has height 1                
            } 
            else 
            {
                x = root;
                boolean placement = true;
                while (placement) // this keeps going until 1 of these breaks
                {
                    if (newNode.data < x.data) // doing the left
                    {
                        if (x.left == null) // nothing, then add
                        {
                            x.left = newNode;
                            placement = false;
                            newNode.parent = x;
                            newNode.height = newNode.parent.height + 1;
                            
                            // gotta put bf checks in here 
                            if(newNode.balance == 1) 
                            // the siftUp only happens when heightChange = true
                                heightChange = false;
                            else if (newNode.balance == -1)
                                // right heavy tree, need a left rotation
                            {
                                heightChange = true;
                                rotateLeft(newNode);
                                heightChange = false;
                            }
                            else if (newNode.balance == 0)
                                // single left rotation
                                heightChange = true;                                                           
                        } 
                        else 
                            x = x.left;                        
                    } 
                    else 
                    {
                        if (x.right == null) // doing the right, nothing then add
                        {
                            x.right = newNode;
                            placement = false;
                            newNode.parent = x;
                            newNode.height = newNode.parent.height + 1;
                            
                            //balance checks here
                            if(newNode.balance == 1) 
                            // the siftUp only happens when heightChange = true
                                heightChange = false;
                            else if (newNode.balance == -1)
                                // right heavy tree, need a left rotation
                            {
                                heightChange = true;
                                rotateLeft(newNode);
                                heightChange = false;
                            }
                            else if (newNode.balance == 0)
                                // single left rotation
                                heightChange = true;
                        } 
                        else 
                            x = x.right;                        
                    }
                }
                if (heightChange = true) 
                // updates everything when inserted. i think?
                {
                siftUp(newNode);
                updateSize(newNode);
                }
            }         
        }
        
        public void updateSize(Node x) 
        {
            do 
            {
                int left = (x.left != null) ? x.left.size : 0; 
                // the ? just means if true first result : false second result
                // i learned this today 10/18/14 on stackoverflow
                // i hope i used this right
                int right = (x.right != null) ? x.right.size : 0;
                x.size = 1 + left + right;
                x = x.parent;
            } while (x != null);
        }

        public String search(int data) //is this better than using searc(node, data)?
        {
            Node x = root;
            while (true)
            {
                if (x != null) 
                {
                    if (data > x.data) 
                    x = x.right; 
                else if (data < x.data)
                    x = x.left;
                else 
                    return "TRUE";                
                }
                return "FALSE";
            }
        }
        
        public int rank(int data) 
        {
		Node min = minValue(root);
		Node newNode = goGet(root, data);
		int rank = 0;
		while (newNode != null) 
                {
			Node pr = predecessor(newNode.data);
			if (newNode.left != null) 
                        {
				rank += newNode.left.size + 1;
				newNode = predecessor(minValue(newNode.left).data);
			} 
                        else if (pr != null && pr.left == null) 
                        {
				newNode = pr;
				rank++;
			} 
                        else 
                        {
				newNode = pr;
				rank++;
			}
		}
		return rank;
	}

        public Node select(Node x, int i) 
        { // its just like the slides
            if (i <= root.size) 
            {
                if (x.left != null && x.left.size >= i) 
                    // we're going left
                    return select(x.left, i); 
                else if (x.left.size +1 == i)
                    return x;                 
                else 
                    return select(x.right, i-1-(x.left.size));
            } 
            else 
                return null;// index i out of bounds            
        }

        public Node successor(int data) //double check this function
        {
		Node newNode = goGet(root, data);
		if (newNode.right != null) // go down and right
			return minValue(newNode.right);		
		Node y = newNode.parent;
		while (y != null && newNode == y.right) 
                {
			newNode = y;
			y = y.parent;
		}
		return y;
	}

	public Node predecessor(int data) // i need this as well so i can mess 
                //around with rotation
        {
		Node newNode = goGet(root, data);
		if (newNode.left != null) // go down and right
			return maxValue(newNode.left);		
		Node y = newNode.parent;
		while (y != null && newNode == y.left) 
                {
			newNode = y;
			y = y.parent;
		}
		return y;
	}
        
        private Node goGet(Node x, int data) {// i'm trying to make a function
            //where i can just reutn a pointer or somemthing
		if (x != null) 
                {
			if (data > x.data) 
				return goGet(x.right, data);
			else if (data < x.data) 
				return goGet(x.left, data);
			else 
				return x;			
		}
		return x = null;
	}
    }

    public static void main(String[] args) {
        boolean debugAVL = true;
        boolean debugKary = false;
        AVLtree avl = new AVLtree(); //wtf?
        if (debugAVL) {
            try {
                Scanner MRIscan = new Scanner(new File("AVLtree-input.txt"));
                    String[] treesome = MRIscan.next().split(" "); // need to find a better way to read in file
                    for (int j = 0; j < treesome.length; j++)
                    {
                        if (treesome[j].equals("IN")) 
                        { avl.insert(Integer.parseInt(treesome[j+1])); j++; }
                        else if (treesome[j].equals("SR"))
                        { avl.search(Integer.parseInt(treesome[j+1])); j++; }
                        else if (treesome[j].equals("SC")) 
                        { avl.successor(Integer.parseInt(treesome[j+1])); j++; }
                        else if (treesome[j].equals("SE")) 
                        { avl.search(Integer.parseInt(treesome[j+1])); j++; }
                        else 
                        { avl.rank(Integer.parseInt(treesome[j+1])); j++; }
                    }
                
            } catch (FileNotFoundException e) {
                System.out.println("Aint never no file ain't not none here");
            }
        }

        if (debugKary) {
            try {
                int[] something; //idk. what is life?
                Scanner bodyScan = new Scanner(new File("KARYtree-input.txt")); //may not be right.
                while (bodyScan.hasNext()) {
                    String[] cheese = bodyScan.next().split(" ");
                    if (cheese[0].equals("IN")) {
                        something.insert(cheese[1]);
                    } else {
                        something.extractMin(cheese[1]);
                    }
                }

            } catch (FileNotFoundException f) {
                System.out.println("Now this shit ain't right.");
            }

        }
    }

}
