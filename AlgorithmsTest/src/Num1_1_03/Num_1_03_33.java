package Num1_1_03;

/**
 * P104 T33 ˫�������ʵ�ּ�T31����̬����ʵ�� ����ʵ��,��������ͨ��
 * 
 * @author he
 *
 */
class ResizingArrayDeque<Item> {
	private int N;// size
	private Item[] a;
	private int head;// ����ͷָ��������м�
	private int taile;// ����β

	@SuppressWarnings("unchecked")
	public ResizingArrayDeque() {
		a = (Item[]) new Object[1];
		head = a.length / 2;
		taile = head;
	}

	// ��������
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		int newhead = (temp.length + 1) / 2 - (N + 1) / 2;// ���������ͷ���±�
		int count = 1;// ���ڼ�¼�������е�Ԫ�ظ���
		for (int i = 0; i < N; i++) {
			temp[newhead + i] = a[head + i];
			count++;
		}
		head = newhead;// ����head��ָ��
		taile = head + count - 1;// ����tail��ָ��
		a = temp;// ��aָ���µ�����
	}

	public int size() {
		return N;
	}

	// �Ҷ����Ԫ��
	void pushRight(Item item) {
		if (taile >= a.length - 1) {
			resize(2 * a.length);
		}

		a[taile++] = item;
		N++;
	}

	// �Ҷ�ɾ��Ԫ��
	public Item popRight() {
		if (N == 0) {
			throw new IndexOutOfBoundsException();
		}
		N--;
		return a[--taile];
	}

	// ������Ԫ��
	void pushLeft(Item item) {
		if (head <= 1) {
			resize(2 * a.length);
		}

		a[--head] = item;
		N++;
	}

	// ���ɾ��Ԫ��
	public Item popLeft() {
		if (N == 0) {
			throw new IndexOutOfBoundsException();
		}
		N--;
		return a[head++];
	}

}

public class Num_1_03_33 {
	public static void main(String[] args) {
		ResizingArrayDeque<Integer> r = new ResizingArrayDeque<Integer>();
		r.pushLeft(1);
		r.pushLeft(2);
		r.pushLeft(3);
		//// r.pushLeft(32);
//		System.out.println(r.popLeft());
//		System.out.println(r.popLeft());
//		System.out.println(r.popLeft());

		r.pushRight(4);
		// r.pushRight(5);
		// r.pushRight(6);
		System.out.println(r.popRight());
		System.out.println(r.popRight());
		System.out.println(r.popRight());
		System.out.println(r.popRight());

		System.out.println(r.size());
	}

}