#include<iostream>
using namespace std;
float recursion(int n);
float de_recursion(int n);
int main()
{
    int n;
    cout<<"the function has the form :\n"
    <<"Sn=1/(1+f1) + 2/(1+f2) + ... + n/(1+fn)\n"
    <<"f1=f2=1\tfn=f(n-1) + f(n-2)\n"
    <<"enter n : ";cin>>n;
    cout<<recursion(n)<<endl;
    cout<<de_recursion(n);
}
//cau b
float f(int n)
{
    if(n==1||n==2) return 1;
    return f(n-1)+f(n-2);
}
float recursion(int n)
{
    if(n==1) return 1.0/2;
    if(n==2) return 3.0/2;
    return n*1.0/(1+f(n)) +  recursion(n-1);
}
//cau c
float de_recursion(int n)
{
    float f1=1,f2=1,f,sum=0,p;
    for(int i=1;i<=n;i++)
    {
        if(i<3) f=f1;
        else
        {
            f=f1+f2;
            f1=f2;
            f2=f;
        }
        p=i*1.0/(1+f);
        sum=sum+p;
    }
    return sum;
}