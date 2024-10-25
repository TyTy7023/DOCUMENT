#include <iostream>
#include <math.h>
struct node
{
    int info;
    node *next;
};
struct list
{
    node *head,*tail;
};
node *getnode(int x)
{
    node *p=new node;
    if(p==NULL) exit(1);
    p->info=x;
    p->next=NULL;
    return p;
}
list l;
using namespace std;
void initList(list l);
void insert_list(list &l);
void process_list(list l);
void delete_prime_element(list &l);
void insert_digits_element(list &l);
int main()
{
	initList(l);
    insert_list(l);
    cout<<"the list you was entered : ";
    process_list(l);
    cout<<"the list was deleted prime :"<<endl;
	delete_prime_element(l);
    process_list(l);
    cout<<"the lsit was insert element befor them : "<<endl;
 	insert_digits_element(l);
    process_list(l);

    return 0;
}
void initList(list l)
{
   l.head=l.tail=NULL;
}
int isEmpty(list l)
{
	return (l.head==NULL);
}

void insert_tail(list &l,node*p)
{
	if(isEmpty(l)) 
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
void insert_list(list &l)
{
	int n,x;
	cout<<"enter the element of the list : ";cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>x;
		insert_tail(l,getnode(x));
	}
}
void process_list(list l)
{
	node *p=l.head;
	if(isEmpty(l))
	{
		cout<<"empty list!";
		exit(1);
	}
	while(p!= NULL)
	{
		cout<<p->info<<" ";
		p=p->next;
	}
	cout<<endl;
}
// cau a
bool prime(int n)
{
	if(n<2) return false;
	for(int i=2;i<=sqrt(n);i++)
	if(n%i==0) return false;
	return true;
}
void delete_head(list &l)
{
	node *p=l.head;
	l.head=p->next;
	if(l.head==NULL) l.tail=NULL;
	p->next=NULL;
	delete p;

}
void delete_element(list &l,int x) // not delete the fist element in the list
{
	if(isEmpty(l)) 
	{
		cout<<"empty list!";
		exit(1);
	}
	node *temp=l.head;
	if(x==l.tail->info) 
	{
		while(temp->next!=l.tail )
		temp=temp->next;
		if(temp->next==l.tail)
		{
			temp->next=NULL;
			temp=l.tail;
		}
	}
	else
	{
		while(temp->next->info!=x && temp!=NULL )
		{
			temp=temp->next;
		}	
		node *q=temp->next;
		
		if(temp==NULL) 
		{
			cout<<"does not find x !"<<endl;
		}
		else
		{
			temp->next=q->next;
		}
	}
	
}
void delete_prime_element(list &l)
{
	node *p=l.head;
	while(prime(p->info))
	{
		delete_head(l);
		p=l.head;
		if(l.head==NULL)
		{
			cout<<"empty list "; 
			exit(1);
		}
	}
	while(p!=NULL)
	{
		if (prime(p->info)) 
		delete_element(l,p->info);
		p=p->next;
		
	}
}

//cau b/////cau b/// //cau b/// //cau b/// //cau b/// //cau b/// //cau b/// //cau b/// //cau b/// //cau b/// //cau b/// 
int sum_digits(int n)
{
	int sum=0;
	while(n!=0)
	{
		sum=sum+n%10;
		n=n/10;
	}
	return sum;
}
void insert_element(list &l,node* q,int x)
{
	node*p=getnode(x);
	if(p==NULL) 
	{
		cout<<"doesn't have enought memmory!";
		exit(1);
	}
	if(!isEmpty(l))
	{
		p->next=q->next;
		q->next=p;
		if(q==l.tail) l.tail=p;
	}
	else l.head=l.tail=p;
	
}
void insert_digits_element(list &l)
{
	node *p=l.head;
	while(p!=NULL)
	{
		int x=sum_digits(p->info);
		insert_element(l,p,x);
		p=p->next;
		p=p->next;
	}
}
