import java.util.Scanner;
class abc
{
	String msg;int k;int cipher[]=new int[100];
	int newcipher[]=new int[100];
	void input()
	{
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter a message");
		msg=Sc.nextLine();
	}

	void replace()
	{
		Scanner Sc=new Scanner(System.in);
		int l=msg.length();char c;
		int index=0;
		for(int i=0;i<l;i++)
		{
			c=msg.charAt(i);
			cipher[index++]=(int)c;
		}
		System.out.println("Replaced Cipher Text is ");
		for(int i=0;i<msg.length();i++)
		{
			System.out.print(cipher[i]);
		}
		System.out.println();
	}

	void reverse()
	{
		int l=msg.length();int index=0;
		for(int i=l-1;i>=0;i--)
		{
			newcipher[index++]=cipher[i];
		}
                System.out.println("Reversed Cipher Text is ");
		for(int i=0;i<msg.length();i++)
		{
			System.out.print(newcipher[i]);
		}
		System.out.println();
	}

	void decrypt()
	{
		int l=msg.length();char c;
		String original="";
		int unrevcipher[]=new int[100];int index=0;
		for(int i=l-1;i>=0;i--)
		{
			unrevcipher[index++]=newcipher[i];
		}

		for(int i=0;i<l;i++)
		{
			original+=(char)unrevcipher[i];
		}
		System.out.println("Original Text is "+original);
	}

	public static void main(String args[])
	{
		abc x=new abc();
		x.input();
		x.replace();
		x.reverse();
		x.decrypt();
	}
}
