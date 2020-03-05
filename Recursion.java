
class Recursion {

	static int factorial(int n) {
		if (n==0) return 1;
		else return factorial(n-1)*n;
	}
	static void printback(int n) {
		if(n<10)
			System.out.print(n);
		else {
			int last = n%10;
			int rest = n/10;
			System.out.print(last);
			printback(rest);
		}
	}
	static boolean isPalindrome(String x) {
		if(x.length()<=1) return true;

		char first=x.charAt(0);
		char last = x.charAt(x.length()-1);
		if (first!=last) return false;
		else return isPalindrome(x.substring(1,x.length()-2));
	}
	static int fib(int n) {
		if(n<2) return n;
		return fib(n-1)+fib(n-2);
	}
	static int fibDynamic(int n) {
		int [] sadness = new int[n+1];
		sadness[0] = 0;
		sadness[1] = 1;
		for (int i=2;i<=n;i++)
			sadness[i] = sadness[i-1]+sadness[i-2];
		return sadness[n];
	}

	public static void main(String [] args) {
		System.out.println(factorial(4));

		printback(8675309);
		System.out.println();
		printback(12345);
		System.out.println();
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("not a palindrome"));
		System.out.println(isPalindrome("palindrome"));
		System.out.println(fibDynamic(5));
		System.out.println(fibDynamic(15));
		System.out.println(fib(5));
		System.out.println(fib(15));
		System.out.println(fib(35));
		System.out.println(fib(50));

	}

}