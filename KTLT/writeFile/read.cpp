#include<iostream>
#include<ctime>
#define maxn 10000000
void Interchangesort(int a[],int n);
using namespace std;
int a[maxn];
int main()
{
	int n,a[maxn];
	FILE *f=fopen("songuyen.txt","rt");
	fscanf(f,"%d",&n);
	for (int i=0;i<n; i++)
	fscanf(f,"%d",&a[i]);
	long t_start=clock();
	Interchangesort(a,n);
	long t_end=clock();
	cout<<(t_end-t_start)/1000.0;
	
	
	cout<<endl;
	return 0;	
}
void exch(int &a,int &b)
{
	int t=a;
	a=b;
	b=t;
}
void Interchangesort(int a[],int n)
{
	for(int i=0;i<n-1;i++)
	for(int j=i+1;j<n;j++)
	if (a[i]>a[j]) exch(a[i],a[j]);
}
void Selectionsort(int a[],int n)
{	
	for(int i=0;i<n-1;i++)
	{
		int minx=i;
		for(int j=i+1;j<n;j++)
		if (a[j]<a[minx]) minx=j;
		exch(a[minx],a[i]);
	}

	
}

