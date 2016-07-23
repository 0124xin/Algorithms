package Num1_3_05;

import java.util.LinkedList;

/**
 * P326 T11 ���Դ�����ͬ�ļ���ֵ���ҿɻ�ȡ��Ӧ�ļ���
 * 
 * @author he
 *
 */

class MultiSET<Key extends Comparable<Key>, Value> {
	private LinkedList<Key> keys[];
	private LinkedList<Value> vals[];
	private int cap;

	@SuppressWarnings("unchecked")
	public MultiSET(int cap) {
		this.cap = cap;
		keys = new LinkedList[cap];
		vals = new LinkedList[cap];
	}

	private int hashCode(Key key) {
		return (key.hashCode() & 0x7fffffff) % cap;
	}

	private boolean contains(Key key) {
		if (key == null)
			throw new NullPointerException("argument to contains() is null");
		return getLast(key) != null;
	}

	public void put(Key key, Value value) {
		int i;
		for (i = hashCode(key); keys[i] != null; i = (i + 1) % cap) {
			if (key.equals(keys[i].getFirst())) {
				keys[i].addLast(key);
				vals[i].addLast(value);
			}
		}
		keys[i] = new LinkedList<Key>();
		vals[i] = new LinkedList<Value>();
		keys[i].addLast(key);
		vals[i].addLast(value);
	}

	/**
	 * ���������µ�ֵ ���磺put("A", 1);put("A", 2);��getLast("A") ����2
	 * 
	 * @param key
	 * @return
	 */
	public Value getLast(Key key) {
		for (int i = hashCode(key); keys[i] != null; i = (i + 1) % cap) {
			if (key.equals(keys[i].getLast())) {
				return vals[i].getLast();
			}
		}
		return null;
	}

	/**
	 * ������ͬ���µļ���
	 * 
	 * @param key
	 * @return
	 */
	public String getGather(Key key) {
		for (int i = hashCode(key); keys[i] != null; i = (i + 1) % cap) {
			if (key.equals(keys[i].getLast())) {
				return vals[i].toString();
			}
		}
		return null;
	}

	/**
	 * ������ͬKey������
	 * 
	 * @param key
	 * @return
	 */
	public int numOfKey(Key key) {
		for (int i = hashCode(key); keys[i] != null; i = (i + 1) % cap) {
			if (key.equals(keys[i].getLast())) {
				return keys[i].size();
			}
		}
		return 0;
	}

	/**
	 * ��ѯ��num����ͬkey ��Ӧ��value 
	 * num��0��ʼ
	 * 
	 * @param key
	 * @param num
	 * @return
	 */
	public Value getOfIndex(Key key, int num) {
		if (contains(key)) {
			for (int i = hashCode(key); keys[i] != null; i = (i + 1) % cap) {
				if (key.equals(keys[i].getLast())) {
					return vals[i].get(num);
				}
			}
		}
		return null;
	}
}

public class Num_3_05_11 {
	public static void main(String[] args) {
		MultiSET<String, Integer> set = new MultiSET<String, Integer>(10);
		set.put("A", 1);
		set.put("A", 2);
		set.put("A", 3);
		set.put("A", 4);
		set.put("A", 5);
		set.put("A", 6);
		set.put("B", 10);
		System.out.println(set.getLast("A"));
		System.out.println(set.getGather("A"));
		System.out.println(set.numOfKey("A"));
		System.out.println(set.getOfIndex("A", 4));

	}

}
