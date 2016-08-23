package Number_4_02;

import edu.princeton.cs.algs4.BellmanFordSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;;

/**
 * P444 ���Ҷһ��е��׻���Ѱ�Ҽ�Ȩ����ͼ�еĸ�Ȩ�ػ���
 * args[0]:rates.txt
 * @author he
 *
 */
public class Arbitrage {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int V = in.readInt();
		String name[] = new String[V];// ���ÿ�������Ӧ�Ļ���
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
		for (int v = 0; v < V; v++) {
			name[v] = in.readString();
			for (int w = 0; w < V; w++) {
				double rate = in.readDouble();
				DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate));
				G.addEdge(e);
			}
		}

		BellmanFordSP sp = new BellmanFordSP(G, 0);
		if (sp.hasNegativeCycle()) {
			double stake = 1000;
			for (DirectedEdge e : sp.negativeCycle()) {
				System.out.printf("%10.5f %s", stake, name[e.from()]);
				stake *= Math.exp(-e.weight());
				System.out.printf("= %10.5f %s\n", stake, name[e.to()]);

			}
		} else
			System.out.println("No arbitrage opportunity");

	}

}
