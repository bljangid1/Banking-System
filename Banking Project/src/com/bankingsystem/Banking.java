package com.bankingsystem; 
import java.util.Scanner; 
class Myexception extends Exception  
{ 
Myexception(String message)  
{ 
super(message); 
} 
} 
class Bank  
{ 
private int age; 
private String name; 
private int balance = 0; 
private int ac_no; 
private String acc_type; 
public Bank(int age, String name, int ac_no,String acc_type)  
{ 
this.age = age; 
this.name = name; 
this.ac_no = ac_no; 
this.acc_type=acc_type; 
} 
public int getAge() { 
return age; 
} 
public void setAge(int age) { 
this.age = age; 
} 
public String getName() { 
return name; 
} 
public void setName(String name) { 
this.name = name; 
} 
public int getBalance() { 
return balance; 
} 
public void setBalance(int balance) { 
this.balance = balance; 
} 
public int getAc_no() { 
return ac_no; 
}
public void setAc_no(int ac_no) { 
this.ac_no = ac_no; 
} 
public String getAcc_type() { 
return acc_type; 
} 
public void setAcc_type(String acc_type) { 
this.acc_type=acc_type; 
} 
} 
class SbiSavingAc extends Bank  
{ 
public SbiSavingAc(int age, String name, int balance,String acc_type)  
{ 
super(age, name, balance,acc_type); 
} 
} 
public class Banking  
{ 
public static void main(String[] args)
{ 
Scanner src = new Scanner(System.in); 
System.out.println("===================================================================="); 
 System.out.println("=============== Bank Management System ============================="); 
  
System.out.println("===================================================================="); 
int ch; 
SbiSavingAc ac = new SbiSavingAc(0, "xyz", 0,"abc"); 
boolean b = true; 
String ss; 
String cho=null; 
try {
	do 
	{ 
	//System.out.println(""); 
	System.out.println("\n****************Menu***************** "); 
	System.out.println("\t1.Create Account "); 
	System.out.println("\t2.Deposit Money "); 
	System.out.println("\t3.Withrow Money "); 
	System.out.println("\t4.Display Details "); 
	System.out.println("\t5.Exit"); 
	System.out.println("**************************************"); 
	System.out.print("Enter Your Choice:-> "); 
	ch = src.nextInt(); 
	switch (ch)  
	{ 
	case 1: 
	System.out.println("*********Please Enter Your Details**********"); 
	System.out.print("Enter Your Name:-> "); 
	ss = src.next(); 
	ac.setName(ss); 
	System.out.print("Please Enter Your Age:-> "); 
	ch = src.nextInt(); 
	ac.setAge(ch); 
	System.out.print("Enter Account type:-> "); 
	ss= src.next(); 
	ac.setAcc_type(ss); 
	System.out.print("Enter Your Account Number:-> "); 
	ch = src.nextInt(); 
	ac.setAc_no(ch); 
	System.out.println("\t Account Created Successfully................."); 
	break; 
	case 2: 
		System.out.println("****************Deposit Section****************"); 
		System.out.print("Please Enter the Account Number to Deposit Money:-> "); 
		ch = src.nextInt(); 
		try 
		{ 
		if (ac.getAc_no() == ch) 
		{ 
		System.out.print("Enter Money to be Deposited:-> ");
		try 
		{	
		ch =  
		src.nextInt(); 
		if (ch < 500)  
		{ 
		throw new 
		Myexception("Minimum Balance Deposit"); 
		}  
		else 
		{ 
		int 
		bb; 
		bb =  
		ac.getBalance() + ch; 
		ac.setBalance(bb); 
		System.out.println("\t Money Deposited Successfully..................."); 
		} 
		}  
		catch (Myexception e) 
		{ 
		System.out.println(e.getMessage()); 
		System.out.println("Transaction Failed"); 
		b = false; 
		} 
		} 
		else 
		{ 
		throw new 
		Myexception("Account Not Found "); 
		} 
		} 
		catch (Myexception e)  
		{ 
		System.out.println(e.getMessage()); 
		System.out.println("Transaction Failed "); 
		b = false; 
		} 
		break; 
		case 3: 
		System.out.println("****************Withrow Section****************"); 
		System.out.print("Please Enter the Account Number to Withrow Money:-> "); 
		ch = src.nextInt(); 
		try 
		{
		if (ac.getAc_no() == ch)  
		{ 
			System.out.print("Enter The Amount To be Withrow:-> "); 
			ch = src.nextInt(); 
			try 
			{ 
			if 
			(ac.getBalance() > ch)  
			{ 
			System.out.println("\t Amount Withrown.................... "); 
			int a; 
			a =  
			ac.getBalance() - ch; 
			ac.setBalance(a); 
			}  
			else 
			{ 
			throw 
			new Myexception("Insufficient funds ! your Current balance is "+ac.getBalance()); 
			} 
			}  
			catch (Myexception  
			e)  
			{ 
			System.out.println(e.getMessage()); 
			System.out.println("Transaction Failed "); 
			b = false; 
			} 
			}  
			else 
			{ 
			throw new 
			Myexception("Account Not Found"); 
			} 
			}  
			catch (Myexception e)  
			{ 
			System.out.println(e.getMessage()); 
			System.out.println("Transaction Failed "); 
			b = false; 
			} 
			break; 
		case 4:
			 
			System.out.println("***********************Account Details*********************** "); 
			System.out.println("Name:-> " +ac.getName());
			System.out.println("Account Type:-> "+ac.getAcc_type()); 
			System.out.println("Account No:-> " + ac.getAc_no()); 
			System.out.println("Age:-> " +  
			ac.getAge()); 
			System.out.println("Balance:-> " 
			+ ac.getBalance()); 
			System.out.println("**************************************"); 
			break; 
		case 5: 
			throw new Myexception("User Exit"); 
			} 
			System.out.println("Do you want to continue? (Y-Yes / N-No)"); 
			cho=src.next(); 
			} 
			while(cho.equals("Y")||cho.equals("y")); 
			  
			System.out.println("===================================================================="); 
			 System.out.println("Bye....");  
			  
			System.out.println("===================================================================="); 
			}  
			catch (Myexception e)  
			{ 
			System.out.println(e.getMessage()); 
			System.out.println("Thanks For Using"); 
			System.exit(0); 
			} 
			} 
			}

		
		

