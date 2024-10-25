#include<iostream>
#include<string.h>
using namespace std;
void insertStringXY(char *string,char* x,char*y);
void converXbyY(char *string,char *x,char *y);
int main()
{
    char *string,*x,*y;
    string=new char[1000];
    x=new char[1000];
    y=new char[1000];
    insertStringXY(string,x,y);
    converXbyY(string,x,y);
    delete string;
    delete x;
    delete y;
}
void insertString(char *string)
{
    fflush(stdin);
    gets(string);
}
void insertStringXY(char *string,char* x,char*y)
{
    cout<<"enter string : ";insertString(string);
    cout<<"enter string x : ";insertString(x);// the string conver
    cout<<"enter string y : ";insertString(y);//the string is convered
    if(strstr(string,x)==NULL) 
    {
        cout<<"string is not contain x";
        exit(1);
    }
}
void converXbyY(char *string,char *x,char *y)
{
    char*temp=new char[1000];
    strcpy(temp,string);
    int k =strstr(string,x)-string;
    *(string+k)='\0';
    strcat(string,y);
    strcat(string,strstr(temp,x)+strlen(x));
    cout<<string;
    delete temp;
}