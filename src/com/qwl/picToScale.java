package com.qwl;
  
  
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.imageio.ImageIO;  
  
public class picToScale {  
      
    public void binaryImage() throws IOException{  
	    File file = new File("C:\\AC\\javafiles\\SVM\\data\\03.jpg");    
	    BufferedImage image = ImageIO.read(file);  
	    PrintWriter out = new PrintWriter("C:\\AC\\javafiles\\SVM\\data\\03totxt.txt");  
	      
	    int width = image.getWidth();  
	    int height = image.getHeight();  
	      
	    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);//重点，技巧在这个参数BufferedImage.TYPE_BYTE_BINARY  
	    for(int i= 0 ; i < width ; i++){  
	        for(int j = 0 ; j < height; j++){  
		        int rgb = image.getRGB(i, j);
		        System.out.println(rgb);
		        //grayImage.setRGB(i, j, rgb);  
	    }  
	    out.close();
    }  
      
    File newFile = new File(System.getProperty("user.dir")+"/src/2722425974762424028.jpg");  
    ImageIO.write(grayImage, "jpg", newFile);  
    } 
	
    public void grayImage() throws IOException{  
	    File file = new File("C:\\AC\\javafiles\\SVM\\data\\4.png");  
	    BufferedImage image = ImageIO.read(file);  
	    PrintWriter out = new PrintWriter("C:\\AC\\javafiles\\SVM\\data\\totxt.txt");   
	    int width = image.getWidth();  
	    int height = image.getHeight();  
	      
	    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);//重点，技巧在这个参数BufferedImage.TYPE_BYTE_GRAY  
	    int num=1;
	    for(int i= 0 ; i < width ; i++){  
	        for(int j = 0 ; j < height; j++){  
	        	int rgb = image.getRGB(i, j);  
	        	////////////////
	        	int r = (rgb & 0xff0000) >> 16;  
                int g = (rgb & 0xff00) >> 8;  
                int b = (rgb & 0xff);  
                int gray = (int)(r * 0.3 + g * 0.59 + b * 0.11);
                int grays=(255-gray);
                if(grays > 200) out.write(num + ":" + 1 + " ");
                num++;
                //System.out.println(grays);
	        	//////////
	        	//grayImage.setRGB(i, j, rgb);
	        }  
	    }  
	    out.write('\n');
	    out.close(); 
    }  
     
    public void grayImage(String path,String label) throws IOException{  
	    File file = new File(path);  
	    BufferedImage image = ImageIO.read(file);  
	    //PrintWriter out = new PrintWriter("C:\\AC\\javafiles\\SVM\\data\\09totxt.txt"); 
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\AC\\javafiles\\SVM\\data\\csv\\mnist\\test.txt", true)));
	    int width = image.getWidth();  
	    int height = image.getHeight();  
	    out.write(label+" ");
	    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);//重点，技巧在这个参数BufferedImage.TYPE_BYTE_GRAY  
	    int num=1;
	    for(int i= 0 ; i < width ; i++){  
	        for(int j = 0 ; j < height; j++){  
	        	int rgb = image.getRGB(i, j);  
	        	////////////////
	        	int r = (rgb & 0xff0000) >> 16;  
                int g = (rgb & 0xff00) >> 8;  
                int b = (rgb & 0xff);  
                int gray = (int)(r * 0.3 + g * 0.59 + b * 0.11);
                int grays=(255-gray);
           
                if(grays > 130) out.write(num + ":" + 1 + " ");
                num++;
                //System.out.println(grays);
	        	//////////
	        	//grayImage.setRGB(i, j, rgb);
	        }  
	    }  
	    out.write('\n');
	    out.close(); 
    } 
    public static void picToScale2(picToScale demo) throws IOException{//批量转换
	    String path1 = "C:\\AC\\javafiles\\SVM\\data\\csv\\mnist\\test";
	    File file1 = new File(path1);
	    String[] fileName1 = file1.list();
	    for(String c1:fileName1){
	    	String path2 = path1+"\\"+c1;
	    	File file2 = new File(path2);
	    	String[] fileName2 = file2.list();
	    	for(String c2 : fileName2){
	    		String path3 = path2+"\\"+c2;
	    		System.out.println(path3);
	    		demo.grayImage(path3,c1); 
	    	}
	    	
	    }
    }
    public static void main(String[] args) throws IOException {  
    	picToScale demo = new picToScale();  
	    //demo.grayImage();  
	    //demo.binaryImage();
    	demo.picToScale2(demo);
    }  
  
}  