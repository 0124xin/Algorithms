package Num1_1_04;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P133 T8 ��Ŀ˵���ǱȽϴ����Ϊ~2lgN,����ʱ��
 * 
 * @author he
 *
 */

public class Num_1_04_18 {

	// public static int minElement(int a[]) {
	// for (int i = 1; i < a.length - 1; i++) {
	// if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
	// return i;
	// }
	// }
	// return -1;
	// }

	/**
	 * ��ӷ�ף��о��Ƚϴ���Ҳû�ٶ��� ����Ŀ��Ԫ�ص�index
	 * 
	 * @param a
	 * @return
	 */
	public static int minElement(int a[]) {
		int temp = 0;// �÷�ֹ��ѭ��
		for (int i = a.length / 2; i > 0 && i < a.length - 1;) {
			if (a[i - 1] > a[i] && a[i] < a[i + 1])
				return i;// ����
			// ����
			if (a[i - 1] < a[i] && a[i] < a[i + 1]) {
				if (i - 2 >= 0 && a[i - 2] > a[i - 1])
					return i - 1;
				// �����Ƕ���Ԫ��
				else if (i - 2 > 0) {
					i = i - 2;
				} else {
					i--;
				}
				// �ƶ�������߻�û�з���Ŀ��Ԫ�أ���ʱɨ���ұ�
				if (i <= 1 && temp <= 1) {
					i = a.length / 2 + 1;
					temp++;
				} else if (temp > 1) {
					return -1;
				}

			}

			// ����
			if (a[i - 1] > a[i] && a[i] > a[i + 1]) {
				if (i + 2 < a.length && a[i + 2] > a[i + 1])
					return i + 1;
				// �����Ƕ���Ԫ��
				else if (i + 2 < a.length - 1) {
					i = i + 2;
				} else {
					i++;
				}

				// �ƶ������ұ߻�û�з���Ŀ��Ԫ�أ���ʱɨ�����
				if (i >= a.length - 2 && temp <= 1) {
					i = a.length / 2 - 1;
					temp++;
				} else if (temp > 1) {
					return -1;
				}
			}

			// ������
			if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
				if (a[i - 1] < a[i + 1])
					i = i - 1;
				else
					i = i + 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 0, 7, 1 };
		int a2[] = { 7, 6, 5, 4, 3, 0, 2, 1 };
		int a3[] = { 1, 6, 7, 3, 5, 6, 4, 2 };
		int a4[] = { 1, 2, 3, 4, 5, 6 };
		int a5[] = { 5, 0, 3, 2, 1 };

		int a6[] = new int[50];
		for (int i = 0; i < a6.length; i++)
			a6[i] = i;
		StdRandom.shuffle(a6);
		System.out.println(minElement(a6));
	}

}
