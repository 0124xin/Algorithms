package Numbe_1;

import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;

/**
 * VisualCount
 * 
 * @author he
 *
 */

class VisualCount {
	private int count = 0;
	private final int XMAX = 1000;// ����X���ֵ
	private final double YMAX = 1.0;// ����Y���ֵ
	private boolean temp = false;
	private Random random = new Random(47);

	public VisualCount(int N, int Max) {
		StdDraw.setXscale(0, XMAX);// ����X��Χ
		StdDraw.setYscale(0, YMAX);// ����Y��Χ
		StdDraw.setPenRadius(.005);

		for (int i = 0; i < N; i++) {
			temp = random.nextBoolean();
			// �����������
			count = temp ? count + 1 : count - 1;

			StdDraw.setPenColor(StdDraw.RED);
			// ����
			StdDraw.point(count * Math.random() * 40, Math.random());
			if (count == Max || -count == Max) {
				System.out.println("�ﵽ���ֵ");
				break;
			}

		}
	}
}

public class TestVisualCounter {
	public static void main(String[] args) {
		new VisualCount(10000, 20);
	}

}
