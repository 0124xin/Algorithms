package Num2_5_02;

import edu.princeton.cs.algs4.Queue;

/**
 * P491 T21 �޸�TST������һ���������ص�һ����ӵ�key
 * 
 * @author he
 *
 */

class Pattern {
	private int N;// �ַ���������
	private TST2<Integer> t[][];
	private int index = -1;

	@SuppressWarnings("unchecked")
	public Pattern(int N) {
		this.N = N;
		t = (TST2<Integer>[][]) new TST2[N][100];
	}

	public void put(String key) {
		if (index == N - 1)
			throw new RuntimeException("�ַ�������������");
		int x = ++index;

		t[x][0] = new TST2<Integer>();
		t[x][0].put(key, key.length());// ֻ����key��
		// t[x][]����key���������ַ���
		for (int length = 1; length <= key.length(); length++) {
			t[x][length] = new TST2<Integer>();
			for (int i = 0; i + length <= key.length(); i++) {
				String temp = key.substring(i, i + length);
				if (!t[x][length].contains(temp))
					t[x][length].put(temp, i);
			}
		}
	}

	// �������а����ַ���s��key
	public Iterable<String> get(String s) {
		Queue<String> queue = new Queue<String>();
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (t[i][j].contains(s))
					queue.enqueue(t[i][0].firstKey());// ��Ӱ���s��key��
			}

		}
		return queue;
	}

}

public class Num_5_02_21 {
	public static void main(String[] args) {
		Pattern p = new Pattern(5);
		p.put("string");
		p.put("she");
		p.put("sea");
		p.put("shells");
		p.put("by");
		for (String s : p.get("h"))
			System.out.println(s);

	}
}
