package Num1_1_03;

/**
 * P106 T40 ����ͨ����Ҫע�⼸�㣬 1.tempΪtrueʱ��break�����򸲸�, 2.����ͷ���ƥ��ʱӦ��pushʱ���Ƴ�ԭ����ͷ���
 * 3.ƥ���������һ�����ʱ����last.next=null������Ҫbreak��
 * 
 * @author he
 *
 */
class MoveToFront<T> {
	private int N;
	private Node first;
	private boolean temp;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	private void newnode(T item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public void push(T item) {
		if (!isContain(item)) {
			// Node oldfirst = first;
			// first = new Node();
			// first.item = item;
			// first.next = oldfirst;
			newnode(item);

		} else {
			// �жϵ�ǰ���
			if (first.item.equals(item)) {
				Node oldfirst = first;
				first = new Node();
				first.item = item;
				first.next = oldfirst.next;
				N--;

			} else {
				delete(item);
				newnode(item);
				// Node oldfirst = first;
				// first = new Node();
				// first.item = item;
				// first.next = oldfirst;
			}
		}
		N++;
	}

	public T pop() {
		T item = first.item;
		first = first.next;
		N--;
		return item;
	}

	private boolean isContain(T item) {
		for (Node x = first; x != null; x = x.next) {
			temp = x.item.equals(item) ? true : false;

			if (temp == true) {
				break;
			}
		}
		return temp;
	}

	private void delete(T item) {
		for (Node x = first; x.next != null; x = x.next) {
			if (x.next.item.equals(item)) {
				if (x.next.next != null) {
					x.next = x.next.next;// �Ƴ�ɾ���Ľ��
				} else {
					x.next = null;
					N--;
					break;
				}
				N--;
			}
		}

	}

}

public class Num_1_03_40 {
	public static void main(String[] args) {
		MoveToFront<String> m = new MoveToFront<String>();
		// args: 1 2 3 3 1
		for (String string : args) {
			m.push(string);
		}

		// m.push(1);
		// m.push(2);
		// m.push(3);
		// m.push(3);
		// m.push(1);

		while (!m.isEmpty()) {
			System.out.println(m.pop()); // 1 3 2
		}
	}

}
