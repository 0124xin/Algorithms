package Num1_2_02;

import edu.princeton.cs.algs4.Queue;

/*
 * һ���������ȡ��һ��Ԫ�غ�����Ż�ȥͬʱ��֤���е�ԭʼ˳��
 * ��ʹ�ø����ڴ�
 * queue: 0 1 2 3 4 
 * ȡ��0���ַŻ�ȥ ������˳��
 * 0 1 2 3 4
 */
public class Fun {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
        Integer t=queue.dequeue();
        int count=queue.size();
        queue.enqueue(t);
        while(count-->0){
        	queue.enqueue(queue.dequeue());
        }
        
        while(!queue.isEmpty()){
        	System.out.print(queue.dequeue()+" ");
        }
        
	}	
}
