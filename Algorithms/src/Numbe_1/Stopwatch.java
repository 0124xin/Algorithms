package Numbe_1;
/**
 * P110   ��ʱ�����ڼ�¼�������е�ʱ��
 * @author he
 *
 */

import edu.princeton.cs.algs4.StdRandom;

/**
 * 	P110
 * ͳ�����к�Ϊ0��������Ԫ�������
 *������������N3  ��N��3�η���
 * 
 * @author he
 *
 */
class ThreeSum {
	public static int count(int a[]) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}

		}
		return cnt;
	}

}

public class Stopwatch {
	private final long start;

	public Stopwatch() {
		start=System.currentTimeMillis();//��ȡϵͳ��ǰʱ���Ժ���Ϊ��λ
	}
	
	public double elapsedTime(){
		long now=System.currentTimeMillis();
		return (now-start)/1000.0;
	}
	
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);//1000
		int a[]=new int[N];
		for(int i =0;i<N;i++){
			a[i]=StdRandom.uniform(-1000000, 1000000);
		}
		Stopwatch s=new Stopwatch();
		int cnt=ThreeSum.count(a);
		double time=s.elapsedTime();
		System.out.println("count:"+cnt+" time:"+time+"seconds");
	}
	
	
}

















