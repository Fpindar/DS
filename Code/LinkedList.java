/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashs;

	//Java program to implement 
	//a Singly Linked List 
import java.io.*; 
public class LinkedList {
	
	// Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node { 
       String data;
       Node next;
       
       Node(String d){
    	 data = d;
    	 next = null;
       }
    } 
    
    
	Node head; // head of list 
  
    
    // Method to insert a new node either in the head (if it is not null otherwise at the tail..) 
    public LinkedList insert(LinkedList list, String data) 
    { 
       
    	Node new_node = new Node(data);
    	new_node.next = null;
    	
        if (list.head == null)
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
    
    public boolean FindNode(LinkedList list,String k){
        
        Node nodeCurr = list.head;
        
        while(nodeCurr != null){        
          if(nodeCurr.data != k){
          nodeCurr = nodeCurr.next;      
        } else {
                return true;    
        }
     }
        return false;
    }
  
    // Method to print the LinkedList. 
    public String printList(LinkedList list){ 
    	
    	Node nodeCurr = list.head;
    	String printout = nodeCurr.data;
    	
        while(nodeCurr.next != null){
          nodeCurr = nodeCurr.next; 
          printout = printout + " " + nodeCurr.data + " ";
        }
        return printout;
    } 
   
    public int countNode(LinkedList list){
    	int counter = 0;
    	Node nodeCurr = list.head;
    	while(nodeCurr != null){
    		counter++;
    		nodeCurr = nodeCurr.next;
    	}
    	return counter;
    }
    
    // Driver code 
    public static void main(String[] args) 
    { 
        
    } 
	 
}
