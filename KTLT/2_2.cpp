#include<iostream>
using namespace std;
struct student
{
	char full_name[100];
	int MSSV;
	int subject_score;
	int major_subject_score_1;
	int major_subject_score_2;
	
};
void input(student *&a,int &n);
void output(student *a,int n);
void findScoreBelow5(student *a,int n);
void quicksort(student *a,int l,int n);
void sort(student *a,int n);
int main()
{
	int n;
	student *a;
	cout<<"enter n student : ";cin>>n;
	input(a,n);
//	output(a,n);
//	cout<<"Student has subject score below 5 : ";findScoreBelow5(a,n);
	sort(a,n); output(a,n);

	delete a;
	cout<<endl;
	return 0;
	
}
//cau a
void input(student *&a,int &n)
{
	a=new student[n];
	for(int i=0;i<n;i++)
	{
		cout<<"\t student "<<i+1<<endl;
		cout<<"enter full name : ";fflush(stdin);gets((a+i)->full_name);
		cout<<"enter MSSV : ";cin>>(a+i)->MSSV;
		cout<<"enter subject_score : ";cin>>(a+i)->subject_score;
		cout<<"enter major_subject_score_1 : ";cin>>(a+i)->major_subject_score_1;
		cout<<"enter major_subject_score_2 : ";cin>>(a+i)->major_subject_score_2;
		cout<<endl;
	}
}
//cau b
void output(student *a,int n)
{
	for(int i=0;i<n;i++)
	{
		int t=(a+i)->subject_score+(a+i)->major_subject_score_1+(a+i)->major_subject_score_2;
		cout<<"student "<<i+1<<" \n ";
		cout<<"full name "<<(a+i)->full_name<<endl;
		cout<<"MSSV : "<<(a+i)->MSSV<<endl;
		cout<<"subject_score : "<<(a+i)->subject_score<<endl;
		cout<<"major_subject_score_1 : "<<(a+i)->major_subject_score_1<<endl;
		cout<<"major_subject_score_2 : "<<(a+i)->major_subject_score_2<<endl;
		cout<<"total score of 3 subject : "<<t;
		cout<<endl;
	}
}
//cau c
void findScoreBelow5(student *a,int n)
{
	for(int i=0;i<n;i++)
	{
		if((a+i)->subject_score<5) cout<<(a+i)->full_name<<endl;
		else if((a+i)->subject_score<5) cout<<(a+i)->full_name<<endl;
		else if((a+i)->subject_score<5) cout<<(a+i)->full_name<<endl;
	}
}
//cau d
void exch(student &a,student &b)
{
	student t=a;
	a=b;
	b=t;
}
/*
void quicksort(student *a,int l,int r)
{
	int x=(a+(l+r)/2)->major_subject_score_1+(a+(l+r)/2)->major_subject_score_2;
	int i=l;
	int j=r;
	do
	{
		while ((a+i)->major_subject_score_1+(a+i)->major_subject_score_2);
		while ((a+j)->major_subject_score_1+(a+j)->major_subject_score_2);
		if(i<=j) exch(*(a+i+1),*(a+j-1));		
	}
	while(i<j);
	if(l<j) quicksort(a,l,j);
	if(i<r) quicksort(a,i,r);
}
*/
void sort(student *a,int n)
{
	for(int i=0;i<n-1;i++)
	for(int j=i+1;j<n;j++)
	{
		int t1=(a+i)->major_subject_score_1+(a+i)->major_subject_score_2;
		int t2=(a+j)->major_subject_score_1+(a+j)->major_subject_score_2;
		if(t1>t2) 
		exch(*(a+i),*(a+j));

	}
}






