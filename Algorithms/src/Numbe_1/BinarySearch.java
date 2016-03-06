package Numbe_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P5
 * ���ַ�����
 * 
 * @author he
 *
 */

// ���ַ������ز������ֵ�����,hi��lo���ܵ���mid  ӦΪ�����������ѭ��
public class BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] whitelist = { 1, 2, 3, 55, 44, 33, 25, 6, 4 };
		Arrays.sort(whitelist);
		for (int i = 0; i < whitelist.length; i++) {
			System.out.print(whitelist[i] + "  ");
		}

		System.out.println("\n  ������Ҫ��ѯ����");
		// ʹ�������в���
		// System.out.println(args[0]);
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();

		System.out.println("�±�����Ϊ" + rank(key, whitelist));
		

	}

}
