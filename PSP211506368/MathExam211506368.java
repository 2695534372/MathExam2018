
package x211506368;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MathExam368 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("输入题目数量：");
		try{
			
			int count = sc.nextInt();
			System.out.println("输入年级：");
			int grade = sc.nextInt();
			File file = new File("C:\\java\\out.txt");
			if(!makeTxt(file)){
				throw new RuntimeException("文件创建失败");
			}
			String[][] RT = buildQuestion(count, grade);
			boolean isSuccess = printQuestion(file, RT);
			if(isSuccess){
				System.out.println("创建成功");
			}else{
				System.out.println("算术创建失败");
			}
		}catch(InputMismatchException e){
			System.out.println("创建失败");
			System.out.println("输入的题目数量和年级必须为正整数");
		}catch(Exception e){
			System.out.println("创建失败");
		}
	}
	
	
	private static String[][] buildQuestion(int count){
		return buildQuestion(count, 2);
	}
	
	
	private static String[][] buildQuestion(int count, int grade){
		
		if(count < 0){
			count = 1;
		}
		if(grade < 1){
			grade = 1;
		}
		if(grade==1) {
			grade=1;
		}

		int limited = grade * 20;
		Random random = new Random();
		String[][] 	RT= new String[count][4];
		for (String[] arr : RT) {
			
			int wohenkun = random.nextInt(limited);
			
			int danshimeizuohao = random.nextInt(limited);
			
			if(grade==1) {
				int woxiangshuijiao = random.nextInt(2);
				if(woxiangshuijiao==0 ) {
				arr[1] = " + ";
				arr[3] = String.valueOf(wohenkun + danshimeizuohao);	
				}
				else if(woxiangshuijiao==1 ) {
					arr[1] = " - ";
					arr[3] = String.valueOf(wohenkun - danshimeizuohao);
					
				
				}}
			if(grade==2) {
				int woxiangshuijiao = random.nextInt(2);
				
				 if(woxiangshuijiao==1) {arr[1] = " × ";
				arr[3] = String.valueOf(wohenkun * danshimeizuohao);
				}		
					
				
				
				 else {
					 arr[1] = " ÷ ";
						while(danshimeizuohao == 0){
							danshimeizuohao = random.nextInt(limited);
						}
						int remainder = (wohenkun%danshimeizuohao);
						if(remainder == 0){
							arr[3] = String.valueOf(wohenkun/danshimeizuohao);
						}else{
							arr[3] = String.valueOf(wohenkun/danshimeizuohao) + "..." + String.valueOf(remainder);
						}

					 
				 }
					}

			  arr[0] = String.valueOf(wohenkun);
				arr[2] = String.valueOf(danshimeizuohao);
		}
		return RT;
		
	}
	
	private static boolean printQuestion(File file, String[][] RT){
		StringBuilder buff = new StringBuilder();
		StringBuilder answerbuff = new StringBuilder();
		String newLine = "\r\n";
		String divideStr = "------------------标准答案------------------\r\n";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日\tHH:mm");
		String anthorInfo = "\t\t211506368 \t\t霍金池\t\t" + sdf.format(new Date());
		
		for(int i =1; i<=RT.length; i++){
			String[] arr = RT[i-1];
			String str = "("+ i + ") " + arr[0] + arr[1] + arr[2] +" =";
			buff.append(str + newLine);
			answerbuff.append(str + " "  + arr[3] + newLine);
		}
		
		FileOutputStream ll = null;
		try {
			ll = new FileOutputStream(file);
			ll.write(buff.toString().getBytes());
			ll.write(divideStr.getBytes());
			ll.write(answerbuff.toString().getBytes());
			ll.write(anthorInfo.getBytes());
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件未找到异常", e);
		}  catch (IOException e) {
			throw new RuntimeException("输入或输出流发生异常", e);
		}
		finally{
			try {
				ll.close();
			} catch (IOException e) {
				throw new RuntimeException("输出流关闭发生异常", e);
			}
		}
		return true;
	}
	
	private static boolean makeTxt(File file){
		
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
		if(! file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException("文件创建失败", e);
			}
		}
		FileWriter fileWrite = null;
		try {
			fileWrite = new FileWriter(file);
			fileWrite.write("");
			fileWrite.flush();
		} catch (IOException e) {
			throw new RuntimeException("文件清空发生异常", e);
		}finally{
			try {
				fileWrite.close();
			} catch (IOException e) {
				throw new RuntimeException("文件写入流关闭发生异常", e);
			}
		}
		
		return file.exists();
	}
}
