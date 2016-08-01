package Num2_4_01;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * P361 T16 ����ͼ��ÿ���߶������ÿ���߱䳤1
 * 
 * @author he 
 * args[0]:G.txt 
 * args[1]:1
 */

class GraphPreoperties {

	private BreadthFirstPaths b;
	private CC c;
	private Graph G;
	private int rad = 99;// �뾶��ʼΪ1��ֹ �õ� ���綥��0������0�ľ���
	private int center;// G��ĳ���е�
	private Cycle cycle;// �������ܳ�

	public GraphPreoperties(Graph G) {
		this.G = G;
		c = new CC(G);
		cycle = new Cycle(G);
		if (c.count() != 1)
			try {
				throw new Exception("G������ͨͼ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * v�������� --->����������Զ�Ķ������̾���
	 * 
	 * @param v
	 * @return
	 */
	public int eccentricity(int v) {
		b = new BreadthFirstPaths(G, v);
		int length = -1;// ��Ϊb.pathTo������������Ϊ-1
		int max = length;
		for (int i = 0; i < G.V(); i++) {
			for (int w : b.pathTo(i))
				length++;
			if (max < length)
				max = length;
			length = -1;// ����
		}
		return max;
	}

	/**
	 * G��ֱ��
	 * 
	 * @return
	 */
	public int diameter() {
		int max = 0;// ֱ��

		for (int v = 0; v < G.V(); v++) {
			if (max < eccentricity(v))
				max = eccentricity(v);
			// �Ұ뾶���е�
			if (eccentricity(v) != 0 && rad > eccentricity(v)) {
				rad = eccentricity(v);
				center = v;
			}
		}
		return max;
	}

	/**
	 * G�İ뾶
	 * 
	 * @return
	 */
	public int radius() {
		if (rad == 0)
			diameter();
		return rad;
	}

	public int center() {
		if (center == 0)
			diameter();
		return center;
	}

	// T17 ��ͼ���ܳ�
	public int girth() {

		if (!cycle.hasCycle()) {
			try {
				throw new Exception("ͼG�޻� �ܳ����޴�");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int gir = -1;// ���ظ��������Ϊ-1
		for (int c : cycle.cycle()) {
			System.out.print(c + " ");
			gir++;
		}
		return gir;
	}

}

public class Num_4_01_16_17 {

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		GraphPreoperties p = new GraphPreoperties(G);
		int i = Integer.valueOf(args[1]);
		System.out.println(i + "������ΪΪ:" + p.eccentricity(1));// 3
		System.out.println("ͼG��ֱ��Ϊ��" + p.diameter());// 3
		System.out.println("ͼG�İ뾶Ϊ��" + p.radius());// 2
		System.out.println("ͼG������Ϊ����:" + p.center());// 0
		System.out.println("ͼG���ܳ�Ϊ��" + p.girth());

	}

}
