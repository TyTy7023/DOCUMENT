#include<iostream>
#include<math.h>
using namespace std;
int countPrime(int a[],int n);
void readFile(int a[],int &n);
void interchangeSort(int a[],int n);
int main()
{
    int a[1000],n;
    readFile(a,n);
    FILE *f=fopen("Num.out","wt");
    fprintf(f,"%d\n",countPrime(a,n));
    interchangeSort(a,n);
    for(int i=0;i<n;i++)
    fprintf(f,"%5d",a[i]);
    fclose(f);
}
void readFile(int a[],int &n)
{
    FILE *f=fopen("C:\\Users\\hp\\Desktop\\ktlt\\Num.txt","rt");
    if(feof(f))
    {
        cout<<"did not read file !!";
        exit(1);
    }
    fscanf(f,"%d",&n);
    for(int i=0;i<n;i++)
    fscanf(f,"%d",&a[i]);
    fclose(f);
}
//cau a
bool isPrime(int n)
{
    if(n<2) return false;
    for(int i=2;i<=sqrt(n);i++)
    if(n%i==0) return false;
    return true;
}
int countPrime(int a[],int n)
{
    int count=0;
    for(int i=0;i<n;i++)
    if(isPrime(a[i])) count++;
    return count;
}
//cau b
void swap(int &a,int &b)
{
    int temp=a;
    a=b;
    b=temp;
}
void interchangeSort(int a[],int n)
{
    for(int i=0;i<n-1;i++)
    for(int j=i+1;j<n;j++)
    if(a[i]>a[j]) swap(a[i],a[j]);
}