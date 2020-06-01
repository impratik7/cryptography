import java.util.Scanner;
class Client
{
	static String msg;public static int k;public static String cipher="";
	void input()
	{
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter a message");
		msg=Sc.nextLine();
	}

	static void encrypt()
	{
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter a number");
		k=Sc.nextInt();
		int l=msg.length();char c;
		for(int i=0;i<l;i++)
		{
			c=msg.charAt(i);
			cipher+=(char)(c+k);
		}
		System.out.println("Cipher Text is "+cipher);
	}
	public static void main(String args[])
	{
		Client x=new Client();
		x.input();
		x.encrypt();
	}
}

class Server
{
	String original="";
	void decrypt(String cip,int k)
	{
		int l=cip.length();char c;
		for(int i=0;i<l;i++)
		{
			c=cip.charAt(i);
			original+=(char)(c-k);
		}
		System.out.println("Original Text is "+original);
	}

	public static void main(String args[])
	{
		Server x=new Server();
		Client cl=new Client();
		x.decrypt(cl.cipher,cl.k);
	}
}
