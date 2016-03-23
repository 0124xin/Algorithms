package Num1_1_03;

import edu.princeton.cs.algs4.Stack;

/**
 * P102 T9 ��P80 ��Evaluate ���ƣ� ֻ����������ջ���ڴ�Ų������ͼ�����ʽ�������ջ���ڴ���������������)�� ���е�ջ����
 * args:1 + 2 ) �� 3 - 4 ) �� 5 - 6 ) ) )
 * 
 * @author he
 *
 */
public class Num_1_03_09 {

	public static void main(String[] args) {
		Stack<String> val = new Stack<String>();// ������ջ
		Stack<String> ops = new Stack<String>();// �����ջ

		for (String string : args) {
			String s = string;

			if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("��")) {
				ops.push(s);
			}

			else if (s.equals(")")) {
				String op = ops.pop();
				String va = val.pop();

				if (op.equals("+")) {
					va = "(" + val.pop() + "+" + va + ")";
				} else if (op.equals("-")) {
					va = "(" + val.pop() + "-" + va + ")";
				} else if (op.equals("��")) {
					va = "(" + val.pop() + "*" + va + ")";
				}

				val.push(va);

			}

			else {
				val.push(s);
			}

		}
		while(!val.isEmpty()){
			System.out.print(val.pop());
		}
		
	}

}
