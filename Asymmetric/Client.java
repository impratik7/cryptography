import java.io.*;
import java.net.*;
import java.util.Scanner;
class Client
{
	double cipher;

	String encrypt(String input,int n,int e)
	{	
		int l=input.length();
		for(int i=0;i<l;i++)
		{
			char c=input.charAt(i);
			cipher=(cipher*10)+((int)c-64);
		}
		System.out.println("Cipher Value is "+cipher);
	
		cipher=(Math.pow(cipher,e))%n;
		System.out.println("Cipher Text is "+cipher);
		String x=String.valueOf(cipher);
		System.out.println("Cipher Text String is "+x);
		return x;		
	}
	
	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",3333);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str="";String str2="";

		System.out.println("Enter a message");
		str=br.readLine();

		/*******************Encrypting the message************************/
		Client x=new Client();

		System.out.println("Enter the value of n");
		int n=Integer.parseInt(br.readLine());

		System.out.println("Enter the value of e");
		int e=Integer.parseInt(br.readLine());

		String sent=x.encrypt(str,n,e);
		/****************************************************************/		
	
		dout.writeUTF(sent);
		dout.flush();	

		//Closing the connection
		din.close();
		s.close();
	}
}