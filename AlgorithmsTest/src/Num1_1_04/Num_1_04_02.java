package Num1_1_04;

/**
 * ��Java��int 32λ������һλ���������������ȡֵ��Χ����ֻ��31λ���ڴ�ֵ -2147483648��2147483647
 * ��Ȼ��int����������������Ǵ��ȥ�����ֲ�û�����ֻ�ǽ�����Ӳ�������� ����������ɽ����������
 * 
 * @author he ����ͨ��
 *
 */

public class Num_1_04_02 {

	public static void main(String[] args) {
		int i = 2147483647;
		int b = 1;
		// int i = -2147483648;
		// int b = -1;
		if ((i > 0 && b > 0 && i + b < 0) || (i < 0 && b < 0 && i + b > 0)) {
			System.out.println("error");
		}

	}
}
