package Num1_2_04;

import java.util.LinkedList;

/**
 * P210 24 ������ʵ��һ�����ȶ��� �����е���ʾ�漰������ʾ�����������Լ����������������⣬�Ǻ����½ڵ�����δѧ��
 * ����Ŀ����linkedlist���ֱ�Ҫ������ʵ������������ ���ڴ���ʱ�Ǵ�index=0��ʼ�ģ��������ϸ����³���������Ӧ���޸�
 *
 * @author he
 *
 */

class MaxPQbyList {
	
	private int N = 0;
	private LinkedList<Integer> linkedList;

	public MaxPQbyList() {
		linkedList = new LinkedList<Integer>();
	}

	public void insert(int item) {
		linkedList.add(item);
		N++;
		swim(N - 1);// �ϸ�
	}

	public int delMax() {
		int max = linkedList.get(0);
		exch(0, --N);// ��������һ��Ԫ�ؽ���
		linkedList.removeLast();// �Ƴ����һ��Ԫ��
		sink(0);// �³�
		return max;

	}

	// �ϸ�
	private void swim(int k) {
		while (k > 0 && less(k / 2, k)) { // �޸�
			exch(k / 2, k);
			k = k / 2;
		}
	}

	// �޸�
	private void sink(int k) {
		while (k * 2 < N) { // �޸�
			int i = 2 * k;
			// �ҵ��ӽ��������һ�����
			if (i < N - 1 && less(i, i + 1)) { // �޸�
				i++;
			}
			// ����λ�����м�
			if (!less(k, i)) {
				break;
			}
			exch(k, i);
			k = i;
		}
	}

	private boolean less(int i, int j) {
		return linkedList.get(i) < linkedList.get(j);
	}

	// ��linkedlist�н���Ԫ��
	private void exch(int i, int j) {

		int temp = linkedList.get(i);
		linkedList.set(i, linkedList.get(j));
		linkedList.set(j, temp);

	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public String show() {
		return linkedList.toString();
	}

}

public class Num_2_04_24 {
	public static void main(String[] args) {
		MaxPQbyList x = new MaxPQbyList();
		// x.insert(4);
		// x.insert(100);
		// x.insert(0);
		// x.insert(99);

		for (int i = 0; i < 10; i++) {
			x.insert(i);
		}

		System.out.println(x.show());
		while (!x.isEmpty()) {
			System.out.println(x.delMax());
		}

	}
}
