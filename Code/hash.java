/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashs; // Change to hash if yours was initially hash, mine package is different

import java.util.*;

public class hash {
    
	public int numKeys;
	public String[] table;
        public int Collision_counter;
        
        public hash(int size){
            
            this.numKeys = size;
            this.table = new String[size*2];
            this.Collision_counter = 0;
        }
        
        public void insert(String k,int x, int y){ //  function to inset 
           
            // I am not sure if this is the correct way to do this though
            
            if(table[x] == null && table[y] == null) // if both indexes are empty use the first one
            {
            table[x] = k;
            System.out.println("At index " + x + " the string " + k + " is stored");
            } 
            else if(table[x] != null && table[y] == null) // If index at x is taken and y is empty, use y
            {
                 table[y] = k;
                 System.out.println("At index " + y + " the string " + k + " is stored");
             }
            else if(table[x] == null && table[y] != null) // If index at y is taken and x is empty, use x
            {
                 table[x] = k;
                 System.out.println("At index " + x + " the string " + k + " is stored");
            }
            else if(table[x] != null && table[y] != null)// If both indexs of the table is not empty, it is a collision
            {
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
                    for(int x = 0; x < 5; x++){ // This loop creates a string of 5 character ex "tgasp"
                        int k = (int)(26*Math.random()); // This creates an int between 0-25 (indext of the alphabet)
                        Key.append(letters.charAt(k)); // Takes the letter from the alphabet string using the index k
                    }    
                    System.out.println("String: " + Key); // prints the key
                    
                    String k = Key.toString(); // Concerts the stringbuilder into a string
                    
                    int x = Hashing.hashcompress1(k, (size*2)); // Calls first hash
                    int y = Hashing.hashcompress2(k, (size*2)); // Calls Second hash
		
                    System.out.println("First key is "+ x); // Shows first Calculated index
                    System.out.println("Second key is "+ y); // Showed second Calculated index
                    
                    KeyHolders[i] = k; //Just hold the keys in array in the order generated incase we might need this for something(possibly searching?)     
                    Hashing.insert(k, x, y); //Inserts the element (NO COLLISION HANDLING INPUTTED YET)
                    
                    Key.setLength(0); // Resets key builders to 0 so the loop can create a new integer
                }
           
                /* String k = "kjdjctggewtdkedjo";
		int x = Hashing.hashcompress1(k, 10);
		int y = Hashing.hashcompress2(k, 10);
		
		System.out.println("First key is "+ x);
		System.out.println("Second key is "+ y); */
                
                System.out.println("The size of the table is "+ Hashing.getNumKeys());
                System.out.println("The size of the table is "+ Hashing.getTableSize());
                
                long finalTime= System.currentTimeMillis(); // final time
                System.out.println("Executed time in seconds: " + (finalTime - startTime)/1000);		
	}
}

