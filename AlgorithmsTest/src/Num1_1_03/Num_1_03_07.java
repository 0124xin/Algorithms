package Num1_1_03;

/**
 * P102 T7 ˼·����pop����Ԫ�ظ�һ������ temp �ٰ�temp push ��ȥ return temp
 * 
 * @author he
 *
 * @param <T>
 */
class StackT<T> {
	private T[] a;// statck entries
	private int N;// size
	private int cap;// ��������ĳ���

	@SuppressWarnings("unchecked")
	public StackT(int cap) {
		this.cap = cap;
		a = (T[]) new Object[cap];
	}

	void push(T item) {
		a[N++] = item;
	}

	T pop() {
		return a[--N];
	}

	boolean isEmpty() {
		return N == 0;
	}

	int size() {
		return N;
	}

	// �ж��Ƿ�����
	boolean isFull() {
		return N == cap;
	}

	T peek() {
		T temp = pop();
		this.push(temp);
		return temp;
	}

}

public class Num_1_03_07 {
	public static void main(String[] args) {
		StackT<String> stack = new StackT<String>(10);
		for (int i = 0; i < 9; i++) {
			stack.push(String.valueOf(i));
		}
		System.out.println("peek-->" + stack.peek());//8
		System.out.println("pop-->" + stack.pop());//8
		System.out.println("peek-->" + stack.peek());//7
	}
}
