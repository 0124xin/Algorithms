package E01;

/**
 * ��Ŀ����
 * 
 * ����һ����������������е�����k����㡣
 * 
 * @author he
 *
 */

class ListNode1 {
	int val;
	ListNode1 next = null;

	ListNode1(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val + "";
	}
}

public class J9 {
	public static ListNode1 FindKthToTail(ListNode1 head, int k) {
		    int count=1;//ͳ������Ľ����
	        int temp = 0;
			ListNode1 node = null;
			for (ListNode1 x = head; x!= null; x = x.next) {
				count++;
			}
			//���������ҵ�������k����㲢����
			for (ListNode1 x = head; x!= null; x = x.next) {
				
				++temp;
				if (temp == count-k) {
					return x;
				}
			}
			return node;

	    }

	public static void main(String[] args) {
		ListNode1 l1 = new ListNode1(1);
		l1.next = new ListNode1(2);
		System.out.println(FindKthToTail(l1, 1).toString());

	}
}
