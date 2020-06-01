import java.net.*;  
import java.io.*;
import java.math.*;
import java.security.*;  
class MyServer
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
		MyServer x=new MyServer();
		
		ServerSocket ss=new ServerSocket(3333);  
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
		String str="",str2="";  
		while(!str.equals("stop"))
		{  
			str=din.readUTF();  
			System.out.println("client says: "+str); 

			/**checking******/
			if(x.toHash("1614110139").equals(str))
			{
				System.out.println("Password is matched");
			}
			else
			{
				System.out.println("Password is NOT matched");
			}
			/****************/
 
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}
}  