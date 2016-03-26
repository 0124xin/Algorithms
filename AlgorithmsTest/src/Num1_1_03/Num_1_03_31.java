package Num1_1_03;

/**
 * P104 T31 ˫������ ��һ����� ��ͷ���������head������� β���������head�����ұ�
 * 
 * @author he
 *
 */
class DoubleNode<T> {
	private int N;// ��¼Ԫ�ظ���
	private Node head= new Node(null);// ͷ���
	private Node last= new Node(null);//β���

	private class Node {
		T item;
		Node perv;// ǰһ�����
		Node next;// ��һ�����

		public Node(T val) {
			item = val;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return item+"";
		}
	}

	//����������ȡ���
	public Node getNode(int index){
		if (index <0 || index >= N) {
			throw new IndexOutOfBoundsException();
		}
		Node node=head;
		for(int i=0;i<index;i++){
			node=node.next;
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
		Node newnode = new Node(item);
//		head=newnode;//ͷ�����ǰ�ƣ����²���Ľ��Ϊͷ���
		pushBefore(newnode, head);
//		
	}

	// ��ָ�����ǰ����½��
	public void pushBefore(Node newnode, Node node) {
		newnode.next = node;
		newnode.perv = node.perv;
		newnode.next.perv = newnode;
		if (newnode.perv != null) {
			newnode.perv.next = newnode;
		}
		head=newnode;//����ͷ���
		N++;
	}

	// �ӱ�β����
	public void pushLast(T item) {
		Node newnode = new Node(item);
		pushAfter(newnode, head);
	}

	// ��ָ����������½��
	public void pushAfter(Node newnode, Node node) {
		newnode.perv = node;
		newnode.next = node.next;
		newnode.perv.next = newnode;
		if (newnode.next != null) {
			newnode.next.perv = newnode;
		}
		N++;
	}

	
	
}

public class Num_1_03_31 {
	public static void main(String[] args) {
		DoubleNode<Integer> d = new DoubleNode<Integer>();
		d.pushFirst(1);
		d.pushFirst(2);
		d.pushFirst(3);
		d.pushFirst(4);
		d.pushLast(5);
//		System.out.println(d.size());
       System.out.println(d.getNode(1));
	}

}
