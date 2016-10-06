package Number_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * P552 �㷨5.11 LZW�㷨
 * ����Ϊ8λ���ֽ������Ϊ12λ����
 * ���ַ����ı����R+1��ʼ
 * ѹ���㷨���ԣ���console��input����abra.txt��console��output����lzw.txt
 * ��ѹ���㷨���ԣ���console��input����lzw.txt
 * ��ζ����ҵĲ���:http://blog.csdn.net/fuckluy/article/details/50999238
 * @author he
 *
 */
public class LZW {
	private static final int R=256;//8ΪASCII����ַ�����
	private static final int L=4096;//�������� 2^12
	private static final int W=12;//�����ȣ�12λ����
	
	//����ѹ��
	public static void compress(){
		String input=BinaryStdIn.readString();
		TST<Integer> st=new TST<Integer>();
		for(int i=0;i<R;i++)
			st.put(""+(char)i, i);
		int code=R+1;//�ļ������ı���
		
		while(input.length()>0){
			String s=st.longestPrefixOf(input);//�ҵ�inputǰ׺��ļ�
			BinaryStdOut.write(st.get(s),W);//��ӡs�ı���(��Wbit)
			int t=s.length();
			if(t<input.length() && code<L)
				//t+1������
				st.put(input.substring(0 ,t+1),code++);
			input=input.substring(t);//ȥ�����ַ���s
		}
		BinaryStdOut.write(R,W);
		BinaryStdOut.close();
		
	}
	
	//����չ��
	public static void expand(){
		String st[]=new String[L];
		int i;//��һ������ȫ�ı���ֵ
		//��ʼ�������
		for( i=0;i<R;i++)
			st[i]=""+(char)i;
		
		st[i++]=" ";//EOF���ڵ�ǰհ�ַ�
		int codeword=BinaryStdIn.readInt(W);//��ȡWbit��ȡ����
		String val=st[codeword];//��ȡ�����ַ�
		while(true){
			BinaryStdOut.write(val);//�����ǰ���ַ�
			codeword=BinaryStdIn.readInt(W);
			if(codeword==R)
				break;
			String s=st[codeword];//��ȡ��һ������
			if(i==codeword)//ǰհ�ַ�������
				s=val+val.charAt(0);//������һ���ַ���������ĸ�õ�������ַ���
			if(i<L)
				st[i++]=val+s.charAt(0);//Ϊ������������Ŀ
			val=s;//���µ�ǰ����
		}
		BinaryStdOut.close();
	}
	
	public static void main(String[] args) {
		if (args[0].equals("-"))
			compress();
		else if (args[0].equals("+"))
			expand();
	}
	
}
