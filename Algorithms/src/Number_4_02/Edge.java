package Number_4_02;

/**
 * P394 ��Ȩ�صıߵ���������
 * 
 * @author he
 *
 */
public class Edge implements Comparable<Edge> {

	private final int v;// ����֮һ
	private final int w;// ��һ������
	private final double weight;// �ߵ�Ȩ��

	public Edge(int w, int v, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * ��ȡ�ߵ�Ȩ��
	 * 
	 * @return
	 */
	public double weight() {
		return weight;
	}

	/**
	 * ��ȡһ������
	 * 
	 * @return
	 */
	public int either() {
		return w;
	}

	/**
	 * ��ȡ��һ������
	 * 
	 * @param x
	 * @return
	 */
	public int other(int x) {
		if (v == w)
			return v;
		else if (x == v)
			return w;
		else
			throw new RuntimeException("�����ڰ����ö���ı�");
	}

	public int compareTo(Edge o) {
		if (this.weight < o.weight)
			return -1;
		else if (this.weight > o.weight)
			return +1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return String.format("%d--%d  %.2f", w, v, weight);
	}

	public static void main(String[] args) {
		Edge e = new Edge(1, 0, 3.54);
		System.out.println(e.toString());
	}

}
