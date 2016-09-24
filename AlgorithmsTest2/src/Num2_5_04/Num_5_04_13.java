package Num2_5_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * P527 T13
 * 
 * @author he
 *
 */
public class Num_5_04_13 {
	private static Pattern pattern;
	private static Matcher matcher;

	// ƥ�����11��111�������ַ���
	public static void matchA(String txt) {
		pattern = Pattern.compile("[^1]{2,3}");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group());
	}

	// ����λΪ1����λ��Ϊ1��
	public static void matchB(String txt) {
		pattern = Pattern.compile("\\s?\\d*1");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group());
	}

	// ƥ�����ٺ�������0�򲻰�����һ��1�������ַ���
	public static void matchC(String txt) {

		pattern = Pattern.compile("\\s?\\d*0{2,}\\d*|\\s?[^1]*");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group());
	}

	public static void matchD(String txt) {
		pattern = Pattern.compile("[^1]{2}");
		matcher = pattern.matcher(txt);
		while (matcher.find())
			System.out.print(matcher.group()+" ");

	}

	public static void main(String[] args) {
		// matchA("11112341111144115411234");
		// matchB("23 45 91 67 21 1");
		// matchC("123 900 789 551 90 112");
		matchD("11432425341143545657");

	}

}
