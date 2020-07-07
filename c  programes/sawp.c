#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b;
     printf(" \n please enter a=");
    scanf("%d",&a);
    printf(" \n please enter b=");
     scanf("%d",&b);
    b=b+a;
    a=b-a;
    b=b-a;
    printf("\n a=%d",a);
    printf("\n b=%d",b);

    return 0;
}
