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

		String str="";String str2="";
		while(!str.equals("stop"))
		{
			str=din.readUTF();
			System.out.println("Client says "+str);
			
			str2=br.readLine();
			dout.writeUTF(str2);
			dout.flush();
		}
		din.close();
		ss.close();
		s.close();
	}
}