package first;

import java.util.Scanner;

public class MathExam361 {
	
public static void main(String[] args)  {
	
	Scanner input =new Scanner(System.in);
	System.out.println("����������Ҫ��������Ŀ");	
	 int number=input.nextInt();
	 int[] d=new int[number];
	 int[] e=new int[number];
	 int[] f=new int[number];
	 
   for (int i = 0; i < number; i++) {
       int a=(int)(0+Math.random()*20);
       int b=(int)(0+Math.random()*20);
       int c=(int)(1+Math.random()*4); 
       d[i] =a;
       e[i]=b;
       f[i]=c;
     
        if(c==1) {
           System.out.println("("+(i+1)+") "+a+" + "+b+"= " );
	  }else if(c==2){
		   System.out.println("("+(i+1)+") "+a+" - "+b+"= " );	
	  }else if(c==3) {
		   System.out.println("("+(i+1)+") "+a+" * "+b+"= " );		
	  }else {
		  System.out.println("("+(i+1)+") "+a+" / "+b+"= " );	
	 }
   }
	 System.out.println("================��׼��=====================");
	
	 for (int i = 0; i < number; i++) {	
   	   if(f[i]==1) {
   		 System.out.println("("+(i+1)+") "+d[i]+" + "+e[i]+"= "+(d[i]+e[i]));	 
   	    }else if(f[i]==2) {
   		 System.out.println("("+(i+1)+") "+d[i]+" - "+e[i]+"= "+(d[i]-e[i]));	
   	    }else if(f[i]==3) {
   		 System.out.println("("+(i+1)+") "+d[i]+" * "+e[i]+"= "+(d[i]*e[i]));
	    }else {
		  System.out.println("("+(i+1)+") "+d[i]+" / "+e[i]+"= "+(d[i]/e[i]));	
	  }
   		
	 } 
}
}


	
