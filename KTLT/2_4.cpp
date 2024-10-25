#include<iostream>
#include<math.h>
struct node
{
	int info;
	node *next;
};
struct list
{
	node *head,*tail;
};
void list_insert(list &l);
void list_process(list l);
int sum(list l);
int count_prime(list l);
void count_even_odd_number(list l);
int max_list(list l);
void delete_head_list(list &l);
using namespace std;
list head,tail;	
list l;
int main()
{

    list_insert(l);
    list_process(l);
//    cout<<sum(l)<<endl;
//	cout<<"the number of list is prime : "<<count_prime(l);
//	count_even_odd_number(l);
//	cout<<max_list(l);
	delete_head_list(l);	
	list_process(l);
    return 0;
}
// create an element for a list
node *getnode(int x)
{
	node *p=new node;
	if(p==NULL) exit(1);
	p->info=x;
	p->next=NULL;
	return p;
}
//insert tail list 
void insert_tail(list &l,node *p)
{
	if(l.head==NULL)
	{
		l.head=p;
		l.tail=p;
	}
	else
	{
		l.tail->next=p;
		l.tail=p;
	}
}
//enter the list
void list_insert(list &l)
{
	int x,n;
	cout<<"enter the number of elements in the list : "; cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>x;
		insert_tail(l,getnode(x));
	}
	
}
// output list
void list_process(list l)
{
	node *p=l.head;
	while(p!=NULL)
	{
		cout<<p->info<<" ";
		p=p->next;
	}
	cout<<endl;
}
// cau a
int sum(list l)
{
	int s=0;
	node *p=l.head;
	while(p!=NULL)
	{
		s=s+p->info;
		p=p->next;
	}
	return s;
}
//cau b
bool prime(int n)
{
	if(n<2) return false;
	for (int i=2;i<=sqrt(n);i++)
	if(n%i==0) return false;
	return true;
}
int count_prime(list l)
{
	int count=0;
	node *p=l.head;
	while(p!=NULL)
	{
		if(prime(p->info)) count++;
		p=p->next;
	}
	return count;
}
//cau c
void count_even_odd_number(list l)
{
	int count_odd=0,count_even=0;
	node *p=l.head;
	while(p!=NULL)
	{
		if((p->info)%2==0) count_even++;
		else count_odd++;
		p=p->next;
	}
	cout<<"the number of even numbers in the list is : "<< count_even
	<<"\nthe number of odd numbers in the list is : "<<count_odd;
}
//cau d
int max_list(list l)
{
	node* p=l.head;
	int max=p->info;
	while(p!=NULL)
	{
		if(max<p->info) max=p->info;
		p=p->next;
	}
	return max;
}
//cau e
void delete_head_list(list &l)
{
	node *p=l.head;
	l.head=p->next;
	if(l.head==NULL) l.tail=NULL;
	p->next=NULL;
	delete p;

}










