package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * P532 ����������ӡ�ڱ�׼����ϣ��ַ���ʽ�� args[0]:16 console���룺ABRACADABRA
 * 
 * @author he
 *
 */
public class BinaryDump {
	public static void main(String[] args) {
		int width = Integer.parseInt(args[0]);
		int cn;
		for (cn = 0; !BinaryStdIn.isEmpty(); cn++) {
			if (width == 0)
				continue;
			if (cn != 0 && cn % width == 0)
				StdOut.println();
			// ��ȡһλ
			if (BinaryStdIn.readBoolean())
				StdOut.print("1");
			else
				StdOut.print("0");

		}

		StdOut.println();
		// ��Ϊ�ûس��Ժ󻹻��ȡһ��8���ص������Ҳ²��ǰ�enter���µģ�������ﻹ��Ҫ��ȥ8����
		StdOut.println(cn - 8 + " bit");
		/**
		 * �����
		 *  0100000101000010 
		 *  0101001001000001 
		 *  0100001101000001
		 *  0100010001000001 
		 *  0100001001010010 
		 *  0100000100001101 
		 *  00001010 
		 *  96 bit
		 * 
		 */

	}
}
