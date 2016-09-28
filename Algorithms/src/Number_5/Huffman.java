package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

/*****************************************************************************************************
 * P547 �㷨 5.10 ������ѹ��
 * 
 * ѹ���Ĺ��̣� 
 *  1����ȡ����
 *  2��ͳ��������ÿ��charֵ���ֵ�Ƶ�ʣ���ȡ���������룩 
 *  3������Ƶ�ʹ��������������
 *  4�����ݻ���������������������ÿ���ַ���һ�������ַ�������� 
 *  5����������������ɱ�����д����� 
 *  6������ĸ��������Ϊ�����ַ���д�����
 *  7��ʹ�ñ������ÿ�������ַ� 
 * չ���Ĺ��̣�
 *  1����ȡ�������� 
 *  2����ȡҪ������ַ����� 
 *  3��ʹ�õ��ʲ�����������������
 * 
 * ѹ���㷨���ԣ���console��input����abra.txt��console��output����HMcom.txt
 * ��ѹ���㷨���ԣ���console��input����HMcom.txt
 * ��ζ����ҵĲ���:http://blog.csdn.net/fuckluy/article/details/50999238
 * 
 * 
 * @author he
 *
 */
public class Huffman {
	private static int R = 256;// 8λASCII�����ĸ����

	/**
	 * �������������Ľ���ʾ
	 */

	private static class Node implements Comparable<Node> {
		private char ch;// Ҷ�ӽڵ�����Ҫ��������ַ�
		private int freq;// ���ڼ�¼��������ÿ���ַ����ֵ�Ƶ��
		private final Node left, right;

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		// ����������Ӷ�ΪNull��ý����Ҷ�ӽ��
		public boolean isLeaf() {
			return left == null && right == null;
		}

		// ������MinPQ�н��бȽ�
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}
	}

	// ѹ��
	public static void compress() {
		String s = BinaryStdIn.readString();// ��ȡ����
		char input[] = s.toCharArray();
		// ͳ��Ƶ��
		int freq[] = new int[R];
		for (int i = 0; i < input.length; i++)
			freq[input[i]]++;

		// �����������
		Node root = buildTrie(freq);
		// �ݹ�ع��������
		String st[] = new String[R];
		buildCode(st, root, "");
		// �ݹ�ؽ���������д�ɱ����ַ��������
		writeTrie(root);
		// ����ַ�����
		BinaryStdOut.write(input.length);

		// ͨ����������ַ�
		for (int i = 0; i < input.length; i++) {
			String code = st[input[i]];
			for (int j = 0; j < code.length(); j++)
				if (code.charAt(j) == '1')
					BinaryStdOut.write(true);
				else
					BinaryStdOut.write(false);
		}
		BinaryStdOut.close();
	}

	// ��ѹ��
	public static void expand() {
		Node root = readTrie();// ��ȡ��������
		int N = BinaryStdIn.readInt();// ��ѹ������ĸ����
		for (int i = 0; i < N; i++) {
			Node x = root;
			while (!x.isLeaf()) {
				if (BinaryStdIn.readBoolean())
					x = x.right;
				else
					x = x.left;
			}
			BinaryStdOut.write(x.ch);
		}
		BinaryStdOut.close();
	}

	/**
	 * �������ֻ��һ����������ɵ�ɭ�֣����б���freq��ʾ���ַ������г��ֵ�Ƶ�ʣ������ҵ�Ƶ����С�Ľ�㣬Ȼ�󴴽�һ���Զ���Ϊ�ӽ����½�㣬
	 * �½���Ƶ��Ϊ�ӽ� ��Ƶ��֮�ͣ���Ҷ�ӽ���Ƶ��Ҳ���ӽ��Ƶ��֮�ͣ����ظ��˹���ֱ�����н��ϲ�Ϊ һ�õ����ĵ��ʲ�����
	 * 
	 * @param freq
	 * @return
	 */
	private static Node buildTrie(int freq[]) {
		MinPQ<Node> mpq = new MinPQ<Node>();
		for (char c = 0; c < R; c++)
			if (freq[c] > 0)
				mpq.insert(new Node(c, freq[c], null, null));// ����Ҷ�ӽڵ�

		// �ϲ�����ֱ��ֻ��һ����
		while (mpq.size() > 1) {
			Node X = mpq.delMin();
			Node Y = mpq.delMin();
			Node parent = new Node('\0', X.freq + Y.freq, X, Y);
			mpq.insert(parent);
		}

		return mpq.delMin();
	}

	/**
	 * ��������� ÿ��Ҷ�ӽڵ㺬��һ����Ҫ������ַ�������ÿ���ַ��ı���� �ǴӸ���㵽�ý���·����ʾ�ı����ַ����� ����������Ϊ0��������Ϊ1
	 * 
	 * @param root
	 * @return
	 */
	private static String[] buildCode(Node root) {
		String st[] = new String[R];
		buildCode(st, root, "");
		return st;
	}

	private static void buildCode(String st[], Node x, String s) {
		if (x.isLeaf()) {
			st[x.ch] = s;
			return;
		}

		buildCode(st, x.left, s + '0');
		buildCode(st, x.right, s + '1');
	}

	/**
	 * �ݹ�أ�����������д�ɱ����ַ���
	 * 
	 * @param x
	 */
	private static void writeTrie(Node x) {
		if (x.isLeaf()) {// Ҷ�ӽ�㣨�����ַ��Ľ�㣩��д��1
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch);
			return;
		}
		BinaryStdOut.write(false);// �ڲ���㣨�ս�㣬x.ch='\0'����д��0
		writeTrie(x.left);
		writeTrie(x.right);
	}

	// �Ӵ�������ǰ�����ؽ���������
	private static Node readTrie() {
		if (BinaryStdIn.readBoolean())
			return new Node(BinaryStdIn.readChar(), 0, null, null);
		return new Node('\0', 0, readTrie(), readTrie());
	}

	public static void main(String[] args) {
		 if (args[0].equals("-"))
		 compress();
		 else if (args[0].equals("+"))
		expand();
	}

}
