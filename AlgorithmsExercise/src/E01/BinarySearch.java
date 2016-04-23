package E01;

/**
 * ���ֲ���
 * 
 * @author he
 *
 */
public class BinarySearch {
	// �����±�index
	static int rank(int key, int[] a) {
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			int mid = start + (start + end) / 2;
			if (key < a[mid]) {
				end = mid - 1;
			} else if (key > a[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
		
	}
}
