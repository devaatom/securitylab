#include<stdio.h>
void doit()
{
char buf[8];
gets(buf);
printf("%s\n",buf);     
}
int main()
{
          printf("before\n");
          doit();
          printf("after\n");
          return 0;
}

