package Num1_1_03;

/**
 * P103 T15 �̳�14��д�Ķ��� �����һ��������ӡ��������K���ַ�������
 * args: 3
 * @author he
 *
 */

public class Num_1_03_15<Item> extends ResizingArrayQueueOfStings<Item> {
	private Item[] a;
	private int head;// ����ͷ
	private int taile;// ����β

	@SuppressWarnings("unchecked")
	public Num_1_03_15(int cap) {
		a = (Item[]) new Object[cap];
	}

	// ���ص�����K��Ԫ��
	Item dequeueK(int k) {
		Item item = a[a.length - k-1];
		a[head] = null;// �����������
		return item;

	}
	@Override
	void enqueue(Item item) {
		a[taile++] = item;
	}

	public static void main(String[] args) {
		Num_1_03_15<Integer> a = new Num_1_03_15<Integer>(5);
		for (int i = 0; i < 4; i++) {
			a.enqueue(i);
		}
		
		System.out.println(a.dequeueK(Integer.parseInt(args[0])));

	}

}
