import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MathExam377 {
 
public static void main(String[] args) throws FileNotFoundException  {
	File file = new File("out.txt");
	
	DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		
	Scanner s=new Scanner(System.in);
	System.out.println("�������꼶��");
	int grade = s.nextInt();
	if(grade == 2) { 
		grade_two();
	}else { 
		grade_one();
	}
	}
public static void grade_one() {
 Scanner input =new Scanner(System.in);
 System.out.println("����������Ҫ��������Ŀ"); 
  int number=input.nextInt();
  int[] d=new int[number];
  int[] e=new int[number];
  int[] f=new int[number];
  
   for (int i = 0; i < number; i++) {
       int a=(int)(0+Math.random()*20);
       int b=(int)(0+Math.random()*20);
       int c=(int)(1+Math.random()*2); 
       d[i] =a;
       e[i]=b;
       f[i]=c;
     
        if(c==1) {
           System.out.println("("+(i+1)+") "+a+" + "+b+"= " );
   }else {
     System.out.println("("+(i+1)+") "+a+" - "+b+"= " );
   }   
  }
 
  System.out.println("================��׼��=====================");
 
  for (int i = 0; i < number; i++) {
  
       if(f[i]==1) {
      System.out.println("("+(i+1)+") "+d[i]+" + "+e[i]+"= "+(d[i]+e[i]));  
     }else {
      System.out.println("("+(i+1)+") "+d[i]+" - "+e[i]+"= "+(d[i]-e[i])); 
     } 
     
  } 
}


public static void grade_two() {
	System.out.println("������������Ŀ��");
	Scanner s=new Scanner(System.in);
	int m = s.nextInt();
	double ai[]=new double[m]; 
	double aj[]=new double[m];
	double ax[]=new double[m];
	int m1=1;
	for(int a=0; a<m;a++)
	{
		int i=(int) Math.floor(Math.random()*10+1);//���������
		int j=(int) Math.floor(Math.random()*10+1);//���������
		int x=(int) Math.floor(Math.random()*2+1);//���������
		ai[a]=i;//���������������
		aj[a]=j;//���������������
		ax[a]=x;//���������������
		if(x%2==1) {
		System.out.println("(" + m1 + ") "+ i +" * " + j + "=");
		}else {
		System.out.println("(" + m1 + ") "+ i + " / " + j + "= ");
		}
		m1++;
	}	
	System.out.println("                  ");		
	int m2=1;
	for(int a1=0;a1<m;a1++)
	{
		int B[]=new int[m];  
	    B[m-1]=(int) (ai[a1]%aj[a1]); //��������������
	if(ax[a1]%2==1) 
	{
	System.out.println("("+ m2 +") "+ ai[a1] +" * "+ aj[a1] +" = "+(ai[a1]*aj[a1]));
	}else {
		if(ai[a1]%aj[a1]==0)
		{
			System.out.println("("+ m2 +") "+ ai[a1] +" / "+ aj[a1] +" = "+floor(ai[a1]/aj[a1]));
		}else {
			System.out.println("("+ m2 +") "+ ai[a1] +" / "+ aj[a1] +" = "+floor((ai[a1]/aj[a1]))+"..."+B[m-1]);
	}
		}
	m2++;
	}}
private static String floor(double d) {
	// TODO Auto-generated method stub
	return null;
}}
