#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,f=0;

   printf("please enter a n ");
 scanf(" %d",&n);

for(int k=2;k<=n;k++){

    for(int i=2;i<=11;i++ ){

        if(k%i!=0){
            f=f+1;
            }
         if(k==i){
           f=f+1;
           }



    }


 /* if(f==10){
printf("\n%d",k);
}*/if(f==10){
 printf("\n %d",k);
}
f=0;
}






    return 0;
}
