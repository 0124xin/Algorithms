package Number_2;

/**
 * P170 ԭ�ع鲢�ĳ��󷽷�
 * Ҫ�����������ұ���������������
 * @author he
 *
 */
public class AutochthonousMerge {
	private static Comparable aux[];

	public static void merge(Comparable a[], int first, int mid, int last) {
		aux = new Comparable[a.length];
		int i = first;
		int j = mid + 1;
		// ������a���Ƶ�����aux
		for (int k = first; k <= last; k++) {
			aux[k] = a[k];
		}
		for (int k = first; k <= last; k++) {
			if (i > mid) {
				a[k] = aux[j++];//���Ԫ��ȡ����ȡ�ұ�
			} 
			else if (j > last) {
				a[k] = aux[i++];//�ұ�Ԫ��ȡ����ȡ���
			} 
			else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];//�ұߵ�ǰԪ��С����ߣ�ȡ�ұ�
			}else {
				a[k]=aux[i++];//ȡ���Ԫ��
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
		String a[]={"E","E","G","M","R","A","C","E","R","T"};
		merge(a, 0, 4,9 );
		show(a);
	}

}
