package Num1_1_01;

import edu.princeton.cs.algs4.StdRandom;

/**
 * ģ��������
 * 
 * @author he
 *
 */
public class Ex_1_1_35 {
	final static int SIDES = 6;
	static double[] dist = new double[2 * SIDES + 1];

	// ����ͳ��
	public static double[] proS() {
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i + j] += 1.0;
			}
		}
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
		}
		return dist;
	}

	// ��������ֵ��
	static int sum() {

		int sum;
		sum = StdRandom.uniform(1, 6) + StdRandom.uniform(1, 6);
		return sum;
	}

	public static void main(String[] args) {
		double a[] = proS();

		for (int i = 2; i < a.length; i++) {
			int k = sum();
			if (i == k) {
				System.out.println("����֮��" + k + "����" + a[i]);
			}

		}
	}

}
