import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.math.*;
class Server
{
	/***************************************RSA ALGORITHM*************************/
	int n,phin,e=2,d,k;
	static int p,q;

	double cipher;

	//Public key is(n,e)
	//Private key is d

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

	void decrypt(String encoded)
	{
		double cipher=Double.parseDouble(encoded);
		
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

	/**************************************************************************************/

	/******************************GENERATING THE PRIME NUMBERS****************************/
	int isPrime(int n)
	{
		int c=0;
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
				c++;
		}
		if(c==2)
			return 1;
		else
			return 0;
	}

	void genServerPublicKey(int n)
	{
		int a=n,c=0,count=0;
		while(a!=0)
		{
			c=a%10;
			count++;
			a=a/10;
		}
		
		for(int i=count-1;i>=2;i--)
		{
			if(isPrime(i)==1)
			{
				p=i;
				break;
			}
		}
		
		for(int i=count;i<=100;i++)
		{
			if(isPrime(i)==1)
			{
				q=i;
				break;
			}
		}
	}
	/******************************************************************************/

	public static void main(String args[])throws Exception
	{
		/***************GENERATING THE PUBLIC AND PRIVATE KEYS********************/
		Server x=new Server();
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter your PRN");
		int prn=Sc.nextInt();
		x.genServerPublicKey(prn);//it will set the values of p & q
		x.rsa(p,q);//it will set the value of public key(n,e) and private key(d)
		/*************************************************************************/

		ServerSocket ss=new ServerSocket(3333);
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str="";String str2="";
		
		//Reading what the client has sent
		str=din.readUTF();	
		System.out.println("Client says Cipher Text String sent is "+str);
		x.decrypt(str);//calling decrypt function to decrypt the encoded string from the client
			
		//closing the connection
		din.close();
		ss.close();
		s.close();
	}
}