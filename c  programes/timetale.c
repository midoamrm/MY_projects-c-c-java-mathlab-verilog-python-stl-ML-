#include <stdio.h>
#include <stdlib.h>
int timetable(int n){
 for (int i=1;i<11;i++ ){
    printf("%dx%d=",n,i);
    printf("%d",n*i);
    printf("\n");

    }
    }
int main()
{ int nof_table;
 printf("entre   nof_table= ");
 scanf("%d",&nof_table);
  timetable(nof_table);
    return 0;
}
