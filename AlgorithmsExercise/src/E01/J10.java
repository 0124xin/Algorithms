package E01;

/**
 * �������������ʾ��������ÿ��������һ����λ����Щ��λ�Ƿ����ŵģ�Ҳ���Ǹ�λ����������ײ�����д������������������ͣ�����������ʽ���ؽ����
 * ������������ListNode* A��ListNode* B���뷵��A+B�Ľ��(ListNode*)��
 * 
 * ���������� {1,2,3},{3,2,1} ���أ�{4,4,4}
 * 
 * @author he
 *
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val + "";
	}
}

public class J10 {
	public static ListNode plusAB(ListNode a, ListNode b) {
		ListNode node = null;
		ListNode old = null;
		for (ListNode x = a; x != null; x = x.next) {
			// ListNode old=node;
			node = new ListNode(-1);
			if (x != null && b != null) {
				node.val = x.val + b.val;
			}
			if (b == null) {
				node.val = x.val;
			}
			if (b.next == null) {
				b.next = b;
				b.next.val = 0;
			}
			b = b.next;
			old = node;
			old.next = node;
			// node.next=old;
		}
		return node;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		ListNode b = new ListNode(3);
		System.out.println(plusAB(a, b));
	}

}