package E01;

/**
 * ��Ŀ����
 * 
 * ��һƪ�����ں�������ʣ��ָ����������ʣ������һ����Ч�㷨���ҳ��������������ʵ���̾���(����������ĵ�����,Ҳ��������������������λ�õĲ�ľ���ֵ)��
 * ����һ��string����article�������������£�ͬʱ�������µĵ�����n�ʹ����ҵ���������x��y���뷵���������ʵ���̾��롣
 * ��֤�������ʾ������г����Ҳ���ͬ��ͬʱ��֤���µ�����С�ڵ���1000��
 * 
 * @author he
 *
 */
public class Distance {
	 public static int getDistance(String[] article, int n, String x, String y) {
	        int min=999;
	        int j=-1,k=-1;
	        for(int i=0;i<n;i++){
	            if(article[i].equals(x))
	                j=i;
	            else if(article[i].equals(y))
	                k=i;
	            if(j!=-1 && k!=-1 && Math.abs(k-j) <min)
	                min=Math.abs(k-j);
	        }
	        return min;
	    }
	 public static void main(String[] args) {
		System.out.println(getDistance(new String[]{"a","v","a","v","v"}, 5, "a", "v"));
	}

}
