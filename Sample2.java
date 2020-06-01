import java.util.Scanner;
import java.math.*;
import java.security.*;
class abc
{
	void toHash(String input)
	{
		try
		{
			MessageDigest md=MessageDigest.getInstance("SHA-1");
			byte[] messagedigest=md.digest(input.getBytes());
			BigInteger no=new BigInteger(1,messagedigest);
			String hashtext=no.toString(16);
			while(hashtext.length()<32)
			{
				hashtext+="0"+hashtext;
			}
			System.out.println("Hash Value is "+hashtext);
		}
		catch(NoSuchAlgorithmException e)
		{
			System.out.println("No such algorithm found");
		}
	}

	public static void main(String args[])
	{
		Scanner Sc=new Scanner(System.in);
		abc x=new abc();
		System.out.println("Enter a string");
		String n=Sc.nextLine();
		x.toHash(n);
	}
}