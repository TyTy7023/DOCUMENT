#include<iostream>
using namespace std;
int caua(int n);
int caub(int n);
int cauc(int n);
int caud(int n);
int main()
{
    int n;
    cout<<"nhap n : ";cin>>n;
    cout<<caua(n)<<endl;
    cout<<caub(n)<<endl;
    cout<<cauc(n)<<endl;
    cout<<caud(n);
    cout<<endl;
    return 0;
}
int caua(int n)
{
    if(n==0) return 0;
    return  n+caua(n-1);   
}
int caub(int n)
{
	if(n==0) return 0;
	return n*n + caub(n-1);
}
int giaithua(int n)
{
	if(n==0||n==1) return 1;
	return n*giaithua(n-1); 
}
int cauc(int n)
{
	if(n==1||n==0) return 1;
	return giaithua(n)+cauc(n-1);
}
int s(int a,int n)
{
	if(a==n) return n;
	return a*s(a-1,n);
}
int caud(int n)
{	
	if(n==0) return 0;
	return s((n)*2,n)+caud(n-1);
	
}
