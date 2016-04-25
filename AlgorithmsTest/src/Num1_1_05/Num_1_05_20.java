package Num1_1_05;

/**
 * P151 T20 ����ͨ��
 * 
 * @author he �������hashCode��Ϊ��ʶ����
 *         �������ݲ��ñȲ�����һ�ķ�ʽ����������Ŀ����Ϊ�˼�����ͨ���������������ݺ���ͨ����Ҳֻ��ԭ����ͨ������һ�������������ݴ�������
 *         ������á�2�ķ�ʽ���ݣ�����������ͨ���� Ӧ�ò�ȡ���ַ�ʽ�Ҳ����
 *
 */

class ResizingUF {
	private int id[] = new int[1];
	private int count = 1;

	// ��������
	private void resize(int max) {
		int temp[] = new int[max];
		for (int i = 0; i < id.length; i++) {
			temp[i] = id[i];
		}
		for (int j = id.length; j < temp.length; j++) {
			temp[j] = j;
		}
		count = count + max - id.length;// ��ͨ����Ϊԭ�ȵ���ͨ�������������ӵ�Ԫ��
		id = temp;
	}

	public int find(int q) {
		if (q >= id.length) {
			resize(q*2);// ��������
		}
		return id[q];
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pRoot) {
				id[i] = qRoot;
			}
		}
		count--;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}

	public int newSite() {
		return id.hashCode();
	}
}

public class Num_1_05_20 {

	public static void main(String[] args) {
		ResizingUF uf = new ResizingUF();
		for (int i = 0; i < args.length; i += 2) {
			int p = Integer.parseInt(args[i]);
			int q = Integer.parseInt(args[i + 1]);
			if (uf.isConnected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		System.out.println(uf.count() + " components");// 8  �������ͨ����Ϊ�����Ԫ��
		System.out.println(uf.newSite());// �ҵ����е�hashCode 705927765
		uf.find(20);
		System.out.println(uf.newSite());// �ҵ����е�hashCode 366712642

	}
}
