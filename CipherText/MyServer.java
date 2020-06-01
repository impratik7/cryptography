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

			/*********decrypting***********/
			msg=str;
			int l=msg.length();char c;int index=0;
			int tt;
			for(int i=l-2;i>=0;i-=2)
			{
				char x=msg.charAt(i);
				char y=msg.charAt(i+1);
	
				int a=Integer.parseInt(String.valueOf(x));
				int b=Integer.parseInt(String.valueOf(y));
				tt=(a*10)+b;
				System.out.println(tt);
				newcipher[index++]=tt;
			}
			String original="";
			int unrevcipher[]=new int[100];index=0;
			for(int i=0;i<l-1;i++)
			{
				unrevcipher[index++]=newcipher[i];
			}

			for(int i=0;i<l;i++)
			{
				original+=(char)unrevcipher[i];
			}
			System.out.println("Original Text is "+original);
			/******************************/
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}
}  