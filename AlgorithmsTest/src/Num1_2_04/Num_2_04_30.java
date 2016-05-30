package Num1_2_04;

/**
 * P211 T30
 * 
 * @author he
 *
 */

class findMedian {
	private int a[];
	private int N;// ������Ԫ�ص�����

	public findMedian() {
		a = new int[1];
	}

	public void insert(int i) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = i;
	}

	// ���ز�ɾ����λ��
	public double median() {
		if (N == 0) {
			System.out.println("����");
			throw new RuntimeException();
		}
		int b[] = new int[N];
		System.arraycopy(a, 0, b, 0, N);// ��Ϊʹ��SelectElement.findMedianʱ����������˳������ʹ�ø���
		double median = SelectElement.findMedian(b);// ��ȡ��λ��

		// ɾ����λ����������
		if (N % 2 != 0) {// ����
			for (int i = N / 2; i < N - 1; i++) {
				a[i] = a[i + 1];
			}
			a[N - 1] = -1;
			N--;
		} else {// ż��
			for (int i = N / 2; i < N - 1; i++) {
				a[i - 1] = a[i + 1];
			}
			a[N - 1] = -1;
			a[N - 2] = -1;
			N -= 2;
		}

		return median;

	}

	// ��������
	private void resize(int max) {
		int temp[] = new int[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void show() {
		for (int i = 0; i < N; i++) {

			System.out.print(a[i] + " ");
		}
	}

}

public class Num_2_04_30 {
	public static void main(String[] args) {
		findMedian f = new findMedian();
		for (int i = 1; i < 6; i++) {
			f.insert(i);
		}

		f.show();
		System.out.println("\n" + "��λ����" + f.median());
		f.show();
		System.out.println("\n" + "��λ����" + f.median());
		f.show();
		System.out.println("\n" + "��λ����" + f.median());
		System.out.println("\n" + "��λ����" + f.median()); // exception

	}

}
