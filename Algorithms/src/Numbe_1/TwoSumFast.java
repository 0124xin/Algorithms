package Numbe_1;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P119 ͳ�����к�Ϊ0�Ķ�Ԫ������������ ���������� NlogN
 * 
 * @author he
 *
 */

public class TwoSumFast {
	public static int count(int a[]) {
		int cun = 0;// ͳ�ƺ�Ϊ0�Ķ�Ԫ���ݵ���Ŀ
		int N = a.length;
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			if (BinarySearch.indexOf(a, -a[i]) > i) {
				cun++;
			}
		}
		return cun;
	}

	public static void main(String[] args) {
		int N = 1000;
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-10000, 10000);
		}
		System.out.println(count(a));
	}
}
