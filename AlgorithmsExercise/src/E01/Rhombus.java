package E01;

/**
 * ��ӡ����
 * 
 * ��ӡ�������� ����*���ɡ� �� Ȼ��һ��for()ѭ���������ӡ* ��ͼ�е� - ��ӡ��λ��
 * 
 * @author he
 *
 */
public class Rhombus {
	public static void main(String[] args) {
		// ��ӡ����벿������
		for (int i = 1; i < 5; i++) {
			// ��ӡ�ո�
			for (int j = 1; j < 5 - i; j++) {
				System.out.print(" ");
			}
			System.out.print("-");
			for (int k = 0; k < i * 2 - 1; k++) {
				System.out.print("*");
			}
			System.out.print("-");
			System.out.println();
		}

		// ��ӡ�²�������
		for (int i = 4; i > 1; i--) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 2 * i - 3; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
