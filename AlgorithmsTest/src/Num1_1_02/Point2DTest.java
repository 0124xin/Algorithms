package Num1_1_02;

import edu.princeton.cs.algs4.Point2D;

/**
 * ���Ի���
 * 
 * @author he
 *
 */
public class Point2DTest {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			double x = Math.random();
			double y = Math.random();
			Point2D p = new Point2D(x, y);
			p.draw();
			
		}		
		System.out.println("������");
	}
}
