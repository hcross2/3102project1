package pkg3102hw;
import java.util.*;
import java.io.*;
/**
 *
 * @author Hunter Crossett and Stephen Truong
 * @class CSC 3102 with Raul Shah Fall 2014
 * @purpose Implement K-ary heap and AVL Trees.
 * @naming Lots of puns. Please do not count off for pun variables.
 */
public class Main 
{
    public class kAry
    {
        public int[] somethingOrOther;
        
        public void insert(int x) //key
        {
            
        }
        
        public int extractMin() //removes and returns the element of heap with the smallest key
        {
            int min = 0;
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
                Scanner bodyScan = new Scanner(new File("KARYtree-input.txt")); //may not be right.
            }catch (FileNotFoundException f) {System.out.println("Now this shit ain't right.");}
        
        }
    }
    
}
