package Num1_1_03;

/**
 * P102 T14 ͨ������ʵ��һ�����в�֧�ֶ�̬����
 * 
 * @author he
 *
 */
public class ResizingArrayQueueOfStings<Item> {

	private Item[] a;
	private int head;// ����ͷ
	private int taile;// ����β

	public ResizingArrayQueueOfStings() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public ResizingArrayQueueOfStings(int cap) {
		a = (Item[]) new Object[cap];
	}

	// ��������
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		int count = 1;// ���ڼ�¼�������е�Ԫ�ظ���
		for (int i = 0; i < taile - head; i++) {
			temp[i] = a[head + i];
			count++;
		}
		head = 0;// ����head��ָ��
		taile = count - 1;// ����tail��ָ��
		a = temp;// ��aָ���µ�����
	}

	// ���Ԫ��
	void enqueue(Item item) {
		if (taile == a.length) {
			resize(2 * a.length);
		}
		a[taile++] = item;
	}

	// ɾ��Ԫ��
	Item dequeue() {
		Item item = a[++head];
		a[head] = null;// �����������
		// �������������
		if (taile > 0 && taile - head == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	// ��ŵ�Ԫ�ظ���
	int size() {
		return taile - head;
	}

	// �ж϶����Ƿ�Ϊ��
	boolean isEmpty() {
		if (head == taile) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ResizingArrayQueueOfStings<Integer> r = new ResizingArrayQueueOfStings<Integer>(1);
		for (int i = 0; i < 10; i++) {
			r.enqueue(i);
			if (i >= 5) {
				
				System.out.println("dequeue��"+r.dequeue());
			}
		}
		System.out.println(r.isEmpty());// false
		System.out.println(r.size());// 5

		
		
	}

}
