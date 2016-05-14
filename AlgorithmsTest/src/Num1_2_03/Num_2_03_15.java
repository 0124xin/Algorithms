package Num1_2_03;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * ����ñ������ʹ�ö��ֲ��ҽ���ƥ�� b�ڱ����ֲ��ҵ������ݸĺ�Ҫ��д��������е������Ҳ���
 * 
 * @author he
 *
 */
class Qu {
	private static int count;
	private static int match;

	public static int match(int a[], int b[]) {
		// matching(a, b);
		matching2(a, b);
		return match;
	}

	private static void matching(int[] a, int[] b) {
		count = a.length + b.length;// ��˿����ñ��������
		Arrays.sort(b);// ����
		int N = a.length < b.length ? a.length : b.length;
		for (int i = 0; i < N; i++) {
			int t = BinarySearch.indexOf(b, a[i]);
			if (t > -1) {
				count = count - 2;
				match++;
				b[t] = -1;// ��֮ǰƥ�䵽��λ������Ϊ-1 ��ֹ�´�����ƥ�䵽
				Arrays.sort(b);// ��b�������򣬱�֤b��������
			}
		}
	}

	private static void matching2(int a[], int b[]) {
		count = a.length + b.length;// ��˿����ñ��������
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[j] == a[i]) {
					count = count - 2;
					match++;
					b[j] = -1;// ��֮ǰƥ�䵽��λ������Ϊ-1 ��ֹ�´�����ƥ�䵽
				}
			}
		}
	}

	public static int Unmatching() {
		return count;
	}
}

public class Num_2_03_15 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 };
		int b[] = { 3, 4, 5, 5, 7, 8, 88, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 };
		System.out.println("ƥ��Ķ�����" + Qu.match(a, b) + "��");// 14
		System.out.println("�� " + Qu.Unmatching() + " ��δƥ��");// 21
	}
}
