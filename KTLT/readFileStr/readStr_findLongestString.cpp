// find longest String
#include <iostream>
#include <string.h>
using namespace std;
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
		if (strlen(s) > strlen(x)) strcpy(x,s);
	}
	cout<<x;
	fclose(f);
	return 0;
}