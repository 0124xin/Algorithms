package Number_4_02;

import edu.princeton.cs.algs4.AcyclicLP;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;;

/**
 * P431 ���ȼ������µĲ��������������Ĺؼ�·��������ת��Ϊ�޻���Ȩ����ͼ���·�� 
 * ��������⣺��������ɴ������ϰ������������ʱ���������������
 * args[0]:jobsPC.txt
 *
 * 
 * @author he
 *
 */
public class CPM {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int N = in.readInt();// ���������
		in.readLine();
		/**
		 * ���ж���0-N��ʾ�������񣬶������������s=2*N��t=2*N+1��ʾ����������յ�
		 * ����0-N��ʾ������������ÿ���߱�ʾ�Ƕ����Ӧ�������ʱ�䣬�����Ҫһ������Ķ��㣨i+N����ö�������,
		 * �Ҷ���i+N���յ�t���ӣ�����s-->i-->(i+N)-->t�ۼ�Ȩ��(ֻ��i-->(i+N)��Ȩ��)��ʾ������ӿ�ʼ����������ʱ��
		 */
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(N * 2 + 2);
		int s = 2 * N, t = 2 * N + 1;
		for (int i = 0; i < N; i++) {
			String a[] = in.readLine().split("\\s+");
			double duration = Double.valueOf(a[0]);// ÿ�������Ӧ��ʱ��
			G.addEdge(new DirectedEdge(i, i + N, duration));
			G.addEdge(new DirectedEdge(s, i, 0.0));
			G.addEdge(new DirectedEdge(i + N, t, 0.0));

			for (int j = 1; j < a.length; j++) {
				// ��ȡ��ǰ����i�ĺ�����񣬼���ǰ��������ں������֮ǰ���
				int successor = Integer.valueOf(a[j]);
				G.addEdge(new DirectedEdge(i + N, successor, 0.0));
			}
		}

		// ����޻���Ȩ����ͼ���·��
		AcyclicLP lp = new AcyclicLP(G, s);
		System.out.println("Start times");
		for (int i = 0; i < N; i++)
			System.out.printf("%4d: %5.1f\n", i, lp.distTo(i));
		System.out.printf("Finish time: %5.1f\n", lp.distTo(t));

	}

}
