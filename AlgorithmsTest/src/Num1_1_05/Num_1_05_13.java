package Num1_1_05;

/**
 * P150 T13 ·��ѹ���ļ�Ȩquick-union�㷨 find�����Ĳ�����T12����һ���ģ�ֱ�������þͺ��� 
 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
 * 
 * @author he
 *
 */

class WeightedQuickUnionPath {
	private int id[];
	private int sz[];
	private int count;

	public WeightedQuickUnionPath(int N) {
		id = new int[N];
		count = N;
		sz = new int[N];

		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int find(int p) {
		int root = p;
		// ��ȡ���ڵ�
		while (root != id[root]) {
			root = id[root];
		}
		while (p != root) {
			int newp = id[p];
			id[p] = root;// ���������ӵ����ڵ�
			p = newp;
		}
		return root;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);

		if (i == j) {
			return;
		}
		// ���߶�С�������ӵ��߶ȴ����
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}
}

public class Num_1_05_13 {
	public static void main(String[] args) {
		System.out.println("x");
		WeightedQuickUnionPath uf = new WeightedQuickUnionPath(10);
		for (int i = 0; i < args.length; i += 2) {
			int p = Integer.parseInt(args[i]);
			int q = Integer.parseInt(args[i + 1]);
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		System.out.println(uf.count() + " components");// 2
	}

}
