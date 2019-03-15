	//Java program to implement 
	//a Singly Linked List 
import java.io.*; 
public class LinkedList {
	
	// Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node { 
  
       int data;
       Node next;
       
       Node(int d){
    	 data = d;
    	 next = null;
       }
    } 
    
    
	Node head; // head of list 
  
    
    // Method to insert a new node either in the head (if it is not null otherwise at the tail..) 
    public static LinkedList insert(LinkedList list, int data) 
    { 
       
    	Node new_node = new Node(data);
    	new_node.next = null;
    	
        if (list.head ==null)
        	list.head = new_node;
    
        else{
        	
        	Node last = list.head;
        	while (last.next != null){
        		last = last.next;	
        	}
        
       last.next = new_node;    	
        }
       return list; 
        
        }
    
      
  
    // Method to print the LinkedList. 
    public static void printList(LinkedList list) 
    { 
      
    	Node nodeCurr = list.head;
        while(nodeCurr != null){
          System.out.println(nodeCurr.data);
          nodeCurr = nodeCurr.next;  
        }
    } 
   
    // Driver code 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkedList list = new LinkedList(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
  
        // Print the LinkedList 
        printList(list); 
    } 
	 
}
