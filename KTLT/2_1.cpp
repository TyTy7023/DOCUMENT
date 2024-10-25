#include <iostream>
#include <math.h>
using namespace std;
void enterarr(int *&a,int n);
void deleteelment(int *&a,int &n,int k);
void outarr(int *a,int n);
void addelement(int *&a,int &n,int k,int &x);
void deletePrime(int *&a,int &n);

int main()
{
	int *a,n,k,x;
	cout<<"enter n : ";cin>>n;
	enterarr(a,n);
	cout<<"\nenter k : ";cin>>k;
	deleteelment(a,n,k);
	outarr(a,n);
	cout<<"\nenter k : ";cin>>k;
	cout<<"nenter x : ";cin>>x;
	addelement(a,n,k,x);
	outarr(a,n);
	cout<<"the array has deleted prime numer : ";
	deletePrime(a,n);
	outarr(a,n);
	delete a;
	cout<<endl;
	return 0;
}
void enterarr(int *&a,int n)
{
	a= new int [n];
	for(int i=0;i<n;i++)
	cin>>*(a+i);
}
void outarr(int *a,int n)
{
	for(int i=0;i<n;i++)
	cout<<*(a+i)<<" ";
}
// xoa phan tu (Cau a)
void deleteelment(int *&a,int &n,int k)
{
	if(k>=n) return;
	for(int i=k;i<n-1;i++)
	*(a+i)=*(a+i+1);
	n--;
}
// chen phan tu (Cau b)
void addelement(int *&a,int &n,int k,int &x)
{
	for(int i=n; i>k;i--)
	*(a+i)=*(a+i-1);
	*(a+k)=x;
	n++;
}
// xoa so nguyen to (Cau c) 
int prime(int a)
{
	if(a<2) return 0;
	for(int i=2;i<=sqrt(a);i++)
	if(a%i==0) return 0;
	return 1;
}
void deletePrime(int *&a,int &n)
{
	for(int i=0;i<n;i++)
	if(prime(*(a+i))) 
	{
		deleteelment(a,n,i);
		i--;
	}
}
