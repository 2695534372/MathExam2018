
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintStream;
	import java.util.Random;

	public class MathExam6351{
			public static void main(String[] args) throws FileNotFoundException {
				int i=0;int a;int r;
				String wen = "";
				String da = "";
				int n = 0;
				if(args.length==1) {
				try {		
					n =Integer.parseInt(args[0]);
	 				if (n < 0||n==0) {
	 					System.out.println("����������");}
	 				if(n>100)
	 				{
	 					System.out.println("������1~100���ڵ���");
	 				}
	 			} catch(NumberFormatException e) {
	 				System.out.println("����������");
	 			}
				for(i=0;i<=n;i++)
				{	
					int fu=new Random().nextInt(2);//�������+��-�ţ���0Ϊ+����1Ϊ-
					if(fu==0)
					{		
						int x=(int)(Math.random()*100);//���100����һ����x
						int y=(int)(Math.random()*(100-x));
						r=x+y;
						System.out.println("(" + i + ") " + x + " + " + y + " =");
						da = "(" + i + ") " + x + " + " + y + " = " + r;			

					}
					if(fu==1)
					{
						int x=(int)(Math.random()*100);
						int y=(int)(Math.random()*100);
						if(y>x)
					{
						a=x;x=y;y=a;
					}
						r=x-y;
						System.out.println("(" + i + ") " + x + " - " + y + " =");
						da = "(" + i + ") " + x + " - " + y + " = " + r;
					}
					
				}					

			}
				File file = new File("out6351.txt");
				PrintStream ps = new PrintStream(file);
				System.setOut(ps);//�Ѵ����Ĵ�ӡ���������ϵͳ
				
			}
	}


