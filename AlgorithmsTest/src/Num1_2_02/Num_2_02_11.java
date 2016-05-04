package Num1_2_02;

import edu.princeton.cs.algs4.Insertion;

/**
 * P180 T11 �Զ����¹鲢����ĸĽ�
 * 
 * @author he �㷨2.4�ĸĽ���
 *           1������С��ģ��������ò�������    �Գ���С��8������ΪС��ģ����
 *           2�����������Ƿ��������a[mid]<=a[mid+1]����Ϊ������
 *           3������Ԫ�ظ��Ƶ��������� ʹ��System.arraycopy ������
 *              Arrays.copyOf��������Ҳ�ǵ���System.arraycopy �����ģ�ǳ����
 */

class QuickMerge{
	private static Comparable aux[];
    private static final int LENGTH=8;//����һ��С��ģ����ĳ���
	public static void sort(Comparable a[]) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);

	}

	private static void sort(Comparable a[], int firstIndex, int lastIndex) {
		/**
		 * ����С��ģ������ò�������
		 */
		if (lastIndex<firstIndex+LENGTH) {
			Insertion.sort(a);
			return;
		}
		
		int midIndex=firstIndex+(lastIndex-firstIndex)/2;
		sort(a,firstIndex,midIndex);//�������
		sort(a, midIndex+1, lastIndex);//�ұ�����
		
		/**
		 * ���������Ƿ��������a[mid]<=a[mid+1]����Ϊ������,����merge();
		 */
		if (a[midIndex].compareTo(a[midIndex+1])>0) {
			merge(a, firstIndex, midIndex, lastIndex);//�鲢���
		}		
	}

	private static void merge(Comparable a[], int firstIndex, int midIndex, int lastIndex) {
		int i = firstIndex;
		int j = midIndex + 1;
		
		/**
		 * ������a���Ԫ�ظ��Ƶ�aux��,ʹ��System.arraycopy()
		 * 
		 */
		System.arraycopy(a, firstIndex, aux, firstIndex, lastIndex-firstIndex+1);

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
}
public class Num_2_02_11 {
	public static void main(String[] args) {
		String a[] = { "E", "E", "G", "M", "R", "A", "E", "C", "R", "T" };
		QuickMerge.sort(a);
		QuickMerge.show(a);
	}

}
