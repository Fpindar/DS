/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashs;

import java.util.*;

public class hash {

	public int numKeys;
	public LinkedList[] table;
        public int counter;

        public hash(int size){
            this.numKeys = size;
            this.table = new LinkedList[size*2-3];
            this.counter = 0;
        }

        public void insertKey(String k,int x, int y){ //  function to insert 

            LinkedList listx = new LinkedList();
            LinkedList listy = new LinkedList();
            
            if(table[x] == null && table[y] == null) // if both indexes are empty use the first one
            {
            
        		table[x] = listx;
        		listx.insert(listx, k);
        		//System.out.println("At index " + x + " the string " + k + " is stored because both were empty");
                        counter++;
            } 
            else if(table[x] != null && table[y] == null) // If index at x is taken and y is empty, use y
            {
        		table[y] = listy;
        		listy.insert(listy, k);
                // System.out.println("At index " + y + " the string " + k + " is stored beacuse it was empty");
                 counter++;
             }
            else if(table[x] == null && table[y] != null) // If index at y is taken and x is empty, use x
            {
        		table[x] = listx;
        		listx.insert(listx, k);
                 //System.out.println("At index " + x + " the string " + k + " is stored because it was empty");
                 counter++;
            }
            else if(table[x] != null && table[y] != null)// If both indexes of the table is not empty, it is a collision
            {
                
                int xNode = table[x].countNode(table[x]);
                int yNode = table[y].countNode(table[y]);
                
                if(xNode <= yNode){
                	table[x].insert(table[x], k);
                	//System.out.println("At index " + x + " the string " + k + " is stored because it had less");
                } else {
                	table[y].insert(table[y], k);
                	//System.out.println("At index " + y + " the string " + k + " is stored because it had less");
                }
                counter++;
            }
            System.out.println("Total Keys inputted: " + counter);
        }

        public int getTableSize(){ // function to return table size
            return table.length;
        }

        public int getNumKeys(){  // function to return the amount of keys
            return numKeys;
        }

	public static int hashf1(String k){
		int key1 = map1(k);
		return key1;
	}

	public static int hashf2(String k){
		int key2 = map2(k);
		return key2;
	}
        public void search(String Keys[],int size){
            
            int i = 17;
            String element = "fasfaa";
            System.out.println(element);
            
            int x = hashcompress1(Keys[i],(size*2-3)); // Calls first hash
            int y = hashcompress2(Keys[i],(size*2-3));
            
            System.out.println("X index: "+ x);
            System.out.println("Y index: "+ y);
           
            if(table[x].FindNode((table[x]),element) == true ){      
                System.out.println("The Key: " + element + " exists at index " + x );
                String printout = table[x].printList(table[x]);
                System.out.println("["+ x +"] : "+ printout);
            } else if (table[y].FindNode((table[y]),element)== true){
                System.out.println("The Key: " + element + " exists at index " + y );
                String printout = table[y].printList(table[y]);
                System.out.println("["+ y +"] : "+ printout);
            } else {
                System.out.println("That Key does not exist in the hash table");
            }
        }

	public static int map2(String k){
            
		String k1 = k;
		int val = 0; int a = 67; int e = k1.length();
		for(int i = 0; i < k1.length(); i++){
				val = val + ((int)k1.charAt(i) * (int)Math.pow(a, e));
				e--;
			}
		return val;
	}

        public static int map1(String k){
		String k1 = k;
		int val = 0;
		int a = 33;
		int e = k1.length();

		for(int i = 0; i < k1.length(); i++){
				val = val + ((int)k1.charAt(i) * (int)Math.pow(a, e));
				e--;
			}
		return val;
	}

	public int hashcompress2(String k, int m){
		
                int key2 = hashf2(k);
		int key = (int) Math.sqrt(Math.pow((double)(key2%m), 2));
		return key;
                
	}

        public  int hashcompress1(String k, int m){
            
		int key2 = hashf1(k);
		int key = (int) Math.sqrt(Math.pow((double)(key2%m), 2));
		return key;
                
	}
        
       public void printTable(){
    	   for(int i=0;i<table.length;i++){
             if(table[i] != null){
                  String printout = table[i].printList(table[i]);
                  System.out.print("["+ i +"] : "+ printout);
    		  System.out.println();
             } else {
                 System.out.println("["+ i + "] :" );
            }
         } 
       }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        long startTime = System.currentTimeMillis(); //Initial time

        String letters = "abcdefghijklmnopqrstuvwxyz"; // Create a String of the entire alphabet to help create random keys
        StringBuilder Key = new StringBuilder(5); // Creates a string builder of size 5 characters


        Scanner inp = new Scanner(System.in); // Initialize Scanner for input
        System.out.println("Enter the amount of keys");

        int size = inp.nextInt();  // Prompts user for input
       
        hash Hashing = new hash(size); // Constructs an object for the a specific size of keys
        String[] KeyHolders = new String[size]; // Creates an array just to store the keys generated

        for(int i = 0;i<Hashing.getNumKeys();i++){ // Creates random string keys based on the user input
            for(int x = 0; x < 6; x++){ // This loop creates a string of 5 character ex "tgasp"
                
                int k = (int)(26*Math.random()); // This creates an int between 0-25 (indext of the alphabet)
                
                Key.append(letters.charAt(k)); // Takes the letter from the alphabet string using the index k
                
            } 
            
            System.out.println("Key: " + Key); // prints the key

            String k = Key.toString(); // Concerts the stringbuilder into a string

            int x = Hashing.hashcompress1(k, (size*2-3)); // Calls first hash
            int y = Hashing.hashcompress2(k, (size*2-3)); // Calls Second hash

            System.out.println("First key is "+ x); // Shows first Calculated index
            System.out.println("Second key is "+ y); // Showed second Calculated index
            KeyHolders[i] = k; //Just hold the keys in array in the order generated incase we might need this for something(possibly searching?)
            
            Hashing.insertKey(k, x, y); //Inserts the element 

            Key.setLength(0); // Resets key builders to 0 so the loop can create a new integer
        }

        System.out.println("The number of keys is "+ Hashing.getNumKeys());
        System.out.println("The size of the table is "+ Hashing.getTableSize());
        Hashing.printTable();
        
        System.out.println();
        Hashing.search(KeyHolders,size);
       
       
        long finalTime= System.currentTimeMillis(); // final time
        System.out.println("Executed time in seconds: " + (finalTime - startTime)/1000);		
        
	}
}