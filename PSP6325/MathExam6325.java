import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6325 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("��������Ҫ���ɵ���Ŀ����(��Χ��1-100)�Լ����꼶����Ŀ(1��2�꼶)��");
		int n;
		int grade;
		int flag = 0;// ��������Ƿ��Կո��β
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String regex = "(([1-9]|[1-9][0-9]|100)( ?)(1?|2{1}))";// ���������ʽ��������ʽ
		if (input.matches(regex)) {
			for (int i = 0; i < input.length(); i++) { // ֻ��������Ŀ����
				if ((input.substring(i, i + 1)).equals(" ")) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) { // �����Կո��β
				n = Integer.valueOf(input);
				grade = 1; // Ĭ�Jһ�꼉
				getFirstGradeMath(n, grade);
				return;
			}
			if (input.endsWith(" ")) { // ֻ������Ŀ�� + һ���ո�
				n = Integer.valueOf(input.substring(0, input.length() - 1));
				grade = 1;
				getFirstGradeMath(n, grade);
				return;
			} else { // �����ʽ��ȷ ��Ŀ�� + �ո� + ���꼶
				String[] spiltArray = null;
				spiltArray = input.split(" ");// �ÿո�ָ��ַ��� �ָ�Ƀɂ����M
				n = Integer.valueOf(spiltArray[0]);
				grade = Integer.valueOf(spiltArray[1]);
				if (grade == 1) {
					getFirstGradeMath(n, grade);
				} else {
					getSecondGradeMath(n, grade);
				}
				return;
			}
		} else {
			System.out.println(
					"��Ǹ ݔ���ʽ���`" + "���_ݔ���ʽ:\n���ɵ���Ŀ��(������1-100)" + " " + "���ɼ��꼶(1��2�꼶)" + "\nע��:��δָ���꼶����Ĭ������һ�꼶��ѧ��");
		}
	}

	private static void getSecondGradeMath(int n, int grade) {
		// TODO �Զ����ɵķ������
		String[] Calculate = new String[n + 1];// ������������ֱ��Á�����ʽ�ͼ�����
		String[] Result = new String[n + 1];
		Calculate[0] = "";
		Result[0] = null;
		for (int i = 1; i <= n; i++) {
			int numberOne;
			int numberTwo;
			int number;
			String randomSign = null;
			Random randomNumber = new Random();
			numberOne = randomNumber.nextInt(9) + 1;/* ȡ������1-9֮������������Ϊ��ʽ������ */
			numberTwo = randomNumber.nextInt(9) + 1;
			number = randomNumber.nextInt(9);/* �������S�C���Q����̖ ���4�顮*�� ��֮�顮/�� */
			if (number > 4) {
				randomSign = "��";
			} else {
				randomSign = "��";
			}
			Calculate[i] = "(" + i + ")" + " " + numberOne + ' ' + randomSign + ' ' + numberTwo + " = ";
			// �����̺�����
			String quotient = null;
			String remainder = null;
			// �ж���ʽ�ǳ˷����㻹�ǳ�������
			if (randomSign.equals("��")) {// ����ʽΪ����ʱ��������������������ʹ����������С��81
				numberOne = randomNumber.nextInt(80) + 1;
				numberTwo = randomNumber.nextInt(80) + 1;
				// �жϱ������Ƿ���ڳ���
				if (numberOne > numberTwo) {// �ж��Ƿ��ܹ�����
					if ((numberOne % numberTwo) == 0) {
						quotient = numberOne / numberTwo + "";
						Result[i] = quotient;
					} else {
						quotient = numberOne / numberTwo + "";
						remainder = numberOne % numberTwo + "";
						Result[i] = quotient + "..." + remainder;
					}
					// �޸�������Ҫ��Ӧ���޸���ʽ
					Calculate[i] = "(" + i + ")" + " " + numberOne + ' ' + randomSign + ' ' + numberTwo + " = ";
				} else {
					// ��������С�ڳ���ʱ���������ͳ�������
					if ((numberTwo % numberOne) == 0) {
						quotient = numberTwo / numberOne + "";
						Result[i] = quotient;
					} else {
						quotient = numberTwo / numberOne + "";
						remainder = numberTwo % numberOne + "";
						Result[i] = quotient + "..." + remainder;
					}
					Calculate[i] = "(" + i + ")" + " " + numberTwo + randomSign + numberOne + " = ";
				}
			} else {
				Result[i] = numberOne * numberTwo + "";
			}
		}
		outputAnswer(Calculate, Result);
		getAnswer();
	}

	private static void getFirstGradeMath(int n, int grade) {
		// TODO �Զ����ɵķ������
		String[] Calculate = new String[n + 1];
		String[] Result = new String[n + 1];// �������� һ�������ʽ һ����Ž��
		Calculate[0] = "";
		Result[0] = null;
		for (int i = 1; i <= n; i++) {
			int numberOne;
			int numberTwo;
			int number;
			String randomSign = null;
			Random randomNumber = new Random();
			numberOne = randomNumber.nextInt(51);
			numberTwo = randomNumber.nextInt(51);// ������������С��������50
			number = randomNumber.nextInt(101);// ���õ����������
			if (number > 50) { // ���������50Ϊ��+�� ʹ����������ġ�+����-�����ʾ�Ϊ50%
				randomSign = "+";
			} else {
				randomSign = "-";
			}
			Calculate[i] = "(" + i + ")" + " " + numberOne + " " + randomSign + " " + numberTwo + " = ";
			if (randomSign.equals("-")) {
				if ((numberOne - numberTwo) >= 0) {
					Result[i] = numberOne - numberTwo + "";
				} else {
					Calculate[i] = "(" + i + ")" + " " + numberTwo + " " + randomSign + " " + numberOne + " = ";
					Result[i] = numberTwo - numberOne + "";
				}
			} else {
				Result[i] = numberOne + numberTwo + "";
			}
		}
		outputAnswer(Calculate, Result);
		getAnswer();
	}

	private static void getAnswer() {
		// TODO �Զ����ɵķ������
		File file = new File("out.txt");
		BufferedReader pr = null;
		String str = "";
		try {
			pr = new BufferedReader(new FileReader(file));
			try {
				while ((str = pr.readLine()) != null) {
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void outputAnswer(String[] Calculate, String[] Result) {
		// TODO �Զ����ɵķ������
		File file = new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				file.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedWriter save = null;
		String str = "";
		try {
			save = new BufferedWriter(new FileWriter(file));
			for (int i = 1; i < Calculate.length; i++) {// �������ʽ��
				str = Calculate[i];
				save.write(str);
				save.newLine();
				save.flush();
			}
			save.newLine();
			save.flush();
			for (int i = 1; i < Calculate.length; i++) { // �������׼�𰸵�ʽ��
				str = Calculate[i] + Result[i];
				save.write(str);
				save.newLine();
				save.flush();
			}
			save.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}