package Numbe_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P27 ����algs.jar ��һ���������
 * 
 * @author he
 *
 */
public class DrawArrays {

	public static void main(String[] args) {
		int N = 50;
		double[] a = new double[N];
		// ����0��1֮��������
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.random();
		}
		Arrays.sort(a);
		// ���������
		for (int i = 0; i < N; i++) {
			// ����
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			// ���
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		
		
	}

}
