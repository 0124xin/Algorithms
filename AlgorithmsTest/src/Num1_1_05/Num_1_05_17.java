package Num1_1_05;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P150 T17
 * 
 * @author he
 *
 */

class ErdosRenyi {
	public static int count(int N) {
		UF uf = new UF(N);
		int count = 0;// ���ɵ�������
		// ��ͨ��������1���ʾ���������д��㶼��ͨ��
		while (uf.count() > 1) {
			int i = StdRandom.uniform(0, N);
			int j = StdRandom.uniform(0, N);
			if (!uf.connected(i, j)) {
				uf.union(i, j);
			}
			count++;
		}
		return count;
	}
}

public class Num_1_05_17 {

	public static void main(String[] args) {
		System.out.println(ErdosRenyi.count(10));
	}
}
