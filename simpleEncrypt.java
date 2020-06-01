import java.util.Scanner;
class abc
{
	String msg;int k;String cipher="";
	void input()
	{
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter a message");
		msg=Sc.nextLine();
	}

	void encrypt()
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

	void decrypt()
	{
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter cipher text");
		String cip=Sc.nextLine();
		int l=cip.length();char c;
		String original="";
		for(int i=0;i<l;i++)
		{
			c=cip.charAt(i);
			original+=(char)(c-k);
		}
		System.out.println("Original Text is "+original);
	}

	public static void main(String args[])
	{
		abc x=new abc();
		x.input();
		x.encrypt();
		x.decrypt();
	}
}
