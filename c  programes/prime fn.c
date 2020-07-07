#include <stdio.h>
#include <stdlib.h>

int primeprint(int n){
int f=0;

for(int k=2;k<=n;k++){

    for(int i=2;i<=11;i++ ){

        if(k%i!=0){
            f=f+1;
            }
         if(k==i){
           f=f+1;
           }
    }
 if(f==10){
 printf("\n %d",k);
}
f=0;
}



return 0;


}
int primef(int p ){
  int f=0;
 for(int i=2;i<=11;i++ ){

        if(p%i!=0){
            f=f+1;
            }
         if(p==i){
           f=f+1;
           }
    }
    if(f==10){
        printf("prime");
    }
    else{
        printf("not prime");
    }

return 0;
}
int main()
{ int z;
     printf("please enter a z ");
 scanf(" %d",&z);
 primef(z);
 printf("\n");
 primeprint(z);
 printf("\n");
 printf("\'     \'");
 printf("\n");
 printf("........");

    return 0;
}
