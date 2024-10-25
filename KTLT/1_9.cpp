#include<iostream>
using namespace std;
void quickSort(int *arr,int left,int right);
void insertArr(int *arr,int &n);
void processArr(int *arr,int &n);
int main()
{
    int *arr=new int[1000],n;
    insertArr(arr,n);
    quickSort(arr,0,n-1);
    processArr(arr,n);

    return 0;
}
void insertArr(int *arr,int &n)
{
    cout<<"enter n : ";cin>>n;
    for(int i=0;i<n;i++)
    cin>>*(arr+i);
}
void processArr(int *arr,int &n)
{
    for(int i=0;i<n;i++)
    cout<<*(arr+i)<<"\t";
}
int swap(int *&a,int *&b)
{
    int *temp=a;
    a=b;
    b=temp;
}
void quickSort(int *arr,int left,int right)
{
    int i=left,j=right;
    int mid=*(arr+(left+right)/2);
    while(i<j)
    {
        while(*(arr+i)<mid) i++;
        while(*(arr+j)>mid) j--;
        if(i<=j) 
        {
            swap(*(arr+i),*(arr+j));
            i++; 
            j--;
        }
    }
    if(j>left) quickSort(arr,left,j);
    if(i<right) quickSort(arr,i,right);
}