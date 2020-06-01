import java.util.Scanner;
import java.math.*;
class abc
{
	int n,phin,e=2,d,k;

	double cipher;

	int calculateGCD(int a,int b)
	{
		int gcd=1;
		for(int i=1;i<=a && i<=b;i++)
		{
			if(a%i==0 && b%i==0)
			{
				gcd=i;
			}
		}
		return gcd;
	}
	
	void rsa(int p,int q)
	{
		n=p*q;
		int phin=(p-1)*(q-1);

		while(e<phin)
		{
			if(calculateGCD(e,phin)==1 && n%e!=0)
			{
				break;
			}
			else
			{
				e++;
			}
		}
	
		System.out.println("Value of e = "+e);
		System.out.println("Public Key is "+n+" , "+e);
		
		int temp=0;
		for(int k=1;k<=100;k++)
		{
			temp=(k*phin)+1;
			if(temp%e==0)
			{
				System.out.println("Value of k="+k);
				break;
			}
		}
		d=temp/e;
		System.out.println("Value of d = "+d);
	}

	void encrypt(String input)
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
	}

	void decrypt()
	{
		BigInteger N=BigInteger.valueOf(n);
		BigInteger C=BigDecimal.valueOf(cipher).toBigInteger();
		System.out.println("Value of C="+C);
		BigInteger msgback=(C.pow(d)).mod(N);
		System.out.println("Msgback value is "+msgback);

		String rev="",original="";
		int a=msgback.intValue(),c=0;

		while(a!=0)
		{
			c=a%10;
			rev=rev+(char)(c+64);
			a=a/10;
		}
		int l=rev.length();
		for(int i=l-1;i>=0;i--)
		{
			original+=rev.charAt(i);
		}
		System.out.println("Original Message = "+original);
	}

	public static void main(String args[])
	{
		Scanner Sc=new Scanner(System.in);

		System.out.println("Enter a message");
		String msg=Sc.nextLine();
		System.out.println("Enter the first prime no.");
		int P=Sc.nextInt();
		System.out.println("Enter the second prime no.");
		int Q=Sc.nextInt();

		abc x=new abc();
		x.rsa(P,Q);
		
		x.encrypt(msg);
	
		x.decrypt();
	}
}
	