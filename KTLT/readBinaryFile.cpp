#include<iostream>
#include<math.h>
struct fraction
{
    int numer;//numerator//tử số
    int denomin;//demnominator//mẫu số
};
using namespace std;
int main()
{
    fraction fract;
    //đọc file nhị phân về phân số
    FILE *f=fopen("C:\\Users\\hp\\Desktop\\file_read\\binary\\fract_b.txt","rb");
    int n;
    n=getw(f);
    cout<<n<<endl;
    while(fread(&fract,sizeof(fract),1,f))
    cout<<fract.numer<<"/"<<fract.denomin<<endl;
    return 0;
}
// tìm ước chung lớn nhất
int divisor(int a,int b)
{
    int r=a%b;
    while(r!=0)
    {
        a=b;
        b=r;
        r=a%b;
    }
    return b;
}
