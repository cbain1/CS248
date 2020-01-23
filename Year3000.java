import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Jon Sorenson
*/
public class Year3000
{
  public static void main(String [] args) throws IOException {
    DateInterface d = new MyDate();
    d.set(1,27,2019,0);  // sets the date to Sunday, January 27th, 2019
    while (d.getYear() > 1799) {
        d.yesterday();
        // System.out.println(d);
    }
    d.tomorrow();
    System.out.println("1800: " + d);

    while (d.getYear() > 999) {
        d.yesterday();
        // System.out.println(d);
    }
    d.tomorrow();
    System.out.println("1000: " + d);

    d.set(1,27,2019,0);
    while(d.getYear()<3000) {
      d.tomorrow();
      // un-comment the next line to help with debugging
     // System.out.println(d);
    }
    System.out.println("3000: " + d);

    d.today(); 
    System.out.println("Today's Date is: " + d);
  
  }
}

