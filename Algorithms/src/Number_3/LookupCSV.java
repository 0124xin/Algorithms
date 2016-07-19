package Number_3;

import edu.princeton.cs.algs4.In;

/**
 * P318
 * args[0]:ip.csv �ļ��� 
 * args[1]:1 ָ������λ�ã��У� 
 * args[2]:0 ָ��ֵ��λ�ã��У�
 * args[3]:128.112.136.35  Ҫ��ѯ��ip
 * 
 * @author he
 *
 */
public class LookupCSV {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int keyField = Integer.valueOf(args[1]);
		int valField = Integer.valueOf(args[2]);
		ST<String, String> st = new ST<String, String>();
		while (!in.isEmpty()) {
			String line = in.readLine();
			String[] tokens = line.split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			st.put(key, val);
		}
		String query = args[3];
		if (st.contains(query))

			System.out.println("��ַ " + st.get(query) + "��Ӧ��IP��ַ " + query);

	}
}
