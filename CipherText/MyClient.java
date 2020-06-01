import java.net.*;  
import java.io.*;  
class MyClient
{  
	static String msg;static int k;static int cipher[]=new int[100];
	static int newcipher[]=new int[100];

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
			msg=br.readLine();  
			
			/****Replace and Reverse*****/
			int l=msg.length();char c;
			int index=0;
			for(int i=0;i<l;i++)
			{
				c=msg.charAt(i);
				cipher[index++]=(int)c;
			}
			index=0;
			for(int i=l-1;i>=0;i--)
			{
				newcipher[index++]=cipher[i];
			}

			/****************************/

			for(int i=0;i<l;i++)
			{
				str+=newcipher[i];
			}

			dout.writeUTF(str);  
			dout.flush();  

			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}   
		dout.close();  
		s.close();  
	}
}  