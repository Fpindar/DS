package DataAssignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

public class hash {

	public int numKeys;
	public LinkedList table[];

        public hash(int size){
            this.numKeys = size;
            this.table = new LinkedList[size];
            for(int i = 0; i < size; i++) {
                table[i] = new LinkedList();
            }
        }

        public void insert(String k){ //  function to insert 
            int x = hashcompress1(k, numKeys); 
            int y = hashcompress2(k, numKeys);
            
            if(table[x].FindNode(k)){
                System.out.println("Already exists at index "+x);
                return;
            }
            
            if(table[y].FindNode(k)) {
                System.out.println("Already exists at index "+y);
                return;
            }
            
            if(table[x].countNode() < table[y].countNode()) {
                System.out.println("Inserting into bucket at index "+x);
                table[x].insert(k);
            } else {
                System.out.println("Inserting into bucket at index "+y);
                table[y].insert(k);
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
    			   System.out.print("["+ i +"] : "+ table[i].printList());
    			   System.out.println();
    		   } else {
    			   System.out.println("["+ i + "] :" );
    		   }
		   } 
       }
        
       public void search(String k){
           int x = hashcompress1(k, (numKeys)); 
           int y = hashcompress2(k, (numKeys));
           
           if(table[x].FindNode(k)){
                System.out.println("The element: " + k + " exists at index " + x );
                String printout = table[x].printList();
                System.out.println("["+ x +"] : "+ printout);
           } else if(table[y].FindNode(k)){
        	System.out.println("The element: " + k + " exists at index " + y );
               String printout = table[y].printList();
               System.out.println("["+ y +"] : "+ printout);
           } else{
        	   System.out.println("That element does not exist in the hash table");
           }
       }
       
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        long startTime = System.currentTimeMillis(); //Initial time

        // Randomly-generated String method
//         String letters = "abcdefghijklmnopqrstuvwxyz"; // Create a String of the entire alphabet to help create random keys
//        StringBuilder Key = new StringBuilder(5); // Creates a string builder of size 5 characters
//        Scanner inp = new Scanner(System.in); // Initialize Scanner for input
//        System.out.println("Enter the amount of keys: ");
//        int size = inp.nextInt();  // Prompts user for input
//        hash Hashing = new hash(size); // Constructs an object for the a specific size of keys
//        String[] KeyHolders = new String[size]; // Creates an array just to store the keys generated
//        for(int i = 0;i<Hashing.getNumKeys();i++){ // Creates random string keys based on the user input
//            for(int x = 0; x < 5; x++){ // This loop creates a string of 5 character ex "tgasp"
//                int k = (int)(26*Math.random()); // This creates an int between 0-25 (index of the alphabet)
//                Key.append(letters.charAt(k)); // Takes the letter from the alphabet string using the index k
//            }    
//            System.out.println("String: " + Key); // prints the key
//            String k = Key.toString(); // Concerts the stringbuilder into a string
//            int x = Hashing.hashcompress1(k, (size*2)); // Calls first hash
//            int y = Hashing.hashcompress2(k, (size*2)); // Calls Second hash
//            System.out.println("First key is "+ x); // Shows first Calculated index
//            System.out.println("Second key is "+ y); // Showed second Calculated index
//            KeyHolders[i] = k; //Just hold the keys in array in the order generated incase we might need this for something(possibly searching?)     
//            Hashing.insert(k); //Inserts the element 
//            Key.setLength(0); // Resets key builders to 0 so the loop can create a new integer 
//        }
        
        
       //User-input method, search doesn't work for this
        System.out.println("Enter the hash table size: ");
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        hash Hashing = new hash(size);
        
        System.out.println("Enter the "+ size + " elements: ");
        Scanner input2 = new Scanner(System.in);
       
        for(int i = 0; i<size; i++){
            String k = input2.next();
            Hashing.insert(k);
        }
        
        //Hard-code String method, search works
        
        /*hash Hashing = new hash(5);
        String[] k = {"James", "Jack", "Jill", "Fred", "Richard"};
        
        for(int i = 0; i<5; i++){
        	int x = Hashing.hashcompress1(k[i], 10);
        	int y = Hashing.hashcompress2(k[i], 10);
        	Hashing.insert(k[i], x, y);
       
        }
        Hashing.search("Jill");
        */
        
        
        System.out.println("The number of keys is "+ Hashing.getNumKeys());
        System.out.println("The size of the table is "+ Hashing.getTableSize());
        Hashing.printTable();
        
        
        
        System.out.println("Enter element to search for: ");
        Scanner input3 = new Scanner(System.in);
        String search = input3.next();
        
        Hashing.search(search);
        

        long finalTime= System.currentTimeMillis(); // final time
        System.out.println("Executed time in seconds: " + (finalTime - startTime)/1000);
        
	}
}