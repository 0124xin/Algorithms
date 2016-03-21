package Numbe_1;

import java.util.Iterator;

/**
 * ʹ������ʵ����ѹջ ��ͷ���ʵ��push() ��pop()����
 * args:a s d - - f g h - j k l o
 * @author he
 *
 */
public class Stack<Item> implements Iterable<Item> {
	private Node first;// ͷ���
	private int N; // ջ��Ԫ�ظ���
	// ����Ľ��

	private class Node {
		Item item;
		Node next;
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

	public int size() {
		return N;
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new listIterator() ;
	}

	private class listIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {

			return current != null;
		}

		// ��ȡͷ���
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		for (String string : args) {
			if (!string.equals("-")) {
				stack.push(string);
			}
			else if (!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
		}
		System.out.println("("+stack.size()+" left on stack"+")");
	}
	
}
