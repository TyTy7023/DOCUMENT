//the number of words in the string
#include <iostream>
#include <string.h>
using namespace std;
int word_count(char s[])
{
	int d=1; 
	for (int i=0;i<strlen(s);i++)
	if (s[i]==' ') d++;
	return d;
}
int main()
{
	FILE *f=fopen("C:\\Users\\hp\\Desktop\\file_read\\string\\ty.txt","rt");
	char *s;
	s=new char [400];
	int count=0;
	while (!feof(f))
	{
		fgets(s,400,f);
		cout<<word_count(s)<<" ";
	}
	fclose(f);
	return 0;
}