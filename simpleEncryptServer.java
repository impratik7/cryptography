class Server
{
	int k;String original="";
	void decrypt(String cip,int k)
	{
		int l=cip.length();char c;
		for(int i=0;i<l;i++)
		{
			c=cip.charAt(i);
			original+=(char)(c-k);
		}
		System.out.println("Original Text is "+original);
	}

	public static void main(String args[])
	{
		Server x=new Server();
		Client cl=new Client();
		x.decrypt(cl.cipher,cl.k);
	}
}
