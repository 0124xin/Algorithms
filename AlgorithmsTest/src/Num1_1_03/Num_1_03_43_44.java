package Num1_1_03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * P106 T43 T44 �ο�ǰ���ϰ�������һ����
 * 
 * 
 * @author he
 *
 */
public class Num_1_03_43_44 {
	private static List<File> directory = new ArrayList<File>();

	public static List<File> getFile(File file) {
		for (File file2 : file.listFiles()) {
			if (file2.isDirectory()) {
				directory.add(file2);
				getFile(file2);
			} else {
				directory.add(file2);
			}

		}

		return directory;
	}
	
	public static void main(String[] args) {
		File file=new File("F:/IOtest");//·���Լ�����
		System.out.println(getFile(file));
	}

}
