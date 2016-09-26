package Number_5;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * P537 ����ѹ�������Ĵ����ʽ
 * 
 * @author he
 *
 */
public class Genome {
	// �������ݵ�ѹ������
	public static void compress() {
		Alphabet DNA = new Alphabet("ACTG");
		// String s = BinaryStdIn.readString();// ��ȡ�ַ���
		String s = "ATAGATGCATAGCGCATAGCTAGATGTGCTAGC";
		int N = s.length();
		BinaryStdOut.write(N);
		for (int i = 0; i < s.length(); i++) {
			int d = DNA.toIndex(s.charAt(i));// ��ȡ����
			BinaryStdOut.write(d, DNA.lgR());
		}
		BinaryStdOut.close();
	}

	// �������ݵ�չ������
	public static void expand() {
		Alphabet DNA = new Alphabet("ACTG");
		int w = DNA.lgR();// һ����������ı�����
		// int N = BinaryStdIn.readInt();//33
		int N = 33;
		for (int i = 0; i < N; i++) {
			// // ��ȡ2���أ�д��һ���ַ�
			char c = BinaryStdIn.readChar(w);
			BinaryStdOut.write(DNA.toChar(c));// ת��Ϊ�ַ������
		}
		BinaryStdOut.close();
	}

	public static void main(String[] args) {
		if (args[0].equals("-"))
			compress();
		if (args[0].equals("+"))
			expand();
	}

}
