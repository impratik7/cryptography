import java.io.*;
import java.net.*;
import java.util.Scanner;
class Client
{
	static int k;
	
	void fromPRN(int n)
	{
		/*****************Sum of odd digits and even digits***********/
		int cycle=1;
		int a=n,c=0;
		int s1=0,s2=0;
		while(a!=0)
		{
			c=a%10;
			if(cycle%2==0)
				s1=s1+c;
			else
				s2=s2+c;
			cycle++;			
			a=a/10;
		}
		if(s1>s2)
			k=s1-s2;
		else
			k=s2-s1;
		System.out.println("Value of k used = "+k);
	}

	void fromEMAIL(String n)
	{
		/**********Email characters count and addition of digits in the email*************/
		int l=n.length();
		char c;int count=0;
		int p=n.lastIndexOf('@');
		for(int i=0;i<p;i++)
		{
			c=n.charAt(i);
			count++;		
		}
		for(int i=0;i<l;i++)
		{
			c=n.charAt(i);
			if(c>='0' && c<='9')
			{
				int temp=Integer.parseInt(String.valueOf(c));
				count-=temp;
			}
		}
		k=count;
		System.out.println("Value of k used = "+k);		
	}

	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",3333);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str="";String str2="";
		int count=0;
		while(!str.equals("stop"))
		{
			if(count%2==0)
			{
				System.out.println("Enter a message to send");
				str=br.readLine();

				/***********************CLIENT ENCRYPTION PROCESS**************/
				Client x=new Client();
				x.fromPRN(1614110139);
				//x.fromEMAIL("shubhankargupta123@gmail.com");
				int l=str.length();String msg="";
				for(int i=0;i<l;i++)
				{
					char c=str.charAt(i);
					msg+=(int)(c+k);
				}
				str=msg;

				dout.writeUTF(str);
				dout.flush();
				count++;
				/**************************************************************/
			}

			else
			{
				/***************Sending the key********************************/
				String key="";
				key=key+Integer.parseInt(String.valueOf(k));
				dout.writeUTF(key);
				dout.flush();
				count++;
				/**************************************************************/
			}		

		}
		//Closing the connection
		din.close();
		s.close();
	}
}
