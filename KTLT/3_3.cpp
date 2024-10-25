#include<iostream>
#include<string.h>
using namespace std;
void deletePosition(char *string);
void insertStringIntoString(char*string);
int main()
{
    char* string=new char[1000];
    cout<<"enter the string : ";
    fflush(stdin);
    gets(string);
    deletePosition(string);
    insertStringIntoString(string);
    delete string;

}
//cau a
void deletePosition(char *string)
//delete long the number of chars from position p; 
{
    int l,p;
    char *temp=new char [1000];
    cout<<"enter l : ";cin>>l;
    cout<<"enter position : ";cin>>p;
    for(int i=0;i<p;i++)
    *(temp+i)=*(string+i);
    for(int i=p+l;i<=(int)strlen(string);i++)
    *(temp+i-l)=*(string+i);
    cout<<temp<<endl;
    delete temp;
}
//cau b
void insertStringIntoString(char*string)
{
    char x[1000],temp[1000];
    int p;//position
    cout<<"enter the string X : ";
    fflush(stdin);gets(x);
    cout<<"enter position you want to insert : ";cin>>p;
    for(int i=0;i<p;i++)
    temp[i]=*(string+i);
    strcat(temp,x);
    for(int i=p;i<=(int)strlen(string);i++)
    temp[i+strlen(x)]=*(string+i);
    strcpy(string,temp);
    cout<<string;    
}