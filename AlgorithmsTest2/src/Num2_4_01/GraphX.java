package Num2_4_01;

import java.util.LinkedList;
import edu.princeton.cs.algs4.In;

/**
 * P336 GraphX(无向图)数据类型 使用邻接表数组，数组的索引对应顶点，每个数组中的元素是与该顶点连接的顶点列表 使用Bag数组 每条边都会添加两次
 * v-w 和 w-v args[0]:tinyG.txt
 * 
 * @author he
 *
 */
public class GraphX {
	private final int V;// 顶点个数
	private int E;// 边的数目
	private LinkedList<Integer> adj[];// 邻接表
	public String b[];// 记录添加的边

	@SuppressWarnings("unchecked")
	public GraphX(int v) {
		this.V = v;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public GraphX(In in) {
		this(in.readInt());
		int E = in.readInt();
		b = new String[E];
		for (int i = 0; i < E; i++) {
			// 添加一条边
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * 删除一条边
	 * 
	 * @param v
	 * @param w
	 */
	public void delEdge(int v, int w) {
		int indexW = -1;
		int indexV = -1;
		// 因为都是类型的adj[v].remove会执行adj[v].remove(index)方法而不是remove(Oject o)
		if (adj[v].contains(w) && adj[w].contains(v)) {
			indexW = adj[v].indexOf(w);
			indexV = adj[w].indexOf(v);
		}
		if (indexV != -1 && indexW != -1) {
			adj[v].remove(indexW);
			adj[w].remove(indexV);
			E--;
		}		

	}

	/**
	 * 添加一条边 v-w
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		// 每条边添加来两次
		adj[v].add(w);// 将w添加到v的链表中
		adj[w].add(v);// 将v添加到w的链表中
		b[E++] = v + "." + w;

	}

	/**
	 * 返回和v相邻的所有顶点
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * 计算v的度数,即v的边数
	 * 
	 * @param G
	 * @param v
	 * @return
	 */
	public static int degree(GraphX G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}

	/**
	 * 计算所有顶点的最大度数
	 * 
	 * @param G
	 * @return
	 */
	public static int maxDegree(GraphX G) {
		int max = 0;
		for (int v = 0; v < G.V; v++) {
			for (int w : G.adj(v)) {
				if (w > max)
					max = w;
			}
		}
		return max;
	}

	/**
	 * 计算所有顶点的平均度数
	 * 
	 * @param G
	 * @return
	 */
	public static double avgDegree(GraphX G) {
		return 2.0 * G.E / G.V;
	}

	/**
	 * 计算自环个数
	 * 
	 * @param G
	 * @return
	 */
	public static int numOfSelfLoops(GraphX G) {
		int count = 0;
		for (int v = 0; v < G.V; v++) {
			for (int w : G.adj(v))
				if (w == v)
					count++;
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + "个顶点" + E + "条边" + "\n");
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : this.adj(v))
				s.append(w + " ");
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		GraphX G = new GraphX(in);
		System.out.println("顶点最大度数: " + maxDegree(G));
		System.out.println(G.toString());
		System.out.println("自环个数: " + numOfSelfLoops(G));
		G.delEdge(5, 4);
	}

}
