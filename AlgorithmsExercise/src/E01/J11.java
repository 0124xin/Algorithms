package E01;

import java.util.ArrayList;
import java.util.List;

/**
 * ���дһ����������������Ƿ�Ϊ���ġ� ����һ������ListNode* pHead���뷵��һ��bool�����������Ƿ�Ϊ���ġ� ����������
 * {1,2,3,2,1} ���أ�true {1,2,3,2,3} ���أ�false
 * 
 * @author he
 *
 */

class ListNode4 {
	int val;
	ListNode4 next = null;

	ListNode4(int val) {
		this.val = val;
	}
}

public class J11 {
	public static boolean isPalindrome(ListNode4 pHead) {
		int count = 0;//������
		List<ListNode4> list = new ArrayList<ListNode4>();
		for (ListNode4 x = pHead; x != null; x = x.next) {
			count++;
			list.add(x);
		}
		for (int i = 0; i < count / 2; i++) {
			if (list.get(i).val != list.get(count - i - 1).val) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode4 ll1 = new ListNode4(1);
		ll1.next = new ListNode4(2);
		ll1.next.next = new ListNode4(1);
		System.out.println(isPalindrome(ll1));

	}
}