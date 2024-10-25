//n=17    20 10 30 16 8 40 25 6 7 19 37 1 4 18 27 14 3
#include <iostream>
struct tagnode
{
    int info;
    tagnode *left,*right;
};
typedef tagnode *tree;
tree root;
using namespace std;
void insertTree(tree &root);
void processLNR(tree root);
int sumNode(tree root);
int findMax(tree root);
int countNodeInTree(tree root);
int countLeaf(tree root);
int countNodeHas1Branch(tree root);
int countNodeHas2Branch(tree root);
int main()
{
    insertTree(root);
    processLNR(root);
    cout<<endl;
   /* cout<<"total of tree: "<<sumNode(root)<<endl;
    cout<<"Max in tree : "<<findMax(root)<<endl;
    cout<<"the number of nodes in tree : "<<countNodeInTree(root)<<endl;
    cout<<"the number of leafs in tree : "<<countLeaf(root)<<endl;
    cout<<"the number of nodes has 1 branch : "<<countNodeHas1Branch(root)<<endl;
    cout<<"the number of nodes has 2 branch : "<<countNodeHas2Branch(root)<<endl;*/
    return 0;
}

int isEmpty(tree root)
{
    return root==NULL;
}
// cau a
int getnodeinBST(tree &root,int x)
{
    if(isEmpty(root)) 
    {
        root=new tagnode;
        if(root==NULL) return -1;
        root->info=x;
        root->left=root->right=NULL;
        return 1;
    }
    else 
    {
        if(root->info==x) return 0;
        if(root->info>x) return getnodeinBST(root->left,x);
        else return getnodeinBST(root->right,x);
    }

}
void insertTree(tree &root)
{
    int n,x;
    cout<<"enter n number you want to insert : ";cin>>n;
    for (int i=0;i<n;i++)
    {
       cin>>x;
       getnodeinBST(root,x);
    }
}
///// ham duyet cay
void processNLR(tree root)
{
    if(!isEmpty(root))
    {
        cout<<root->info<<" ";
	    processNLR(root->left);
	    processNLR(root->right);
    }
    
}
void processLNR(tree root)
{
    if(!isEmpty(root))
    {
	    processLNR(root->left);
	    cout<<root->info<<" ";
	    processLNR(root->right);
    }
    
}
void processLRN(tree root)
{  
	if(!isEmpty(root))
	{
		processLRN(root->left);
	    processLRN(root->right);
	    cout<<root->info<<" ";	
	}
	
}
void processNRL(tree root)
{
    if(!isEmpty(root))
    {
	    cout<<root->info<<" ";
	    processNRL(root->right);
	    processNRL(root->left);
    }
    
}
void processRNL(tree root)
{
    if(!isEmpty(root))
    {
	    processRNL(root->right);
	    cout<<root->info<<" ";
	    processRNL(root->left);
    }
    
}
void processRLN(tree root)
{
    if(!isEmpty(root))
    {
	    processRLN(root->right);
	    processRLN(root->left);
	    cout<<root->info<<" ";
    }
    
}
//cau b
int sumNode(tree root)
{
	if(isEmpty(root)) return 0;
    return root->info+sumNode(root->right)+sumNode(root->left);
}
//cau c
int findMax(tree root)
{
    if(isEmpty(root)) return 0;
    while(!isEmpty(root->right))
    root=root->right;
    return root->info;
}
//cau d
int countNodeInTree(tree root)
{
	if(isEmpty(root)) return 0;
	return 1+countNodeInTree(root->right)+countNodeInTree(root->left);
}
// cau e
int countLeaf(tree root)
{
	if (isEmpty(root)) return 0;
	if(isEmpty(root->left) && isEmpty(root->right)) return 1;
	else return countLeaf(root->left)+countLeaf(root->right);
}
// cau f
int countNodeHas1Branch(tree root)
{
	if (isEmpty(root)) return 0;
	if(!isEmpty(root->left) && isEmpty(root->right)||isEmpty(root->left) && !isEmpty(root->right)) 
	return 1+countNodeHas1Branch(root->left)+countNodeHas1Branch(root->right);
	else return countNodeHas1Branch(root->left)+countNodeHas1Branch(root->right);
}
int countNodeHas2Branch(tree root)
{
	if (isEmpty(root)) return 0;
	if(!isEmpty(root->left) && !isEmpty(root->right)) 
	return 1+countNodeHas2Branch(root->left)+countNodeHas2Branch(root->right);
	else return countNodeHas2Branch(root->left)+countNodeHas2Branch(root->right);
}

