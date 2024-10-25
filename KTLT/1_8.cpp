#include<iostream>
using namespace std;
int C(int n,int k);
void Pascal(int h);
int main()
{
    int n,k,h;
    cout<<"enter n : ";cin>>n;
    cout<<"enter k : ";cin>>k;
    cout<<"result : "<<C(n,k);
    Pascal(h);
}
//calculate the combination k n 
int C(int n,int k)
{
    if(k==0||k==n) return 1;
    return C(n-1,k-1)+C(n-1,k);
}
// draw pascal striangle with hieght h 
void Pascal(int h) 
{
    cout<<"\nenter the height of the triangle : ";cin>>h;
    for(int i=0;i<=h;i++)
    {
        for(int j=0;j<=i;j++)
        cout<<C(i,j)<<" ";
        cout<<endl;
    }
    }
    