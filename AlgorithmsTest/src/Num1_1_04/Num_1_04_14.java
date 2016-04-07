package Num1_1_04;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P132 T14 ˼·����forѭ�����һ��forѭ���ö��ֲ��Ҵ��� 
 * ������ N3log2N(N��3�η���log��2Ϊ��)
 * ��������
 * 
 * @author he
 *
 */
public class Num_1_04_14 {
	public static int count(int a[]) {
		int N = a.length;
		Arrays.sort(a);
		int cun = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (BinarySearch.indexof(a, -a[i] - a[j] - a[k]) > k) {
						cun++;
					}
				}
			}
		}

		return cun;
	}

	public static void main(String[] args) {
		int N = 100;
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-1000, 1000);
		}
		System.out.println(count(a));
	}

}
