#include<iostream>
#include<fstream>
#include<string>
#include<ctime>
#include<stdlib.h>
using namespace std;
int main()
{
	int n,m;
	srand(time(NULL));
	cout<<"enter m (the number of files you want to create) : ";cin>>m;
	cout<<"enter n : ";cin>>n;
	for(int i=1;i<=m;i++)
	{
		string a="C:\\Users\\hp\\Desktop\\file_read\\100k_number\\file_"+ to_string(i)+".txt";
		ofstream f(a);
		//enter n number in file
		f<<n<<"\n";
		//create random number
		for(int i=1;i<=n;i++)
		{
			f<<rand()%(500+500+1)-500<<"\t";
			if(i%20==0) f<<"\n";
		}
		f.close();
	}
	
	return  0;
}

