package pkg3102hw;
import java.util.*;
import java.io.*;
/**
 * @author Hunter Crossett and Stephen Truong
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
        
        public void insert(int x) //key
        {
            poop.add(x); // add element to the end
            int m = poop.size()-1; // and find the location of that element
            if (m == 0)
                return;
            //Math.floor: Returns the largest (closest to positive infinity) double value 
            //that is less than or equal to the argument and is equal to a mathematical integer.
            // I found that formula somehwere
            while(m!=0  &&(poop.get(m) < poop.get(((int) Math.floor(((double) m-1)/x)))) ) // comparing nodes, maybe theres a better way
            {
                int par = ((int) Math.floor(((double) m-1)/x)); // the new node that will be swapped
                int tempp = poop.get(m);
                poop.set(m, poop.get(par)); // starting to swap stuff
                poop.set(par, tempp);
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
                poop.set(0, poop.get(poop.size()-1));
                poop.remove(poop.size()-1);
            }
            // no fucking clue after this
                       
            
            return min;
        }
    }
    
    public class AVLtree 
    {
        public int[] treesome; //this doesn't look right
        
        public void insert(int x) //x = key
        {
            
        }
        
        public boolean search(int x) //x = key
        {
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
