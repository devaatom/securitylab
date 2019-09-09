#include<stdio.h>
void doit()
{
char buf[8];
fgets(buf,8,stdin);
printf("%s\n",buf);     
}
int main()
{
          printf("before\n");
          doit();
          printf("after\n");
          return 0;
}

