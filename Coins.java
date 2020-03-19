class Coins
{
	static int [] base={1,5,10,11,25,50};
	
	static int c(int n)
	{
		// base cases
		if(n==0) return 0;
		for(int i=0; i<base.length; i++)
			if(n==base[i]) return 1;
		
		// recursive case
		int minsofar=n;
		for(int i=0; i<base.length; i++)
		{
			if(base[i]<=n)
			{
				int thisnumberofcoins;
				thisnumberofcoins=c(n-base[i])+1;
				if(thisnumberofcoins<minsofar)
					minsofar=thisnumberofcoins;
			}
			
		}
		return minsofar;
	}
	
	static int cDyno(int n)
	{
		// base cases
		if(n==0) return 0;
		for(int i=0; i<base.length; i++)
			if(n==base[i]) return 1;
		
		int [] c=new int[n+1];
		c[0]=0;
		c[1]=1;
		for(int k=2; k<=n; k++)
		{
			c[k]=k;
			for(int i=0; i<base.length; i++)
			{
				if(base[i]<=k)
				{
					int thisnumberofcoins;
					thisnumberofcoins=c[k-base[i]]+1;
					if(thisnumberofcoins<c[k])
						c[k]=thisnumberofcoins;
				}
			}
		}
		return c[n];
	}
	
	public static void main(String [] args)
	{
		for(int n=0; n<=70; n++)
			System.out.println("C("+n+")="+c(n)
		       +" c["+n+"]="+cDyno(n));
		for(int n=0; n<=1000000; n++)
			System.out.println("c["+n+"]="+cDyno(n));
	}
	
}