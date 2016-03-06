package Num1_1_02;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;

/**
 * Interval2D��������
 * 
 * @author he
 *
 */
public class Interval2DTest {
	public static void main(String[] args) {
		double xlo = .1;// x��ʼ��
		double xhi = .5;// x����ֹ��
		double ylo = .4;// y��ʼ��
		double yhi = .6;// y����ֹ��
		int T = 100000;
		//��ȡx�ĳ���
		Interval1D xinterval = new Interval1D(xlo, xhi);
		System.out.println(xinterval.length());
		//��ȡy�ĳ���
		Interval1D yinterval = new Interval1D(ylo, yhi);
		System.out.println(yinterval.length());
		//������ֱ��������������ά���   ��ƽ��ͼ��
		Interval2D box = new Interval2D(xinterval, yinterval);
		box.draw();
		System.out.println(box.area());
	}
}
