import java.net.*;  
import java.io.*;  
class MyServer
{  
	static String msg="";static int newcipher[]=new int[100];
	public static void main(String args[])throws Exception
	{  
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

			/**********decrypting**************/
			String msg=str;
			int l=msg.length();String unswap="";
			if(l%2==0)
			{
				for(int i=0;i<l;i+=2)
				{
					unswap+=msg.charAt(i+1);
					unswap+=msg.charAt(i);	
				}
			}
			else
			{
				for(int i=0;i<l-2;i+=2)
				{
					unswap+=msg.charAt(i+1);
					unswap+=msg.charAt(i);	
				}
				unswap+=msg.charAt(l-1);
			}
			System.out.println(unswap);
			String unrev="";
			for(int i=l-1;i>=0;i--)
			{
				unrev+=unswap.charAt(i);
			}
			System.out.println("Original text is "+unrev);
			/**********************************/
 
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}
}  