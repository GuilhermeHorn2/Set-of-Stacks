package misc;

import java.util.ArrayList;

public class Set_of_Stacks {
	
	public static class Node{
		private int data;
		private Node next;
		
		public Node(int d) {
			data = d;
		}
		
		public String toString() {
			String s = "";
			s += this.data;
			return s;
		}
		
	}
	
	
	private int max_capacity;
	private static int num_stacks;
	private static ArrayList<Node> top = new ArrayList<>();	
	private static ArrayList<Integer> num_elements = new ArrayList<>();
	
	
	public Set_of_Stacks(int capacity){
		max_capacity = capacity;
		num_stacks = 0;
	}
	
	public int pop(){
			
		int k = num_stacks-1;
		
		if(top.get(k) == null) {
			System.out.println("Empty Stack");
			return -1;
		}
		
		int value = top.get(k).data;
		Node n = top.get(k);
		top.set(k, n.next);
		num_elements.set(k, num_elements.get(k)-1);
		if(num_elements.get(k) == 0) {
			top.remove(k);
			num_elements.remove(k);
			num_stacks--;
		}
		return value;	
	}
	
	public void push(int d){
		
		int k = num_stacks-1;
		
		if(num_stacks == 0 && num_elements.size() == 0) {
			//first stack
			
			Node novo = new Node(d);
			top.add(novo);
			num_elements.add(1);
			num_stacks++;
			return;
			
		}
		
		if(num_elements.get(k) < max_capacity){
			
			Node novo = new Node(d);
			novo.next = top.get(k);
			top.set(k, novo);
			num_elements.set(k, num_elements.get(k)+1);
			return;
		}
		
		if(num_elements.get(k) == max_capacity){
			//I have to create a new stack
		
			Node novo = new Node(d);
			top.add(novo);
			num_elements.add(1);
			
		}
		num_stacks++;	
	}
	
	public int pop_at(int i) {
		
		
		if(i > num_stacks-1) {
			System.out.println("Invalid Stack");
			return -1;
		}
		
	    Node n = top.get(i);
	    int value = n.data;
		top.set(i,n.next);
		num_elements.set(i,num_elements.get(i)-1);
		if(num_elements.get(i) == 0){
			top.set(i, null);
			num_elements.set(i, null);
		}
		return value;
		
		
	}
	
	public ArrayList show_numbers() {
		return num_elements;
	}
	
	public static ArrayList show_tops(){
		return top;
	}
	
	

}
