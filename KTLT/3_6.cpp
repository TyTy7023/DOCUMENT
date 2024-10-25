#include <iostream>
#include <string.h>
struct infomation
{
    char MSSV[20];
    char lastname[256];
    char firstname[20];
};
using namespace std;
void insertStudent(infomation *student,int n);
void processImfomation(infomation *student,int n);
int main()
{
    infomation *student = new infomation;
    int n;
    cout<<"enter n number of student : ";cin>>n;
    insertStudent(student,n);
    processImfomation(student,n);
    delete student;
    return 0;
}
void insertS(char *s)
{
    fflush(stdin); gets(s);
}
void insertStudent(infomation *student,int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<"\timfomation "<<i<<endl;
        cout<<"enter your MSSV : "; insertS((student+i)->MSSV);
        cout<<"enter your lastname : "; insertS((student+i)->lastname);
        cout<<"enter your firstname : "; insertS((student+i)->firstname);
        strlwr(student[i].firstname);
    }
}
void swap(infomation &a,infomation &b)
{
    infomation temp=a;
    a=b;
    b=temp;
}
void interchangeSort(infomation *student,int n)
{
    for(int i=0;i<n-1;i++)
    for(int j=i+1;j<n;j++)
    if(strcmp(student[i].firstname,student[j].firstname)==1)  
    swap(student[i],student[j]);
}
void processImfomation(infomation *student,int n)
{
    interchangeSort(student,n);
    for (int i=0;i<n;i++)
    {
        cout<<"\tinfomation "<<i<<endl;
        cout<<student[i].lastname<<" "<<student[i].firstname
        <<" - "<<student[i].MSSV<<endl;
    }
}