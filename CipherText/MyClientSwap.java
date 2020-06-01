import java.net.*;  
import java.io.*;  
class MyClient
{  
	static String msg;static int k;

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
			
			/****Reverse*****/
			String rev="";
			int l=msg.length();char c;
			for(int i=l-1;i>=0;i--)
			{
				c=msg.charAt(i);
				rev+=c;
			}

			String adj="";
			if(l%2==0)
			{
				for(int i=0;i<l-1;i+=2)
				{
					adj+=rev.charAt(i+1);
					adj+=rev.charAt(i);
					System.out.println(adj);
				}	
			}
			else
			{
				for(int i=0;i<l-2;i+=2)
				{
					adj+=rev.charAt(i+1);
					adj+=rev.charAt(i);
					System.out.println(adj);
				}
				adj+=rev.charAt(l-1);
			}
			System.out.println(adj);
			str=adj;

			/****************************/

			dout.writeUTF(str);  
			dout.flush();  

			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}   
		dout.close();  
		s.close();  
	}
}  