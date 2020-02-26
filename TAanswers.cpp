#include <iostream>


int main () {


	//Question 1 
	int tacos(0);
	std::cout << "How many tacos would you like to order? ";
	std::cin >> tacos;
	
	for (int x = 0; x<tacos; x++) {
		std::cout << "taco" << std::endl;
	}

	//Question 2 
	char favNum = 'A';
	char guess;

	std::cout << "Please guess my favorite letter: ";
	do {
		std::cin >> guess;
		if (guess!=favNum) 
			std::cout<<"Definitely not. Guess again. ";
	}while(guess!=favNum);

	std::cout << "Congrats! You got it! Thanks for playing." << std::endl;


	// Question 3 
	int number(0);
	int fact(1);

	std::cout << "Please give me a number ";
	std::cin >> number;
	while (number>0) {
		fact*=number--;
	}
	std::cout << fact << std::endl;


return 0;
}

