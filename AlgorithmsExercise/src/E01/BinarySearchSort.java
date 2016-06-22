package E01;

/**
 * ���ö��ֲ���(����ֵ���޸�)�����Ԫ��ʱ����
 * 
 * @author he
 *
 */
public class BinarySearchSort<T extends Comparable<T>> {

	private T a[];
	private int N;// Ԫ�ظ���

	public BinarySearchSort(int N) {
		a = (T[]) new Comparable[N];
	}

	public int rank(T item) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = item.compareTo(a[mid]);
			if (cmp > 0)
				lo = mid + 1;//ע������,���һ�αȽϺ�lo���ڱ�itemС�����Ԫ�ص��±�+1
			else if (cmp < 0)
				hi = mid - 1;
			else
				return mid;
		}
		return lo;
	}

	public void put(T item) {
		int i = rank(item);// ���δ���У���i���ڱ�itemС�����Ԫ�ص�index+1
		for (int j = N; j > i; j--) {
			a[j] = a[j - 1];// Ԫ�غ���
		}
		a[i] = item;
		N++;
	}

	public void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		BinarySearchSort<Integer> b = new BinarySearchSort<>(10);
		b.put(1);
		b.put(3);
		b.put(3);
		b.put(3);
		b.put(2);
		b.put(0);
		b.put(5);
		b.put(4);
		b.print();// 0 1 2 3 3 3 4 5
	}

}
