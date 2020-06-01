import java.io.*;
import java.net.*;
class Server
{
	public static void main(String args[])throws Exception
	{
		ServerSocket ss=new ServerSocket(3333);
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str="";String str2="";String msg="";
		int count=0;
		while(!str.equals("stop"))
		{
			/************FIRST TIME READ THE MESSAGE**************/
			str=din.readUTF();	
			msg=str;
			System.out.println("Client says "+str);
			
			/************REPLY WITH OK****************************/
			str2=br.readLine();
			dout.writeUTF(str2);
			dout.flush();

			/*******************DECRYPTING THE MESSAGE WITH THE RECEIVED VALUE OF K WHICH CLIENT HAS NOW SENT IT************/
			str=din.readUTF();
			int key=Integer.parseInt(str);
			System.out.println("Client says the KEY used is "+str);
			
			String original="";

			int l=msg.length();
			for(int i=0;i<=l-2;i+=2)
			{
				char x=msg.charAt(i);
				char y=msg.charAt(i+1);
				int a=Integer.parseInt(String.valueOf(x));
				int b=Integer.parseInt(String.valueOf(y));
				int tt=(a*10)+b;
				original+=(char)(tt-key);
			}
			System.out.println("Original message is "+original);	
		}
		din.close();
		ss.close();
		s.close();
	}
}