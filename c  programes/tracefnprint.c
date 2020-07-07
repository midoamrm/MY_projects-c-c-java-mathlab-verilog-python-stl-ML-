#include <stdio.h>
#include <stdlib.h>
int traceprintfn(int h){

int m[25][25];
  int tr=0;
for(int j=0;j<h;j++){
   for(int n=0;n<h;n++)
   {  printf("m %d %d",j,n);
       scanf("%d",&m[j][n]);

   }
}

for(int j=0;j<h;j++){
   for(int n=0;n<h;n++)
   {

        printf("%d  ",m[j][n]);
   }
   printf("\n");
}
printf("\n");

for(int j=0;j<h;j++){
   for(int n=0;n<h;n++)
   {
      if(j==n){
        tr=tr+m[j][n];
      }

   }

}



//printf("%d",tr);


return tr;


};
int main(){
    int z,r;
   printf("z*z");
   scanf("%d",&z);
   r=traceprintfn(z);
   printf("%d", r);
    return 0;
}
