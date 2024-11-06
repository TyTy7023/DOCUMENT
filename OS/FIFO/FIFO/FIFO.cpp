// FIFO.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include<iostream>
using namespace std;
struct FCFS
{
	char name[5];
	int timeCPU, timeIn;
};
/*
struct tagnode
{
	FCFS infor;
	tagnode* next;
};
typedef tagnode* node;
struct queue
{
	node head, tail;
};*/
void input(int &num, FCFS* process)
{
	FILE* f = fopen_s("C:\\Users\\Admin\\OneDrive\\Máy tính\\OS\\FIFO\\process1.txt", "rt");
	fscanf_s(f, "%d", num);
	process = new FCFS[num];
	while (!feof(f))
	{
		for (int i = 0; i < num; i++)
		{
			fscanf_s(f, "%c", (process + i)->name);
			fscanf_s(f, "%d", (process + i)->timeIn);
			fscanf_s(f, "%d", (process + i)->timeCPU);
		}
		fclose(f);
	}
}
int main()
{
	int num;
	FCFS* process;
	input(num, process);
	for (int i = 0; i < num; i++)
		cout << (process + i)->name << "\t" << (process + i)->timeIn << "\t" << (process + i)->timeCPU << endl;
	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
