#include <iostream>
using namespace std;

int main () {

	int r = 4;
	{
		r = 12;
		cout << r << endl;
		int r = 9;
		cout << r << endl;
		if (r < 12) {
			r = 18;
		}
		else {
			{{{{{r=-1;}}}}}
		}
		cout << r << endl;
		{
			int r = 90;
			r = 29;
			cout << r << endl;
			{ 	r = 91;
				cout << r << endl;
			}
			cout << --r << endl;
			r %= 5;
		}
		r = 5;
	}
	cout << r << endl;
	return 0;
}