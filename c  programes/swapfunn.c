#include <stdio.h>
#include <stdlib.h>
int sawp5(int *a,int *b){

    *b=*b+*a;
    *a=*b-*a;
    *b=*b-*a;



return 0;
}
int main()
{
   int x,y;
    printf(" \n please enter x=");
    scanf("%d",&x);
    printf(" \n please enter y=");
    scanf("%d",&y);
sawp5(&x,&y);
    printf("\n x=%d y=%d ",x,y);

    return 0;
}
