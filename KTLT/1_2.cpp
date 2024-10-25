#include<iostream>
using namespace std;
int recursion(int n);
int de_recursion(int n);
int main()
{
    int n;
    cout<<"Xn has the form :"
    <<"\tX_n=X_n-1 + (n-1)*X_n-2\n";
    cout<<"enter n : ";cin>>n;
    cout<<recursion(n)<<endl;
    cout<<de_recursion(n);
}
//cau b
int recursion(int n)
{
    if(n==1||n==2) return 1;
    return recursion(n-1)+(n-1)*recursion(n-2);
}
//cau c
int de_recursion(int n)
{
    int a[1000];
    a[1]=a[2]=1;
    for(int i=3;i<=n;i++)
    a[i]=a[i-1]+a[i-2]*(i-1);
    return a[n];
}