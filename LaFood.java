import java.util.*;

public class LaFood {
	String name;
    int time;
    int size;
	int bribe;
	
	static int count=0;

	public LaFood(int t, int s, int b, String n) {
		time = t;
		size = s;
		bribe = b;
		name = n;
	}

	public LaFood(Scanner in) {
		time = in.nextInt();
        size = in.nextInt();
        bribe = in.nextInt();
        name = in.next();
        count+=size;
    }
}