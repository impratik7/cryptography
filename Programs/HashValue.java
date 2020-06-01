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
				hashtext="0"+hashtext;
			}
			System.out.println("Hash value is "+hashtext);
		}
		catch(NoSuchAlgorithmException e)
		{
			System.out.println("No Such Algorithm Found");
		}
	}

	public static void main(String args[])
	{
		abc x=new abc();
		x.toHash("1614110139");
	}
}