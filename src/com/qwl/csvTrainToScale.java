package com.qwl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class csvTrainToScale {

	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new FileReader("C:\\AC\\javafiles\\SVM\\data\\csv\\train.csv")); 
		PrintWriter out = new PrintWriter("C:\\AC\\javafiles\\SVM\\data\\csv\\train1000.txt"); 
		String tempread = in.readLine();
		int limit=130;//二值化阈值
		int n=0;
		while(tempread != null && n++<1000){
			String[] read = tempread.split("\\,");
			//写入lablel
			out.print(Integer.parseInt(read[0])+" ");
			//写入数据
			for(int i=1; i<read.length;i++){
				int val = Integer.parseInt(read[i])>limit ? 1:0;
				if(val==1) out.print(i+":"+val+" ");
			}
			out.println();
			tempread=in.readLine();
		}
		in.close();
		out.close();
	}

}
