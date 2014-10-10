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
    public class kAry
    {
        //public int[] heap;
        public List<Integer> poop = new ArrayList<Integer>(); // lets try arraylist to add stuff
        private int size;
        private int x;
        
        public kAry(int x)
        {
            this.x = x;
        }
        
        public void insert(Integer x) //key
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
            // no fucking clue after this
                       
            
            return min;
        }
    }
    
    public class AVLtree 
    {
        public AVLtree root; // the 1st node   
        public List<Integer> gun = new ArrayList<Integer>(); // lets try arraylist to add stuff
        public int avlsize;
        
        public AVLtree()        
        {
            root = null;
        }
        
        public void insert(AVLtree x) //might need a Node*x and int somethign
        {
            if (root == null) // if theres nothing, add the new node
                root = x;       
            
        }
        
           
        public boolean search(AVLtree root, int x) //x = key
        {
            // this shit is probaly wrong
            if (x == null)
                return false;
            if 
            return true;
        }
        
        public int successor(int x) //key
        {
            return 1;
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
