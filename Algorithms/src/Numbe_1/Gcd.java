package Numbe_1;
/**
 * P1
 * �����Լ��
 * �õݹ��˼��
 * @author he
 *
 */

/**
 * �����Ǹ�����p,q�����Լ���� ��q��0�������Լ��Ϊp. ����p����q�õ�������r��p��q�����Լ����Ϊq��r�����Լ��
 * 
 * @author he
 *
 */

public class Gcd {
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		int r = p % q;
		// �ݹ�
		return gcd(q, r);
	}	
	public static void main(String[] args) {
		System.out.println(gcd(1, 2));
	}
}
