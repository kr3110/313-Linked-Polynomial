/********************************************************
 * 			Node.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-07-19			 
 * 								 
 *	 Constructor Summary:
 * Node()
 * 		Default Constructor.		
 * Node(int c, int e)
 * 		Pass in the number for coefficient and exponent.
 * Node(int c,int e,Node n)
 *		Pass in the number for coefficient, exponent 
 *		and pass the value for the Next value
 *
 *	  Methods Summary:
 *Void SetNext(Node n)
 *		Pass a Node and set it to Next value.
 *Void setCoef(int c)
 * 		Pass an integer and set it as Coefficient.
 *Void setExponent(int e)
 *		Pass an integer and set it as Exponent.
 *Int getExponent()
 *		Return an integer representing the exponent.
 *Int getCoeft()
 *		Return an integer representing the coefficient.
 *Public Node getNext()
 *		Return a Node for the next Node.			
 *******************************************************/

public class Node {
	
	private int coeff;
	private int exponent;
	private Node Next;

	public Node()						{   this(0,0,null);							}
	public Node( int c, int e)			{	this(c,e,null); 						}
	public Node(int c, int e, Node n)	{	coeff=c;	exponent=e;		Next= n;	}

	public void setNext(Node n) 		{	Next=n;			}
	public void setCoef(int c)			{	coeff=c;		}
	public void setExponent(int e)		{	exponent=e;		}
	public int getExponent()			{	return exponent;}
	public int getCoeft()				{	return coeff;	}
	public Node getNext()				{	return Next;	}
	
}
