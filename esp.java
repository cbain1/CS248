// Catherine Bain


import java.io.*;
import java.util.*;

class esp {
    // Main Function
    public static void main(String [] args) throws IOException {
        int [] file = readFile(); 
        double sum = 0;
        int a,b,c,d,f;
        a=b=c=d=f=0;

        // These are sorting loops
        for (int i = 0; i < file.length; i++) {
            for (int j=i+1; j<file.length; j++) {
                if (file[i] > file[j]) {
                    int temp = file[i];
                    file[i] = file[j];
                    file[j] = temp;
                }
            }
        }

        // for loop that finds grades, min, max, and average 
        for (int i=0; i<file.length; i++) {
            if (file[i] >= 90) 
                a++; 
            if (file[i] >=80 && file[i] <90)
                b++;
            if (file[i] >=70 && file[i] < 80 )
                c++; 
            if (file[i] >=60 && file[i] < 70 )
                d++;
            if (file[i] < 60) 
                f++; 
            sum += file[i];
        }

        
        double mean = sum/(file.length);
        int min = file[0]; 
        int max = file[file.length-1];
        double median;
        
        if (file.length % 2 != 0) 
            median = (double) file[file.length/2]; 
        else 
            median = (double) (file[(file.length-1)/2] + file[file.length/2])/2.0;
 
            

        
        System.out.println("There are " + file.length + " scores in the file.");
        System.out.println("The minimum value is " + min);
        System.out.println("The maximum value is " + max); 
        System.out.println("The mean is " + mean);
        System.out.println("The median value is " + median);
        System.out.println("There are " + a + " As in the file.");
        System.out.println("There are " + b + " Bs in the file.");
        System.out.println("There are " + c + " Cs in the file.");
        System.out.println("There are " + d + " Ds in the file.");
        System.out.println("There are " + f + " Fs in the file.");



    }
    
    
    
    
    // Function Used to Read the File 
    static int [] readFile() throws IOException {

        // Scanner used to get name of file from user
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name of your file: ");
        String name = in.nextLine();

        File file = new File(name); 
        
        // Scanner used to read file
        Scanner inputFile = new Scanner(file); 
        // reads first line of file for length of array
        int x = inputFile.nextInt();

        //Creates array 
        int [] scores = new int[x]; 

        for (int i=0; i<x; i++) {
            int value = inputFile.nextInt();
            scores[i] = value;
        }
        inputFile.close();
        in.close();
    return scores; 
    }
 }


