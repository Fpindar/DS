/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAssignment;

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
    
    Node head;
    
    public LinkedList() {
        this.head = null;
    }
    // Method to insert a new node either in the head (if it is not null otherwise at the tail..) 
    public void insert(String data) 
    { 
       
    	Node new_node = new Node(data);
    	
        if (this.head == null)
        	this.head = new_node;
    
        else{
        	
        	Node last = this.head;
        	while (last.next != null){
        		last = last.next;	
        	}
        
       last.next = new_node;    	
        }
        
    }
    
    public boolean FindNode(String k){
        Node nodeCurr = this.head;
        
        while(nodeCurr != null){
          if(!nodeCurr.data.equals(k)){
            nodeCurr = nodeCurr.next;      
          } else {
            return true;    
          }
       }
        return false;
    }
  
    // Method to print the LinkedList. 
    public String printList(){ 
    	
    	Node nodeCurr = this.head;
        if(nodeCurr == null) {
            return "";
        }
        
    	String printout = nodeCurr.data;
    	
        while(nodeCurr.next != null){
          nodeCurr = nodeCurr.next; 
          printout = printout + " " + nodeCurr.data + " ";
        }
        return printout;
    } 
   
    public int countNode(){
    	int counter = 0;
    	Node nodeCurr = this.head;
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