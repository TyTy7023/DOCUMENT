#include <iostream>
#include<string.h>
using namespace std;
void appearTheMostK(char *string,int k[]);
int main()
{
    char *string=new char[1000];
    int k[256];
    cout<<"enter the string : ";
    fflush(stdin);
    gets(string);
    appearTheMostK(string,k);
    delete string;
    return 0;
}
void countK(char *string, int k[],int &n)
{
    int count=0;
    n=0;
    *(string + strlen(string))=32;
    for(int i=0; i<(int)strlen(string); i++)
    {
        if(*(string + i)==32) 
        {
            k[n]=count;
            n++;
            count=0;
        }
        else count++;
    }
}
void swap(int &a,int &b)
{
    int temp =a;
    a=b;
    b=temp;
}
void interchangeSort(int k[],int n)
{
    for(int i=0;i<n-1;i++)
    for(int j=i+1;j<n;j++)
    if(k[i]>k[j]) swap(k[i],k[j]);
}
void maxK(int k[],int n)
{
    int temp=k[0],count1=1,count2=1,typek=temp; 
    for(int i=1;i<n;i++)
    {
        if(temp==k[i]) count2++;
        else 
        {
            if(count2>=count1) 
            {
                count1=count2;
                typek=temp;
                count2=1;
                temp=k[i];
            }
            else
            {
                temp=k[i];
                count2=1;
            }
        }
    }
    cout<<"K xuat hien nhieu nhat : "<<typek<<endl;
    cout<<"so lan xuat hien : " <<count1;
}
void appearTheMostK(char* string,int k[])
{
    int n;
    countK(string,k,n);
    interchangeSort(k,n);
    maxK(k,n);
}