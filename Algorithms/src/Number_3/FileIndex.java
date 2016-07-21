package Number_3;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * P322 �ļ��������������ļ��е�����һ�����ʺ�һ�����ֹ�������ʵ������ļ����ļ������ɵ�SET�����������
 * args:ex*.txt
 * 
 * 
 * @author he
 *
 */
public class FileIndex {
	public static void main(String[] args) {
		ST<String, SET<File>> st = new ST<String, SET<File>>();
		for (String filename : args) {
			File file = new File(filename);
			In in = new In(file);
			while (!in.isEmpty()) {
				String word = in.readString();
				if (!st.contains(word))
					st.put(word, new SET<File>());
				SET<File> set = st.get(word);
				set.add(file);
			}
		}

		while (!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if (st.contains(query))
				for (File file : st.get(query))
					System.out.println(" " + file.getName());
		}

	}
}
