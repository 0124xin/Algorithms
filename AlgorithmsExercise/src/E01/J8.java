package E01;

/**
 * �ٶ����Ƕ�֪���ǳ���Ч���㷨�����һ�������Ƿ�Ϊ�����ַ������Ӵ����뽫����㷨��д��һ�����������������ַ���s1��s2��
 * ���д������s2�Ƿ�Ϊs1��ת���ɣ�Ҫ��ֻ�ܵ���һ�μ���Ӵ��ĺ�����
 * ���������ַ���s1,s2,�뷵��boolֵ����s2�Ƿ���s1��ת���ɡ��ַ������ַ�ΪӢ����ĸ�Ϳո����ִ�Сд���ַ�������С�ڵ���1000�� ����������
 * "Hello world","worldhello " ���أ�false "waterbottle","erbottlewat" ���أ�true
 * 
 * @author he
 * 
 *         ���������ת s2����s1+s1���ִ�
 *
 */
public class J8 {
	public static boolean checkReverseEqual(String s1, String s2) {
		return (s1 + s1).contains(s2);
	}

	public static void main(String[] args) {
		System.out.println(checkReverseEqual("waterbottle", "erbottlewat"));

	}
}
