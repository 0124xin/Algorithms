package Num1_1_04;

import edu.princeton.cs.algs4.Stack;;

/**
 * ʹ��1.3.32д��Steque,ʹ��1.3.33��API
 * Steque�����������push()���ݣ�ͬʱSteque��pop()��ӦDeque��popRight() ����popLeft()
 * 
 *
 * @author he
 * ����ͨ��
 */

class Deque1<T> {
	private Steque<T> steque = new Steque<T>();
	private Stack<T> stack = new Stack<T>();

	public void pushLeft(T item) {
		steque.enqueue(item);
	}

	public void pushRight(T item) {
		steque.push(item);
	}

	public T popLeft() {

		if (steque.isEmpty()) {
			throw new RuntimeException();
		}

		// ��Ԫ��push��stack
		while (!steque.isEmpty()) {
			stack.push(steque.pop());
		}
		T first=stack.pop();
		
		// ��Ԫ������pushRight��steque,��ȥ������˵�Ԫ��
		while(!stack.isEmpty()){
			steque.enqueue(stack.pop());
		}		
		return first;
	}

	public T popRight() {
		if (steque.isEmpty()) {
			throw new RuntimeException();
		}
		return steque.pop();
	}
}

public class Num_1_04_30 {
	public static void main(String[] args) {
		Deque1<Integer> deque1 = new Deque1<Integer>();
		deque1.pushLeft(2);
		deque1.pushLeft(1);
		deque1.pushRight(3);
		deque1.pushRight(4);
		System.out.println(deque1.popRight());// 4
		System.out.println(deque1.popRight());// 3
		System.out.println(deque1.popLeft());// 1
		System.out.println(deque1.popLeft());// 2

	}
}
