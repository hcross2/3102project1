package pkg3102hw;
import java.util.*;
import java.io.*;
/**
 *
 * @author Hunter Crossett and Stephen Truong
 * @class CSC 3102 with Raul Shah Fall 2014
 * @purpose Implement K-ary heap and AVL Trees.
 */
public class Main 
{
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
        try
        {
            Scanner scan = new Scanner(new File("AVLtree-input.txt"));
            while(scan.hasNext())
            {
                int[] treesome; //idk what I am doing
                String[] beans = scan.next().split(" ");
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
    
}
