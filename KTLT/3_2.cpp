#include<iostream>
#include<string.h>
using namespace std;
int findStringX(char *string,char* x);
void insertString(char *string,char *x);
int countX(char *string,char *x);
int main()
{
    char* string=new char[1000];
    char* x=new char[1000];
    insertString(string,x);
    cout<< findStringX(string,x)<<endl;
    cout<<"string x appeare : "<<countX(string,x);
    delete string;
    delete x;
    return 0;
}
//cau a
void insertString(char *string,char *x)
{
    cout<<"enter the string : ";
    fflush(stdin);
    gets(string);
    cout<<"enter the string x : ";
    fflush(stdin);
    gets(x);
}
int findStringX(char *string,char* x)
{
   if(strstr(string,x)==NULL) return -1;
   return strstr(string,x)-string+1;
}
//cau b
int countX(char *string,char *x)
{
    int count=0;
	while (strstr(string,x)!=NULL)
	{
		count++;
		strcpy(string,strstr(string,x)+1);
	}
	return count;
}