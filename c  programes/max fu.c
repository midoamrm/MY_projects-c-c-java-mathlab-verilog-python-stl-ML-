#include <stdio.h>
#include <stdlib.h>
int max(int y){

int a[50];

 for(int r=0;r<y;r++){
     printf("a %d",r);
    scanf("%d",&a[r]);
 }
int max=a[0];

  for(int i=0;i<y;i++){
     if(a[i]>max){
        max=a[i];
     }

  }
  return max;

}
int main()
{
    int e;
    printf("num of arry=");
 scanf("%d",&e);
    printf("%d",max(e));
    return 0;
}
