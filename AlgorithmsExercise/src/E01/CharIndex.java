package E01;

public class CharIndex {

	public static void main(String[] args) {
		int hundredsDigit,tensDigit,unitsDigit;//hundredsDigit��ʾ���ֵİ�λ��tensDigit��ʾ���ֵ�ʮλ��unitsDigit��ʾ���ֵĸ�λ
		System.out.println("Ѱ��Armstrong����");
		for (int i = 100; i <= 999; i++) {
			//No.1
			//��ʼд���룬����153��������1^3 + 5^3 + 3^3 = 153������������ΪArmstrong�������������λ���е�Armstrong��
			hundredsDigit =i/100; 
			tensDigit = (i-hundredsDigit*100)/10;
			unitsDigit =i-hundredsDigit*100-tensDigit*10;
			if (hundredsDigit*hundredsDigit*hundredsDigit + unitsDigit*unitsDigit*unitsDigit +tensDigit*tensDigit*tensDigit ==i)
				System.out.print(i + " ");
			//end_code
		}
		System.out.println();
	}
}
