#include<iostream>
#include<math.h>
using namespace std;
struct monomial
{
	float coefficient;//he so
	int exponent;//so mu	
};
void input(monomial *&a, int &n);
void arr_process(monomial *a, int n);
float sumMonomial(monomial *a,int n,float x0);

int main()
{
	monomial *a;
	int n;
	float x0;
	input(a,n);
	arr_process(a,n);
	cout<<"\nenter x0 : ";cin>>x0;
	cout<<"answer = "<<sumMonomial(a,n,x0);

	delete a;
	cout<<endl;
	return 0;
	
}
void input(monomial *&a, int &n)
{
	cout<<"enter n monomial : ";cin>>n;
	a=new monomial [n];
	for(int i=0;i<n;i++)
	{
		cout<<"enter coefficient "<<i<<" : ";cin>>(a+i)->coefficient;
		cout<<"enter exponent "<<i<<" : ";cin>>(a+i)->exponent;
	}
}
void arr_process(monomial *a, int n)
{
	if(n<1)
	{
		cout<<"empty ! ";
		exit(0);
	}
	cout<<endl;
	for(int i=0;i<n;i++)
	{
		if(i==n-1) cout<<(a+i)->coefficient<<"x^"<<(a+i)->exponent;
		else cout<<(a+i)->coefficient<<"x^"<<(a+i)->exponent<<"+";
	}
	cout<<endl;
}
float sumMonomial(monomial *a,int n,float x0)
{
	if(n==0) return 0;
	return 
	((a+n-1)->coefficient)*pow(x0,((a+n-1)->exponent))+sumMonomial(a,n-1,x0);

}
