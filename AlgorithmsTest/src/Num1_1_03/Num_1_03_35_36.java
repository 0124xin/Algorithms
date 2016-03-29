package Num1_1_03;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P105 T35 ��������ͨ��,
 * ��ֵʱ��a[taile-1]��ʼ�ģ�a[taile]Ϊnull
 * �������Ƴ�Ԫ��ʱҲҪ��a[taile-1]��ʼ
 * 
 * @author he
 *
 */
class RandomQueue<Item> implements Iterable<Item>{

	private Item[] a;
	private int N;// size
	private int head;// ����ͷ
	private int taile;// ����β

	@SuppressWarnings("unchecked")
	public RandomQueue() {
		a = (Item[]) new Object[1];
		head = (a.length + 1) / 2;
		taile = head;
	}

	// ��������
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		int count = 1;// ���ڼ�¼�������е�Ԫ�ظ���
		int newhead = (temp.length + 1) / 2;
		for (int i = 0; i < N; i++) {
			temp[newhead + i] = a[head + i];
			count++;
		}
		head = newhead;// ����head��ָ��
		taile = head + count - 1;// ����tail��ָ��
		a = temp;// ��aָ���µ�����
	}

	// ����ͷ���Ԫ��
	void enqueue(Item item) {
		if (head <= 1) {
			resize(2 * a.length);
		}
		a[--head] = item;
		N++;
	}

	// ����βɾ��Ԫ��
	Item dequeue() {
		// ��ȡhead-taile֮������Ԫ��
//		int temp = head + (int) (Math.random() * (taile - head - 1));
		int temp =StdRandom.uniform(head, taile-1);
		Item item = a[temp];
		// ����t������Ͷ���β��Ԫ��
		a[temp] = a[taile-1];
		a[taile-1] = item;
		N--;
		taile--;
		return item;
	}

	// �������һ��Ԫ�ص���ɾ��
	public Item sample() {
		// ��ȡhead��taile֮��������
//		int temp = head + (int) (Math.random() * (taile - head - 1));
		int temp =StdRandom.uniform(head, taile);
		Item item = a[temp];
		return item;

	}

	// �ж϶����Ƿ�Ϊ��
	boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RecverseArrayIterator();
	}
	private class RecverseArrayIterator implements Iterator<Item> {

		private int i = N;
		private int nhead=head;
		private int ntaile=taile;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		public Item next() {
			//��ȡ����±�
			int temp =StdRandom.uniform(nhead, ntaile-1);
			Item item = a[temp];
			// ����������Ͷ���β��Ԫ��
			a[temp] = a[ntaile-1];
			a[ntaile-1] = item;
			N--;
			ntaile--;
			return item;
		}

		public void remove() {

		}
	}
}

public class Num_1_03_35_36 {
	public static void main(String[] args) {
		RandomQueue<Integer> r = new RandomQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			r.enqueue(i);
			if (i >= 5) {
				System.out.println("dequeue:" + r.dequeue());
			}
			if (i > 0) {
				System.out.println("sample:" + r.sample());
			}
		}

		System.out.println(r.isEmpty());// false
	}

}
