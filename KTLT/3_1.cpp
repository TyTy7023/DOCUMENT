#include<iostream>
#include<string.h> 
using namespace std;
void insertString(char *string);
void countUpperandLowerChar(char *string);
void converChar(char *string);
void findAscii(char *string);
int countWords(char *string);
void countCharOfWord(char *string);
void findFirstLRWord(char *string);
int main()
{
	char *TheString;
	TheString=new char;
	insertString(TheString);
	cout<<endl;
	countUpperandLowerChar(TheString);cout<<endl;
	findAscii(TheString);cout<<endl;
	converChar(TheString);cout<<endl;
	cout<<"the number of words is : "<<countWords(TheString);cout<<endl;
	countCharOfWord(TheString);cout<<endl;
	findFirstLRWord(TheString);cout<<endl;
	delete TheString;
	return 0;
}
void insertString(char *string)
{
	cout<<"enter the string : ";
	fflush(stdin);gets(string);
	if(strlen(string)>256) 
	{
		cout<<"the number of chars exceed the allowed  ";
		exit(0);	
	}
	if(*string==32||*(string+strlen(string)-1)==32)
	{
		cout<<"error! the string have the space in the fisrt or the last string ";
		exit(0);
	}
}
// cau a
void countUpperandLowerChar(char *string)
{
	int countUpper=0,countLower=0;
	for(int i=0; i<(int)strlen(string);i++)
	{
		if(isspace(*(string+i))) i++;
		if(isupper(*(string+i))) countUpper++;
		if(islower(*(string+i))) countLower++;
	}
	cout<<"the number of lower chars is : "
	<<countLower<<endl;
	cout<<"the number of upper chars is : "
	<<countUpper<<endl;
}
//cau b
void findAscii(char *string)
{
	for(int i=0;i<(int)strlen(string);i++)
	{
		cout<<toascii(*(string+i))<<" ";	
	}
}
//cau c
//convert the first letter of a word to uppercase and the rest to lowercase
void converChar(char *string)
{
	strlwr(string);
	for(int i=0;i<(int)strlen(string);i++)
	{
		if(isspace(*(string+i))) 
		*(string+i+1)=toupper(*(string+i+1));
		*string=toupper(*string);
		putchar(*(string+i));
	}	
}
//cau d
int countWords(char *string)
{
	int count=0;
	*(string+strlen(string))=' ';
	for(int i=0;i<(int)strlen(string);i++)
	if(*(string +i)==' ') count++;
	*(string+strlen(string))=10;
	return count;
}
//cau e
void countCharOfWord(char *string)
{
	int count=0;
	*(string+strlen(string))=32;
	for(int i=0; i<(int)strlen(string);i++)
	{
		if(*(string+i)==32) 
		{
			cout<<count<<" ";
			count=0;
		}
		else count++;
	}
	*(string+strlen(string))=10;
}
//cau f
void findFirstLRWord(char *string)
{
	cout<<"the last word in tring : "<<strrchr(string,' ')+1<<endl;
	cout<<"the first word in string : "<<strtok(string," ");
}












