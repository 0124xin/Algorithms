package Num1_1_03;

import edu.princeton.cs.algs4.Stack;

/**
 * P107 T49
 * 
 * @author he ˼·��������ջʵ��һ�����У���֤��Ԫ�ص����˳���FIFO
 * ��ջʵ�ֶ��л���ɿռ��˷ѣ�����һ��ջ����������ת��֤FIFO��˳��
 */

class Que<T> {
	private Stack<T> left = new Stack<T>();
	private Stack<T> right = new Stack<T>();

	// ���Ԫ��
	void enqueue(T item) {
		left.push(item);
	}

	T dequeue() {
		while (!left.isEmpty()) {
			// ��left�е�Ԫ�ظ�right
			right.push(left.pop());
		}
		return right.pop();
	}

	int size() {
		return left.size();
	}

	boolean isEmpty() {
		if (left.isEmpty() && right.isEmpty()) {
			return true;
		}
		return false;
	}
}

public class Num_1_03_49 {
	public static void main(String[] args) {

		Que<Integer> que = new Que<Integer>();
		for (int i = 0; i < 5; i++) {
			que.enqueue(i);
		}
		System.out.println("que size-->"+que.size());
		while (!que.isEmpty()) {
			System.out.println(que.dequeue());
		}
	}

}
