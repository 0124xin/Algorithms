package Num1_1_02;

import edu.princeton.cs.algs4.Interval1D;

/**
 * ��ֱ��
 * 
 * @author he
 *
 */
public class Interval1DText {
	public static void main(String[] args) {
		Interval1D t = new Interval1D(.1, .4);
		Interval1D t2 = new Interval1D(.2, .6);
		double x = .3;
		// �жϵ�.3�Ƿ���ֱ����
		System.out.println(t.contains(x));// true
		// �ж�����ֱ���Ƿ��ཻ
		System.out.println(t.intersects(t2));// true
	}
}
