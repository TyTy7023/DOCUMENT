//count the number of word in file

#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	FILE *f=fopen("C:\\Users\\hp\\Desktop\\file_read\\string\\ty.txt","rt");
	char s;
	int count=0;
	while (!feof(f))
	{
		s=fgetc(f);
		if(s==32 || s==10) count++;
	}
	count++;
	cout<<count;
	fclose(f);
	return 0;
}