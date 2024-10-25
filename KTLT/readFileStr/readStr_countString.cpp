//count the number of string in file
#include <iostream>
#include <string.h>
using namespace std;
int main()
{
	FILE *f=fopen("C:\\Users\\hp\\Desktop\\file_read\\string\\str.txt","rt");
	char s[1000];
	int count=0;
	while (!feof(f))
	{
		if(fgets(s,1000,f))
        count++;
	}
	cout<<count;
	fclose(f);
	return 0;
	
}