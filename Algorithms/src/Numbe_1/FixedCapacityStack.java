package Numbe_1;
/**
 * P84 һ�ֱ�ʾ���Ͷ���ջ�ĳ�����������
 * @author he
 *
 * @param <T>
 */
public class FixedCapacityStack<T> {
	private T[] a;// statck entries
	private int N;// size
	private int cap;// ��������ĳ���

	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
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

	public static void main(String[] args) {
		FixedCapacityStack<String> f=new FixedCapacityStack<String>(10);
		for (String string : args) {
			if (!string.equals("-")) {
				f.push(string);
			}
			else if (!f.isEmpty()) {
				System.out.print(f.pop()+" ");
			}
		}
		System.out.println("�Ƿ�������"+ f.isFull());
		System.out.println("("+f.size()+" left on stack"+")");
	}	
}
