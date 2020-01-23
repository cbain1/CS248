import java.io.*;
import java.util.*;

class rot13 {

    static String encrypt (String line) {
        String encodedLine=""; 
        
        for (int i=0; i<line.length(); i++) {
            char here=line.charAt(i);

            if ('a'<=here && here<='z') {
                here=(char)((int)here+13);
                if (here>'z')
                    here -=26;
            }

            if ('A'<=here && here<='Z') {
                here=(char)((int)here+13);
                if (here>'Z')
                    here -=26;
            }

            encodedLine += here;

        }
        return encodedLine;
    }
	public static void main(String [] args) throws IOException {
        String infile, outfile; 
        
        Scanner cin = new Scanner(System.in); 
        System.out.println("Please enter your inputy and output " + "file names: "); 
        infile = cin.next(); 
        outfile=cin.next(); 

        Scanner in = new Scanner(new FileReader(infile));
        PrintWriter out = new PrintWriter(new FileWriter(outfile)); 

        while(in.hasNext()) {
            String line; 
            line = in.nextLine(); 
            out.println(line); 
        }
        out.close(); 
        cin.close();
        in.close();
	}
}
