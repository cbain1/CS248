import java.util.*;

// maximum contiguous sub sequence
class MCSS {


    // although this will work..... it will take a while especially with a long list
    static int alg1(int [] list)
	{
		int maxsofar=0;
		for(int start=0; start<list.length; start++)
		{
			for(int stop=start; stop<list.length; stop++)
			{
				int sum=0;
				for(int i=start; i<=stop; i++)
				{ sum=sum+list[i]; }
				if(sum>maxsofar) maxsofar=sum;
			}
		}
		return maxsofar;
	}

    static int alg2(int [] list) {
        int max = 0; //1
        for(int start=0; start<list.length; start++) { //n //2(< and ++)
            int sum =0; // 1
            for (int stop=start; stop<list.length; stop++) { // n //2(< and ++)
                sum+=list[stop]; //1
                if(sum>max) max=sum; // 1+1 = 2
            }
        }
        return max; // 1
    }
    
    static int alg3(int [] list) {
        int [] prefixSum = new int[list.length];
        prefixSum[0] = list[0];
        for (int i=1;i<list.length;i++)
            prefixSum[i] = prefixSum[i-1]+list[i];

        //find smallest sum to the left
        int [] smallestNum = new int[list.length];
        smallestNum[0] = list[0];
        for (int i=1;i<list.length;i++) {
            smallestNum[i]=smallestNum[i-1];
            if(prefixSum[i-1]<smallestNum[i-1]) smallestNum[i]=prefixSum[i-1];
        }

        //best subsequence ending at each position
        int[] subSequence = new int[list.length];
        for (int i=0;i<list.length;i++)
            subSequence[i]=prefixSum[i]-smallestNum[i];
        
        //largest subSequence is the answer

        int max=subSequence[0];
        for(int i=0;i<list.length;i++)
            if(max<subSequence[i]) max=subSequence[i];

        return max;
    }

    static int [] makeRandom(int size, int range) {
        int [] list = new int[size];
        for (int i=0; i<size; i++) 
            list[i] = -range+(int)((2*range+1)*Math.random());
        return list;
    }
    public static void main (String[] args) {
        int [] list; //={1,-3,-4,7,8,-2,5};
        int size, range;
        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter the size and the range: ");
        size = cin.nextInt();
        range = cin.nextInt();
        list=makeRandom(size,range);
        for(int i=0; i<size;i++) {
            // System.out.print(list[i] + " ");
        }
        System.out.println("\n"+alg3(list));
        System.out.println("\n"+alg2(list));
        System.out.println("\n"+alg1(list));

        cin.close();
    }
}