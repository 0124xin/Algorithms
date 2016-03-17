package Numbe_1;

import edu.princeton.cs.algs4.Stack;

/**
 * P80 ˫ջ�������ʽ��ֵ�㷨 ���Ʊ���Ҫ��")"�������ܽ�������
 * 
 * @author he
 *
 */
public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();// �����ջ
		Stack<Double> val = new Stack<Double>();// ������ջ

		// ���������в���
		for (String string : args) {

			String s = string;

			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("-"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals("/"))
				ops.push(s);
			else if (s.equals("sqrt"))
				ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();// ��ջ
				double v = val.pop();

				if (op.equals("+"))
					v = val.pop() + v;
				else if (s.equals("-"))
					v = val.pop() - v;
				else if (s.equals("*"))
					v = val.pop() * v;
				else if (s.equals("/"))
					v = val.pop() / v;
				else if (s.equals("sqrt"))
					v = Math.sqrt(v);
				val.push(v);
			} else {
				val.push(Double.parseDouble(s));
			}

		}
		System.out.println(val.pop());
	}
}
