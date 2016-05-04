package Number_2;

/**
 * P171 �Զ����µĹ鲢����
 * 
 * @author he
 *
 */
public class Merge {
	private static Comparable aux[];

	public static void sort(Comparable a[]) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);

	}

	private static void sort(Comparable a[], int firstIndex, int lastIndex) {
		if (firstIndex>=lastIndex) {
			return;
		}
		int midIndex=firstIndex+(lastIndex-firstIndex)/2;
		sort(a,firstIndex,midIndex);//�������
		sort(a, midIndex+1, lastIndex);//�ұ�����
		merge(a, firstIndex, midIndex, lastIndex);//�鲢���
	}

	private static void merge(Comparable a[], int firstIndex, int midIndex, int lastIndex) {
		int i = firstIndex;
		int j = midIndex + 1;
		// ������a���Ԫ�ظ��Ƶ�aux��
		for (int k = firstIndex; k <= lastIndex; k++) {
			aux[k] = a[k];
		}

		for (int k = firstIndex; k <= lastIndex; k++) {
			if (i > midIndex) {
				a[k] = aux[j++];// ���ȡ��ȡ�ұ�
			} else if (j > lastIndex) {
				a[k] = aux[i++];// �ұ�ȡ��ȡ���
			} else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	
	public static void show(Comparable a[]) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		String a[] = { "E", "E", "G", "M", "R", "A", "E", "C", "R", "T" };
		sort(a);
		show(a);
	}

}
