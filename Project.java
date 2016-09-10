/********************************************************
 * 			Project.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-07-19			 
 * 			
 * Summary:							
 *Reads a file named it "data" located it in the folder src. 
 *Create two polynomial and print it to the screen.
 *Add these two polynomial and print it to the screen.
 *Calculate the product of these two Polynomial and print it to the screen
 *Keep doing these until the file "data" is empty.
 *
 *******************************************************/
import java.io.*;

public class Project {
	public static void main(String[] args) {
	FileReader file;
	BufferedReader infile;
	String line;
	Polynomial p1,p2;
	p1=new Polynomial();
	p2=new Polynomial();
	try	{
		file=new FileReader("src/data");
		infile=new BufferedReader(file);
		int i=1;
		while((line=infile.readLine())!=null)	{
			System.out.println("Set "+ i+" of Polynomials");
			String number[]=line.split(",");
			p1.addFromString(number);
			System.out.println("First Polynomial");
			p1.Print();
			if((line=infile.readLine())==null)
					break;
			number=line.split(",");
			p2.addFromString(number);
			System.out.println("Second Polynomial");
			p2.Print();
			line=infile.readLine();
			Polynomial sum=Polynomial.addition(p1,p2);
			System.out.println("The sum of these two polynomials is:");
			sum.Print();
			sum.makeEmpty();
			System.out.println("The product of these two polynomials is");
			Polynomial prod= Polynomial.product(p1, p2);
			prod.Print();
			prod.makeEmpty();
			System.out.println();
			p1.makeEmpty();
			p2.makeEmpty();
			i++;
		}
	}
	catch(Exception e)	{	 System.out.println(e);	}
	}	
}

