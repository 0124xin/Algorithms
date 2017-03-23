package Searching;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ�� ��һ������40�ڸ�������е�32λ������˳���ļ��У�ע��������򣩣��ҳ�һ�������ļ��е�32λ��������int���͵����������ļ���
 * ����ȱ��һ���������� Ҫ��ʹ�����ٵ��ڴ�
 * 
 * ˼·����ÿ����ת��Ϊ2��������Ȼ�����0/1̽�⣬��Ϊ0��λ������һ���ڴ��У���Ϊ1��λ��������һ���ڴ��У�
 * һ���ļ�������ֻ��20�ڸ�����Ϊ40��С��2��32�η�������ȱ�ٵĿ϶��ܶ࣬��ĿҪ��ֻҪ�ҵ�1�����ɣ������淭��������
 * ����Ӧ���Ժ����������ٵ��ļ��ٴ���Ϊ����Դ������0/1̽�⣬���̽����ǵڶ�λ���������ң��ٽ��з��࣬�������� �����㷨ʱ�临�Ӷ�ֻ��O(n);
 * 
 * ������˼·ֻ���ҵ�һ�����������Ҫ���ҵ����ڴ����������Ӧ�ÿ���λͼ����
 * 
 * 
 * 
 * 
 * @author he
 *
 */

public class FindLackNumber {

	private static int bit = 4;// �ܹ���λ����int 32λ

	private static Integer[] temp;
	private static ArrayList<Integer> zero;// ���0
	private static List<Integer> one;// ���1
	private static int number;

	// �ҵ�����a��ȱ�ٵ�����
	public static int find(Integer[] a) {
		temp = a;
		zero = new ArrayList<>();
		one = new ArrayList<>();

		while (bit-- > 0) {
			zero.clear();
			one.clear();
			for (int i = 0; i < temp.length; i++) {
				// ��λΪ1
				if ((temp[i] & (1 << bit)) != 0) {
					one.add(temp[i]);
				} else {
					zero.add(temp[i]);
				}
			}

			if (zero.size() < one.size()) {
				temp = (Integer[]) zero.toArray(new Integer[zero.size()]);
				number |= 0 << bit;
			} else {
				temp = (Integer[]) one.toArray(new Integer[one.size()]);
				number |= 1 << bit;
			}
		}
		return number;

	}

	public static void main(String[] args) {
		Integer[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15 };
		System.out.println(find(a));

	}

}
