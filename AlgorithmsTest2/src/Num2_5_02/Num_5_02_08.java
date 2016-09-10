package Num2_5_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * P491 T08 args[0]=shellsST.txt
 * ��Ϊÿ����㲻����һ���������Բ��ܰ��ն��������ֵݹ�д���ҵ�˼·���ǽ����е�key���浽һ�������У�
 * ���÷�����ʱ��ͨ�����ֲ��һ�ȡindex����������ȡ������������key
 * 
 * @author he
 *
 */

class TrieS<Value> {

	private static final int R = 256;
	private Node root;
	private String temp[];// �����������
	private int N;
	private boolean change = true;// �����ж��ڵ�����array�����������Ƿ�������ӻ�ɾ������

	private static class Node {
		Object val;
		Node next[] = new Node[R];
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null) {
			x = new Node();
		}
		if (d == key.length()) {
			if (x.val == null)
				N++;
			x.val = val;
			change = true;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);

	}

	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length()) {
			x.val = null;
			change = true;
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		if (x.val != null)
			return x;
		for (char c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		return null;

	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}

	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(pre);
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, q);
	}

	// ��temp���鸳ֵ
	private void array() {
		// ����������ģ���collect��ʵ�־��ǰ�������˳����еĵݹ飨����
		if (change || temp == null) {
			temp = new String[N];
			int ind = 0;
			for (String t : keys()) {
				temp[ind++] = t;
			}
		}
	}

	// ����ȡ��
	public String ceiling(String key) {
		array();
		int j = sel(temp, key);
		if (j >= N)
			throw new RuntimeException("δ�ҵ����ϵļ�");
		return temp[j];
	}

	// ����ȡ��
	public String floor(String key) {
		array();
		int j = sel(temp, key);
		if (temp[j].compareTo(key) == 0)// ƥ�䵽
			return temp[j];
		if (j - 1 < 0)// δ�ҵ�j����Ϊ0
			throw new RuntimeException("δ�ҵ����ϵļ�");
		return temp[j - 1];

	}

	// С��key�ļ�������
	public int rank(String key) {
		array();
		int j = sel(temp, key);
		return j;
	}

	public String select(int k) {
		if (k < 0 || k >= N)
			throw new RuntimeException("��������Ч����");
		array();
		return temp[k];
	}

	// ���ֲ���
	private int sel(String[] t, String key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(t[mid]);
			// System.out.println(" drr"+"z".compareTo("the"));
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

}

public class Num_5_02_08 {
	public static void main(String[] args) {
		TrieS<Integer> t = new TrieS<Integer>();
		In in = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			t.put(key, i++);
		}
		System.out.println(t.get("shells"));
		// t.delete("shells");
		System.out.println("ceiling:" + t.ceiling("sh"));
		System.out.println("floor:" + t.floor("sh"));
		// System.out.println(t.get("shells"));
		System.out.println("rank:" + t.rank("she"));
		t.put("tha", 10);
		System.out.println("select:" + t.select(6));
	}

}
