package Num1_1_03;

/**
 * �������� head ���,taile ɾ��
 * P106 T39
 * @author he
 *
 */

class RingBuffer<T> {
	private int size;// �����С
	private int N;// Ԫ�ظ���
	private int head;
	private int taile;
	private T[] a;

	@SuppressWarnings("unchecked")
	public RingBuffer(int size) {
		a = (T[]) new Object[size];
		this.size = size;
		taile = a.length - 1;
		head = taile;
	}

	public void enqueue(T item) {
		if (N == size) {
			taile = head;
		}
		a[head--] = item;
		N++;
	}

	public T dequeue() {
		N--;
		return a[taile--];
	}

	public boolean isEmpty() {
		return N == 0;
	}
}

public class Num_1_03_39 {
	public static void main(String[] args) {
		RingBuffer<Integer> r=new RingBuffer<Integer>(5);
		for(int i=0;i<5;i++){
			r.enqueue(i);	
			System.out.println(r.dequeue());
		}
	
		
		
	}

}
