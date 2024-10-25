#include<iostream>
struct tagnode
{
	int info;
	tagnode *next;
};
typedef tagnode *node;
struct list
{
	node head,tail;
};
list l,l1;
using namespace std;
void insert_list(list &l);
int findElement(list l,int x);
void process_list(list l);
void selectionSort(list &l);
void initList(list l);
int main()
{
	initList(l);
	insert_list(l);
	process_list(l);
	int x;
	cout<<"enter x you want to find : ";cin>>x;
	cout<<findElement(l,x)<<endl;;
	selectionSort(l);
	cout<<" the list was sorted : ";
	process_list(l);
	return 0;
}
node getnode(int x)
{
    node p=new tagnode;
    if(p==NULL) exit(1);
    p->info=x;
    p->next=NULL;
    return p;
}

void initList(list l)
{
   l.head=l.tail=NULL;
}
int isEmpty(list l)
{
	return (l.head==NULL);
}

void insert_tail(list &l,node p)
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
	node p=l.head;
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
int findElement(list l,int x)
{
	if(isEmpty(l)) return 0;
	node p=l.head;
	while(p!=NULL)
	{
		if(p->info==x) return 1;
		p=p->next;
	}
	return 0;
}
void deleteHead(list &l)
{
	if(isEmpty(l)) 
	{
		cout<<"the list is empty ";
		exit(0);
	}
	if(l.head->next==NULL) l.head=l.tail=NULL;
	else l.head=l.head->next;
	
}
void deleteElement(list &l, int k)
{
	node p=l.head;
	if(p->info==k) deleteHead(l);
	else
	{
		node q=p->next;
		while((q->info!=k)&&(q!=NULL))
		{
			p=q;
			q=p->next;
		}
		p->next=q->next;
	}
}
void selectionSort(list &l)
{
	node p=l.head;
	int min;
	initList(l1);
	while(l.head!=NULL)
	{
		min=l.head->info;
		p=l.head;
		while(p!=NULL)
		{
			if(min>p->info)  min=p->info;
			p=p->next;
		}
		insert_tail(l1,getnode(min));
		deleteElement(l,min);
	}
	l=l1;
}
