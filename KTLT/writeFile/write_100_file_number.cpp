#include <iostream>
#include <ctime>
#include <stdlib.h>
using namespace std;
int main()
{
	char a[20]="d:\\1_test\\a01.txt";
	int j=0,n=0,t,num;
	cout<<"enter n number you want create in 1 file : ";cin>>num;
	srand(time(NULL));
	while(n<100)
	{
		for(int i=48;i<=57;i++)
		{
			a[11]=i;
			for(j=48;j<=57;j++)
			{
				FILE *fp;
				a[12]=j;
				fp=fopen(a,"w");
				for(int t=0;t<num;t++)
				{	
					fprintf(fp,"%5d ",rand()%(500+500+1)-500);
					if(t%15==0) fprintf(fp,"\n");
				}
				fclose(fp);
				n++;
			}
		}		
	}
	
	return 0;
}

