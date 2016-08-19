package Number_4_02;

/**
 * P415 ��Ȩ����ߵ����ݽṹ
 * 
 * @author he
 *
 */
public class DirectedEdge {

	private final int v;// ����ߵ����
	private final int w;// ����ߵ��յ�
	private final double weight;// �ߵ�Ȩ��

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * ���رߵ����
	 * 
	 * @return
	 */
	public int from() {
		return v;
	}

	/**
	 * ���رߵ��յ�
	 * 
	 * @return
	 */
	public int to() {
		return w;
	}

	/**
	 * ���رߵ�Ȩ��
	 * 
	 * @return
	 */
	public double weight() {
		return weight;
	}

	@Override
	public String toString() {
		return String.format("%d-->%d %.2f", v, w, weight);
	}

	public static void main(String[] args) {
		DirectedEdge e = new DirectedEdge(1, 0, .5);
		System.out.println(e);

	}

}
