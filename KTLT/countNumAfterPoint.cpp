#include <iostream>
#include <string.h>
struct tagnode
{
    char info;
    tagnode *next;
};
typedef tagnode *node;
struct list
{
    node head,tail;
};
list l;

using namespace std;

int isEmpty(list l)
{
    return (l.head==NULL);
}
void initList(list &l)
{
    l.head=l.tail=NULL;
}
void insertList(list &l, char *num);
void processList(list l);
int countNumAfterPoint(list l);

//////////main/////////main/////////main/////////main/////////main/////////main/////////main/////////main/////////
int main()
{
    initList(l);
    char *num=new char[1000];
    insertList(l,num);
    processList(l);
    cout<<"the number of numbers after point is : "<<countNumAfterPoint(l);
    delete num;
    return 0;
}
//////////main/////////main/////////main/////////main/////////main/////////main/////////main/////////main/////////main/////////
node getnode(char x)
{
    node p=new tagnode;
    if(p==NULL) exit(1);
    p->info=x;
    p->next=NULL;
    return p;
}
void insertTail(list &l,node x)
{
    if(isEmpty(l))
    {
        l.head=l.tail=x;
    }
    else
    {
        l.tail->next=x;
        l.tail=x;
    }
}
void insertList(list &l, char *num)
{
    cout<<"enter the number : ";
    fflush(stdin); gets(num);
    for(int i=0;i<strlen(num);i++)
    {
    	if(*(num+i)<46||*(num+i)>57||*(num+i)==47) 
    	{
    		cout<<"the number is error !! ";
    		exit(1);
		}
    	insertTail(l,getnode(*(num+i)));
	}
}
void processList(list l)
{
	if(isEmpty(l))
	{
		cout<<"the list is empty!! ";
		exit(1);
	}
    node p=l.head;
    while(p!=NULL)
    {
    	cout<<p->info;
    	p=p->next;
	}
    cout<<endl;
}
int countNumAfterPoint(list l)
{
	node p=l.head;
	int count=0;
	if(isEmpty(l)) return -1;
	while(p->info!= 46 && p!=NULL)
	p=p->next;
	while(p->next!=NULL)
	{
		count++;
		p=p->next;
	}
	return count;
}

