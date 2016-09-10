/*************************************************************************************
 * 			Polynomial.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0.1		 
 * @since 	2016-07-19			 
 * 								 
 *	 Constructor Summary:
 *Polynomial()
 *		Default constructor. set Node head to null and size to 0;
 *
 *	  Methods Summary:
 *Public void add(int coef, int expo)
 *		Pass the value for coefficient and exponent and create a new Node
 *public void addFromString(String[] numbers)
 *		Pass a string, parse it and get the numbers, and start creating Node from those numbers.
 *public int getCoef(int index)
 *		Pass an int with a location, returns the coefficient value in the location specify if exist.
 *public int getPower(int index)
 *		Pass an int with a location, return the exponent value in the location specify if exist.
 *public boolean isEmpty()
 *		return true is the Polynomial is empty, otherwise false. 
 *public int getSize()
 *		return size of polynomial.
 *public void Print()
 *		print to screen the entire Polynomial.
 *public void ModifyIndex(int index,int coef,int power)
 *		Pass a location, coefficient and power to modify the location with the values before mentioned.
 *public void makeEmpty()
 *		makes head equal to null and size equal to 0 
 *public static Polynomial addition(Polynomial p1,Polynomial p2)
 *		Pass 2 Polynomial types, return the addition of the 2 polynomial before mentioned.
 *Static Polynomial product(Polynomial p1,Polynomial p2)
 *		Pass 2 Polynomial types, return the product of the 2 polynomial.
 ***************************************************************************************************/
public class Polynomial {
	
	private Node head;
	private int size;

	public Polynomial()		{	head=null;	size=0; 	}
	
	public void add(int coef, int expo)	{
		Node elem=new Node(coef,expo);	
		Node track=head;
		if(isEmpty()) 	{
			head=elem;
			size++;
			return;
		}
		
		while(track.getNext()!=null)
			track=track.getNext();
		track.setNext(elem);
		size++;
	}
	
	public void addFromString(String[] numbers)	{
		for(int i=0;i<numbers.length;i++)	{
			add(Integer.parseInt(numbers[i]),i);
		}
	}
	
	public int getCoef(int index)	{
		if(index>size) 	{
			System.out.println("Index not found, System will return 0");
			return 0;
		}
		Node track=head;
		for(int i=0;i<index;i++)
			track=track.getNext();
		return track.getCoeft();	
	}
	
	public int getPower(int index)	{
		if(index>size) 	{
			System.out.println("Index not found, System will return 0");
			return 0;
		}
		Node track=head;
		for(int i=0;i<index;i++)
			track=track.getNext();
		return track.getExponent();
	}
	
	public boolean isEmpty()	{
		return head==null;
	}
	
	public int getSize()	{
		return size;
	}
	
	public void Print()	{
		Node track=head;
		while(track!=null)	{
				if(track.getCoeft()>=0)
					System.out.print("+");
			System.out.print(track.getCoeft());
			if(track.getExponent()!=0)
				System.out.print("x^"+track.getExponent());
			System.out.print(" ");
			track=track.getNext();
		}
		System.out.println();
	}
	
	public void ModifyIndex(int index,int coef,int power)	{
		if(index>size) 	{
			System.out.println("Index not found");
			return ;
		}
		Node track=head;
		for(int i=0;i<size-1;i++)	{
			track=track.getNext();
		}
		track.setCoef(coef);
		track.setExponent(power);
	}
	public void makeEmpty()	{
		head=null;
		size=0;
	}
	
	public static Polynomial addition(Polynomial p1,Polynomial p2)
	{
		Polynomial sum=new Polynomial();
		Node a=p1.head;
		Node b=p2.head;
		while(a!=null || b!= null)	{
			if((a!=null && b!=null))	{
				if(a.getExponent()<b.getExponent())	{
					sum.add(a.getCoeft(), a.getExponent());
					a=a.getNext();
				}	
				else if(a.getExponent()> b.getExponent())	{
					sum.add(b.getCoeft(),b.getExponent());
					b=b.getNext();
				}
				else 	{
					sum.add(a.getCoeft()+b.getCoeft(), a.getExponent());
					a=a.getNext();
					b=b.getNext();
				}
			}
			else	{
				if(a==null)	{
					sum.add(b.getCoeft(),b.getExponent());
					b=b.getNext();
				}
				else	{
					sum.add(a.getCoeft(),a.getExponent());
					a=a.getNext();
				}
			}
		}
		return sum;
	}
	
	public static Polynomial product(Polynomial p1,Polynomial p2)	{
		Polynomial sum=new Polynomial();
		for(Node b=p2.head;b!=null;b=b.getNext())	{
			Polynomial temp=new Polynomial();
			for(Node a=p1.head;a!=null;a=a.getNext())	{
			temp.add(a.getCoeft()*b.getCoeft(), a.getExponent()+b.getExponent());	
			}
			sum=addition(sum,temp);
			}
		return sum;
	}
	
}
