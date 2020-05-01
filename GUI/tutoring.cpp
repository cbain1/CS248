#include <iostream>
#include <stdio.h>
#include <string>
#include <iomanip>
#include "mpi.h"

Using namespace std;
Int my_rank; 
Int numCPUS; 
Int sourceRank; 
Int destRank; 
MPI_Init(&argc, &argv);
MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
MPI_Comm_size(MPI_COMM_WORLD, &p);
 
Double digits;
Cout << “Please enter the number of digits you want to estimate” << endl;
Cin >> digits;
 
Int local_start = my_rank*(digits/numCPUS);
Double local_sum=0; 
For (int x = local_start; x<local_start+(digits/numCPUS); x++) {
	local_Sum =  local_sum + (1/(x*x));
}
 
if(my_rank!=0) {
	MPI_Send(&local_sum, 1, MPI_DOUBLE, 0, MPI_COMM_WORLD);
}
Double final_sum;
Double temp_sum;
else {
	MPI_Recv(&temp_sum, 1, MPI_DOUBLE, MPI_ANY_SOURCE, MPI_COMM_WORLD);
	Final_sum = final_sum + temp_sum; 
}
 
if(my_rank == 0) {
Double pi = sqrt(6*final_sum);
	Cout << “The estimate of pi is: “ << pi << endl; 
}
MPI_Finalize();
