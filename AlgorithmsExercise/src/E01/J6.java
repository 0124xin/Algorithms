package E01;

/**
 * ��һ����NxN�����ʾ��ͼ������ÿ��������һ��int��ʾ�����дһ���㷨���ڲ�ռ�ö����ڴ�ռ�������(����ʹ�û������)����ͼ��˳ʱ����ת90�ȡ�
 * ����һ��NxN�ľ��󣬺;���Ľ���N,�뷵����ת���NxN����,��֤NС�ڵ���500��ͼ��Ԫ��С�ڵ���256�� ����������
 * [[1,2,3],[4,5,6],[7,8,9]],3 ���أ�[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * @author he
 *
 *         ˼·���ȶ�ά����ת�� �ٽ���j�к͵�n-1-j�н���
 *
 */
public class J6 {
	// ��ӡ����
	static void print(int a[][]) {
		int count = 0;
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[j][i] + "\t");
				count++;
			}
			if (count % a.length == 0) {
				System.out.println();
			}
		}
	}

	public static int[][] trans(int a[][], int n) {
		int b[][] = new int[n][n];
		int temp;
		// ��ά����ת��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = a[j][i];
			}
		}

		// ��i�к͵�n-1-i�н���
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				temp=b[i][j];
				b[i][j] = b[i][n-j-1];
				b[i][n-j-1]=temp;
			}
		}
		return b;
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(a);
		// // trans(a, 3);
		System.out.println("-----------------");
		print(trans(a, 3));

	}

}
