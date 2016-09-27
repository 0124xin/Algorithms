package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * P538 �γ̱���
 * 
 * @author he
 *
 */
public class RunLength {

	// �γ�չ��
	public static void expand() {
		boolean b = false;
		while (!BinaryStdIn.isEmpty()) {
			char cnt = BinaryStdIn.readChar();
			for (int i = 0; i < cnt; i++) {
				BinaryStdOut.write(b);
			}
			b = !b;
		}
		BinaryStdOut.close();
	}

	// �����γ�
	public static void compress() {
		char cnt = 0;
		boolean b, old = false;
		while (!BinaryStdIn.isEmpty()) {
			b = BinaryStdIn.readBoolean();
			if (b != old) {
				BinaryStdOut.write(cnt);// д����ǰֵ����ǰ��0��1�ĸ���
				cnt = 0;// ����
				old = !old;// ����
			} else {
				// �γ̳��ȴﵽ���
				if (cnt == 255) {
					BinaryStdOut.write(cnt);
					cnt = 0;
					BinaryStdOut.write(cnt);
				}
			}
			cnt++;
		}
		BinaryStdOut.write(cnt);// ���һ���γ̵ĳ���
		BinaryStdOut.close();
	}

	public static void main(String[] args) {
		if (args[0].equals("-"))
			compress();
		if (args[0].equals("+"))
			expand();
	}

}
