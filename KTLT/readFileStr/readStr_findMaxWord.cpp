#include<iostream>
#include<string.h>
using namespace std;
void coutWordLenmax(char s[], char temp[])
{
	char *token;
    token = strtok(s," ");
    char maxChar[20];
    int max=0;
    while(token !=NULL) 
    {
    	if(strlen(token)>=max) 
		{
			max=strlen(token);
			strcpy(maxChar,token);
		}
     	token=strtok(NULL," ");
    }
  	strcpy(temp,maxChar);
}
int main()
{
	char s[1000],temp1[1000],temp2[1000];
	FILE *f=fopen("C:\\Users\\hp\\Desktop\\file_read\\string\\ty.txt","rt");
	int count1=0,count2;
	while(!feof(f))
	{
	 	fgets(s,256,f);
		s[strlen(s)-1]=32;
		coutWordLenmax(s,temp1);
		if(strlen(temp1)>=strlen(temp2)) strcpy(temp2,temp1);
	}
	cout<<temp2<<"\t"<<strlen(temp2);
	fclose(f);
	return 0;
}