package Num1_1_03;

/**
 * P106 T42 41��ο�42��
 * ����ͨ����ջ����ʱҪ�Ӹ���ת����������ԭ��ջ�е�˳Ԫ��
 * �ڷ��������е�Ԫ�ظ��µ�ջ��ԭ����ջ
 * @author he
 *
 */

class Stack<Item> {
	private Node first;
	private int N;
	private Item temp2[];
	
	private class Node {
		Item item;
		Node next = null;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public Stack() {
	}

	public Stack(Stack<Item> stack) {
	    temp(stack);

	    for(int i=temp2.length-1;i>=0;i--){
	    	this.push(temp2[i]);
	    	stack.push(temp2[i]);
	    }
	    
	    
	}
	//��ת
	@SuppressWarnings("unchecked")
	private void temp(Stack<Item> stack){
		temp2= (Item [])new Object[stack.N];
		int  i=0;
		while(!stack.isEmpty()){
			temp2[i++]=stack.pop();
		}
		
	}
	

}

public class Num_1_03_41_42 {
	public static void main(String[] args) {
          Stack<Integer> stack=new Stack<Integer>();
          for(int i=0;i<5;i++){
        	  stack.push(i);
          }
//          while(!stack.isEmpty()){
//        	  System.out.println(stack.pop());
//          }
          
           Stack <Integer> stack2=new Stack<Integer>(stack);
           while(!stack2.isEmpty()){
        	   System.out.println(stack2.pop()); //4 3 2 1 0
           }
           
	}
}
