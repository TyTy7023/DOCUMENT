#include<iostream>
#define maxn 1000
using namespace std;
int findNumSeries(int arr[],int n);
void readFile(int arr[],int &n,int &m);
int main()
{
    int arr[maxn],n,m;
    readFile(arr,n,m);
    cout<< findNumSeries(arr,n);
    return 0;
}
void readFile(int arr[],int &n,int &m)
{
    FILE *f=fopen("C:\\Users\\hp\\Desktop\\ktlt\\Num.txt","rt");
    if(feof(f))
    {
        cout<<"did not read file !!";
        exit(1);
    }
    int temp;
    fscanf(f,"%d%d",&n,&m);
    for(int i=0;i<n;i++)
    {
        fscanf(f,"%d",&temp);
        arr[i]=temp;
    }
    fclose(f);
}
int findMax(int arr[],int n)
{
    int max=arr[0];
    for(int i=1;i<n;i++)
    if(max<arr[i]) max=arr[i];
    return max;
}
int findNumSeries(int arr[],int n)
{
    int count1=1,count2=1;
    for(int i=0;i<n-1;i++)
    {
        if(arr[i]<=arr[i+1]) count2++;
        else 
        {
            if(count1<=count2) count1=count2;
            count2=1;
        }
    }
    return count1;
}

