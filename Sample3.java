import java.util.Scanner;
import java.math.*;
import java.security.*;
class abc
{
	String hashtext="";
	String toHash(String input)
	{
		try
		{
			MessageDigest md=MessageDigest.getInstance("SHA-1");
			byte[] messagedigest=md.digest(input.getBytes());
			BigInteger no=new BigInteger(1,messagedigest);
			hashtext=no.toString(16);
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
		return hashtext;
	}

	public static void main(String args[])
	{
		Scanner Sc=new Scanner(System.in);
		abc x=new abc();
		System.out.println("Enter new password");
		String n=Sc.nextLine();
		String s1=x.toHash(n);
		System.out.println("Enter your current password");
		n=Sc.nextLine();
		String s2=x.toHash(n);
		if(s1.equals(s2))
		{
			System.out.println("Password matched");
		}
		else
		{
			System.out.println("Password NOT matched");
		}
	}
}