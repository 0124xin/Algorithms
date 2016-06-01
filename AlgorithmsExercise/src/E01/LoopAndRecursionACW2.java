package E01;

/**
 * ��ʱ����������
 * 
 * @author Administrator
 * 
 */
public class LoopAndRecursionACW2 {
	private int[][] numArray;
	int x = 0;
	int y = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoopAndRecursionACW2 loopACW = new LoopAndRecursionACW2();
		int row=Integer.valueOf(args[0]);//�к�  4
		int column=Integer.valueOf(args[1]);//�к�  5
		loopACW.createArray(row,column);
		loopACW.printToConsole();
	}

	private void createArray(int row,int column ) {
		int i = 0, j = 0;// �����±�
		int c = 0;// ��������0��ʼ��ÿһ�㶼��һ�������Σ��򳤷��Σ����ܹ��������ߣ�ÿһ���ߵĽ��ϣ����ǹյ�
		int d = 0;// 0����ʾ��һ���ߣ�1����ʾ�ڶ����ߣ�2����ʾ��������3����ʾ������
		x=row;
		y=column;
		numArray = new int[x][y];
		int maxValue = x * y;

		for (int k = 1; k <= maxValue; k++) {
			if (d == 0) {
				if (i == x - c - 1) {// ��һ���յ�
					d = 1;
				} else {
					numArray[i][j] = k;
					i++;
					continue;
				}
			}
			if (d == 1) {
				if (j == y - c - 1) {// �ڶ����յ�
					d = 2;
				} else {
					numArray[i][j] = k;
					j++;
					continue;
				}
			}
			if (d == 2) {
				if (i == c) {// �������յ�
					d = 3;
				} else {
					numArray[i][j] = k;
					i--;
					continue;
				}
			}
			if (d == 3) {
				if (j == c + 1) {// ���ĸ��յ�Ĵ���Ƚ�����
					numArray[i][j] = k;
					d = 0;
					c++;
					i++;
					continue;
				} else {
					numArray[i][j] = k;
					j--;
					continue;
				}
			}
		}

	}

	private void printToConsole() {
		String space = "";
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (numArray[i][j] < 10) {
					space = "  ";
				} else {
					space = " ";
				}
				System.out.print(numArray[i][j] + space);
			}
			System.out.println();// ����
		}

	}

}
