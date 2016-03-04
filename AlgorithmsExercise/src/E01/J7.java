package E01;

import java.util.HashSet;
import java.util.Set;

/**
 * ���дһ���㷨����MxN������ĳ��Ԫ��Ϊ0���������ڵ����������㡣
 * ����һ��MxN��int[][]����(C++��Ϊvector>)mat�;���Ľ���n���뷵����ɲ������int[][]����(C++��Ϊvector>)��
 * ��֤nС�ڵ���300�������е�Ԫ��Ϊint��Χ�ڡ� ���������� [[1,2,3],[0,1,2],[0,0,1]]
 * ���أ�[[0,0,3],[0,0,0],[0,0,0]]
 * 
 * @author he
 *
 *         ��set��¼����
 *
 *
 */
public class J7 {
	public static int[][] clearZero(int[][] mat, int n) {
		Set<Integer> hang = new HashSet<>();
		Set<Integer> lie = new HashSet<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					hang.add(i);
					lie.add(j);
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (hang.contains(i) || lie.contains(j)) {
					mat[i][j] = 0;
				}
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 0, 1, 2 }, { 0, 0, 1 } };
		ArraysPrint.print(clearZero(mat, 0));
	}
}
