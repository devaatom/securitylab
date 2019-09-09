#include<stdio.h>
#include<math.h>
int gcd(int a,int h)
{
	int temp;
	while(1)
	{
		temp = a%h;
		if(temp==0)
			return h;
		a = h;
		h = temp;
	}
}
int main()
{
	int p,q;
	//scanf("%d%d",&p,&q);
	p = 3;
	q = 7;
	
    int n = p*q;
	int e = 2;
	int phi = (p-1)*(q-1);
	while(e<phi)
	{
		if(gcd(e,phi)==1)
			break;
			
		else
			e++;
	}
//	printf("phi %lf e %d",phi,e);
	int k = 2;
	int x = (1+(k*phi))%e;
	while(x!=0)
	{
               
                           k++;
                           x = (1+(k*phi))%e;
 }
	int d = (1+(k*phi))/e;
	printf("\nd %d\n",d);
	int msg = 15;
	printf("%d",msg);
    	int c = pow(msg,e);
	c = fmod(c,n);
	printf("Encrypted %d",c);
 double m = pow(c,d);
 printf("\nm %lf\n",m);
int m1 = fmod(m,n);
	printf("Decrypted %d",m1);
	return 0;
}
