package E01;

/**
 * ��ӡ�����Ż���
 * ���þ���ֵ
 * args:7
 * @author he
 * ���ɣ�����args:7 ���1����7/2=3���ո�ͣ�7/2+1-7/2����2-1����*��
 */
public class Rhombus02 {
	public static void main(String[] args) {
		
		int N=Integer.valueOf(args[0]);//���ε�������ҪΪ����
		int space=N/2;//��һ�еĿո���
         for(int i=space;Math.abs(i)<space+1;i--){
        	 //��ӡ�ո�
        	 for(int j=Math.abs(i);j>0;j--){
        		 System.out.print(" ");
        	 }
        	 //��ӡ��*����
        	 for(int k=(space+1-Math.abs(i))*2-1;k>0;k--){
        		 System.out.print("*");
        	 }
        	 System.out.println();
        	 
         }
	}
}
