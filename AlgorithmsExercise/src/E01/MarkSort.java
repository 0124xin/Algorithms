package E01;

import java.util.*;
import java.util.Map.Entry;

/**
 * �ɼ�����
 * ��Ŀ���������⣨�û����ɼ������У����Ի�óɼ��Ӹߵ��ͻ�ӵ͵��ߵ�����,��ͬ�ɼ�
      ������¼��������ǰ�Ĺ�����
   ��ʾ��
   jack      70
   peter     96
   Tom       70
   smith     67
   �Ӹߵ���  �ɼ�            
   peter     96    
   jack      70    
   Tom       70    
   smith     67    
   �ӵ͵���
   smith     67  
   Tom       70    
   jack      70    
   peter     96      
 * @author he
 *
 *˼·��
 *�����ݴ�ŵ�HashMap����ת��Ϊlist�����Collections.sortָ���Ƚ��� ��������
 *
 *
 */

//�Դ����map�е�Valueֵ��������
class myCompare implements Comparator<Map.Entry<String, Integer>>{
	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		//��ȡVӳ����бȽ�
		return o2.getValue().compareTo(o1.getValue());
	}
	
}

public class MarkSort {
	
	public static void main(String[] args) {

		Map<String , Integer> map=new HashMap<String,Integer>();
		map.put( "jack" , 70);
		map.put("peter", 96);
		map.put("Tom",70);
		map.put("smith", 67);
		
		List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list, new myCompare());
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}	
	}
}
