import java.net.*;  
import java.io.*; 
import java.math.*;
import java.security.*; 
class MyClient
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

	public static void main(String args[])throws Exception
	{  
		MyClient x=new MyClient();		

		Socket s=new Socket("localhost",3333);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
		String str="",str2="";  
		while(!str.equals("stop"))
		{  
			str=br.readLine();  
			dout.writeUTF(x.toHash(str));  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}  
  
		dout.close();  
		s.close();  
	}
}  