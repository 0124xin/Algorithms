package Number_2;

/**
 * P153 �����㷨���ģ�壬ʹ�ø�ģ��������֧��Comparable
 * 
 * @author he
 *
 */
public class Example {
	// ����
	public static void sort(Comparable[] a) {
		/* ���㷨2.1 2.2 2.3 2.4 �� */
	}

	// Ԫ��֮����бȽ�
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; // ���v<w��Ϊtrue
	}

	// ����Ԫ��λ��
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	//�����д�ӡ����
	public static void show(Comparable a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	//���������Ƿ�����
	public static boolean isShorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a={"A","B","C"};
		assert isShorted(a);//���� ��ֹ���������ѭ������ϵͳ����
		show(a);
		System.out.println(isShorted(a));
	}

}
