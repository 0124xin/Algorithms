package Number_5;

import java.math.BigInteger;
import java.util.Random;

/**
 * P508 �㷨5.8 Rabin-Karpָ���ַ��������㷨 
 * ʹ�����ؿ����㷨������ʱ�������Լ�����ҳ���ĸ���С���ǳ�С����
 * ��˹ά��˹�㷨�ܹ���֤��ȷ�������ܼ���ӽ����Լ���
 *
 * args[0]:AACAA 
 * args[1]:AABRAACADABRAACAADABRA
 * 
 * @author he
 *
 */
public class RabinKarp {
	private String pat;// ������˹ά��˹�㷨��check
	private long patHash;// ģʽ�ַ�����ɢ��ֵ
	private int M;// ģʽ�ַ����ĳ���
	private long Q;// һ���ܴ������
	private int R = 256;// 8ΪASCII���Ԫ������
	private long RM;// R^(M-1)%Q

	public RabinKarp(String pat) {
		this.pat = pat;
		this.M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		// ����R^(M-1)%Q
		for (int i = 1; i <= M - 1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}

	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt, M);// ��ȡ�ı�ǰM���ַ�����hashֵ
		if (txtHash == patHash && check(0)) // һ��ʼ������
			return 0;
		// �ı��ַ���ʼ���Ʋ�����ƥ��
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;

			/**
			 * �������еȼ���������һ�д��룬������ͼ5.3.17 i>=5�Ĳ���
			 */
			// txtHash=((txtHash+txt.charAt(i-M)*(Q-RM))*R+txt.charAt(i))%Q;

			if (patHash == txtHash)
				if (check(i - M + 1))
					return i - M + 1;// �ҵ�ƥ��

		}
		return N;// δ�ҵ�ƥ��

	}

	// �������㷨
	public boolean check(int i) {
		return true;
	}

	// ��˹ά��˹�㷨
	public boolean check(String txt, int i) {
		for (int j = 0; j < M; j++) {
			if (txt.charAt(j + i) != pat.charAt(j))
				return false;
		}

		return true;
	}

	// �����ַ�����ɢ��ֵ
	private long hash(String key, int M) {
		long h = 0;
		for (int i = 0; i < M; i++)
			h = (R * h + key.charAt(i)) % Q;
		return h;
	}

	// ����31λ���������
	private long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();// ת��Ϊlong����
	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		RabinKarp kmp = new RabinKarp(pat);
		System.out.println("text:   " + txt);
		int offset = kmp.search(txt);
		System.out.print("pattern:");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pat);
	}

}
