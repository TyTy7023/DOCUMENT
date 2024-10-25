#include<iostream>
using namespace std;
int n,a[100],used[100],pos=1;
void output(int a[],int n)
{
    for(int i=1;i<=n;i++)
    cout<<a[i]<<"\t";
    cout<<endl;
}
void hoanvi(int pos)
{
    if(pos>n) output(a,n);
    for(int i=1;i<=n;i++)
    {
        if(!used[i]) 
        {
            a[pos]=i;
            used[i]=true;
            hoanvi(pos+1);
            used[i]=false;
        }
    }
}
int main()
{
    cin>>n;
    hoanvi(1);
}