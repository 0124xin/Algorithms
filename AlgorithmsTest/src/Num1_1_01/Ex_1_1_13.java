package Num1_1_01;

/**
 * ��ά����ת�� �����к���
 * 
 * @author he
 *
 */
public class Ex_1_1_13 {
	static int count = 1;
	// ��ӡ���� ��������
	public static void array(int m, int n) {
		int a[][] = new int[m][n];
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				a[j][i] = count++;
				System.out.print(a[j][i]);
				// ���д�ӡ
				if (count % n == 1) {
					System.out.println();
				}
			}
		}
		System.out.println("-----------");
		//����ת�÷���
		trans(a);
	}

	// ת��
	public static void trans(int a[][]) {
		int hang = a[0].length;// 4
		int lie = a.length;// 2
		int b[][] = new int[hang][lie];
		for (int i = 0; i < hang; i++) {
			for (int j = 0; j < lie; j++) {
				b[i][j] = a[j][i];
				System.out.print(b[i][j]);
			}
			if (count % lie == 1) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		array(2, 4);
	}

}
