#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include <time.h> 
int main(int argc , char ** argv)
{
    FILE *fp1,*fp2;
    char filename[100];
    srand(time(0)); 
    strcpy(filename,argv[0]);
    
   char filedest[100]; 
   int r = rand() % 20 + 10;
   char num[10];
  itoa(r,num,10);
    strcpy(filedest,"hello");
    strcat(filedest,num);
    strcat(filedest,".exe");
   char command[100];
   strcpy(command,"copy ");
   strcat(command,filename);
   strcat(command," ");
   strcat(command,filedest);
   printf("%s",command);
   system(command);
    return 0;
}
