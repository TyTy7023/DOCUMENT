#include <iostream>
#include <ctime>
#include <stdlib.h>
using namespace std;
int main()
{
	FILE *f=fopen("C:\\Users\\hp\\Desktop\\fileNum.txt","wt");
	int num;
	cout<<"enter n number you want create in 1 file : ";cin>>num;
	srand(time(NULL));
	fprintf(f,"%d\n",num);
	for(int i=0;i<num;i++)
	{
		fprintf(f,"%6d",rand()%(100+100+1)-100);
		if(i%10==0) fprintf(f,"\n");
	}
	
	fclose(f);
	return 0;
}

