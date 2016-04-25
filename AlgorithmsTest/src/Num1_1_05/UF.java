package Num1_1_05;

/**
 * P138 union-find��ʵ��
 * 
 * @author he
 */
public class UF {
	private int id[];// ����id
	private int count;// ��������

	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	/**
	 * quick-find�㷨 ������ʶ��Ϊ�����ֵ
	 * �����ԣ����ҽ���id[p]����id[q]��p��q����ͨ�ģ�������֮����ͬһ����ͨ�����е����д�����id[]�е�ֵ������ͬ
	 * ������find()�����ܿ죬��union()����Ҫɨ������id[]���飬������ʴ����ڣ�N+3������2N+1��֮��
	 * �����µ���union()ΪN-1�Σ�����quick-find�㷨��ƽ�������
	 * 
	 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7 �����2 components
	 * 
	 * @param p
	 * @param q
	 */

	/*
	 public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (pID == qID) {
			return;
		}
		// �������ͬ��id[p]��ֵȫ����Ϊid[q]��ֵ
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		count--;
	}
	public int find(int p) {
		return id[p];
	}
*/
	
	
	
	
	/**
	 * quick-union ,quick-find�ĸ����� 
	 * �����㣺 p=id[p]��������p��ֵ��id[p]��ֵ��ȣ���pΪ������
	 * ���ҽ����ֱ����������㿪ʼ��������̵�����ͬһ��������ʱ�����Ǵ�����ͬһ����ͨ����֮��
	 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
	 * @param p
	 * @param q
	 * @return
	 */
	
	//������p,q�ĸ��ڵ� ���Ϊ�����㣬������p���ڵķ����ĸ�����
	public void union(int p,int q){
		int pRoot=find(p);
		int qRoot=find(q);
		if (qRoot==pRoot) {
			return;
		}
		id[pRoot]=qRoot;
		count--;
	}
	
	//�ҵ�����ĸ��ڵ�
	public int find(int p){
		while(p!=id[p]){
			p=id[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		UF uf = new UF(10);
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
