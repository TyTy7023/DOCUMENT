//find the string which has longest left-character 
#include <iostream>
#include <string.h>
using namespace std;
char *word_left(char *s)
{	
	char *x;
	x=new char [400];
	strcpy(x,s);
	int k=strchr(s,' ')-s;
	x[k]='\0';
	return x;
}
int main()
{
	FILE *f=fopen("C:\\Users\\hp\\Desktop\\file_read\\string\\ty.txt","rt");
	char s[400],x[400];
	int d=0;
	fgets(s,400,f);
	strcpy(x,s);
	while (!feof(f))
	{
		fgets(s,400,f);
		if (strlen(word_left(s)) > strlen(word_left(x))) strcpy(x,s);
	}
	cout<<x;
	fclose(f);
	return 0;
}