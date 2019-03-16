package DataAssignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

public class hash {

	public int numKeys;
	public LinkedList[] table;
        public int Collision_counter;

        public hash(int size){
            this.numKeys = size;
            this.table = new LinkedList[size*2];
            this.Collision_counter = 0;
        }

        public void insert(String k,int x, int y){ //  function to insert 

            if(table[x] == null && table[y] == null) // if both indexes are empty use the first one
            {
            	LinkedList listx = new LinkedList();
        		table[x] = listx;
        		listx.insert(listx, k);
        		System.out.println("At index " + x + " the string " + k + " is stored because both were empty");
            } 
            else if(table[x] != null && table[y] == null) // If index at x is taken and y is empty, use y
            {
            	LinkedList listy = new LinkedList();
        		table[y] = listy;
        		listy.insert(listy, k);
                 System.out.println("At index " + y + " the string " + k + " is stored beacuse it was empty");
             }
            else if(table[x] == null && table[y] != null) // If index at y is taken and x is empty, use x
            {
            	LinkedList listx = new LinkedList();
        		table[x] = listx;
        		listx.insert(listx, k);
                 System.out.println("At index " + x + " the string " + k + " is stored because it was empty");
            }
            else if(table[x] != null && table[y] != null)// If both indexes of the table is not empty, it is a collision
            {
                int xNode = table[x].countNode(table[x]);
                int yNode = table[y].countNode(table[y]);
                if(xNode < yNode){
                	table[x].insert(table[x], k);
                	System.out.println("At index " + x + " the string " + k + " is stored because it had less");
                } else {
                	table[y].insert(table[y], k);
                	System.out.println("At index " + y + " the string " + k + " is stored because it had less");
                }
            	Collision_counter++;
                 System.out.println("COLLISION!!! Counter At: " + Collision_counter);
            }
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

	public static int map2(String k){
		String k1 = k;
		int val = 0;
		int a = 67;
		int e = k1.length();

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
        
       public void search(String k){
    	   int x = hashcompress1(k, (numKeys*2)); 
           int y = hashcompress2(k, (numKeys*2));
           
           if(table[x] != null && table[x].FindNode(table[x], k)){
        	   System.out.println("The element: " + k + " exists at index " + x );
               String printout = table[x].printList(table[x]);
               System.out.println("["+ x +"] : "+ printout);
           } else if(table[y] != null && table[y].FindNode(table[y], k)){
        	   System.out.println("The element: " + k + " exists at index " + y );
               String printout = table[y].printList(table[y]);
               System.out.println("["+ y +"] : "+ printout);
           } else{
        	   System.out.println("That element does not exist in the hash table");
           }
       }
       
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        long startTime = System.currentTimeMillis(); //Initial time

        /* Randomly-generated String method
         * String letters = "abcdefghijklmnopqrstuvwxyz"; // Create a String of the entire alphabet to help create random keys
        StringBuilder Key = new StringBuilder(5); // Creates a string builder of size 5 characters
        Scanner inp = new Scanner(System.in); // Initialize Scanner for input
        System.out.println("Enter the amount of keys: ");
        int size = inp.nextInt();  // Prompts user for input
        hash Hashing = new hash(size); // Constructs an object for the a specific size of keys
        String[] KeyHolders = new String[size]; // Creates an array just to store the keys generated
        for(int i = 0;i<Hashing.getNumKeys();i++){ // Creates random string keys based on the user input
            for(int x = 0; x < 5; x++){ // This loop creates a string of 5 character ex "tgasp"
                int k = (int)(26*Math.random()); // This creates an int between 0-25 (index of the alphabet)
                Key.append(letters.charAt(k)); // Takes the letter from the alphabet string using the index k
            }    
            System.out.println("String: " + Key); // prints the key
            String k = Key.toString(); // Concerts the stringbuilder into a string
            int x = Hashing.hashcompress1(k, (size*2)); // Calls first hash
            int y = Hashing.hashcompress2(k, (size*2)); // Calls Second hash
            System.out.println("First key is "+ x); // Shows first Calculated index
            System.out.println("Second key is "+ y); // Showed second Calculated index
            KeyHolders[i] = k; //Just hold the keys in array in the order generated incase we might need this for something(possibly searching?)     
            Hashing.insert(k, x, y); //Inserts the element 
            Key.setLength(0); // Resets key builders to 0 so the loop can create a new integer 
        }*/
        
        
       /*User-input method, search doesn't work for this
        System.out.println("Enter the hash table size: ");
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        hash Hashing = new hash(size);
        
        System.out.println("Enter the "+ size + " elements: ");
        Scanner input2 = new Scanner(System.in);
       
	        for(int i = 0; i<size; i++){
	        	String k = (input2.next()).toString();
	        	int x = Hashing.hashcompress1(k, size*2);
	        	int y = Hashing.hashcompress2(k, size*2);
	        	Hashing.insert(k, x, y);
	        }*/
        
        //Hard-code String method, search works
        hash Hashing = new hash(5);
        String[] k = {"James", "Jack", "Jill", "Fred", "Richard"};
        
        for(int i = 0; i<5; i++){
        	int x = Hashing.hashcompress1(k[i], 10);
        	int y = Hashing.hashcompress2(k[i], 10);
        	Hashing.insert(k[i], x, y);
        }
        
        
        System.out.println("The number of keys is "+ Hashing.getNumKeys());
        System.out.println("The size of the table is "+ Hashing.getTableSize());
        Hashing.printTable();
        
        Hashing.search("Jill");
        

        long finalTime= System.currentTimeMillis(); // final time
        System.out.println("Executed time in seconds: " + (finalTime - startTime)/1000);		
	}
}