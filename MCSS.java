import java.util.*;

class MCSS {


    // although this will work..... it will take a while especially with a long list
    static int alg1(int [] list) {
        int max = 0; 
        for(int start=0; start<list.length; start++) {
            for (int stop=start; stop<list.length; stop++) {
                int sum=0; 
                for(int i=start; i<=stop; i++)
                    sum=sum+list[i];
                if(sum>max) 
                    max=sum;
            }
        }
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
            System.out.print(list[i] + " ");
        }
        System.out.println("\n"+alg1(list));
    }
}