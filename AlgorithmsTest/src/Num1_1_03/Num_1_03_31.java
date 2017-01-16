package Num1_1_03;

/**
 * P104 T31 ˫������ �൱�ڼ򻯰��Linkedlist
 * ��Ҫʵ���˴ӱ�ͷ����β����һ����㣬��ָ�����֮ǰ��֮�����һ����㣬
 * �ӱ�ͷ����βɾ��һ����㣬ɾ��ָ����� 
 * ָ���������ؽ��
 * 
 * 
 * ����ͨ����
 * 
 * @author he
 *
 */
class DoubleNode<T> {
	private int N;// ��¼Ԫ�ظ���
	private Node first;// ͷ���
	private Node last;// β���

	private class Node {
		T item;
		Node perv;// ǰһ�����
		Node next;// ��һ�����

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return item + "";
		}
	}

	// ����������ȡ���
	public Node getNode(int index) {
		if (index < 0 || index >= N) {
			throw new IndexOutOfBoundsException();
		}

		Node node = first;

		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		return node;
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return N == 0;
	}

	// Ԫ�ظ���
	public int size() {
		return N;
	}

	// ��ͷ������
	public void pushFirst(T item) {

		Node oldfirst = first;
		first = new Node();
		first.item = item;
		if (isEmpty()) {
			last = first;
		} else {
			first.next = oldfirst;
			oldfirst.perv = first;
		}
		N++;
	}

	// ��ָ�����ǰ����½��
	public void pushBefore(Node newnode, Node node) {
		newnode.next = node;
		newnode.perv = node.perv;
		newnode.next.perv = newnode;
		// ��ֹ��ͷ���ǰ������½��
		if (newnode.perv != null) {
			newnode.perv.next = newnode;
		}
		N++;
	}

	// ��ָ������ǰ�����½��
	public void pushBeforeOfIndex(T item, int index) {
		Node node = getNode(index);
		Node newnode = new Node();
		newnode.item = item;
		if(index==0){
			first=newnode;
		}
		pushBefore(newnode, node);
	}

	// �ӱ�β����
	public void pushLast(T item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
			last.perv = oldlast;
		}
		N++;
	}

	// ��ָ����������½��
	public void pushAfter(Node newnode, Node node) {
		newnode.perv = node;
		newnode.next = node.next;
		newnode.perv.next = newnode;
		// ��ֹ��β���֮������½��
		if (newnode.next != null) {
			newnode.next.perv = newnode;
		}
		N++;
	}

	// ��ָ������֮����ӽ��
	public void pushAfterOfIndex(T item, int index) {
		Node newnode = new Node();
		newnode.item = item;
		Node node = getNode(index);
		pushAfter(newnode, node);

	}

	// �ӱ�ͷɾ��һ�����
	public void popFirst() {
		first = first.next;
		if (first != null) {
			first.perv = null;
		}
		N--;
	}

	// �ӱ�Ϊɾ��һ�����
	public void popLast() {
		last.perv.next = null;
		last.perv = null;
		N--;
	}

	// ɾ��ָ���Ľ��
	private void pop(Node node) {

		node.perv.next = node.next;
		node.next.perv = node.perv;
		node.perv = null;
		node.next = null;
		N--;
	}

	// ɾ��ָ�������Ľ��
	public void popOfIndex(int index) {
		if (index == 0) {
			popFirst();
		} else if (index == N - 1) {
			popLast();
		} else {
			Node node = getNode(index);
			pop(node);
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = first;
		for (int i = 0; i < N; i++) {
			sb.append("[");
			sb.append(node);
			sb.append("]");
			sb.append(",");
			node = node.next;
		}
		return sb.toString();
	}

}

public class Num_1_03_31 {
	public static void main(String[] args) {
		DoubleNode<Integer> d = new DoubleNode<Integer>();
		d.pushFirst(1);
		d.pushFirst(2);
		d.pushFirst(3);
		// d.pushFirst(4);
		d.pushLast(5);
		// d.pushLast(6);
		// System.out.println(d.size());
		// d.pushBeforeOfIndex(10, 1);
		// d.pushAfterOfIndex(9, 0);
		// d.popFirst();
		// d.popFirst();
		d.popOfIndex(0);
		// d.popOfIndex(3);
		// d.popLast();
		System.out.println(d.toString());
		// System.out.println(d.getNode(2));
	}

}
