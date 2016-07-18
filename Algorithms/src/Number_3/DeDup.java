package Number_3;

import java.util.HashSet;

import edu.princeton.cs.algs4.In;

/**
 * P314 Dedup������ ȥ���������е��ظ���
 * HashSet�ײ��õ���HashMap,����ϣɢ�б�
 * args[0]:tinyTale.txt
 * @author he
 *
 */
public class DeDup {
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		In in=new In(args[0]);//args[0]:tinyTale.txt
		while(!in.isEmpty()){
			String key=in.readString();
			if(!set.contains(key)){
				set.add(key);
				System.out.print(key+" ");
			}
			
		}
	}

}
